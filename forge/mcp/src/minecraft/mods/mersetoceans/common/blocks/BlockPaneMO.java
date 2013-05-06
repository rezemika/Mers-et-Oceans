package mods.mersetoceans.common.blocks;

import mods.mersetoceans.client.ClientProxy;
import net.minecraft.block.BlockPane;
import net.minecraft.block.material.Material;

public class BlockPaneMO extends BlockPane {

    public BlockPaneMO(int id, String name, Material material) {
        super(id, "mersetoceans:"+name, "mersetoceans:"+name, material, true);
        setHardness(0.5F);
    }
    
}