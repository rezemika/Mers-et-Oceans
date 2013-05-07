package mods.mersetoceans.common.blocks;

import java.util.ArrayList;
import java.util.Random;

import mods.mersetoceans.MersEtOceans;
import mods.mersetoceans.client.ClientProxy;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSand;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityFallingSand;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockPalourdeSand extends Block/*Sand*/ {

    public BlockPalourdeSand(int id, String name) {
        super(id, Material.sand);
        setHardness(0.5F);
        setStepSound(soundSandFootstep);
        setTickRandomly(true);
    }

	public void updateTick(World world, int x, int y, int z, Random random) {
        super.updateTick(world, x, y, z, random);
        
		int meta = world.getBlockMetadata( x, y, z );
		meta = meta+1 > 15 ? 15 : meta+1;
		world.setBlockMetadataWithNotify( x, y, z, blockID, meta );

        if ( !isWaterNearby(world, x, y, z) ) {
            world.setBlock(x, y, z, Block.sand.blockID);
            world.spawnEntityInWorld( new EntityItem(world, x+.5, y+1, z+.5, new ItemStack(MersEtOceans.palourde, 1)) );
        }
    }
	
    public void onNeighborBlockChange(World world, int x, int y, int z, int par5) {
        if (((BlockSand) Block.blocksList[Block.sand.blockID]).canFallBelow(world, x, y - 1, z) && y >= 0) {
            byte b0 = 32;

            if (!((BlockSand) Block.blocksList[Block.sand.blockID]).fallInstantly && world.checkChunksExist(x - b0, y - b0, z - b0, x + b0, y + b0, z + b0))
                if (!world.isRemote) {
                    EntityFallingSand entityfallingsand = new EntityFallingSand(world, (double)((float)x + .5F), (double)((float)y + .5F), (double)((float)z + .5F), this.blockID, world.getBlockMetadata(x, y, z));
                    world.spawnEntityInWorld(entityfallingsand);
                }
            else {
                world.setBlockToAir(x, y, z);

                while (((BlockSand) Block.blocksList[Block.sand.blockID]).canFallBelow(world, x, y - 1, z) && y > 0)
                    --y;

                if (y > 0) world.setBlock(x, y, z, this.blockID);
            }
        }
    }
	
    public boolean isWaterNearby(World world, int x, int y, int z) {
        for (int l = x - 3; l <= x + 3; ++l)
        for (int i1 = y - 1; i1 <= y + 1; ++i1)
        for (int j1 = z - 3; j1 <= z + 3; ++j1)
        	if (world.getBlockMaterial(l, i1, j1) == Material.water)
        		return true;

        return false;
    }

    @Override 
    public int idDropped(int par1, Random random, int par3) {
        return Block.sand.blockID;
    }

    @Override 
    public ArrayList<ItemStack> getBlockDropped(World world, int x, int y, int z, int metadata, int fortune) {
    	
        ArrayList<ItemStack> ret = super.getBlockDropped(world, x, y, z, metadata, fortune);

        ret.add(new ItemStack(MersEtOceans.palourde.itemID, 1, 0));

        return ret;
    }


    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World world, int x, int y, int z, Random par5Random) {
        System.err.println( "parti "+world.getBlockMetadata(x, y, z) );
        
        if( world.getBlockMaterial(x, y+1, z) == Material.water ) {
            if( world.getBlockMetadata(x, y, z) == 15 ) {
	        	world.spawnParticle("bubble", x+.0625*7, y+1, z+.0625*5, 0, 0, 0);
		        world.spawnParticle("bubble", x+.0625*5, y+1, z+.0625*10, 0, 0, 0);
		        world.spawnParticle("bubble", x+.0625*10, y+1, z+.0625*10, 0, 0, 0);
            } else if( world.getBlockMetadata(x, y, z) > 6 ) {
	        	world.spawnParticle("bubble", x+.0625*7, y+1, z+.0625*5, 0, 0, 0);
		        world.spawnParticle("bubble", x+.0625*5, y+1, z+.0625*10, 0, 0, 0);
            } else
		        world.spawnParticle("bubble", x+.5, y+1, z+.5, 0, 0, 0);
        } else 
        	world.spawnParticle("splash", x+.5, y+.7, z+.5, 0, 0, 0);

    }
    
    public void registerIcons(IconRegister iconRegister) {
        this.blockIcon = iconRegister.registerIcon("sand");
    }

}