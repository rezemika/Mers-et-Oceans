package com.mersetoceans.common.items;

import com.mersetoceans.common.CommonProxy;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemMO extends Item {

	public ItemMO(int id, int texture, CreativeTabs tab) {
		super(id);
		setIconIndex(texture);
		setCreativeTab(tab);
	}
	
	@Override
	public String getTextureFile() { return CommonProxy.ITEM_PNG; }

}
