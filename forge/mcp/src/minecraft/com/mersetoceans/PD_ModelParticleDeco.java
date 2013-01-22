package com.mersetoceans;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import com.mersetoceans.PD_EntityParticleDeco;

public class PD_ModelParticleDeco extends ModelBase {
	
	ModelRenderer Body;
	
	public PD_ModelParticleDeco() {
		this.Body = new ModelRenderer (this, 0, 0);
		this.Body.addBox(-4.0F, -4.0F, -4.0F, 8, 8, 8);
		this.Body.setRotationPoint(0.0F, 20.0F, 0.0F);
	}
	
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		this.Body.render(f5);
	}
	
	public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
		super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
	}
	
	public void setLivingAnimations(EntityLiving entityliving, float f, float f1, float f2) {
		if ( entityliving instanceof PD_EntityParticleDeco ) {
			PD_EntityParticleDeco entity = (PD_EntityParticleDeco)entityliving;
			switch (entity.direction) {
				case 0:
					this.Body.rotateAngleX = 0.0F;
					this.Body.rotateAngleZ = 0.0F;
				break;
				case 1:
					this.Body.rotateAngleX = 0.0F;
					this.Body.rotateAngleZ = 1.570796F;
				break;
				case 2:
					this.Body.rotateAngleX = 0.0F;
					this.Body.rotateAngleZ = -1.570796F;
				break;
				case 3:
					this.Body.rotateAngleX = 1.570796F;
					this.Body.rotateAngleZ = 0.0F;
				break;
				case 4:
					this.Body.rotateAngleX = -1.570796F;
					this.Body.rotateAngleZ = 0.0F;
			}
		}
	}
}