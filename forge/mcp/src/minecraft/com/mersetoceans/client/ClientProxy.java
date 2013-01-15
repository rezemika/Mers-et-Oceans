package com.mersetoceans.client;

import com.mersetoceans.client.meduse.EntityMeduse;
import com.mersetoceans.client.meduse.ModelMeduse;
import com.mersetoceans.client.meduse.RenderMeduse;
import com.mersetoceans.client.RenderWater;
import com.mersetoceans.common.CommonProxy;

import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends CommonProxy {
	
	public static final int RENDERWATER = RenderingRegistry.getNextAvailableRenderId();
	public static final int RENDERVAGUE = RenderingRegistry.getNextAvailableRenderId();
	public static final int RENDERPANE = RenderingRegistry.getNextAvailableRenderId();
	
	@Override
	public void registerRenderThings() {
		MinecraftForgeClient.preloadTexture(BLOCK_PNG);
		MinecraftForgeClient.preloadTexture(ITEM_PNG);
		RenderingRegistry.registerEntityRenderingHandler(EntityMeduse.class, new RenderMeduse(new ModelMeduse(), 0.3F));
		
		RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(new RenderWater());
		RenderingRegistry.registerBlockHandler(new RenderVague());
		RenderingRegistry.registerBlockHandler(new RenderPane());
	}
	
}
