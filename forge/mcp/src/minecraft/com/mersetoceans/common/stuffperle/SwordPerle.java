package com.mersetoceans.common.stuffperle;

import com.mersetoceans.common.CommonProxy;

import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;

public class SwordPerle extends ItemSword {
	
    public SwordPerle(int itemID, EnumToolMaterial toolMaterial) {
        super(itemID, toolMaterial);
    }
	
	@Override
	public String getTextureFile () { return CommonProxy.ITEM_PNG; }
}