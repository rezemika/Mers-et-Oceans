package com.mersetoceans.common;

import cpw.mods.fml.client.registry.RenderingRegistry;

public class CommonProxy {
	
	public static String BLOCK_PNG    = "/com/mersetoceans/assets/blocks.png";
	public static String WATER_PNG    = "/com/mersetoceans/assets/water.png";
	public static String ITEM_PNG     = "/com/mersetoceans/assets/items.png";
	
	public static String MEDUSE_PNG   = "/com/mersetoceans/assets/mobs/meduse.png";
	public static String BALEINE_PNG  = "/com/mersetoceans/assets/mobs/baleine.png";
	public static String KRAKEN_PNG   = "/com/mersetoceans/assets/mobs/kraken.png";
	public static String CRABE_PNG    = "/com/mersetoceans/assets/mobs/crabe.png";
	public static String PALOURDE_PNG = "/com/mersetoceans/assets/mobs/palourde.png";
	public static String SARDINE_PNG  = "/com/mersetoceans/assets/mobs/sardine.png";
	public static String RAIE_PNG     = "/com/mersetoceans/assets/mobs/raie.png";
	public static String THON_PNG     = "/com/mersetoceans/assets/mobs/thon.png";
	
	public static String PERLEH_PNG   = "/com/mersetoceans/assets/armor/perle_1.png";
	public static String PERLEB_PNG   = "/com/mersetoceans/assets/armor/perle_2.png";
	public static String SCAPHANDREH_PNG   = "/com/mersetoceans/assets/armor/scaphandre_1.png";
	public static String SCAPHANDREB_PNG   = "/com/mersetoceans/assets/armor/scaphandre_2.png";
	
	public static final int RENDERWATER = RenderingRegistry.getNextAvailableRenderId();
	public static final int RENDERVAGUE = RenderingRegistry.getNextAvailableRenderId();
	public static final int RENDERPANE = RenderingRegistry.getNextAvailableRenderId();

	public void registerRenderThings() {}
}
