package com.mersetoceans.client.meduse;


import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;

public class RenderMeduse extends RenderLiving {

	protected ModelMeduse model;
	
	public RenderMeduse (ModelMeduse modelTutorial, float f) {
		super(modelTutorial, f);
		model = (ModelMeduse) mainModel;
	}

	public void renderTutorial(EntityMeduse entity, double par2, double par4, double par6, float par8, float par9) {
        super.doRenderLiving(entity, par2, par4, par6, par8, par9);
    }

	public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9) {
        renderTutorial((EntityMeduse)par1EntityLiving, par2, par4, par6, par8, par9);
    }

	public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
        renderTutorial((EntityMeduse)par1Entity, par2, par4, par6, par8, par9);
    }
}