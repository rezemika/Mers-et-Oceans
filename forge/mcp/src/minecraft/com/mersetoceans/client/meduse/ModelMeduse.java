package com.mersetoceans.client.meduse;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelMeduse extends ModelBase {
	
    //fields
    ModelRenderer tete;
    ModelRenderer inttest;
    
    ModelRenderer[] petiteTentacles = new ModelRenderer[1];
    ModelRenderer[] grandeTentacles = new ModelRenderer[1];
  
    public ModelMeduse() {
		  
	    textureWidth = 90;
	    textureHeight = 32;
    
        tete = new ModelRenderer(this, 0, 2);
        tete.addBox(-8F, 0F, -8F, 16, 8, 16);
        tete.setRotationPoint(0F, 0F, 0F);
        tete.setTextureSize(90, 32);
        tete.mirror = true;
        setRotation(tete, 0F, 0F, 0F);
        inttest = new ModelRenderer(this, 48, 2);
        inttest.addBox(-5F, -6F, -5F, 10, 6, 10);
        inttest.setRotationPoint(0F, 8F, 0F);
        inttest.setTextureSize(90, 32);
        inttest.mirror = true;
        setRotation(inttest, 0F, 0F, 0F);
        
        byte var1 = -9;

        for (int var2 = 0; var2 < this.grandeTentacles.length; ++var2) {
            this.grandeTentacles[var2] = new ModelRenderer(this, 0, 0);
            double var3 = (double)var2 * Math.PI * 2.0D / (double)this.grandeTentacles.length;
            float var5 = (float)Math.cos(var3) * 1.0F;
            float var6 = (float)Math.sin(var3) * 1.0F;
            this.grandeTentacles[var2].addBox(-1.0F, 0.0F, -1.0F, 2, 18, 2);
            this.grandeTentacles[var2].rotationPointX = var5;
            this.grandeTentacles[var2].rotationPointZ = var6;
            this.grandeTentacles[var2].rotationPointY = 8;
            var3 = (double)var2 * Math.PI * -2.0D / (double)this.grandeTentacles.length + (Math.PI / 2D);
            this.grandeTentacles[var2].rotateAngleY = (float)var3;
        }
        
        for (int var2 = 0; var2 < this.petiteTentacles.length; ++var2) {
            this.petiteTentacles[var2] = new ModelRenderer(this, 8, 0);
            double var3 = (double)var2 * Math.PI * 2.0D / (double)this.petiteTentacles.length;
            float var5 = (float)Math.cos(var3) * 1.0F;
            float var6 = (float)Math.sin(var3) * 1.0F;
            this.petiteTentacles[var2].addBox(-3.5F, 0.0F, -0.5F, 1, 10, 1);
            this.petiteTentacles[var2].rotationPointX = var5;
            this.petiteTentacles[var2].rotationPointZ = var6;
            this.petiteTentacles[var2].rotationPointY = 8;
            var3 = (double)var2 * Math.PI * -2.0D / (double)this.petiteTentacles.length + (Math.PI / 2D);
            this.petiteTentacles[var2].rotateAngleY = (float)var3;
        }
    }
  
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
	    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	    tete.render(f5);
	    inttest.render(f5);
	    
        for (int var8 = 0; var8 < this.grandeTentacles.length; ++var8)
            this.grandeTentacles[var8].render(f5);
        
        for (int var8 = 0; var8 < this.petiteTentacles.length; ++var8)
            this.petiteTentacles[var8].render(f5);
    }
  
    private void setRotation(ModelRenderer model, float x, float y, float z) {
	    model.rotateAngleX = x;
	    model.rotateAngleY = y;
	    model.rotateAngleZ = z;
    }

    public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
    	
        ModelRenderer[] var8 = this.petiteTentacles;
        int var9 = var8.length;

        for (int var10 = 0; var10 < var9; ++var10) {
            ModelRenderer var11 = var8[var10];
            var11.rotateAngleX = par3;
        }
        
        var8 = this.grandeTentacles;
        var9 = var8.length;

        for (int var10 = 0; var10 < var9; ++var10) {
            ModelRenderer var11 = var8[var10];
            var11.rotateAngleX = par3;
        }
    }

}