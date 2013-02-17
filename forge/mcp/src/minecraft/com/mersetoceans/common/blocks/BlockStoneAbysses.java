package com.mersetoceans.common.blocks;

import java.util.Random;

import com.mersetoceans.MersEtOceans;
import com.mersetoceans.common.CommonProxy;

import cpw.mods.fml.common.registry.LanguageRegistry;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.src.ModLoader;

public class BlockStoneAbysses extends BlockMO {

	public BlockStoneAbysses(int id, int texture) {
		super(id, texture, Material.rock);
		setHardness(1.5F);
		setResistance(10.0F);
		setStepSound(Block.soundStoneFootstep);
		setCreativeTab(MersEtOceans.tabOceanBlock);
	}

    public int getBlockTextureFromSideAndMetadata(int par1, int par2) {
    	Random randomTexture = new Random();
    	if(randomTexture.nextInt(2) > 1)
    		return this.blockIndexInTexture = 80;
    	return this.blockIndexInTexture = 64;
    }

}
