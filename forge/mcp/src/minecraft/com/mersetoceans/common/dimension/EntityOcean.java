package com.mersetoceans.common.dimension;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntityOcean extends EntityLiving {

	public EntityOcean(World world) {
		super(world);
	}

	@Override
	public int getMaxHealth() {
		return 0;
	}

}
