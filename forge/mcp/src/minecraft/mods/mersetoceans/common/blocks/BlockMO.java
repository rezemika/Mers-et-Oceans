package mods.mersetoceans.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.MinecraftForge;

public class BlockMO extends Block {

	public BlockMO(int id, String name, Material material) {
		super(id, material);
		setUnlocalizedName("mersetoceans:"+name);
	}

}
