package com.mersetoceans.common.dimension;

import net.minecraft.block.Block;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.SpawnListEntry;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenSand;

import com.mersetoceans.client.meduse.EntityMeduse;
import com.mersetoceans.client.meduse.EntityMicro;

public class BiomeGenAbysses extends BiomeGenBase {
	
    public BiomeGenAbysses(int id) {
        super(id);
        this.spawnableMonsterList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
        this.field_82914_M.clear();
        this.spawnableWaterCreatureList.add(new SpawnListEntry(EntitySquid.class, 30, 4, 4));
        this.spawnableWaterCreatureList.add(new SpawnListEntry(EntityMeduse.class, 30, 4, 4));
        this.spawnableWaterCreatureList.add(new SpawnListEntry(EntityMicro.class, 30, 4, 4));
        
        this.theBiomeDecorator.clayPerChunk = 1;
        
        this.theBiomeDecorator.sandGen = new WorldGenSand(7, Block.sand.blockID);
        this.theBiomeDecorator.gravelAsSandGen = new WorldGenSand(6, Block.gravel.blockID);
        this.theBiomeDecorator.dirtGen = new WorldGenMinable(Block.dirt.blockID, 32);
        this.theBiomeDecorator.gravelGen = new WorldGenMinable(Block.gravel.blockID, 32);
        this.theBiomeDecorator.ironGen = new WorldGenMinable(Block.oreIron.blockID, 8);
        this.theBiomeDecorator.goldGen = new WorldGenMinable(Block.oreGold.blockID, 8);
        this.theBiomeDecorator.redstoneGen = new WorldGenMinable(Block.oreRedstone.blockID, 7);
        this.theBiomeDecorator.diamondGen = new WorldGenMinable(Block.oreDiamond.blockID, 7);
        this.theBiomeDecorator.lapisGen = new WorldGenMinable(Block.oreLapis.blockID, 6);
    }
    
}