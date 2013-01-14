package com.mersetoceans.common.items;

import com.mersetoceans.MersEtOceans;
import com.mersetoceans.common.CommonProxy;

import cpw.mods.fml.common.registry.LanguageRegistry;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.src.ModLoader;
import net.minecraft.world.World;

public class ItemHuitreFermee extends ItemMO {

	public ItemHuitreFermee(int id, int texture, CreativeTabs tab) {
		super(id, texture, tab);
	}

	@Override
	public String getTextureFile() { return CommonProxy.ITEM_PNG; }
	
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player){
		super.onItemRightClick(itemstack, world, player);
		if(--itemstack.stackSize <= 0){
			if(!player.inventory.addItemStackToInventory(new ItemStack(MersEtOceans.huitreOuverte))){
				return new ItemStack(MersEtOceans.huitreOuverte);
			}
		}else if(!player.inventory.addItemStackToInventory(new ItemStack(MersEtOceans.huitreOuverte))){
			player.dropPlayerItem(new ItemStack(MersEtOceans.huitreOuverte, 1, 0));
		}
		
		return itemstack;
	}

}
