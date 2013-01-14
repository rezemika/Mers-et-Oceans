package com.mersetoceans.common.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;

import com.mersetoceans.common.CommonProxy;

public class ItemFoodMO extends ItemFood {

	public ItemFoodMO(int id, int texture, CreativeTabs tab, int healAmount, float saturationModifier, boolean isWolfsFavoriteMeat) {
		super(id, healAmount, saturationModifier, isWolfsFavoriteMeat);
		setIconIndex(texture);
		setCreativeTab(tab);
	}
	
	@Override
	public String getTextureFile() { return CommonProxy.ITEM_PNG; }

}
