package com.mersetoceans.common.blocks;

import com.mersetoceans.MersEtOceans;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;


public class VerreRenforce extends BlockMO {

	public VerreRenforce(int id, int texture, Material material) {
		super(id, texture, material);
		setCreativeTab(MersEtOceans.tabOceanBlock);
		setHardness(3.0F);
		setResistance(5.0F);
		setStepSound(Block.soundGlassFootstep);
	}
    
    public boolean isOpaqueCube() { return false; }
    public int getRenderBlockPass() { return 1; }

}
