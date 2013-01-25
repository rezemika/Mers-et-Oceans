package com.mersetoceans.common.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStationary;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.util.Timer;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import com.mersetoceans.MersEtOceans;
import com.mersetoceans.client.ClientProxy;
import com.mersetoceans.common.TileEntityVague;
import com.mersetoceans.common.particle.PD_EntityParticleDeco;

public class BlockWater extends BlockStationary {
	
	private static float maree;

	public BlockWater(int id, Material material) {
		super(id, material);
		setHardness(100);
		setLightOpacity(3);
		disableStats();
		setRequiresSelfNotify();
		setTickRandomly(true);
	}
	
    public int getRenderType() { return ClientProxy.RENDERWATER; }

    public boolean shouldSideBeRendered(IBlockAccess iBlockAccess, int x, int y, int z, int meta) {
    	int id = iBlockAccess.getBlockId(x, y, z);
    	if ( id != 0 && ! Block.blocksList[id].isOpaqueCube() )
    		if( iBlockAccess.getBlockId(x - 1, y, z) != 0 &&
        		iBlockAccess.getBlockId(x + 1, y, z) != 0 &&
        		iBlockAccess.getBlockId(x, y, z - 1) != 0 &&
        		iBlockAccess.getBlockId(x, y, z + 1) != 0 &&
        	    iBlockAccess.getBlockId(x, y - 1, z) != 0 &&
        	    iBlockAccess.getBlockId(x, y + 1, z) != 0 )
        			return false;
    	
        Material var6 = iBlockAccess.getBlockMaterial(x, y, z);
        return var6 == this.blockMaterial ? false : (meta == 1 ? true : (var6 == Material.ice ? false : super.shouldSideBeRendered(iBlockAccess, x, y, z, meta)));
    }

	public void maj(World world, int x, int y, int z) {
		System.err.println(getMaree( world ));
    	world.scheduleBlockUpdate(x, y, z, this.blockID, 50);
        //world.markBlockRangeForRenderUpdate(x, y, z, x, y, z);
        
	}

	public static float getMaree( World world ) {
		
		float TD = world.getWorldTime() / 3000F;
		int moon = world.getMoonPhase( new Timer(20.0F).renderPartialTicks );
		
	    if( moon < 4 ) maree = -(TD%32);
	    else maree = -32 + (TD%32);
	    
		return maree;
	}
	
	public void randomDisplayTick(World world, int x, int y, int z, Random random)	{
		//if( world.getBlockId(x, y+1, z) != 9 )
		//	world.markBlockRangeForRenderUpdate(x, y, z, x, y, z);
	}
    
    public void updateTick(World world, int x, int y, int z, Random random) {
    	//world.scheduleBlockUpdate(x, y, z, this.blockID, 50);
    	//System.err.println("update");

		//world.setBlockWithNotify(x, y, z, 0);
		//world.setBlockWithNotify(x, y, z, 9);
    	
    	
    	/*for (int var34 = 0; var34 < 100; ++var34)
        for (int var35 = 0; var35 < 100; ++var35) {
        	world.markBlockRangeForRenderUpdate(var34, 62, var35, x, y, z);
        	world.markBlockRangeForRenderUpdate(var34, 61, var35, x, y, z);
        	world.markBlockRangeForRenderUpdate(var34, 60, var35, x, y, z);
        	world.markBlockRangeForRenderUpdate(var34, 62, -var35, x, y, z);
        	world.markBlockRangeForRenderUpdate(var34, 61, -var35, x, y, z);
        	world.markBlockRangeForRenderUpdate(var34, 60, -var35, x, y, z);
        	world.markBlockRangeForRenderUpdate(-var34, 62, -var35, x, y, z);
        	world.markBlockRangeForRenderUpdate(-var34, 61, -var35, x, y, z);
        	world.markBlockRangeForRenderUpdate(-var34, 60, -var35, x, y, z);
        	world.markBlockRangeForRenderUpdate(-var34, 62, var35, x, y, z);
        	world.markBlockRangeForRenderUpdate(-var34, 61, var35, x, y, z);
        	world.markBlockRangeForRenderUpdate(-var34, 60, var35, x, y, z);
        }*/
        		
    	/*
		TileEntityVague tile = (TileEntityVague) world.getBlockTileEntity(x, y, z);
		
		int nx = tile.centerX+tile.step;
		//int nz = tile.centerZ+tile.step;

		MersEtOceans.vague.init(world, nx, y, z, tile.centerX, tile.centerZ, tile.step);
		
		if( tile.step % 3 == 0 ) {
			MersEtOceans.vague.init(world, nx, y, z-1, tile.centerX, tile.centerZ, tile.step);
			MersEtOceans.vague.init(world, nx, y, z+1, tile.centerX, tile.centerZ, tile.step);
		}
		
		world.setBlock(x, y, z, 0);
    	*/
	}
	
	/*
	 * isOpaqueCube( World world, int x, int y, int z )
	 * 
	 * public void init(World world, int x, int y, int z, int centerX, int centerZ, int step) {

    	int id = world.getBlockId(x, y, z);
    	int id2 = world.getBlockId(x, y-1, z);
    	if ( id == 0 && id2 == 9 ) {
			world.setBlock(x, y, z, MersEtOceans.waterStill.blockID);
    		TileEntityVague tile = (TileEntityVague) world.getBlockTileEntity(x, y, z);
			tile.centerX = centerX;
			tile.centerZ = centerZ;
			tile.step = ++step;
			System.err.println("---"+x+" "+y+" "+z+" "+tile.step);
	    	//world.scheduleBlockUpdate(x, y, z, this.blockID, 10);
    	}
		
	}*/

}
