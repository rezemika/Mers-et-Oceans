package com.mersetoceans.common.blocks;

import com.mersetoceans.MersEtOceans;
import com.mersetoceans.common.CommonProxy;

import net.minecraft.block.Block;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class BlockTallGrassMO extends BlockTallGrass {
	
	public int rendertype;

	public BlockTallGrassMO(int id, int texture, int rtype) {
		super(id, texture);
		rendertype = rtype;
	}
	
	@Override
	public String getTextureFile () { return CommonProxy.BLOCK_PNG; }
	
    public int getBlockTextureFromSideAndMetadata(int par1, int par2) {
        return this.blockIndexInTexture;
    }

    public int getRenderType() {
        return rendertype;
    }

    public boolean canPlaceBlockAt(World world, int x, int y, int z) {
        int id = world.getBlockId(x, y-1, z);
        return id == MersEtOceans.terreAbysse.blockID;
    }
    
    public boolean canBlockStay(World world, int x, int y, int z) {
        int id = world.getBlockId(x, y-1, z);
        return id != 0;
    }
}
