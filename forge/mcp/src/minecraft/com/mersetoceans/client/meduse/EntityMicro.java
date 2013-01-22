package com.mersetoceans.client.meduse;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import com.mersetoceans.client.ClientProxy;

public class EntityMicro extends EntitySquid {
	
	public EntityMicro(World world) {
		super(world);
		moveSpeed = 0.25F;
		tasks.addTask(0, new EntityAISwimming(this));
        //tasks.addTask(1, new EntityAIBreakDoor(this));
        //tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, this.moveSpeed, false));
        //tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        //tasks.addTask(4, new EntityAIWander(this, this.moveSpeed));
        targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
        targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 16.0F, 0, true));
	}

	public int getAttackStrength(Entity entity) { return 4; }

	protected boolean isAIEnabled() { return true; }
	
	public int getMaxHealth() { return 20; }

	public EnumCreatureAttribute getCreatureAttribute() { return EnumCreatureAttribute.UNDEAD; }

	public String getTexture() { return ClientProxy.MEDUSE_PNG; }

	public int getTotalArmorValue() { return 2; }

	public void onLivingUpdate() {
		
        if (worldObj.isDaytime() && !worldObj.isRemote) {
            float var1 = getBrightness(1.0F);

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
    }

}