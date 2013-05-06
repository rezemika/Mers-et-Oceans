package mods.mersetoceans.client;

import java.util.EnumSet;
import java.util.Iterator;

import mods.mersetoceans.MersEtOceans;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

public class ClientTickHandler implements ITickHandler {

	public void tickStart(EnumSet<TickType> type, Object... tickData) {}

	public void tickEnd(EnumSet<TickType> type, Object... tickData) {
		if(type.equals(EnumSet.of(TickType.RENDER))) onPlayerTick();
	}

	@Override 
	public EnumSet<TickType> ticks() { 
		return EnumSet.of(TickType.RENDER);
	}

	@Override
	public String getLabel() { return null; }
	
	
	
	
	
	
	
	
	private boolean oldStep;
	
    private void onPlayerTick() {
    	Minecraft mc = Minecraft.getMinecraft();
    	if(mc.thePlayer != null) {
    		ItemStack helmet = mc.thePlayer.getCurrentItemOrArmor(4);
    		ItemStack plate = mc.thePlayer.getCurrentItemOrArmor(3);
		    ItemStack legs = mc.thePlayer.getCurrentItemOrArmor(2);
		    ItemStack boots = mc.thePlayer.getCurrentItemOrArmor(1);
		    
	    	if ( mc.thePlayer.isInsideOfMaterial(Material.water) && helmet != null && 
	    			 ( helmet.getItem() == MersEtOceans.helmetScaphandre
	    			|| helmet.getItem() == MersEtOceans.helmetPerle )) {
	    		oldStep = true;
	    		mc.thePlayer.addPotionEffect(new PotionEffect(Potion.nightVision.getId(),300,10));
		    } else if( oldStep ) {
		    	oldStep = false;
	    		int i = 0;
	    		if( !mc.thePlayer.getActivePotionEffects().isEmpty() ) {
		    		for (Iterator iterator = mc.thePlayer.getActivePotionEffects().iterator(); iterator.hasNext(); i++ ) {
	    				PotionEffect potioneffect = (PotionEffect)iterator.next();
	    				if( potioneffect.getPotionID() == Potion.nightVision.getId() )
	    					mc.thePlayer.getActivePotionEffects().remove(potioneffect);
	    			}
	    		}
		    }
	    	
		    if ( mc.thePlayer.isInWater() ) {
		    	if ( legs != null && mc.thePlayer.onGround && 
		    		 ( legs.getItem() == MersEtOceans.leggingsScaphandre
				    || legs.getItem() == MersEtOceans.leggingsPerle )) {
			    	mc.thePlayer.motionX *= 1.06;
			    	mc.thePlayer.motionZ *= 1.06;
			    }
		    	if ( boots != null && !mc.thePlayer.onGround &&
		    		 ( boots.getItem() == MersEtOceans.bootsScaphandre
		    		|| boots.getItem() == MersEtOceans.bootsPerle )) {
			    	mc.thePlayer.motionX *= 1.07F;
			    	mc.thePlayer.motionY *= 1.07F;
			    	mc.thePlayer.motionZ *= 1.07F;
			    }
		    }
		    
    	}
    }
}