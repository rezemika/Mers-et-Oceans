package com.mersetoceans.common.dimension;

import com.mersetoceans.MersEtOceans;

import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;

public class WorldProviderMO extends WorldProvider {

	public WorldProviderMO() {
		this.hasNoSky = true;
	}
	
	public void registerWorldChunkManager() {
		this.worldChunkMgr = new WorldChunkManagerHell(BiomeGenBase.beach, 0.8F, 0.1F);
		this.dimensionId = MersEtOceans.dimension;
	}
	
	@Override
	public String getDimensionName() {
		return "MersEtOceans";
	}

	public boolean canRespawnHere() {
		return true;
	}
	
	public String getSaveFolder() {
        return "Custom Dimension Folder";
    }

	public double getMovementFactor() {
		return 25.0;
    }

	@Override
	public IChunkProvider createChunkGenerator() {
		return new ChunkProvider(worldObj, worldObj.getSeed(), true);
	}

}
