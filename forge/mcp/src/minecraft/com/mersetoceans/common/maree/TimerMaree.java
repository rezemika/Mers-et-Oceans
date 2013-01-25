package com.mersetoceans.common.maree;

import static net.minecraft.world.biome.BiomeGenBase.ocean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.TimerTask;

import net.minecraft.client.Minecraft;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManager;

import com.mersetoceans.MersEtOceans;
import com.mersetoceans.common.TileEntityVague;

public class TimerMaree extends TimerTask {
	
    private ArrayList biomesToSpawnIn;
    public static ArrayList<BiomeGenBase> allowedBiomes = new ArrayList<BiomeGenBase>(Arrays.asList(ocean));
    
	public void run() {
		
		if( Minecraft.getMinecraft() != null && Minecraft.getMinecraft().theWorld != null && Minecraft.getMinecraft().theWorld.provider != null ) {
			
			World world = Minecraft.getMinecraft().theWorld;
			WorldProvider provider = world.provider;
	
	        biomesToSpawnIn = new ArrayList();
	        biomesToSpawnIn.addAll(allowedBiomes);
	
	        WorldChunkManager var2 = provider.worldChunkMgr;
	        Random var4 = new Random(provider.getSeed());
	        ChunkPosition var5 = var2.findBiomePosition(0, 0, 100, biomesToSpawnIn, var4);
	        
    		int ny = 255;
    		do { ny--; }
    		while ( world.getBlockId(var5.x, ny, var5.z) != 9 );

        	if ( world.getBlockId(var5.x, ny+1, var5.z) == 0 && world.getBlockId(var5.x, ny, var5.z) == 9 ) {
        		
        		double[] vagueP = {var5.x, ny+1, var5.z, MersEtOceans.wind};
        		ArrayList<double[]> vagueLP = new ArrayList<double[]>();
        		vagueLP.add(vagueP);
        		
    			world.setBlock(var5.x, ny+1, var5.z, MersEtOceans.vague.blockID);
        		
        		int[] vagueO = {0, var5.x, var5.z};
        		ArrayList<int[]> vagueLO = new ArrayList<int[]>();
        		vagueLO.add(vagueO);
    			
        		ArrayList[] vague = {vagueLO, vagueLP};
        		
        		MersEtOceans.vagues.add(vague);
        	}
		}
    	
    }
}