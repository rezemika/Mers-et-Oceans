package com.mersetoceans.common.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.mersetoceans.common.CommonProxy;

public class ItemMO extends Item {

	public ItemMO(int id, int texture, CreativeTabs tab) {
		super(id);
		setIconIndex(texture);
		setCreativeTab(tab);
	}
	
	@Override
	public String getTextureFile() { return CommonProxy.ITEM_PNG; }
	
}