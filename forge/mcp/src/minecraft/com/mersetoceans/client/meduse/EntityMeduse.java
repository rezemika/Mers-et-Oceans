package com.mersetoceans.client.meduse;

import com.mersetoceans.client.ClientProxy;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIBreakDoor;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityMeduse extends EntitySquid {
	
	public EntityMeduse(World world) {
		super(world);
		///moveSpeed = 0.25F;
		///tasks.addTask(0, new EntityAISwimming(this));
        //tasks.addTask(1, new EntityAIBreakDoor(this));
        //tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, this.moveSpeed, false));
        //tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        //tasks.addTask(4, new EntityAIWander(this, this.moveSpeed));
        ///targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
        ///targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 16.0F, 0, true));
	}
	
	public String getTexture() { return ClientProxy.MEDUSE_PNG; }
	
/*
	public int getAttackStrength(Entity entity) { return 4; }

	protected boolean isAIEnabled() { return true; }
	
	public int getMaxHealth() { return 20; }

	public EnumCreatureAttribute getCreatureAttribute() { return EnumCreatureAttribute.UNDEAD; }

	

	public int getTotalArmorValue() { return 2; }

	public void onLivingUpdate() {
		
        if (worldObj.isDaytime() && !worldObj.isRemote) {
            float var1 = getBrightness(1.0F);

            if (var1 > 0.5F && worldObj.canBlockSeeTheSky(MathHelper.floor_double(posX), MathHelper.floor_double(posY), MathHelper.floor_double(posZ)) && rand.nextFloat() * 30.0F < (var1 - 0.4F) * 2.0F)
                setFire(8);
        }

        super.onLivingUpdate();
    }

	protected String getLivingSound() { return "mob.zombie.say"; }
    protected String getHurtSound() { return "mob.zombie.hurt"; }
    protected String getDeathSound() { return "mob.zombie.death"; }
    
    protected void playStepSound(int par1, int par2, int par3, int par4) {
        worldObj.playSoundAtEntity(this, "mob.zombie.step", 0.15F, 1.0F);
    }
    
    protected int getDropItemId() { return Item.ingotGold.itemID; }
    
    protected void dropRareDrop(int par1) {
        switch (this.rand.nextInt(2)) {
            case 0: this.dropItem(Item.ingotIron.itemID, 1); break;
            case 1: this.dropItem(Item.helmetSteel.itemID, 1); break;
        }
    }
    
    protected void dropFewItems(boolean par1, int par2) {
	    if(this.rand.nextInt(3) == 0)
	    	this.dropItem(Item.appleRed.itemID, 1);
    }*/

}