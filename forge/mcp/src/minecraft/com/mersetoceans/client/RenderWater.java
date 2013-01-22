package com.mersetoceans.client;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFluid;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Timer;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import com.mersetoceans.MersEtOceans;
import com.mersetoceans.common.blocks.BlockWater;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class RenderWater implements ISimpleBlockRenderingHandler {

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer) {
		System.err.println("renderInventoryBlock");
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess iBlockAccess, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {

		int h = 0;
		
		if( y == 62 || y == 61 || y == 60 ) {
			World world = Minecraft.getMinecraft().theWorld;
			
			if( BlockWater.getMaree(world) < -18 && y == 62 ) world.setBlockWithNotify(x, y, z, 0);
			else if( BlockWater.getMaree(world) < -30 && y == 61 )  world.setBlockWithNotify(x, y, z, 0);
			
			if( iBlockAccess.getBlockId(x, y+1, z) == 0 && ( ( BlockWater.getMaree(world) > -30 && y == 60 ) || ( BlockWater.getMaree(world) > -18 && y == 61 ) ) )
				world.setBlockWithNotify(x, y+1, z, 9);
			
			h = (int) (BlockWater.getMaree(world) +2);
			if( y == 61 ) h = (int) (BlockWater.getMaree(world) + 14 +2);
			if( y == 60 ) h = (int) (BlockWater.getMaree(world) + 30 +2);
		}
	
		return renderBlockFluids(block, x, y, z, renderer, h);
		
	}
	
	public boolean renderBlockFluids(Block block, int par2, int par3, int par4, RenderBlocks renderer, int H) {
		
		double p = 1F/16F;
		
        Tessellator var5 = Tessellator.instance;
        int var6 = block.colorMultiplier(renderer.blockAccess, par2, par3, par4);
        float var7 = (float)(var6 >> 16 & 255) / 255.0F;
        float var8 = (float)(var6 >> 8 & 255) / 255.0F;
        float var9 = (float)(var6 & 255) / 255.0F;
        boolean var10 = block.shouldSideBeRendered(renderer.blockAccess, par2, par3 + 1, par4, 1);
        boolean var11 = block.shouldSideBeRendered(renderer.blockAccess, par2, par3 - 1, par4, 0);
        boolean[] var12 = new boolean[] {block.shouldSideBeRendered(renderer.blockAccess, par2, par3, par4 - 1, 2), block.shouldSideBeRendered(renderer.blockAccess, par2, par3, par4 + 1, 3), block.shouldSideBeRendered(renderer.blockAccess, par2 - 1, par3, par4, 4), block.shouldSideBeRendered(renderer.blockAccess, par2 + 1, par3, par4, 5)};

        if (!var10 && !var11 && !var12[0] && !var12[1] && !var12[2] && !var12[3])
        {
            return false;
        }
        else
        {
            boolean var13 = false;
            float var14 = 0.5F;
            float var15 = 1.0F;
            float var16 = 0.8F;
            float var17 = 0.6F;
            double var18 = 0.0D;
            double var20 = 1.0D;
            Material var22 = block.blockMaterial;
            int var23 = renderer.blockAccess.getBlockMetadata(par2, par3, par4);
            double var24 = (double)renderer.getFluidHeight(par2, par3, par4, var22);
            double var26 = (double)renderer.getFluidHeight(par2, par3, par4 + 1, var22);
            double var28 = (double)renderer.getFluidHeight(par2 + 1, par3, par4 + 1, var22);
            double var30 = (double)renderer.getFluidHeight(par2 + 1, par3, par4, var22);
            double var32 = 0.0010000000474974513D;
            int var34;
            int var37;

            if (renderer.renderAllFaces || var10)
            {
                var13 = true;
                var34 = block.getBlockTextureFromSideAndMetadata(1, var23);
                float var35 = (float)BlockFluid.getFlowDirection(renderer.blockAccess, par2, par3, par4, var22);

                if (var35 > -999.0F)
                {
                    var34 = block.getBlockTextureFromSideAndMetadata(2, var23);
                }

                var24 -= var32;
                var26 -= var32;
                var28 -= var32;
                var30 -= var32;
                int var36 = (var34 & 15) << 4;
                var37 = var34 & 240;
                double var38 = ((double)var36 + 8.0D) / 256.0D;
                double var40 = ((double)var37 + 8.0D) / 256.0D;

                if (var35 < -999.0F)
                {
                    var35 = 0.0F;
                }
                else
                {
                    var38 = (double)((float)(var36 + 16) / 256.0F);
                    var40 = (double)((float)(var37 + 16) / 256.0F);
                }

                double var42 = (double)(MathHelper.sin(var35) * 8.0F) / 256.0D;
                double var44 = (double)(MathHelper.cos(var35) * 8.0F) / 256.0D;
                var5.setBrightness(block.getMixedBrightnessForBlock(renderer.blockAccess, par2, par3, par4));
                float var46 = 1.0F;
                var5.setColorOpaque_F(var15 * var46 * var7, var15 * var46 * var8, var15 * var46 * var9);
                var5.addVertexWithUV((double)(par2 + 0), (double)par3 + var24 +p*H, (double)(par4 + 0), var38 - var44 - var42, var40 - var44 + var42);
                var5.addVertexWithUV((double)(par2 + 0), (double)par3 + var26 +p*H, (double)(par4 + 1), var38 - var44 + var42, var40 + var44 + var42);
                var5.addVertexWithUV((double)(par2 + 1), (double)par3 + var28 +p*H, (double)(par4 + 1), var38 + var44 + var42, var40 + var44 - var42);
                var5.addVertexWithUV((double)(par2 + 1), (double)par3 + var30 +p*H, (double)(par4 + 0), var38 + var44 - var42, var40 - var44 - var42);
            }

            if (renderer.renderAllFaces || var11)
            {
                var5.setBrightness(block.getMixedBrightnessForBlock(renderer.blockAccess, par2, par3 - 1, par4));
                float var65 = 1.0F;
                var5.setColorOpaque_F(var14 * var65, var14 * var65, var14 * var65);
                renderer.renderBottomFace(block, (double)par2, (double)par3 + var32, (double)par4, block.getBlockTextureFromSide(0));
                var13 = true;
            }

            for (var34 = 0; var34 < 4; ++var34)
            {
                int var64 = par2;
                var37 = par4;

                if (var34 == 0)
                {
                    var37 = par4 - 1;
                }

                if (var34 == 1)
                {
                    ++var37;
                }

                if (var34 == 2)
                {
                    var64 = par2 - 1;
                }

                if (var34 == 3)
                {
                    ++var64;
                }

                int var66 = block.getBlockTextureFromSideAndMetadata(var34 + 2, var23);
                int var39 = (var66 & 15) << 4;
                int var67 = var66 & 240;

                if (renderer.renderAllFaces || var12[var34])
                {
                    double var43;
                    double var41;
                    double var47;
                    double var45;
                    double var51;
                    double var49;

                    if (var34 == 0)
                    {
                        var41 = var24;
                        var43 = var30;
                        var45 = (double)par2;
                        var49 = (double)(par2 + 1);
                        var47 = (double)par4 + var32;
                        var51 = (double)par4 + var32;
                    }
                    else if (var34 == 1)
                    {
                        var41 = var28;
                        var43 = var26;
                        var45 = (double)(par2 + 1);
                        var49 = (double)par2;
                        var47 = (double)(par4 + 1) - var32;
                        var51 = (double)(par4 + 1) - var32;
                    }
                    else if (var34 == 2)
                    {
                        var41 = var26;
                        var43 = var24;
                        var45 = (double)par2 + var32;
                        var49 = (double)par2 + var32;
                        var47 = (double)(par4 + 1);
                        var51 = (double)par4;
                    }
                    else
                    {
                        var41 = var30;
                        var43 = var28;
                        var45 = (double)(par2 + 1) - var32;
                        var49 = (double)(par2 + 1) - var32;
                        var47 = (double)par4;
                        var51 = (double)(par4 + 1);
                    }

                    var13 = true;
                    double var53 = (double)((float)(var39 + 0) / 256.0F);
                    double var55 = ((double)(var39 + 16) - 0.01D) / 256.0D;
                    double var57 = ((double)var67 + (1.0D - var41) * 16.0D) / 256.0D;
                    double var59 = ((double)var67 + (1.0D - var43) * 16.0D) / 256.0D;
                    double var61 = ((double)(var67 + 16) - 0.01D) / 256.0D;
                    var5.setBrightness(block.getMixedBrightnessForBlock(renderer.blockAccess, var64, par3, var37));
                    float var63 = 1.0F;

                    if (var34 < 2)
                    {
                        var63 *= var16;
                    }
                    else
                    {
                        var63 *= var17;
                    }

                    var5.setColorOpaque_F(var15 * var63 * var7, var15 * var63 * var8, var15 * var63 * var9);
                    var5.addVertexWithUV(var45, (double)par3 + var41 +p*H, var47, var53, var57);
                    var5.addVertexWithUV(var49, (double)par3 + var43 +p*H, var51, var55, var59);
                    var5.addVertexWithUV(var49, (double)(par3 + 0), var51, var55, var61);
                    var5.addVertexWithUV(var45, (double)(par3 + 0), var47, var53, var61);
                }
            }

            renderer.renderMinY = var18;
            renderer.renderMaxY = var20;
            return var13;
        }
    }

	@Override
	public boolean shouldRender3DInInventory() {
		System.err.println("shouldRender3DInInventory");
		return false;
	}

	@Override
	public int getRenderId() {
		return ClientProxy.RENDERWATER;
	}

}
/*
	
	
	
	public static boolean rendervague(IBlockAccess iblockaccess, int x, int y, int z, Block block, int modelId, RenderBlocks renderblocks) {

        Tessellator var5 = Tessellator.instance;
        int var6 = block.colorMultiplier(renderblocks.blockAccess, x, y, z);
        float var7 = (float)(var6 >> 16 & 255) / 255.0F;
        float var8 = (float)(var6 >> 8 & 255) / 255.0F;
        float var9 = (float)(var6 & 255) / 255.0F;
        
        boolean var13 = false;
        Material var22 = block.blockMaterial;
        int var23 = renderblocks.blockAccess.getBlockMetadata(x, y, z);
        double var24 = (double)renderblocks.getFluidHeight(x, y, z, var22);
        double var26 = (double)renderblocks.getFluidHeight(x, y, z + 1, var22);
        double var28 = (double)renderblocks.getFluidHeight(x + 1, y, z + 1, var22);
        double var30 = (double)renderblocks.getFluidHeight(x + 1, y, z, var22);

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
        var5.setBrightness(block.getMixedBrightnessForBlock(renderblocks.blockAccess, x, y, z));
        var5.setColorOpaque_F(1.0F * 1.0F * var7, 1.0F * 1.0F * var8, 1.0F * 1.0F * var9);
        
        var5.addVertexWithUV((double)(x + 0), (double)y + var24, (double)(z + 0), var38 - var44 - var42, var40 - var44 + var42);
        var5.addVertexWithUV((double)(x + 0), (double)y + var26, (double)(z + 1), var38 - var44 + var42, var40 + var44 + var42);
        var5.addVertexWithUV((double)(x + 1), (double)y + var28, (double)(z + 1), var38 + var44 + var42, var40 + var44 - var42);
        var5.addVertexWithUV((double)(x + 1), (double)y + var30, (double)(z + 0), var38 + var44 - var42, var40 - var44 - var42);
        
        renderblocks.renderMinY = 0.0D;
        renderblocks.renderMaxY = 1.0D;
        return var13;
        
        
        
        
		/*double p = 0, r = 0, a = 0, b = 0, c = 0, d = 0;
	    if ( iblockaccess.getBiomeGenForCoords(x, y).biomeName == "Ocean" ) {
	        if ( y == 62 ) {
	        	
	        	
	        	
	        	TileEntityVague tile = (TileEntityVague) iblockaccess.getBlockTileEntity(x, y, z);
	
		    	System.err.println(tile.step);
	        	if( tile.step > 0 ) {
		    		r = p*-12;
		    		a = r; b = r; c = r; d = r;
		    	}
		    	*/
	        	
	        	//MinecraftMO publicMinecraft = new MinecraftMO();
	        	//Timer timer = publicMinecraft.getTimer();
	        	//mc.theWorld.getCelestialAngle(1.0F);
	        	//System.err.println(y);
	        	//System.err.println( ((World) iblockaccess).getMoonPhase(timer.renderPartialTicks) );
	        	
				/*
				p = 1F/16F;
				
				
		    	if( iblockaccess.getBlockId(x, y+1, z) == MersEtOceans.vague.blockID ) {
		    		a = ( b = ( c = ( d = p*-12 )));
		    	}
		    	
		    	else if( iblockaccess.getBlockId(x-1, y+1, z) == MersEtOceans.vague.blockID ) {
		    		a = ( b = p*-12 );
		    		c = ( d = p*-5 );
		    	} else if( iblockaccess.getBlockId(x+1, y+1, z) == MersEtOceans.vague.blockID ) {
		    		c = ( d = p*-12 );
		    		a = ( b = p*-5 );
		    	} else if( iblockaccess.getBlockId(x, y+1, z-1) == MersEtOceans.vague.blockID ) {
		    		a = ( d = p*-12 );
		    		c = ( b = p*-5 );
		    	} else if( iblockaccess.getBlockId(x, y+1, z+1) == MersEtOceans.vague.blockID ) {
		    		c = ( b = p*-12 );
		    		a = ( d = p*-5 );
		    	}
		    	
		    	else if( iblockaccess.getBlockId(x-2, y+1, z) == MersEtOceans.vague.blockID ) {
		    		a = ( b = p*-5 );
		    	} else if( iblockaccess.getBlockId(x+2, y+1, z) == MersEtOceans.vague.blockID ) {
		    		c = ( d = p*-5 );
		    	} else if( iblockaccess.getBlockId(x, y+1, z-2) == MersEtOceans.vague.blockID ) {
		    		a = ( d = p*-5 );
		    	} else if( iblockaccess.getBlockId(x, y+1, z+2) == MersEtOceans.vague.blockID ) {
		    		c = ( b = p*-5 );
		    	}
		    	
		    	else if( iblockaccess.getBlockId(x-1, y+1, z-1) == MersEtOceans.vague.blockID ) {
		    		a = p*-12;
		    		d = ( b = p*-5 );
		    		c = p*-3;
		    	} else if( iblockaccess.getBlockId(x+1, y+1, z+1) == MersEtOceans.vague.blockID ) {
		    		c = p*-12;
		    		d = ( b = p*-5 );
		    		a = p*-3;
		    	} else if( iblockaccess.getBlockId(x+1, y+1, z-1) == MersEtOceans.vague.blockID ) {
		    		d = p*-12;
		    		a = ( c = p*-5 );
		    		b = p*-3;
		    	} else if( iblockaccess.getBlockId(x-1, y+1, z+1) == MersEtOceans.vague.blockID ) {
		    		b = p*-12;
		    		a = ( c = p*-5 );
		    		d = p*-3;
		    	}
		    	
		    	else if( iblockaccess.getBlockId(x-2, y+1, z-1) == MersEtOceans.vague.blockID ) {
		    		a = p*-5;
		    		b = p*-3;
		    	} else if( iblockaccess.getBlockId(x+2, y+1, z-1) == MersEtOceans.vague.blockID ) {
		    		d = p*-5;
		    		c = p*-3;
		    	} else if( iblockaccess.getBlockId(x-2, y+1, z+1) == MersEtOceans.vague.blockID ) {
		    		b = p*-5;
		    		a = p*-3;
		    	} else if( iblockaccess.getBlockId(x+2, y+1, z+1) == MersEtOceans.vague.blockID ) {
		    		c = p*-5;
		    		d = p*-3;
		    	} else if( iblockaccess.getBlockId(x-1, y+1, z-2) == MersEtOceans.vague.blockID ) {
		    		a = p*-5;
		    		d = p*-3;
		    	} else if( iblockaccess.getBlockId(x+1, y+1, z-2) == MersEtOceans.vague.blockID ) {
		    		d = p*-5;
		    		a = p*-3;
		    	} else if( iblockaccess.getBlockId(x-1, y+1, z+2) == MersEtOceans.vague.blockID ) {
		    		b = p*-5;
		    		c = p*-3;
		    	} else if( iblockaccess.getBlockId(x+1, y+1, z+2) == MersEtOceans.vague.blockID ) {
		    		c = p*-5;
		    		b = p*-3;
		    	}
		    	
		    	else if( iblockaccess.getBlockId(x-2, y+1, z-2) == MersEtOceans.vague.blockID ) {
		    		a = p*-3;
		    	} else if( iblockaccess.getBlockId(x+2, y+1, z+2) == MersEtOceans.vague.blockID ) {
		    		c = p*-3;
		    	} else if( iblockaccess.getBlockId(x+2, y+1, z-2) == MersEtOceans.vague.blockID ) {
		    		d = p*-3;
		    	} else if( iblockaccess.getBlockId(x-2, y+1, z+2) == MersEtOceans.vague.blockID ) {
		    		b = p*-3;
		    	}
		    	
	        }
	    }
	    
	}
}
*/