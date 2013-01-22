package com.mersetoceans;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Timer;
import net.minecraft.world.World;

import com.mersetoceans.common.items.ItemMO;

public class ItemMoondial extends ItemMO {
	
	public ItemMoondial(int id, int texture, CreativeTabs tab) {
		super(id, texture, tab);
	}
	
	public void onUpdate(ItemStack itemStack, World world, Entity entity, int par4, boolean par5)	{
		this.setIconIndex(198+world.getMoonPhase( new Timer(20.0F).renderPartialTicks ));
	}
	
}
