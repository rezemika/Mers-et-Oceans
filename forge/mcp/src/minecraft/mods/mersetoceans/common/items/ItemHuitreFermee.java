package mods.mersetoceans.common.items;

import mods.mersetoceans.MersEtOceans;
import mods.mersetoceans.common.CommonProxy;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemHuitreFermee extends ItemMO {

	public ItemHuitreFermee(int id, String name) {
		super(id, name);
	}
	
	public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int par7, float par8, float par9, float par10) {
		super.onItemUse(itemStack, player, world, x, y, z, par7, par8, par9, par10);
		
		if(    !world.isRemote
		  && ( world.getBlockMaterial(x, y, z) == Material.anvil
			|| world.getBlockMaterial(x, y, z) == Material.iron
			|| world.getBlockMaterial(x, y, z) == Material.rock) ) {
			--itemStack.stackSize;
			world.spawnEntityInWorld( new EntityItem(world, x+.5, y+.5, z+.5, new ItemStack(MersEtOceans.huitreOuverte, 1)) );
			if( Math.random() > .3 )
				world.spawnEntityInWorld( new EntityItem(world, x+.5, y+.5, z+.5, new ItemStack(MersEtOceans.perle.itemID, 1, 0)) );
		}
		
		return true;
	}

}
