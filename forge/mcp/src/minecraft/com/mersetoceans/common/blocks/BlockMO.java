package com.mersetoceans.common.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

import com.mersetoceans.common.CommonProxy;

public class BlockMO extends Block {

	public BlockMO(int id, int texture, Material material) {
		super(id, texture, material);
	}
	
	@Override
	public String getTextureFile () { return CommonProxy.BLOCK_PNG; }

}
