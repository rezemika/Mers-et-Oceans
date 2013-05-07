package mods.mersetoceans.common;

import mods.mersetoceans.MersEtOceans;
import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.UseHoeEvent;

public class EventHookContainerMO {
	
	@ForgeSubscribe
	public void useHoe(UseHoeEvent event) {
	
		World world = event.entityPlayer.worldObj;
		
		if (!world.isRemote && world.getGameRules().getGameRuleBooleanValue("doTileDrops")) {
			
			ItemStack itemStack = event.entityPlayer.inventory.getCurrentItem();
	        
	        if( world.getBlockId(event.x, event.y, event.z) == MersEtOceans.palourdeSand.blockID ) {
	        	itemStack.setItemDamage( itemStack.getItemDamage()+1 );
	        	int nb = 1;
	        	if( world.getBlockMetadata(event.x, event.y, event.z) == 15 && itemStack.itemID == MersEtOceans.hoePerle.itemID )
	        		nb = 6;
	        	else if( world.getBlockMetadata(event.x, event.y, event.z) == 15 )
	        		nb = 4;
	        	else if( world.getBlockMetadata(event.x, event.y, event.z) > 6 && itemStack.itemID == MersEtOceans.hoePerle.itemID )
	        		nb = 4;
	            world.spawnEntityInWorld( new EntityItem(world, event.x+.5, event.y+1, event.z+.5, new ItemStack(MersEtOceans.palourde, nb)) );
	        	world.setBlock(event.x, event.y, event.z, Block.sand.blockID, 1, 4);
	        }
			//if (event.isCancelable()) event.setCanceled(true);
		}
	}
	
	@ForgeSubscribe
	public void usePalourde(PlayerInteractEvent event) {
		
		World world = event.entityPlayer.worldObj;
		
		if (!world.isRemote && world.getGameRules().getGameRuleBooleanValue("doTileDrops")) {
			ItemStack itemStack = event.entityPlayer.inventory.getCurrentItem();

	        if( world.getBlockId(event.x, event.y, event.z) == Block.sand.blockID && itemStack != null && itemStack.itemID == MersEtOceans.palourde.itemID ) {
	        	itemStack.stackSize--;
	        	world.setBlock(event.x, event.y, event.z, MersEtOceans.palourdeSand.blockID, 1, 1);
	        }
		}

		//if (event.isCancelable()) event.setCanceled(true);
	}
}