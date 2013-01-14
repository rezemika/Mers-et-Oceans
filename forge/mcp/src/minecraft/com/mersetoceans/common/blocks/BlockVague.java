package com.mersetoceans.common.blocks;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.mersetoceans.MersEtOceans;
import com.mersetoceans.client.ClientProxy;
import com.mersetoceans.common.TileEntityVague;

public class BlockVague extends BlockStationaryMO {

	public BlockVague(int id, Material material) {
		super(id, material);
		disableStats();
		setRequiresSelfNotify();
	}
	
    public int getRenderType() { return ClientProxy.RENDERVAGUE; }

	public void init(World world, int x, int y, int z, int centerX, int centerZ, int step) {

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
		
	}
    
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
    
    public boolean isOpaqueCube() { return false; }
    public boolean renderAsNormalBlock() { return false; }

	@Override
	public TileEntity createNewTileEntity(World var1) {
		return new TileEntityVague();
	}

}
