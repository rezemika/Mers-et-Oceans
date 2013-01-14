package com.mersetoceans.client.meduse;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelMeduse extends ModelBase {
	
    //fields
    ModelRenderer tete;
    ModelRenderer grande_pate_1;
    ModelRenderer grande_pate_2;
    ModelRenderer grande_pate_3;
    ModelRenderer grande_pate_4;
    ModelRenderer petite_pate_1;
    ModelRenderer petite_pate_2;
    ModelRenderer petite_pate_3;
    ModelRenderer petite_pate_4;
    ModelRenderer inttest;
  
    public ModelMeduse() {
		  
	    textureWidth = 90;
	    textureHeight = 32;
    
        tete = new ModelRenderer(this, 0, 2);
        tete.addBox(-8F, 0F, -8F, 16, 8, 16);
        tete.setRotationPoint(0F, 0F, 0F);
        tete.setTextureSize(90, 32);
        tete.mirror = true;
        setRotation(tete, 0F, 0F, 0F);
        grande_pate_1 = new ModelRenderer(this, 0, 0);
        grande_pate_1.addBox(-1F, 0F, 1F, 2, 16, 2);
        grande_pate_1.setRotationPoint(0F, 8F, 0F);
        grande_pate_1.setTextureSize(90, 32);
        grande_pate_1.mirror = true;
        setRotation(grande_pate_1, 0.1570796F, 0.7853982F, 0F);
        grande_pate_2 = new ModelRenderer(this, 0, 0);
        grande_pate_2.addBox(-1F, 0F, 1F, 2, 16, 2);
        grande_pate_2.setRotationPoint(0F, 8F, 0F);
        grande_pate_2.setTextureSize(90, 32);
        grande_pate_2.mirror = true;
        setRotation(grande_pate_2, 0.1570796F, -0.7853982F, 0F);
        grande_pate_3 = new ModelRenderer(this, 0, 0);
        grande_pate_3.addBox(-1F, 0F, 1F, 2, 16, 2);
        grande_pate_3.setRotationPoint(0F, 8F, 0F);
        grande_pate_3.setTextureSize(90, 32);
        grande_pate_3.mirror = true;
        setRotation(grande_pate_3, 0.1570796F, 2.356194F, 0F);
        grande_pate_4 = new ModelRenderer(this, 0, 0);
        grande_pate_4.addBox(-1F, 0F, 1F, 2, 16, 2);
        grande_pate_4.setRotationPoint(0F, 8F, 0F);
        grande_pate_4.setTextureSize(90, 32);
        grande_pate_4.mirror = true;
        setRotation(grande_pate_4, 0.1570796F, -2.356194F, 0F);
        petite_pate_1 = new ModelRenderer(this, 8, 0);
        petite_pate_1.addBox(-3.5F, 0F, -0.5F, 1, 10, 1);
        petite_pate_1.setRotationPoint(0F, 8F, 0F);
        petite_pate_1.setTextureSize(90, 32);
        petite_pate_1.mirror = true;
        setRotation(petite_pate_1, 0F, 0F, 0.2617994F);
        petite_pate_2 = new ModelRenderer(this, 8, 0);
        petite_pate_2.addBox(-3.5F, 0F, -0.5F, 1, 10, 1);
        petite_pate_2.setRotationPoint(0F, 8F, 0F);
        petite_pate_2.setTextureSize(90, 32);
        petite_pate_2.mirror = true;
        setRotation(petite_pate_2, 0F, 1.570796F, 0.2617994F);
        petite_pate_3 = new ModelRenderer(this, 8, 0);
        petite_pate_3.addBox(-3.5F, 0F, -0.5F, 1, 10, 1);
        petite_pate_3.setRotationPoint(0F, 8F, 0F);
        petite_pate_3.setTextureSize(90, 32);
        petite_pate_3.mirror = true;
        setRotation(petite_pate_3, 0F, 3.141593F, 0.2617994F);
        petite_pate_4 = new ModelRenderer(this, 8, 0);
        petite_pate_4.addBox(-3.5F, 0F, -0.5F, 1, 10, 1);
        petite_pate_4.setRotationPoint(0F, 8F, 0F);
        petite_pate_4.setTextureSize(90, 32);
        petite_pate_4.mirror = true;
        setRotation(petite_pate_4, 0F, -1.570796F, 0.2617994F);
        inttest = new ModelRenderer(this, 48, 2);
        inttest.addBox(-5F, -6F, -5F, 10, 6, 10);
        inttest.setRotationPoint(0F, 8F, 0F);
        inttest.setTextureSize(90, 32);
        inttest.mirror = true;
        setRotation(inttest, 0F, 0F, 0F);
    }
  
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
	    super.render(entity, f, f1, f2, f3, f4, f5);
	    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	    tete.render(f5);
	    grande_pate_1.render(f5);
	    grande_pate_2.render(f5);
	    grande_pate_3.render(f5);
	    grande_pate_4.render(f5);
	    petite_pate_1.render(f5);
	    petite_pate_2.render(f5);
	    petite_pate_3.render(f5);
	    petite_pate_4.render(f5);
	    inttest.render(f5);
    }
  
    private void setRotation(ModelRenderer model, float x, float y, float z) {
	    model.rotateAngleX = x;
	    model.rotateAngleY = y;
	    model.rotateAngleZ = z;
    }
    
    public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
      super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
    }

}