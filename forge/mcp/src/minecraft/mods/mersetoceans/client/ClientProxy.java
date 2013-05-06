package mods.mersetoceans.client;

import mods.mersetoceans.common.CommonProxy;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

public class ClientProxy extends CommonProxy {
	
	public static String PERLEH_PNG = "/mods/mersetoceans/textures/armors/perle_1.png";
	public static String PERLEB_PNG = "/mods/mersetoceans/textures/armors/perle_2.png";
	
	public static String SCAPHANDREH_PNG = "/mods/mersetoceans/textures/armors/scaphandre_1.png";
	public static String SCAPHANDREB_PNG = "/mods/mersetoceans/textures/armors/scaphandre_2.png";
	
	public static int RENDERHUITRE = RenderingRegistry.getNextAvailableRenderId();

	@Override
	public void registerRender() {
		RenderingRegistry.registerBlockHandler(new RenderHuitre());
		
		TickRegistry.registerTickHandler(new ClientTickHandler(), Side.CLIENT);
	}

}
