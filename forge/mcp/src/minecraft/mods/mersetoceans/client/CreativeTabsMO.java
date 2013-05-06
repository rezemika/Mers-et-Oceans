package mods.mersetoceans.client;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CreativeTabsMO extends CreativeTabs {

    private final Object iconBlock;

    public CreativeTabsMO(String label, Object icon) {
	    super(label);
		iconBlock = icon;
	}
	
	@Override
	public ItemStack getIconItemStack() {
		try {
			Block[] hop = ((Block) iconBlock).blocksList;
			return new ItemStack((Block) iconBlock);
		} catch ( Exception e ) {
			return new ItemStack((Item) iconBlock);
		}
	}
	
}
