package mods.mersetoceans.armure;

import java.util.List;

import mods.mersetoceans.MersEtOceans;
import mods.mersetoceans.client.ClientProxy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.IArmorTextureProvider;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ArmurePerle extends ItemArmor implements IArmorTextureProvider {
	
	public ArmurePerle(int id, EnumArmorMaterial enumarmormaterial, int par3) {
		super(id, enumarmormaterial, 0, par3);
        setHasSubtypes(true);
	}
	
	@SideOnly(Side.CLIENT)
	public String getArmorTextureFile(ItemStack armor) {
        if (armor.itemID == MersEtOceans.leggingsPerle.itemID)
            return ClientProxy.PERLEB_PNG;
       else return ClientProxy.PERLEH_PNG;
	}

    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack itemStack) {
        return false;
    }

    @SideOnly(Side.CLIENT)
    public void getSubItems(int id, CreativeTabs creativeTabs, List list) {
    	
    	if( armorType == 1 ) {
    		Enchantment enchantment = Enchantment.enchantmentsList[5];
    		ItemStack itemShack = new ItemStack(id, 1, 0);
    		itemShack.addEnchantment(enchantment, 3);
    		list.add(itemShack);
    	} else {
            list.add(new ItemStack(id, 1, 0));
    	}
		
    }
	
}