package com.mersetoceans.common.dimension;

import com.mersetoceans.MersEtOceans;

import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenHell;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.ChunkProviderHell;

public class WorldProviderMO extends WorldProvider {

	public static BiomeGenBase abysses = new BiomeGenAbysses(30);

	public WorldProviderMO() {
		this.hasNoSky = false;
		abysses.setColor(0x0000FF);
		abysses.setBiomeName("Abysses");
		abysses.setDisableRain();
		abysses.setTemperatureRainfall(1.0F, 0.0F);
		abysses.setMinMaxHeight(-1.0F, 0.4F);
	}
	
	public void registerWorldChunkManager() {
		this.worldChunkMgr = new WorldChunkManagerHell(abysses, 1.0F, 0.0F);
		this.dimensionId = MersEtOceans.dimension;
	}
	
	@Override
	public String getDimensionName() {
		return "AbysseS";
	}

	public boolean canRespawnHere() {
		return true;
	}
	
	public String getSaveFolder() {
        return "DIM-ABYSSES";
    }

	public double getMovementFactor() { return 1; }

	@Override
	public IChunkProvider createChunkGenerator() {
		return new ChunkProviderAbysses(worldObj, worldObj.getSeed());
	}

}
