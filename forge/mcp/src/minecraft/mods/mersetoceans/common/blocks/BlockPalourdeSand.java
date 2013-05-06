package mods.mersetoceans.common.blocks;

import java.util.Random;

import mods.mersetoceans.MersEtOceans;
import mods.mersetoceans.client.ClientProxy;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSand;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockPalourdeSand extends BlockSand {
	
    @SideOnly(Side.CLIENT)
    protected Icon icon;

    public BlockPalourdeSand(int id, String name) {
        super(id, Material.sand);
        setHardness(0.5F);
        setStepSound(soundSandFootstep);
        setUnlocalizedName("sand");
    }

	public void updateTick(World world, int x, int y, int z, Random random) {
		int meta = world.getBlockMetadata( x, y, z );
		meta = meta+1 > 16 ? 16 : meta+1;
		world.setBlockMetadataWithNotify( x, y, z, blockID, meta );

        if ( !isWaterNearby(world, x, y, z) ) {
            world.setBlock(x, y, z, Block.sand.blockID);
        }
    }
	
    public boolean isWaterNearby(World world, int x, int y, int z) {
        for (int l = x - 4; l <= x + 4; ++l)
        for (int i1 = y - 1; i1 <= y + 1; ++i1)
        for (int j1 = z - 4; j1 <= z + 4; ++j1)
        	if (world.getBlockMaterial(l, i1, j1) == Material.water)
        		return true;

        return false;
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister) {
        icon = par1IconRegister.registerIcon("sand");
    }

}