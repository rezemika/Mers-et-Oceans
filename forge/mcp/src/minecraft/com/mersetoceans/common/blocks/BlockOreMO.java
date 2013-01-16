package com.mersetoceans.common.blocks;

import java.util.Random;

import com.mersetoceans.MersEtOceans;
import com.mersetoceans.common.CommonProxy;
import com.mersetoceans.common.dimension.BlockPortal;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockOreMO extends BlockMO {

	public BlockOreMO(int id, int texture) {
		super(id, texture, Material.rock);
	}
    
    public int idDropped(int par1, Random random, int par3) {
		      if( this.blockID == MersEtOceans.glowstoneAberlan.blockID ) return MersEtOceans.poudreAberlan.itemID;
		else if( this.blockID == MersEtOceans.rocklisse.blockID )        return MersEtOceans.rock.blockID;
		else if( this.blockID == MersEtOceans.rockDiamonds.blockID )     return Item.diamond.itemID;
		else if( this.blockID == MersEtOceans.rockEmeraude.blockID )     return Item.emerald.itemID;
		else if( this.blockID == MersEtOceans.rockLapis.blockID )        return Item.dyePowder.itemID;
		else if( this.blockID == MersEtOceans.rockRedstone.blockID )     return Item.redstone.itemID;
		else if( this.blockID == MersEtOceans.rockSpinel.blockID )       return MersEtOceans.spinel.itemID;
		else if( this.blockID == MersEtOceans.rockAberlan.blockID )      return MersEtOceans.aberlan.itemID;
		else if( this.blockID == MersEtOceans.rockBulle.blockID )        return MersEtOceans.cristalBulle.itemID;
        return this.blockID;
    }
    
    public int quantityDropped(Random random) {
        return this.blockID == MersEtOceans.rockLapis.blockID ? 4 + random.nextInt(5) : 1;
    }
    
    public int quantityDroppedWithBonus(int par1, Random random) {
        if (par1 > 0 && this.blockID != this.idDropped(0, random, par1)) {
        	
            int var3 = random.nextInt(par1 + 2) - 1;
            if (var3 < 0) var3 = 0;

            return this.quantityDropped(random) * (var3 + 1);
        } else
            return this.quantityDropped(random);
    }
    
    public void dropBlockAsItemWithChance(World world, int par2, int par3, int par4, int par5, float par6, int par7) {
    	
        super.dropBlockAsItemWithChance(world, par2, par3, par4, par5, par6, par7);

        if (this.idDropped(par5, world.rand, par7) != this.blockID) {
            int var8 = 0;

			if( this.blockID == MersEtOceans.glowstoneAberlan.blockID )
                var8 = MathHelper.getRandomIntegerInRange(world.rand, 2, 5);
			else if( this.blockID == MersEtOceans.rockDiamonds.blockID )
                var8 = MathHelper.getRandomIntegerInRange(world.rand, 3, 7);
			else if( this.blockID == MersEtOceans.rockEmeraude.blockID )
                var8 = MathHelper.getRandomIntegerInRange(world.rand, 3, 7);
			else if( this.blockID == MersEtOceans.rockLapis.blockID )  
                var8 = MathHelper.getRandomIntegerInRange(world.rand, 2, 5);
			else if( this.blockID == MersEtOceans.rockSpinel.blockID )
                var8 = MathHelper.getRandomIntegerInRange(world.rand, 0, 2);
			else if( this.blockID == MersEtOceans.rockAberlan.blockID )
                var8 = MathHelper.getRandomIntegerInRange(world.rand, 3, 7);
			else if( this.blockID == MersEtOceans.rockBulle.blockID )
                var8 = MathHelper.getRandomIntegerInRange(world.rand, 0, 2);

            this.dropXpOnBlockBreak(world, par2, par3, par4, var8);
        }
    }
    
    /* metaDropped */
    public int damageDropped(int par1) {
        return this.blockID == MersEtOceans.rockLapis.blockID ? 4 : 0;
    }
    
}
