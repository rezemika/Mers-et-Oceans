package com.mersetoceans.common.blocks;

import java.util.Random;

import com.mersetoceans.common.CommonProxy;

import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockOreMO extends BlockOre {
	
	public int itemOre;

	public BlockOreMO(int id, int texture, int item) {
		super(id, texture);
		setCreativeTab(CreativeTabs.tabBlock);
		
		itemOre = item;
	}
	
	@Override
	public String getTextureFile () { return CommonProxy.BLOCK_PNG; }

    public int idDropped(int par1, Random random, int par3) {
        return this.itemOre;
    }

}
