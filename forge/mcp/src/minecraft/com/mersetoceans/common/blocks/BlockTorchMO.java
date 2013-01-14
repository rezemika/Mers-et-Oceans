package com.mersetoceans.common.blocks;

import com.mersetoceans.common.CommonProxy;

import net.minecraft.block.BlockTorch;

public class BlockTorchMO extends BlockTorch {

	public BlockTorchMO(int id, int texture) {
		super(id, texture);
	}
	
	@Override
	public String getTextureFile () { return CommonProxy.BLOCK_PNG; }

}
