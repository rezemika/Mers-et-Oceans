package mods.mersetoceans.common.blocks;

import java.util.Random;

import mods.mersetoceans.MersEtOceans;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockOreMO extends BlockMO {

	private int drop;
	private int min;
	private int max;
	
	public BlockOreMO(int id, String name, int drop, int min, int max, Material material ) {
		super(id, name, material);
		this.drop = drop;
		this.min = min;
		this.max = max;
	}
	
	public BlockOreMO(int id, String name, int drop, int min, int max ) {
		this(id, name, drop, min, max, Material.rock);
	}
    
    public int idDropped(int par1, Random random, int par3) {
        return drop;
    }
    
    public int quantityDropped(Random random) {
        return 1;
    }
    
    public int quantityDroppedWithBonus(int par1, Random random) {
        if (par1 > 0 && blockID != idDropped(0, random, par1)) {
        	
            int var3 = random.nextInt(par1 + 2) - 1;
            if (var3 < 0) var3 = 0;

            return this.quantityDropped(random) * (var3 + 1);
        } else
            return this.quantityDropped(random);
    }
    
    public void dropBlockAsItemWithChance(World world, int par2, int par3, int par4, int par5, float par6, int par7) {
    	
        super.dropBlockAsItemWithChance(world, par2, par3, par4, par5, par6, par7);

        if (this.idDropped(par5, world.rand, par7) != this.blockID) {
            int var8 = MathHelper.getRandomIntegerInRange(world.rand, min, max);
            this.dropXpOnBlockBreak(world, par2, par3, par4, var8);
        }
    }
    
}
