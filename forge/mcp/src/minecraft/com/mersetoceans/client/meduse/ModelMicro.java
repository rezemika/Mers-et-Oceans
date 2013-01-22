package com.mersetoceans.client.meduse;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelMicro extends ModelBase {
	
    //fields
    ModelRenderer Corps;
    ModelRenderer Basenageoire;
    ModelRenderer Nageoiresup;
    ModelRenderer Nageoireinf;
    ModelRenderer Tete;
    ModelRenderer Nageoire;
    ModelRenderer Nageoire2;
    ModelRenderer Nageoiredos;
  
    public ModelMicro() {
        textureWidth = 32;
        textureHeight = 32;
        
          Corps = new ModelRenderer(this, 0, 0);
          Corps.addBox(0F, 0F, 0F, 1, 3, 5);
          Corps.setRotationPoint(0F, 0F, 0F);
          Corps.setTextureSize(32, 32);
          Corps.mirror = true;
          setRotation(Corps, 0F, 0F, 0F);
          Basenageoire = new ModelRenderer(this, 0, 0);
          Basenageoire.addBox(0F, 0F, 0F, 1, 1, 1);
          Basenageoire.setRotationPoint(0F, 1F, -1F);
          Basenageoire.setTextureSize(32, 32);
          Basenageoire.mirror = true;
          setRotation(Basenageoire, 0F, 0F, 0F);
          Nageoiresup = new ModelRenderer(this, 0, 0);
          Nageoiresup.addBox(0F, 0F, 0F, 1, 1, 1);
          Nageoiresup.setRotationPoint(0F, 0F, -2F);
          Nageoiresup.setTextureSize(32, 32);
          Nageoiresup.mirror = true;
          setRotation(Nageoiresup, 0F, 0F, 0F);
          Nageoireinf = new ModelRenderer(this, 0, 0);
          Nageoireinf.addBox(0F, 0F, 0F, 1, 1, 1);
          Nageoireinf.setRotationPoint(0F, 2F, -2F);
          Nageoireinf.setTextureSize(32, 32);
          Nageoireinf.mirror = true;
          setRotation(Nageoireinf, 0F, 0F, 0F);
          Tete = new ModelRenderer(this, 0, 0);
          Tete.addBox(0F, 0F, 0F, 1, 1, 1);
          Tete.setRotationPoint(0F, 1F, 5F);
          Tete.setTextureSize(32, 32);
          Tete.mirror = true;
          setRotation(Tete, 0F, 0F, 0F);
          Nageoire = new ModelRenderer(this, 0, 0);
          Nageoire.addBox(0F, 0F, 0F, 1, 0, 2);
          Nageoire.setRotationPoint(1F, 1F, 2F);
          Nageoire.setTextureSize(32, 32);
          Nageoire.mirror = true;
          setRotation(Nageoire, 0F, 0F, 0F);
          Nageoire2 = new ModelRenderer(this, 0, 0);
          Nageoire2.addBox(0F, 0F, 0F, 1, 0, 2);
          Nageoire2.setRotationPoint(-1F, 1F, 2F);
          Nageoire2.setTextureSize(32, 32);
          Nageoire2.mirror = true;
          setRotation(Nageoire2, 0F, 0F, 0F);
          Nageoiredos = new ModelRenderer(this, 0, 0);
          Nageoiredos.addBox(0F, 0F, 0F, 1, 1, 2);
          Nageoiredos.setRotationPoint(0F, -1F, 1F);
          Nageoiredos.setTextureSize(32, 32);
          Nageoiredos.mirror = true;
          setRotation(Nageoiredos, 0F, 0F, 0F);
    }
  
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
	    super.render(entity, f, f1, f2, f3, f4, f5);
	    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	    Corps.render(f5);
	    Basenageoire.render(f5);
	    Nageoiresup.render(f5);
	    Nageoireinf.render(f5);
	    Tete.render(f5);
	    Nageoire.render(f5);
	    Nageoire2.render(f5);
	    Nageoiredos.render(f5);
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