package com.mersetoceans.client;

import com.mersetoceans.MersEtOceans;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class CreativeTabsMO extends CreativeTabs {
	
    private final String tabLabel;

	public CreativeTabsMO(int id, String label) {
		super(id, label);
		tabLabel = label;
	}
	
	public CreativeTabsMO(String label) {
	    super(label);
		tabLabel = label;
	}
	
	@Override
	public ItemStack getIconItemStack() {
		if( this.tabLabel == "OceansTools" )
			return new ItemStack(MersEtOceans.swordPerle);
		else if( this.tabLabel == "OceansMaterials" )
			return new ItemStack(MersEtOceans.perle);
		else if( this.tabLabel == "OceansFood" )
			return new ItemStack(MersEtOceans.huitreOuverte);
		else //if( this.tabLabel == "OceansBlock" )
			return new ItemStack(MersEtOceans.rock);
	}

}
