package mods.mersetoceans.common.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemMO extends Item {

	public ItemMO(int id, String name) {
		super(id);
		setFull3D();
		setUnlocalizedName("mersetoceans:"+name);
	}
	
}