package mods.mersetoceans.common.blocks;

import java.util.Random;

import mods.mersetoceans.MersEtOceans;
import mods.mersetoceans.client.ClientProxy;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityBrewingStand;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockHuitre extends BlockMO {

    public BlockHuitre(int id, String name) {
        super(id, name, Material.ice);
        setHardness(1);
        setStepSound(soundStoneFootstep);
        setUnlocalizedName(name);
        setBlockBounds(0, 0, 0, 1, 1, 1);
        setTickRandomly(true);
    }

	public void updateTick(World world, int x, int y, int z, Random random) {
        for (int i1 = x-2; i1 <= x+2; ++i1)
        for (int j1 = z-2; j1 <= z+2; ++j1)
        for (int k1 = y-2; k1 <= y+2; ++k1)
        	if (  world.getBlockMaterial(i1, k1, j1) == Material.water
        	   && canBlockStay(world, i1, k1, j1)
        	   && random.nextInt(100) == 0 )
            	world.setBlock(i1, k1, j1, blockID);
    }

    public int idDropped(int par1, Random par2Random, int par3) {
        return MersEtOceans.huitreFermee.itemID;
    }
    
    public int quantityDropped(Random par1Random) {
        return 1 + par1Random.nextInt(5);
    }

    public boolean canBlockStay(World world, int x, int y, int z) {
    	return (world.getBlockMaterial(x+1, y, z) == Material.rock
   	    	 || world.getBlockMaterial(x-1, y, z) == Material.rock
   	    	 || world.getBlockMaterial(x, y+1, z) == Material.rock
   	    	 || world.getBlockMaterial(x, y-1, z) == Material.rock
   	    	 || world.getBlockMaterial(x, y, z+1) == Material.rock
   	    	 || world.getBlockMaterial(x, y, z-1) == Material.rock)
   	    	 && !world.isAirBlock(x, y+1, z);
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister) {
        blockIcon = par1IconRegister.registerIcon("mersetoceans:huitre");
    }
    
    public int getRenderType() { return ClientProxy.RENDERHUITRE; }
    
    public void onNeighborBlockChange(World world, int x, int y, int z, int par5) {
        super.onNeighborBlockChange(world, x, y, z, par5);
        if (!canBlockStay(world, x, y, z)) {
            dropBlockAsItem(world, x, y, z, world.getBlockMetadata(x, y, z), 0);
            world.setBlockToAir(x, y, z);
        }
    }

    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4) { return null; }

    public boolean isOpaqueCube() { return false; }
    public boolean renderAsNormalBlock() { return false; }

}