package com.mersetoceans.common.blocks;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockStationaryMO extends BlockFluidMO
{
    protected BlockStationaryMO(int par1, Material par2Material)
    {
        super(par1, par2Material);
        this.setTickRandomly(false);

        if (par2Material == Material.lava)
        {
            this.setTickRandomly(true);
        }
    }

    public boolean getBlocksMovement(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
    {
        return this.blockMaterial != Material.lava;
    }

    /**
     * Lets the block know when one of its neighbor changes. Doesn't know which neighbor changed (coordinates passed are
     * their own) Args: x, y, z, neighbor blockID
     */
    public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5)
    {
        super.onNeighborBlockChange(par1World, par2, par3, par4, par5);

        if (par1World.getBlockId(par2, par3, par4) == this.blockID)
        {
            this.setNotStationary(par1World, par2, par3, par4);
        }
    }

    /**
     * Changes the block ID to that of an updating fluid.
     */
    private void setNotStationary(World par1World, int par2, int par3, int par4)
    {
        int var5 = par1World.getBlockMetadata(par2, par3, par4);
        par1World.editingBlocks = true;
        par1World.setBlockAndMetadata(par2, par3, par4, this.blockID - 1, var5);
        par1World.markBlockRangeForRenderUpdate(par2, par3, par4, par2, par3, par4);
        par1World.scheduleBlockUpdate(par2, par3, par4, this.blockID - 1, this.tickRate());
        par1World.editingBlocks = false;
    }
}