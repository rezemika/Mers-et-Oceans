package com.mersetoceans.client;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFluid;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.IBlockAccess;

import com.mersetoceans.MersEtOceans;
import com.mersetoceans.common.MinecraftMO;
import com.mersetoceans.common.TileEntityVague;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class RenderVague implements ISimpleBlockRenderingHandler {
	
	private int animeState = 0;

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer) {}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
		
		this.animeState ++;

		if( world.getBlockId(x, y-1, z) != 9 )
			return renderSmall(world, x, y, z, block, modelId, renderer);
		if( world.getBlockId(x, y-2, z) != 9 )
			return renderLow(world, x, y, z, block, modelId, renderer);
		if( world.getBlockId(x, y-3, z) != 9 )
			return renderMiddle(world, x, y, z, block, modelId, renderer);
		return renderHight(world, x, y, z, block, modelId, renderer);
		
	}
	
	public boolean renderHight(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {

        Tessellator tess = Tessellator.instance;
        
        tess.setBrightness(block.getMixedBrightnessForBlock(renderer.blockAccess, x, y, z));

        int var6 = block.colorMultiplier(renderer.blockAccess, x, y, z);
        float var7 = (float)(var6 >> 16 & 255) / 255.0F;
        float var8 = (float)(var6 >> 8 & 255) / 255.0F;
        float var9 = (float)(var6 & 255) / 255.0F;
        tess.setColorOpaque_F(1.0F * 1.0F * var7, 1.0F * 1.0F * var8, 1.0F * 1.0F * var9);
		
        int texture = block.getBlockTextureFromSideAndMetadata((int) this.animeState, 0);
        
        int h1 = 12, h2 = 9, h3 = 3, h4 = -2;
        
        renderFace( tess, block, x  , y, z  , h1, h1, h1, h1, texture, 0 );
        
        renderFace( tess, block, x+1, y, z  , h1, h1, h2, h2, texture, 0 );
        renderFace( tess, block, x-1, y, z  , h2, h2, h1, h1, texture, 0 );
        renderFace( tess, block, x  , y, z+1, h1, h2, h2, h1, texture, 0 );
        renderFace( tess, block, x  , y, z-1, h2, h1, h1, h2, texture, 0 );

        renderFace( tess, block, x+2, y, z  , h2, h2, h4, h4, texture, 0 );
        renderFace( tess, block, x-2, y, z  , h4, h4, h2, h2, texture, 0 );
        renderFace( tess, block, x  , y, z+2, h2, h4, h4, h2, texture, 0 );
        renderFace( tess, block, x  , y, z-2, h4, h2, h2, h4, texture, 0 );

        renderFace( tess, block, x+1, y, z+1, h1, h2, h3, h2, texture, 0 );
        renderFace( tess, block, x-1, y, z-1, h3, h2, h1, h2, texture, 0 );
        renderFace( tess, block, x-1, y, z+1, h2, h3, h2, h1, texture, 0 );
        renderFace( tess, block, x+1, y, z-1, h2, h1, h2, h3, texture, 0 );

	    if( world.getBlockId(x, y, z+1) != block.blockID || world.getBlockId(x, y-3, z+1) != 9 )
	    renderFace( tess, block, x+2, y, z+1, h2, h3, h4, h4, texture, 0 );
	    if( world.getBlockId(x, y, z+1) != block.blockID )
	    renderFace( tess, block, x-2, y, z+1, h4, h4, h3, h2, texture, 0 );
	    if( world.getBlockId(x, y, z-1) != block.blockID || world.getBlockId(x, y-3, z-1) != 9 )
	    renderFace( tess, block, x+2, y, z-1, h3, h2, h4, h4, texture, 0 );
	    if( world.getBlockId(x, y, z-1) != block.blockID )
	    renderFace( tess, block, x-2, y, z-1, h4, h4, h2, h3, texture, 0 );
	    if( world.getBlockId(x+1, y, z) != block.blockID || world.getBlockId(x+1, y-3, z) != 9 )
	    renderFace( tess, block, x+1, y, z+2, h2, h4, h4, h3, texture, 0 );
        if( world.getBlockId(x-1, y, z) != block.blockID || world.getBlockId(x-1, y-3, z) != 9 )
	    renderFace( tess, block, x-1, y, z+2, h3, h4, h4, h2, texture, 0 );
        if( world.getBlockId(x+1, y, z) != block.blockID || world.getBlockId(x+1, y-3, z) != 9 )
	    renderFace( tess, block, x+1, y, z-2, h4, h2, h3, h4, texture, 0 );
        if( world.getBlockId(x-1, y, z) != block.blockID || world.getBlockId(x-1, y-3, z) != 9 )
	    renderFace( tess, block, x-1, y, z-2, h4, h3, h2, h4, texture, 0 );
    	
        renderFace( tess, block, x+2, y, z+2, h3, h4, h4, h4, texture, 0 );
        renderFace( tess, block, x-2, y, z-2, h4, h4, h3, h4, texture, 0 );
        renderFace( tess, block, x-2, y, z+2, h4, h4, h4, h3, texture, 0 );
        renderFace( tess, block, x+2, y, z-2, h4, h3, h4, h4, texture, 0 );

        
        renderer.renderMinY = 0.0D;
        renderer.renderMaxY = 1.0D;
        return true;
        
	}
	
	public boolean renderMiddle(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {

        Tessellator tess = Tessellator.instance;
        
        tess.setBrightness(block.getMixedBrightnessForBlock(renderer.blockAccess, x, y, z));

        int var6 = block.colorMultiplier(renderer.blockAccess, x, y, z);
        float var7 = (float)(var6 >> 16 & 255) / 255.0F;
        float var8 = (float)(var6 >> 8 & 255) / 255.0F;
        float var9 = (float)(var6 & 255) / 255.0F;
        tess.setColorOpaque_F(1.0F * 1.0F * var7, 1.0F * 1.0F * var8, 1.0F * 1.0F * var9);
		
        int texture1 = block.getBlockTextureFromSideAndMetadata((int) this.animeState, 0);
        int texture2 = block.getBlockTextureFromSideAndMetadata((int) this.animeState, 1);

        int h1 = 12, h2 = 9, h3 = 3, h4 = -2;

        renderFace( tess, block, x  , y, z  , h1, h1, h1, h1, texture1, 0 );

        renderFace( tess, block, x+1, y, z  , h1, h1, h4, h4, texture2, 1 );
        renderFace( tess, block, x-1, y, z  , h2, h2, h1, h1, texture1, 0 );
        renderFace( tess, block, x  , y, z+1, h1, h2, h2, h1, texture1, 0 );
        renderFace( tess, block, x  , y, z-1, h2, h1, h1, h2, texture1, 0 );

        renderFace( tess, block, x-2, y, z  , h4, h4, h2, h2, texture1, 0 );
        renderFace( tess, block, x  , y, z+2, h2, h4, h4, h2, texture1, 0 );
        renderFace( tess, block, x  , y, z-2, h4, h2, h2, h4, texture1, 0 );

	    if( world.getBlockId(x, y, z+1) != block.blockID )
        renderFace( tess, block, x+1, y, z+1, h1, h2, h4, h4, texture2, 1 );
        renderFace( tess, block, x-1, y, z-1, h3, h2, h1, h2, texture1, 0 );
        renderFace( tess, block, x-1, y, z+1, h2, h3, h2, h1, texture1, 0 );
        renderFace( tess, block, x+1, y, z-1, h2, h1, h4, h4, texture2, 1 );

	    if( world.getBlockId(x, y, z+1) != block.blockID )
	    renderFace( tess, block, x-2, y, z+1, h4, h4, h3, h2, texture1, 0 );
	    if( world.getBlockId(x, y, z-1) != block.blockID )
	    renderFace( tess, block, x-2, y, z-1, h4, h4, h2, h3, texture1, 0 );
	    if( world.getBlockId(x+1, y, z) != block.blockID )
	    renderFace( tess, block, x+1, y, z+2, h2, h4, h4, h4, texture2, 1 );
        if( world.getBlockId(x-1, y, z) != block.blockID )
	    renderFace( tess, block, x-1, y, z+2, h3, h4, h4, h2, texture1, 0 );
        if( world.getBlockId(x+1, y, z) != block.blockID )
	    renderFace( tess, block, x+1, y, z-2, h4, h2, h4, h4, texture2, 1 );
        if( world.getBlockId(x-1, y, z) != block.blockID )
	    renderFace( tess, block, x-1, y, z-2, h4, h3, h2, h4, texture1, 0 );

        renderFace( tess, block, x-2, y, z-2, h4, h4, h3, h4, texture1, 0 );
        renderFace( tess, block, x-2, y, z+2, h4, h4, h4, h3, texture1, 0 );

        
        renderer.renderMinY = 0.0D;
        renderer.renderMaxY = 1.0D;
        return true;
        
	}
	
	public boolean renderLow(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {

        Tessellator tess = Tessellator.instance;
        
        tess.setBrightness(block.getMixedBrightnessForBlock(renderer.blockAccess, x, y, z));

        int var6 = block.colorMultiplier(renderer.blockAccess, x, y, z);
        float var7 = (float)(var6 >> 16 & 255) / 255.0F;
        float var8 = (float)(var6 >> 8 & 255) / 255.0F;
        float var9 = (float)(var6 & 255) / 255.0F;
        tess.setColorOpaque_F(1.0F * 1.0F * var7, 1.0F * 1.0F * var8, 1.0F * 1.0F * var9);
		
        int texture1 = block.getBlockTextureFromSideAndMetadata((int) this.animeState, 0);
        int texture2 = block.getBlockTextureFromSideAndMetadata((int) this.animeState, 2);

        int h1 = 12, h2 = 9, h3 = 2, h4 = -2, h5 = -10;

        renderFace( tess, block, x  , y, z  , h1, h1, h1, h1, texture1, 0 );

        renderFace( tess, block, x+1, y, z  , h1, h1, h5, h5, texture2, 1 );
        renderFace( tess, block, x-1, y, z  , h2, h2, h1, h1, texture1, 0 );
        renderFace( tess, block, x  , y, z+1, h1, h2, h2, h1, texture1, 0 );
        renderFace( tess, block, x  , y, z-1, h2, h1, h1, h2, texture1, 0 );

        renderFace( tess, block, x-2, y, z  , h4, h4, h2, h2, texture1, 0 );
        renderFace( tess, block, x  , y, z+2, h2, h4, h4, h2, texture1, 0 );
        renderFace( tess, block, x  , y, z-2, h4, h2, h2, h4, texture1, 0 );

	    if( world.getBlockId(x, y, z+1) != block.blockID )
        renderFace( tess, block, x+1, y, z+1, h1, h2, h5, h5, texture2, 1 );
        renderFace( tess, block, x-1, y, z-1, h3, h2, h1, h2, texture1, 0 );
        renderFace( tess, block, x-1, y, z+1, h2, h3, h2, h1, texture1, 0 );
        renderFace( tess, block, x+1, y, z-1, h2, h1, h5, h5, texture2, 1 );

	    if( world.getBlockId(x, y, z+1) != block.blockID )
	    renderFace( tess, block, x-2, y, z+1, h4, h4, h3, h2, texture1, 0 );
	    if( world.getBlockId(x, y, z-1) != block.blockID )
	    renderFace( tess, block, x-2, y, z-1, h4, h4, h2, h3, texture1, 0 );
	    if( world.getBlockId(x+1, y, z) != block.blockID )
	    renderFace( tess, block, x+1, y, z+2, h2, h4, h5, h5, texture2, 1 );
        if( world.getBlockId(x-1, y, z) != block.blockID )
	    renderFace( tess, block, x-1, y, z+2, h3, h4, h4, h2, texture1, 0 );
        if( world.getBlockId(x+1, y, z) != block.blockID )
	    renderFace( tess, block, x+1, y, z-2, h4, h2, h5, h5, texture2, 1 );
        if( world.getBlockId(x-1, y, z) != block.blockID )
	    renderFace( tess, block, x-1, y, z-2, h4, h3, h2, h4, texture1, 0 );

        renderFace( tess, block, x-2, y, z-2, h4, h4, h3, h4, texture1, 0 );
        renderFace( tess, block, x-2, y, z+2, h4, h4, h4, h3, texture1, 0 );

        
        renderer.renderMinY = 0.0D;
        renderer.renderMaxY = 1.0D;
        return true;
        
	}
	
	public boolean renderSmall(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {

        Tessellator tess = Tessellator.instance;
        
        tess.setBrightness(block.getMixedBrightnessForBlock(renderer.blockAccess, x, y, z));

        int var6 = block.colorMultiplier(renderer.blockAccess, x, y, z);
        float var7 = (float)(var6 >> 16 & 255) / 255.0F;
        float var8 = (float)(var6 >> 8 & 255) / 255.0F;
        float var9 = (float)(var6 & 255) / 255.0F;
        tess.setColorOpaque_F(1.0F * 1.0F * var7, 1.0F * 1.0F * var8, 1.0F * 1.0F * var9);
		
        int texture1 = block.getBlockTextureFromSideAndMetadata((int) this.animeState, 0);
        int texture2 = block.getBlockTextureFromSideAndMetadata((int) this.animeState, 2);

        int h1 = 6, h2 = 3, h3 = 1, h4 = -2;

        renderFace( tess, block, x  , y, z  , h1, h1, h4, h4, texture2, 1 );

        renderFace( tess, block, x-1, y, z  , h2, h2, h1, h1, texture1, 0 );
        renderFace( tess, block, x  , y, z+1, h1, h2, h4, h4, texture2, 1 );
        renderFace( tess, block, x  , y, z-1, h2, h1, h4, h4, texture2, 1 );

        renderFace( tess, block, x-2, y, z  , h4, h4, h2, h2, texture1, 0 );
        renderFace( tess, block, x  , y, z+2, h2, h4, h4, h4, texture2, 1 );
        renderFace( tess, block, x  , y, z-2, h4, h2, h4, h4, texture2, 1 );

        renderFace( tess, block, x-1, y, z-1, h3, h2, h1, h2, texture1, 0 );
        renderFace( tess, block, x-1, y, z+1, h2, h3, h2, h1, texture1, 0 );

	    if( world.getBlockId(x, y, z+1) != block.blockID )
	    renderFace( tess, block, x-2, y, z+1, h4, h4, h3, h2, texture1, 0 );
	    if( world.getBlockId(x, y, z-1) != block.blockID )
	    renderFace( tess, block, x-2, y, z-1, h4, h4, h2, h3, texture1, 0 );
        if( world.getBlockId(x-1, y, z) != block.blockID )
	    renderFace( tess, block, x-1, y, z+2, h3, h4, h4, h2, texture1, 0 );
        if( world.getBlockId(x-1, y, z) != block.blockID )
	    renderFace( tess, block, x-1, y, z-2, h4, h3, h2, h4, texture1, 0 );

        renderFace( tess, block, x-2, y, z-2, h4, h4, h3, h4, texture1, 0 );
        renderFace( tess, block, x-2, y, z+2, h4, h4, h4, h3, texture1, 0 );

        
        renderer.renderMinY = 0.0D;
        renderer.renderMaxY = 1.0D;
        return true;
        
	}

	public void renderFace( Tessellator tess, Block block, double x, double y, double z, double a, double b, double c, double d, int texture, int o ) {
		

		double p = 1F/16F;
        int var36 = (texture & 15) << 4;
        int var37 =  texture & 240;

        float uvx = (float)var36 / 256.0F;
        float uvy = (float)var37 / 256.0F;
        
        switch( o ) {
        	case 0 :
        	    tess.addVertexWithUV(x+0, y+(p*a), z+0, uvx+0    , uvy+0);
        	    tess.addVertexWithUV(x+0, y+(p*b), z+1, uvx+0    , uvy+1/16D);
        	    tess.addVertexWithUV(x+1, y+(p*c), z+1, uvx+1/16D, uvy+1/16D);
        	    tess.addVertexWithUV(x+1, y+(p*d), z+0, uvx+1/16D, uvy+0);
        	break;
        	case 1 :
        	    tess.addVertexWithUV(x+0, y+(p*a), z+0, uvx+1/16D, uvy+0);
        	    tess.addVertexWithUV(x+0, y+(p*b), z+1, uvx+0    , uvy+0);
        	    tess.addVertexWithUV(x+1, y+(p*c), z+1, uvx+0    , uvy+1/16D);
        	    tess.addVertexWithUV(x+1, y+(p*d), z+0, uvx+1/16D, uvy+1/16D);
            break;
        	case 2 :
        	    tess.addVertexWithUV(x+0, y+(p*a), z+0, uvx+1/16D, uvy+1/16D);
        	    tess.addVertexWithUV(x+0, y+(p*b), z+1, uvx+1/16D, uvy+0);
        	    tess.addVertexWithUV(x+1, y+(p*c), z+1, uvx+0    , uvy+0);
        	    tess.addVertexWithUV(x+1, y+(p*d), z+0, uvx+0    , uvy+1/16D);
            break;
        	case 3 :
        	    tess.addVertexWithUV(x+0, y+(p*a), z+0, uvx+0    , uvy+1/16D);
        	    tess.addVertexWithUV(x+0, y+(p*b), z+1, uvx+1/16D, uvy+1/16D);
        	    tess.addVertexWithUV(x+1, y+(p*c), z+1, uvx+1/16D, uvy+0);
        	    tess.addVertexWithUV(x+1, y+(p*d), z+0, uvx+0    , uvy+0);
            break;
        }
	    
	}

	@Override
	public boolean shouldRender3DInInventory() { return false; }

	@Override
	public int getRenderId() { return ClientProxy.RENDERVAGUE; }

}