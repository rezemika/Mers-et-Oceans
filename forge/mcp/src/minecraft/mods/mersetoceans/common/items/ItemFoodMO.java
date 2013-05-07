package mods.mersetoceans.common.items;

import mods.mersetoceans.MersEtOceans;
import mods.mersetoceans.common.CommonProxy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;

public class ItemFoodMO extends ItemFood {

	public ItemFoodMO(int id, String name, int healAmount) {
		super(id, healAmount, .3F, false);
		setFull3D();
		setUnlocalizedName("mersetoceans:"+name);
	}

}
