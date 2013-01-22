package com.mersetoceans.client;

import net.minecraftforge.client.MinecraftForgeClient;

import com.mersetoceans.client.meduse.EntityMeduse;
import com.mersetoceans.client.meduse.EntityMicro;
import com.mersetoceans.client.meduse.ModelMeduse;
import com.mersetoceans.client.meduse.ModelMicro;
import com.mersetoceans.client.meduse.RenderMeduse;
import com.mersetoceans.client.meduse.RenderMicro;
import com.mersetoceans.common.CommonProxy;

import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {
	
	@Override
	public void registerRenderThings() {
		MinecraftForgeClient.preloadTexture(BLOCK_PNG);
		MinecraftForgeClient.preloadTexture(WATER_PNG);
		MinecraftForgeClient.preloadTexture(ITEM_PNG);
	    MinecraftForgeClient.preloadTexture(PERLEH_PNG);
	    MinecraftForgeClient.preloadTexture(PERLEB_PNG);
	    MinecraftForgeClient.preloadTexture(SCAPHANDREH_PNG);
	    MinecraftForgeClient.preloadTexture(SCAPHANDREB_PNG);
	    
		RenderingRegistry.registerEntityRenderingHandler(EntityMeduse.class, new RenderMeduse(new ModelMeduse(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityMicro.class, new RenderMicro(new ModelMicro(), 0.3F));
		
		RenderingRegistry.registerBlockHandler(new RenderWater());
		RenderingRegistry.registerBlockHandler(new RenderVague());
		RenderingRegistry.registerBlockHandler(new RenderPane());
		
	}
	
}
