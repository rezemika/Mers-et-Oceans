package com.mersetoceans.common;

import cpw.mods.fml.client.registry.RenderingRegistry;

public class CommonProxy {
	
	public static String BLOCK_PNG = "/com/mersetoceans/assets/blocks.png";
	public static String WATER_PNG = "/com/mersetoceans/assets/water.png";
	public static String ITEM_PNG = "/com/mersetoceans/assets/items.png";
	public static String MEDUSE_PNG = "/com/mersetoceans/assets/meduse.png";
	public static String BALEINE_PNG = "/com/mersetoceans/assets/baleine.png";
	public static String KRAKEN_PNG = "/com/mersetoceans/assets/kraken.png";
	public static String CRABE_PNG = "/com/mersetoceans/assets/crabe.png";
	public static String PALOURDE_PNG = "/com/mersetoceans/assets/palourde.png";
	public static String SARDINE_PNG = "/com/mersetoceans/assets/sardine.png";
	public static String RAIE_PNG = "/com/mersetoceans/assets/raie.png";
	public static String THON_PNG = "/com/mersetoceans/assets/thon.png";
	
	public static final int RENDERWATER = RenderingRegistry.getNextAvailableRenderId();
	public static final int RENDERVAGUE = RenderingRegistry.getNextAvailableRenderId();
	public static final int RENDERPANE = RenderingRegistry.getNextAvailableRenderId();

	public void registerRenderThings() {}
}
