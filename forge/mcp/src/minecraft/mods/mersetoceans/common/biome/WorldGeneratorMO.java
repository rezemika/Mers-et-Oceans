package mods.mersetoceans.common.biome;

import java.util.Random;

import mods.mersetoceans.MersEtOceans;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldGeneratorMO implements IWorldGenerator {

        @Override
        public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        	
        	int x, y, z; 
        	
        	// Huitre
        	for ( y = 66; y > 0; y-- ) {
                x = chunkX*16+random.nextInt(16);
                z = chunkZ*16+random.nextInt(16);
                if ( !world.isAirBlock(x, y, z) && world.getBlockMaterial(x, y, z) != Material.water ) {
                	if (   world.getBlockMaterial(x, y, z)   == Material.rock
                		&& world.getBlockMaterial(x, y+1, z) == Material.water
                		&& world.getBlockMaterial(x, y+2, z) == Material.water ) {
                		world.setBlock(x, y+1, z, MersEtOceans.blockHuitre.blockID);
                	}
                	y=-1;
                }
                
            }

        	// Palourde
        	for ( y = 80; y > 0; y-- ) {
                x = chunkX*16+ random.nextInt(16) + random.nextInt(4) - 2;
                z = chunkZ*16+ random.nextInt(16) + random.nextInt(4) - 2;
                if ( !world.isAirBlock(x, y, z) ) {
                	if ( world.getBlockId(x, y, z) == Block.sand.blockID && MersEtOceans.palourdeSand.isWaterNearby(world, x, y, z) ) {
	                	world.setBlock(x, y, z, Block.glowStone.blockID);
	                }
                	y=-1;
                }
            }
        	
        	
        	
        }

}