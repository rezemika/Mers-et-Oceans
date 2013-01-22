package com.mersetoceans.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import com.mersetoceans.MersEtOceans;
import com.mersetoceans.common.CommonProxy;

public class BlockStartVague extends Block {

	public BlockStartVague(int id, Material material) {
		super(id, 1, material);
		setCreativeTab(CreativeTabs.tabBlock);
	}
	
	@Override
	public String getTextureFile () { return CommonProxy.BLOCK_PNG; }
	
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int idk, float what, float these, float are) {

    	if( !world.isRemote ) {

    		int ny = y;
    		do { ny--; }
    		while ( world.getBlockId(x, ny, z) != 9 );
    		
    		MersEtOceans.waterStill.maj(world, x, ny, z);
    		
    		//int bempty = world.getBlockId(x, y-2, z);
    		//int bwater = world.getBlockId(x, y-2, z);
    		
    		//if ( /*bwater == 9 &&*/ bempty == 0 ) {

    			//MersEtOceans.vague.init(world, x, y-2, z, x, z, 0);
    			//
    			
	        //}
    	}
        return true;
    	
    }

}
