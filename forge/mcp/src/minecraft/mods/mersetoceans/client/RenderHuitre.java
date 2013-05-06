package mods.mersetoceans.client;

import mods.mersetoceans.MersEtOceans;
import mods.mersetoceans.client.obj.ReadObj;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class RenderHuitre implements ISimpleBlockRenderingHandler {

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer) {}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
		
		Tessellator tess = Tessellator.instance;
        tess.setBrightness(block.getMixedBrightnessForBlock(world, x, y, z));
        tess.setColorOpaque_F(1.0F, 1.0F, 1.0F);

		ReadObj obj = (ReadObj) ReadObj.init("/mods/mersetoceans/client/obj/huitre.obj");
		obj.icon( block.getIcon(0, 0) );
		
    	if( world.getBlockMaterial(x-1, y, z) == Material.rock ) {
    		obj.render( x, y, z, "x_m" );
    		obj.render( x, y, z, "x.001_m" );
    		obj.render( x, y, z, "x.002_m" );
    		obj.render( x, y, z, "x.003_m" );
    		obj.render( x, y, z, "x.004_m" );
    		obj.render( x, y, z, "x.005_m" );
    	}
    	if( world.getBlockMaterial(x+1, y, z) == Material.rock ) {
    		obj.render( x, y, z, "x__m" );
    	}
    	
    	if( world.getBlockMaterial(x, y+1, z) == Material.rock ) {
    		obj.render( x, y, z, "y_m2" );
    		obj.render( x, y, z, "y.001_m" );
    	}
    	if( world.getBlockMaterial(x, y-1, z) == Material.rock ) {
    		obj.render( x, y, z, "y__m" );
    		obj.render( x, y, z, "y_.001_m" );
    	}
    	
    	if( world.getBlockMaterial(x, y, z+1) == Material.rock ) {
    		obj.render( x, y, z, "z_m" );
    		obj.render( x, y, z, "z.001_m" );
    	}
    	if( world.getBlockMaterial(x, y, z-1) == Material.rock ) {
    		obj.render( x, y, z, "z__m" );
    		obj.render( x, y, z, "z_.001_m" );
    		obj.render( x, y, z, "z_.002_m" );
    	}
		
		return true;
		
	}

	@Override
	public boolean shouldRender3DInInventory() { return false; }

	@Override
	public int getRenderId() { return ClientProxy.RENDERHUITRE; }

}
