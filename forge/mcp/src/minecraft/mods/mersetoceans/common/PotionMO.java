package mods.mersetoceans.common;

import net.minecraft.potion.Potion;

public class PotionMO extends Potion {

	public PotionMO(int par1, boolean par2, int par3) {
		super(par1, par2, par3);
	}

	public Potion setIconIndex(int par1, int par2) {
		super.setIconIndex(par1, par2);
		return this;
	}

}