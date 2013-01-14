package com.mersetoceans.common.dimension;

import java.util.Random;

import com.mersetoceans.MersEtOceans;
import com.mersetoceans.common.CommonProxy;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.World;

public class BlockPortal extends Block {
	
	public BlockPortal(int id, int texture) {
		super(id, texture, Material.portal);
	}
	
	@Override
	public String getTextureFile () { return CommonProxy.BLOCK_PNG; }
	
	public void updateTick(World world, int x, int y, int z, Random random) {}
	
	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {
		if (entity.ridingEntity == null && entity.riddenByEntity == null) {
			if (entity instanceof EntityPlayerMP) {
				EntityPlayerMP thePlayer = (EntityPlayerMP) entity;
				if (entity.dimension != MersEtOceans.dimension)
					thePlayer.mcServer.getConfigurationManager().transferPlayerToDimension(thePlayer, MersEtOceans.dimension, new TeleporterMO(thePlayer.mcServer.worldServerForDimension(MersEtOceans.dimension)));
				else
					thePlayer.mcServer.getConfigurationManager().transferPlayerToDimension(thePlayer, 0, new TeleporterMO(thePlayer.mcServer.worldServerForDimension(0)));
			}
		}
	}
	
	public boolean tryToCreatePortal(World world, int x, int y, int z) {
        byte var5 = 0;
        byte var6 = 0;

        if (world.getBlockId(x - 1, y, z) == Block.sandStone.blockID || world.getBlockId(x + 1, y, z) == Block.sandStone.blockID)
            var5 = 1;

        if (world.getBlockId(x, y, z - 1) == Block.sandStone.blockID || world.getBlockId(x, y, z + 1) == Block.sandStone.blockID)
            var6 = 1;

        if (var5 == var6)
            return false;
        else {
            if (world.getBlockId(x - var5, y, z - var6) == 0) {
                x -= var5;
                z -= var6;
            }

            int var7;
            int var8;

            for (var7 = -1; var7 <= 2; ++var7)
            for (var8 = -1; var8 <= 3; ++var8) {
                boolean var9 = var7 == -1 || var7 == 2 || var8 == -1 || var8 == 3;

                if (var7 != -1 && var7 != 2 || var8 != -1 && var8 != 3) {
                    int var10 = world.getBlockId(x + var5 * var7, y + var8, z + var6 * var7);

                    if (var9) {
                        if (var10 != Block.sandStone.blockID)
                            return false;
                    } else if (var10 != 0 && var10 != Block.fire.blockID)
                        return false;
                }
            }

            world.editingBlocks = true;

            for (var7 = 0; var7 < 2; ++var7)
            for (var8 = 0; var8 < 3; ++var8)
                world.setBlockWithNotify(x + var5 * var7, y + var8, z + var6 * var7, this.blockID);

            world.editingBlocks = false;
            return true;
        }
    }
	
	public void randomDisplayTick(World world, int x, int y, int z, Random par5Random) {}
	
	public void onNeighborBlockChange(World world, int x, int y, int z, int par5) {
		
		byte var6 = 0;
		byte var7 = 1;
	
		if (world.getBlockId(x - 1, y, z) == this.blockID || world.getBlockId(x + 1, y, z) == this.blockID) {
			var6 = 1;
			var7 = 0;
		}
	
		int var8;
	
		for (var8 = y; world.getBlockId(x, var8 - 1, z) == this.blockID; --var8) ;
	
		if (world.getBlockId(x, var8 - 1, z) != Block.sandStone.blockID)
			world.setBlockWithNotify(x, y, z, 0);
		else {
			int var9;
		
			for (var9 = 1; var9 < 4 && world.getBlockId(x, var8 + var9, z) == this.blockID; ++var9) ;
		
			if (var9 == 3 && world.getBlockId(x, var8 + var9, z) == Block.sandStone.blockID) {
				boolean var10 = world.getBlockId(x - 1, y, z) == this.blockID || world.getBlockId(x + 1, y, z) == this.blockID;
				boolean var11 = world.getBlockId(x, y, z - 1) == this.blockID || world.getBlockId(x, y, z + 1) == this.blockID;
			
				if (var10 && var11)
					world.setBlockWithNotify(x, y, z, 0);
				else {
					if ((world.getBlockId(x + var6, y, z + var7) != Block.sandStone.blockID || world.getBlockId(x - var6, y, z - var7) != this.blockID) && (world.getBlockId(x - var6, y, z - var7) != Block.sandStone.blockID || world.getBlockId(x + var6, y, z + var7) != this.blockID))
						world.setBlockWithNotify(x, y, z, 0);
				}
			} else world.setBlockWithNotify(x, y, z, 0);
		}
	}
	
}