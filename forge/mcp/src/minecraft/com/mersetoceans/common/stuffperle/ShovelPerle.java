package com.mersetoceans.common.stuffperle;

import com.mersetoceans.common.CommonProxy;

import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSpade;

public class ShovelPerle extends ItemSpade {
	
    public ShovelPerle(int itemID, EnumToolMaterial toolMaterial) {
        super(itemID, toolMaterial);
    }
	
	@Override
	public String getTextureFile () { return CommonProxy.ITEM_PNG; }
}