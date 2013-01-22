package com.mersetoceans.common.stuffperle;

import com.mersetoceans.MersEtOceans;
import com.mersetoceans.client.ClientProxy;

import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.IArmorTextureProvider;

public class ArmurePerle extends ItemArmor implements IArmorTextureProvider {
	
    public ArmurePerle(int par1, EnumArmorMaterial par2EnumArmorMaterial, int par3, int par4) {
        super(par1, par2EnumArmorMaterial, par3, par4);
    }
 
    public String getArmorTextureFile(ItemStack par1) {
        if (par1.itemID == MersEtOceans.leggingsPerle.itemID)
             return ClientProxy.PERLEB_PNG;
        else return ClientProxy.PERLEH_PNG;
    }
	
	@Override
	public String getTextureFile () { return ClientProxy.ITEM_PNG; }
}