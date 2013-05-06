package mods.mersetoceans.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockGrass;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockGrassMO extends BlockGrass {

    @SideOnly(Side.CLIENT)
    private Icon bottom;
    @SideOnly(Side.CLIENT)
    private Icon grassTop;
    
	public BlockGrassMO(int id, String name) {
		super(id);
		setUnlocalizedName("mersetoceans:"+name);
	}

	@Override
	@SideOnly(Side.CLIENT)
    public Icon getIcon(int par1, int par2) {
        return par1 == 1 ? this.grassTop : (par1 == 0 ? bottom : blockIcon);
    }
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister) {
		grassTop = iconRegister.registerIcon("mersetoceans:grassAbysse_1");
		blockIcon = iconRegister.registerIcon("mersetoceans:grassAbysse_2");
		bottom = iconRegister.registerIcon("mersetoceans:dirtAbysse");
	}

	
	@Override
	@SideOnly(Side.CLIENT)
    public Icon getBlockTexture(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5) {
        if (par5 == 1) return this.grassTop;
        else if (par5 == 0) return bottom;
        else return this.blockIcon;
    }
    
    /*public void updateTick(World world, int x, int y, int z, Random random) {
    	
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
    }*/
}
