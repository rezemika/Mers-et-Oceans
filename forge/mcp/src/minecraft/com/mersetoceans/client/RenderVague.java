package com.mersetoceans.client;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFluid;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;

import com.mersetoceans.MersEtOceans;
import com.mersetoceans.common.MinecraftMO;
import com.mersetoceans.common.TileEntityVague;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class RenderVague implements ISimpleBlockRenderingHandler {

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer) {}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {

        Tessellator var5 = Tessellator.instance;
        int var6 = block.colorMultiplier(renderer.blockAccess, x, y, z);
        float var7 = (float)(var6 >> 16 & 255) / 255.0F;
        float var8 = (float)(var6 >> 8 & 255) / 255.0F;
        float var9 = (float)(var6 & 255) / 255.0F;
        
        boolean var13 = false;
        Material var22 = block.blockMaterial;
        int var23 = renderer.blockAccess.getBlockMetadata(x, y, z);
        double var24 = (double)renderer.getFluidHeight(x, y, z, var22);
        double var26 = (double)renderer.getFluidHeight(x, y, z + 1, var22);
        double var28 = (double)renderer.getFluidHeight(x + 1, y, z + 1, var22);
        double var30 = (double)renderer.getFluidHeight(x + 1, y, z, var22);

        var13 = true;
        int var34 = block.getBlockTextureFromSideAndMetadata(1, var23);
        float var35 = 0;

        var24 -= 0.0010000000474974513D;
        var26 -= 0.0010000000474974513D;
        var28 -= 0.0010000000474974513D;
        var30 -= 0.0010000000474974513D;
        int var36 = (var34 & 15) << 4;
        int var37 = var34 & 240;
        double var38 = ((double)var36 + 8.0D) / 256.0D;
        double var40 = ((double)var37 + 8.0D) / 256.0D;

        double var42 = (double)(MathHelper.sin(var35) * 8.0F) / 256.0D;
        double var44 = (double)(MathHelper.cos(var35) * 8.0F) / 256.0D;
        var5.setBrightness(block.getMixedBrightnessForBlock(renderer.blockAccess, x, y, z));
        var5.setColorOpaque_F(1.0F * 1.0F * var7, 1.0F * 1.0F * var8, 1.0F * 1.0F * var9);
        
        double p = 0, r = 0, a = 0, b = 0, c = 0, d = 0;
        double cx = x, cy = y, cz = z;
		p = 1F/16F;
        
		a = ( b = ( c = ( d = p*12 )));
        var5.addVertexWithUV(cx+0, y+a, cz+0, var38 - var44 - var42, var40 - var44 + var42);
        var5.addVertexWithUV(cx+0, y+b, cz+1, var38 - var44 + var42, var40 + var44 + var42);
        var5.addVertexWithUV(cx+1, y+c, cz+1, var38 + var44 + var42, var40 + var44 - var42);
        var5.addVertexWithUV(cx+1, y+d, cz+0, var38 + var44 - var42, var40 - var44 - var42);

        
        
        cx = x+1; cy = y; cz = z;
		a = ( b = p*12 );
		c = ( d = p*5 );
        var5.addVertexWithUV(cx+0, y+a, cz+0, var38 - var44 - var42, var40 - var44 + var42);
        var5.addVertexWithUV(cx+0, y+b, cz+1, var38 - var44 + var42, var40 + var44 + var42);
        var5.addVertexWithUV(cx+1, y+c, cz+1, var38 + var44 + var42, var40 + var44 - var42);
        var5.addVertexWithUV(cx+1, y+d, cz+0, var38 + var44 - var42, var40 - var44 - var42);

        cx = x-1; cy = y; cz = z;
		c = ( d = p*12 );
		a = ( b = p*5 );
        var5.addVertexWithUV(cx+0, y+a, cz+0, var38 - var44 - var42, var40 - var44 + var42);
        var5.addVertexWithUV(cx+0, y+b, cz+1, var38 - var44 + var42, var40 + var44 + var42);
        var5.addVertexWithUV(cx+1, y+c, cz+1, var38 + var44 + var42, var40 + var44 - var42);
        var5.addVertexWithUV(cx+1, y+d, cz+0, var38 + var44 - var42, var40 - var44 - var42);

        cx = x; cy = y; cz = z+1;
		a = ( d = p*12 );
		c = ( b = p*5 );
        var5.addVertexWithUV(cx+0, y+a, cz+0, var38 - var44 - var42, var40 - var44 + var42);
        var5.addVertexWithUV(cx+0, y+b, cz+1, var38 - var44 + var42, var40 + var44 + var42);
        var5.addVertexWithUV(cx+1, y+c, cz+1, var38 + var44 + var42, var40 + var44 - var42);
        var5.addVertexWithUV(cx+1, y+d, cz+0, var38 + var44 - var42, var40 - var44 - var42);

        cx = x; cy = y; cz = z-1;
		c = ( b = p*12 );
		a = ( d = p*5 );
        var5.addVertexWithUV(cx+0, y+a, cz+0, var38 - var44 - var42, var40 - var44 + var42);
        var5.addVertexWithUV(cx+0, y+b, cz+1, var38 - var44 + var42, var40 + var44 + var42);
        var5.addVertexWithUV(cx+1, y+c, cz+1, var38 + var44 + var42, var40 + var44 - var42);
        var5.addVertexWithUV(cx+1, y+d, cz+0, var38 + var44 - var42, var40 - var44 - var42);

        
        
        cx = x+2; cy = y; cz = z;
    	a = ( b = p*5 );
    	c = ( d = p*-2 );
        var5.addVertexWithUV(cx+0, y+a, cz+0, var38 - var44 - var42, var40 - var44 + var42);
        var5.addVertexWithUV(cx+0, y+b, cz+1, var38 - var44 + var42, var40 + var44 + var42);
        var5.addVertexWithUV(cx+1, y+c, cz+1, var38 + var44 + var42, var40 + var44 - var42);
        var5.addVertexWithUV(cx+1, y+d, cz+0, var38 + var44 - var42, var40 - var44 - var42);

        cx = x-2; cy = y; cz = z;
    	c = ( d = p*5 );
    	a = ( b = p*-2 );
        var5.addVertexWithUV(cx+0, y+a, cz+0, var38 - var44 - var42, var40 - var44 + var42);
        var5.addVertexWithUV(cx+0, y+b, cz+1, var38 - var44 + var42, var40 + var44 + var42);
        var5.addVertexWithUV(cx+1, y+c, cz+1, var38 + var44 + var42, var40 + var44 - var42);
        var5.addVertexWithUV(cx+1, y+d, cz+0, var38 + var44 - var42, var40 - var44 - var42);

        cx = x; cy = y; cz = z+2;
    	a = ( d = p*5 );
    	b = ( c = p*-2 );
        var5.addVertexWithUV(cx+0, y+a, cz+0, var38 - var44 - var42, var40 - var44 + var42);
        var5.addVertexWithUV(cx+0, y+b, cz+1, var38 - var44 + var42, var40 + var44 + var42);
        var5.addVertexWithUV(cx+1, y+c, cz+1, var38 + var44 + var42, var40 + var44 - var42);
        var5.addVertexWithUV(cx+1, y+d, cz+0, var38 + var44 - var42, var40 - var44 - var42);

        cx = x; cy = y; cz = z-2;
    	c = ( b = p*5 );
    	a = ( d = p*-2 );
        var5.addVertexWithUV(cx+0, y+a, cz+0, var38 - var44 - var42, var40 - var44 + var42);
        var5.addVertexWithUV(cx+0, y+b, cz+1, var38 - var44 + var42, var40 + var44 + var42);
        var5.addVertexWithUV(cx+1, y+c, cz+1, var38 + var44 + var42, var40 + var44 - var42);
        var5.addVertexWithUV(cx+1, y+d, cz+0, var38 + var44 - var42, var40 - var44 - var42);

    	

        cx = x+1; cy = y; cz = z+1;
		a = p*12;
		d = ( b = p*5 );
		c = p*3;
        var5.addVertexWithUV(cx+0, y+a, cz+0, var38 - var44 - var42, var40 - var44 + var42);
        var5.addVertexWithUV(cx+0, y+b, cz+1, var38 - var44 + var42, var40 + var44 + var42);
        var5.addVertexWithUV(cx+1, y+c, cz+1, var38 + var44 + var42, var40 + var44 - var42);
        var5.addVertexWithUV(cx+1, y+d, cz+0, var38 + var44 - var42, var40 - var44 - var42);

        cx = x-1; cy = y; cz = z-1;
		c = p*12;
		d = ( b = p*5 );
		a = p*3;
        var5.addVertexWithUV(cx+0, y+a, cz+0, var38 - var44 - var42, var40 - var44 + var42);
        var5.addVertexWithUV(cx+0, y+b, cz+1, var38 - var44 + var42, var40 + var44 + var42);
        var5.addVertexWithUV(cx+1, y+c, cz+1, var38 + var44 + var42, var40 + var44 - var42);
        var5.addVertexWithUV(cx+1, y+d, cz+0, var38 + var44 - var42, var40 - var44 - var42);

        cx = x-1; cy = y; cz = z+1;
		d = p*12;
		a = ( c = p*5 );
		b = p*3;
        var5.addVertexWithUV(cx+0, y+a, cz+0, var38 - var44 - var42, var40 - var44 + var42);
        var5.addVertexWithUV(cx+0, y+b, cz+1, var38 - var44 + var42, var40 + var44 + var42);
        var5.addVertexWithUV(cx+1, y+c, cz+1, var38 + var44 + var42, var40 + var44 - var42);
        var5.addVertexWithUV(cx+1, y+d, cz+0, var38 + var44 - var42, var40 - var44 - var42);

        cx = x+1; cy = y; cz = z-1;
		b = p*12;
		a = ( c = p*5 );
		d = p*3;
        var5.addVertexWithUV(cx+0, y+a, cz+0, var38 - var44 - var42, var40 - var44 + var42);
        var5.addVertexWithUV(cx+0, y+b, cz+1, var38 - var44 + var42, var40 + var44 + var42);
        var5.addVertexWithUV(cx+1, y+c, cz+1, var38 + var44 + var42, var40 + var44 - var42);
        var5.addVertexWithUV(cx+1, y+d, cz+0, var38 + var44 - var42, var40 - var44 - var42);

    	

        cx = x+2; cy = y; cz = z+1;
		a = p*5;
		b = p*3;
    	c = ( d = p*-2 );
        var5.addVertexWithUV(cx+0, y+a, cz+0, var38 - var44 - var42, var40 - var44 + var42);
        var5.addVertexWithUV(cx+0, y+b, cz+1, var38 - var44 + var42, var40 + var44 + var42);
        var5.addVertexWithUV(cx+1, y+c, cz+1, var38 + var44 + var42, var40 + var44 - var42);
        var5.addVertexWithUV(cx+1, y+d, cz+0, var38 + var44 - var42, var40 - var44 - var42);

        cx = x-2; cy = y; cz = z+1;
		d = p*5;
		c = p*3;
    	a = ( b = p*-2 );
        var5.addVertexWithUV(cx+0, y+a, cz+0, var38 - var44 - var42, var40 - var44 + var42);
        var5.addVertexWithUV(cx+0, y+b, cz+1, var38 - var44 + var42, var40 + var44 + var42);
        var5.addVertexWithUV(cx+1, y+c, cz+1, var38 + var44 + var42, var40 + var44 - var42);
        var5.addVertexWithUV(cx+1, y+d, cz+0, var38 + var44 - var42, var40 - var44 - var42);

        cx = x+2; cy = y; cz = z-1;
		b = p*5;
		a = p*3;
    	c = ( d = p*-2 );
        var5.addVertexWithUV(cx+0, y+a, cz+0, var38 - var44 - var42, var40 - var44 + var42);
        var5.addVertexWithUV(cx+0, y+b, cz+1, var38 - var44 + var42, var40 + var44 + var42);
        var5.addVertexWithUV(cx+1, y+c, cz+1, var38 + var44 + var42, var40 + var44 - var42);
        var5.addVertexWithUV(cx+1, y+d, cz+0, var38 + var44 - var42, var40 - var44 - var42);

        cx = x-2; cy = y; cz = z-1;
		c = p*5;
		d = p*3;
    	a = ( b = p*-2 );
        var5.addVertexWithUV(cx+0, y+a, cz+0, var38 - var44 - var42, var40 - var44 + var42);
        var5.addVertexWithUV(cx+0, y+b, cz+1, var38 - var44 + var42, var40 + var44 + var42);
        var5.addVertexWithUV(cx+1, y+c, cz+1, var38 + var44 + var42, var40 + var44 - var42);
        var5.addVertexWithUV(cx+1, y+d, cz+0, var38 + var44 - var42, var40 - var44 - var42);

        cx = x+1; cy = y; cz = z+2;
		a = p*5;
		d = p*3;
    	b = ( c = p*-2 );
        var5.addVertexWithUV(cx+0, y+a, cz+0, var38 - var44 - var42, var40 - var44 + var42);
        var5.addVertexWithUV(cx+0, y+b, cz+1, var38 - var44 + var42, var40 + var44 + var42);
        var5.addVertexWithUV(cx+1, y+c, cz+1, var38 + var44 + var42, var40 + var44 - var42);
        var5.addVertexWithUV(cx+1, y+d, cz+0, var38 + var44 - var42, var40 - var44 - var42);

        cx = x-1; cy = y; cz = z+2;
		d = p*5;
		a = p*3;
    	b = ( c = p*-2 );
        var5.addVertexWithUV(cx+0, y+a, cz+0, var38 - var44 - var42, var40 - var44 + var42);
        var5.addVertexWithUV(cx+0, y+b, cz+1, var38 - var44 + var42, var40 + var44 + var42);
        var5.addVertexWithUV(cx+1, y+c, cz+1, var38 + var44 + var42, var40 + var44 - var42);
        var5.addVertexWithUV(cx+1, y+d, cz+0, var38 + var44 - var42, var40 - var44 - var42);

        cx = x+1; cy = y; cz = z-2;
		b = p*5;
		c = p*3;
    	a = ( d = p*-2 );
        var5.addVertexWithUV(cx+0, y+a, cz+0, var38 - var44 - var42, var40 - var44 + var42);
        var5.addVertexWithUV(cx+0, y+b, cz+1, var38 - var44 + var42, var40 + var44 + var42);
        var5.addVertexWithUV(cx+1, y+c, cz+1, var38 + var44 + var42, var40 + var44 - var42);
        var5.addVertexWithUV(cx+1, y+d, cz+0, var38 + var44 - var42, var40 - var44 - var42);

        cx = x-1; cy = y; cz = z-2;
		c = p*5;
		b = p*3;
    	a = ( d = p*-2 );
        var5.addVertexWithUV(cx+0, y+a, cz+0, var38 - var44 - var42, var40 - var44 + var42);
        var5.addVertexWithUV(cx+0, y+b, cz+1, var38 - var44 + var42, var40 + var44 + var42);
        var5.addVertexWithUV(cx+1, y+c, cz+1, var38 + var44 + var42, var40 + var44 - var42);
        var5.addVertexWithUV(cx+1, y+d, cz+0, var38 + var44 - var42, var40 - var44 - var42);

    	

        cx = x+2; cy = y; cz = z+2;
		a = p*3;
    	b = ( c = ( d = p*-2 ));
        var5.addVertexWithUV(cx+0, y+a, cz+0, var38 - var44 - var42, var40 - var44 + var42);
        var5.addVertexWithUV(cx+0, y+b, cz+1, var38 - var44 + var42, var40 + var44 + var42);
        var5.addVertexWithUV(cx+1, y+c, cz+1, var38 + var44 + var42, var40 + var44 - var42);
        var5.addVertexWithUV(cx+1, y+d, cz+0, var38 + var44 - var42, var40 - var44 - var42);

        cx = x-2; cy = y; cz = z-2;
		c = p*3;
    	a = ( b = ( d = p*-2 ));
        var5.addVertexWithUV(cx+0, y+a, cz+0, var38 - var44 - var42, var40 - var44 + var42);
        var5.addVertexWithUV(cx+0, y+b, cz+1, var38 - var44 + var42, var40 + var44 + var42);
        var5.addVertexWithUV(cx+1, y+c, cz+1, var38 + var44 + var42, var40 + var44 - var42);
        var5.addVertexWithUV(cx+1, y+d, cz+0, var38 + var44 - var42, var40 - var44 - var42);

        cx = x-2; cy = y; cz = z+2;
		d = p*3;
    	a = ( b = ( c = p*-2 ));
        var5.addVertexWithUV(cx+0, y+a, cz+0, var38 - var44 - var42, var40 - var44 + var42);
        var5.addVertexWithUV(cx+0, y+b, cz+1, var38 - var44 + var42, var40 + var44 + var42);
        var5.addVertexWithUV(cx+1, y+c, cz+1, var38 + var44 + var42, var40 + var44 - var42);
        var5.addVertexWithUV(cx+1, y+d, cz+0, var38 + var44 - var42, var40 - var44 - var42);

        cx = x+2; cy = y; cz = z-2;
		b = p*3;
    	a = ( c = ( d = p*-2 ));
        var5.addVertexWithUV(cx+0, y+a, cz+0, var38 - var44 - var42, var40 - var44 + var42);
        var5.addVertexWithUV(cx+0, y+b, cz+1, var38 - var44 + var42, var40 + var44 + var42);
        var5.addVertexWithUV(cx+1, y+c, cz+1, var38 + var44 + var42, var40 + var44 - var42);
        var5.addVertexWithUV(cx+1, y+d, cz+0, var38 + var44 - var42, var40 - var44 - var42);

        
        renderer.renderMinY = 0.0D;
        renderer.renderMaxY = 1.0D;
        return var13;
        
	}

	@Override
	public boolean shouldRender3DInInventory() { return false; }

	@Override
	public int getRenderId() { return ClientProxy.RENDERVAGUE; }

}