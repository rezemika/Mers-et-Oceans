package com.mersetoceans.common.blocks;

import java.util.Random;

import net.minecraft.block.BlockStationary;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.mersetoceans.MersEtOceans;
import com.mersetoceans.client.ClientProxy;
import com.mersetoceans.common.CommonProxy;
import com.mersetoceans.common.TileEntityVague;

public class BlockVague extends BlockFluidMO {
	
	public BlockVague(int id, Material material) {
		super(id, material);
		disableStats();
		setRequiresSelfNotify();
		this.setTickRandomly(true);
		
        this.blockIndexInTexture = 12 * 16 + 13;
	}
	
	@Override
	public String getTextureFile () { return CommonProxy.WATER_PNG; }
	
    public int getRenderType() { return ClientProxy.RENDERVAGUE; }
    
    public int getBlockTextureFromSideAndMetadata( int stap, int meta ) {
    	if( meta == 0 ) return (stap/20)%32;
    	if( meta == 1 ) return (stap/3)%64 + 32;
    	return (stap/3)%128 + 96;
    }
	
	public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random)	{
		par1World.setBlockWithNotify(par2, par3, par4, 0);
		par1World.setBlockWithNotify(par2, par3, par4, this.blockID);
	}

	/*public void init(World world, int x, int y, int z, int centerX, int centerZ, int step) {

    	int id = world.getBlockId(x, y, z);
    	int id2 = world.getBlockId(x, y-1, z);
    	if ( id == 0 && id2 == 9 ) {
			world.setBlock(x, y, z, MersEtOceans.vague.blockID);
			TileEntityVague tile = (TileEntityVague) world.getBlockTileEntity(x, y, z);
			tile.centerX = centerX;
			tile.centerZ = centerZ;
			tile.step = ++step;
	    	//world.scheduleBlockUpdate(x, y, z, this.blockID, 10);
    	}
		
	}*/
    
    /*public void updateTick(World world, int x, int y, int z, Random random) {
    	System.err.println("update");

		TileEntityVague tile = (TileEntityVague) world.getBlockTileEntity(x, y, z);
		
		int nx = tile.centerX+tile.step;
		//int nz = tile.centerZ+tile.step;

		MersEtOceans.vague.init(world, nx, y, z, tile.centerX, tile.centerZ, tile.step);
		
		if( tile.step % 3 == 0 ) {
			MersEtOceans.vague.init(world, nx, y, z-1, tile.centerX, tile.centerZ, tile.step);
			MersEtOceans.vague.init(world, nx, y, z+1, tile.centerX, tile.centerZ, tile.step);
		}
		
		world.setBlock(x, y, z, 0);
    	
	}*/
    
    //public boolean isOpaqueCube() { return false; }
    //public boolean renderAsNormalBlock() { return false; }

	//@Override
	//public TileEntity createNewTileEntity(World var1) {
	//	return new TileEntityVague();
	//}

}
