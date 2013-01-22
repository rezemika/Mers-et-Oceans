package com.mersetoceans.common.blocks;

import java.util.Random;

import com.mersetoceans.common.CommonProxy;

import net.minecraft.block.Block;
import net.minecraft.block.BlockGrass;
import net.minecraft.block.material.Material;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockGrassMO extends BlockGrass {

	public BlockGrassMO(int id, int texture) {
		super(id);
        this.blockIndexInTexture = 17;
	}
	
	@Override
	public String getTextureFile () { return CommonProxy.BLOCK_PNG; }

    public int getBlockTextureFromSideAndMetadata(int side, int meta) {
        return side == 1 ? 1 : (side == 0 ? 33 : 17);
    }
    
    public int getBlockTexture(IBlockAccess iBlockAccess, int x, int y, int z, int side) {
    	int meta = iBlockAccess.getBlockMetadata(x, y, z);
    	int id = iBlockAccess.getBlockId(x, y+1, z);
    	if( meta == 1 || (id != 0 && id != 9) ) return 33;
        return side == 1 ? 1 : (side == 0 ? 33 : 17);
    }
    
    public void updateTick(World world, int x, int y, int z, Random random) {
    	
        if (!world.isRemote) {
            if (world.getBlockLightValue(x, y + 1, z) < 4 && world.getBlockLightOpacity(x, y + 1, z) > 2)
                world.setBlockAndMetadataWithUpdate(x, y, z, this.blockID, 1, true);
            else if (world.getBlockLightValue(x, y + 1, z) >= 9) {
                for (int var6 = 0; var6 < 4; ++var6) {
                    int rx = x + random.nextInt(3) - 1;
                    int ry = y + random.nextInt(5) - 3;
                    int rz = z + random.nextInt(3) - 1;

                    if ( ( world.getBlockId(rx, ry, rz) == this.blockID && world.getBlockMetadata(rx, ry, rz) == 1 ) && world.getBlockLightValue(rx, ry + 1, rz) >= 4 && world.getBlockLightOpacity(rx, ry + 1, rz) <= 2)
                        world.setBlockAndMetadataWithUpdate(x, y, z, this.blockID, 0, true);
                }
            }
        }
    }
}
