package com.mersetoceans.common.dimension.structure;

import java.util.List;
import java.util.Random;

import com.mersetoceans.MersEtOceans;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;

public class ComponentAbyssesBridgeStraight extends ComponentAbyssesBridgePiece
{
    public ComponentAbyssesBridgeStraight(int par1, Random par2Random, StructureBoundingBox par3StructureBoundingBox, int par4)
    {
        super(par1);
        this.coordBaseMode = par4;
        this.boundingBox = par3StructureBoundingBox;
    }

    /**
     * Initiates construction of the Structure Component picked, at the current Location of StructGen
     */
    public void buildComponent(StructureComponent par1StructureComponent, List par2List, Random par3Random)
    {
        this.getNextComponentNormal((ComponentAbyssesBridgeStartPiece)par1StructureComponent, par2List, par3Random, 1, 3, false);
    }

    /**
     * Creates and returns a new component piece. Or null if it could not find enough room to place it.
     */
    public static ComponentAbyssesBridgeStraight createValidComponent(List par0List, Random par1Random, int par2, int par3, int par4, int par5, int par6)
    {
        StructureBoundingBox var7 = StructureBoundingBox.getComponentToAddBoundingBox(par2, par3, par4, -1, -3, 0, 5, 10, 19, par5);
        return isAboveGround(var7) && StructureComponent.findIntersecting(par0List, var7) == null ? new ComponentAbyssesBridgeStraight(par6, par1Random, var7, par5) : null;
    }

    /**
     * second Part of Structure generating, this for example places Spiderwebs, Mob Spawners, it closes Mineshafts at
     * the end, it adds Fences...
     */
    public boolean addComponentParts(World par1World, Random par2Random, StructureBoundingBox par3StructureBoundingBox)
    {
        this.fillWithBlocks(par1World, par3StructureBoundingBox, 0, 3, 0, 4, 4, 18, MersEtOceans.briqueAbyss.blockID, MersEtOceans.briqueAbyss.blockID, false);
        this.fillWithBlocks(par1World, par3StructureBoundingBox, 1, 5, 0, 3, 7, 18, 0, 0, false);
        this.fillWithBlocks(par1World, par3StructureBoundingBox, 0, 5, 0, 0, 5, 18, MersEtOceans.briqueAbyss.blockID, MersEtOceans.briqueAbyss.blockID, false);
        this.fillWithBlocks(par1World, par3StructureBoundingBox, 4, 5, 0, 4, 5, 18, MersEtOceans.briqueAbyss.blockID, MersEtOceans.briqueAbyss.blockID, false);
        this.fillWithBlocks(par1World, par3StructureBoundingBox, 0, 2, 0, 4, 2, 5, MersEtOceans.briqueAbyss.blockID, MersEtOceans.briqueAbyss.blockID, false);
        this.fillWithBlocks(par1World, par3StructureBoundingBox, 0, 2, 13, 4, 2, 18, MersEtOceans.briqueAbyss.blockID, MersEtOceans.briqueAbyss.blockID, false);
        this.fillWithBlocks(par1World, par3StructureBoundingBox, 0, 0, 0, 4, 1, 3, MersEtOceans.briqueAbyss.blockID, MersEtOceans.briqueAbyss.blockID, false);
        this.fillWithBlocks(par1World, par3StructureBoundingBox, 0, 0, 15, 4, 1, 18, MersEtOceans.briqueAbyss.blockID, MersEtOceans.briqueAbyss.blockID, false);

        for (int var4 = 0; var4 <= 4; ++var4)
        {
            for (int var5 = 0; var5 <= 2; ++var5)
            {
                this.fillCurrentPositionBlocksDownwards(par1World, MersEtOceans.briqueAbyss.blockID, 0, var4, -1, var5, par3StructureBoundingBox);
                this.fillCurrentPositionBlocksDownwards(par1World, MersEtOceans.briqueAbyss.blockID, 0, var4, -1, 18 - var5, par3StructureBoundingBox);
            }
        }

        this.fillWithBlocks(par1World, par3StructureBoundingBox, 0, 1, 1, 0, 4, 1, MersEtOceans.briqueAbyssBulle.blockID, MersEtOceans.briqueAbyssBulle.blockID, false);
        this.fillWithBlocks(par1World, par3StructureBoundingBox, 0, 3, 4, 0, 4, 4, MersEtOceans.briqueAbyssBulle.blockID, MersEtOceans.briqueAbyssBulle.blockID, false);
        this.fillWithBlocks(par1World, par3StructureBoundingBox, 0, 3, 14, 0, 4, 14, MersEtOceans.briqueAbyssBulle.blockID, MersEtOceans.briqueAbyssBulle.blockID, false);
        this.fillWithBlocks(par1World, par3StructureBoundingBox, 0, 1, 17, 0, 4, 17, MersEtOceans.briqueAbyssBulle.blockID, MersEtOceans.briqueAbyssBulle.blockID, false);
        this.fillWithBlocks(par1World, par3StructureBoundingBox, 4, 1, 1, 4, 4, 1, MersEtOceans.briqueAbyssBulle.blockID, MersEtOceans.briqueAbyssBulle.blockID, false);
        this.fillWithBlocks(par1World, par3StructureBoundingBox, 4, 3, 4, 4, 4, 4, MersEtOceans.briqueAbyssBulle.blockID, MersEtOceans.briqueAbyssBulle.blockID, false);
        this.fillWithBlocks(par1World, par3StructureBoundingBox, 4, 3, 14, 4, 4, 14, MersEtOceans.briqueAbyssBulle.blockID, MersEtOceans.briqueAbyssBulle.blockID, false);
        this.fillWithBlocks(par1World, par3StructureBoundingBox, 4, 1, 17, 4, 4, 17, MersEtOceans.briqueAbyssBulle.blockID, MersEtOceans.briqueAbyssBulle.blockID, false);
        return true;
    }
}
