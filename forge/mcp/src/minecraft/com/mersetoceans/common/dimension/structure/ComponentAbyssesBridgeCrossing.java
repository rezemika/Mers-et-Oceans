package com.mersetoceans.common.dimension.structure;

import java.util.List;
import java.util.Random;

import com.mersetoceans.MersEtOceans;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;

public class ComponentAbyssesBridgeCrossing extends ComponentAbyssesBridgePiece
{
    public ComponentAbyssesBridgeCrossing(int par1, Random par2Random, StructureBoundingBox par3StructureBoundingBox, int par4)
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
        this.getNextComponentNormal((ComponentAbyssesBridgeStartPiece)par1StructureComponent, par2List, par3Random, 2, 0, false);
        this.getNextComponentX((ComponentAbyssesBridgeStartPiece)par1StructureComponent, par2List, par3Random, 0, 2, false);
        this.getNextComponentZ((ComponentAbyssesBridgeStartPiece)par1StructureComponent, par2List, par3Random, 0, 2, false);
    }

    /**
     * Creates and returns a new component piece. Or null if it could not find enough room to place it.
     */
    public static ComponentAbyssesBridgeCrossing createValidComponent(List par0List, Random par1Random, int par2, int par3, int par4, int par5, int par6)
    {
        StructureBoundingBox var7 = StructureBoundingBox.getComponentToAddBoundingBox(par2, par3, par4, -2, 0, 0, 7, 9, 7, par5);
        return isAboveGround(var7) && StructureComponent.findIntersecting(par0List, var7) == null ? new ComponentAbyssesBridgeCrossing(par6, par1Random, var7, par5) : null;
    }

    /**
     * second Part of Structure generating, this for example places Spiderwebs, Mob Spawners, it closes Mineshafts at
     * the end, it adds Fences...
     */
    public boolean addComponentParts(World par1World, Random par2Random, StructureBoundingBox par3StructureBoundingBox)
    {
        this.fillWithBlocks(par1World, par3StructureBoundingBox, 0, 0, 0, 6, 1, 6, MersEtOceans.briqueAbyss.blockID, MersEtOceans.briqueAbyss.blockID, false);
        this.fillWithBlocks(par1World, par3StructureBoundingBox, 0, 2, 0, 6, 7, 6, 0, 0, false);
        this.fillWithBlocks(par1World, par3StructureBoundingBox, 0, 2, 0, 1, 6, 0, MersEtOceans.briqueAbyss.blockID, MersEtOceans.briqueAbyss.blockID, false);
        this.fillWithBlocks(par1World, par3StructureBoundingBox, 0, 2, 6, 1, 6, 6, MersEtOceans.briqueAbyss.blockID, MersEtOceans.briqueAbyss.blockID, false);
        this.fillWithBlocks(par1World, par3StructureBoundingBox, 5, 2, 0, 6, 6, 0, MersEtOceans.briqueAbyss.blockID, MersEtOceans.briqueAbyss.blockID, false);
        this.fillWithBlocks(par1World, par3StructureBoundingBox, 5, 2, 6, 6, 6, 6, MersEtOceans.briqueAbyss.blockID, MersEtOceans.briqueAbyss.blockID, false);
        this.fillWithBlocks(par1World, par3StructureBoundingBox, 0, 2, 0, 0, 6, 1, MersEtOceans.briqueAbyss.blockID, MersEtOceans.briqueAbyss.blockID, false);
        this.fillWithBlocks(par1World, par3StructureBoundingBox, 0, 2, 5, 0, 6, 6, MersEtOceans.briqueAbyss.blockID, MersEtOceans.briqueAbyss.blockID, false);
        this.fillWithBlocks(par1World, par3StructureBoundingBox, 6, 2, 0, 6, 6, 1, MersEtOceans.briqueAbyss.blockID, MersEtOceans.briqueAbyss.blockID, false);
        this.fillWithBlocks(par1World, par3StructureBoundingBox, 6, 2, 5, 6, 6, 6, MersEtOceans.briqueAbyss.blockID, MersEtOceans.briqueAbyss.blockID, false);
        this.fillWithBlocks(par1World, par3StructureBoundingBox, 2, 6, 0, 4, 6, 0, MersEtOceans.briqueAbyss.blockID, MersEtOceans.briqueAbyss.blockID, false);
        this.fillWithBlocks(par1World, par3StructureBoundingBox, 2, 5, 0, 4, 5, 0, MersEtOceans.briqueAbyssBulle.blockID, MersEtOceans.briqueAbyssBulle.blockID, false);
        this.fillWithBlocks(par1World, par3StructureBoundingBox, 2, 6, 6, 4, 6, 6, MersEtOceans.briqueAbyss.blockID, MersEtOceans.briqueAbyss.blockID, false);
        this.fillWithBlocks(par1World, par3StructureBoundingBox, 2, 5, 6, 4, 5, 6, MersEtOceans.briqueAbyssBulle.blockID, MersEtOceans.briqueAbyssBulle.blockID, false);
        this.fillWithBlocks(par1World, par3StructureBoundingBox, 0, 6, 2, 0, 6, 4, MersEtOceans.briqueAbyss.blockID, MersEtOceans.briqueAbyss.blockID, false);
        this.fillWithBlocks(par1World, par3StructureBoundingBox, 0, 5, 2, 0, 5, 4, MersEtOceans.briqueAbyssBulle.blockID, MersEtOceans.briqueAbyssBulle.blockID, false);
        this.fillWithBlocks(par1World, par3StructureBoundingBox, 6, 6, 2, 6, 6, 4, MersEtOceans.briqueAbyss.blockID, MersEtOceans.briqueAbyss.blockID, false);
        this.fillWithBlocks(par1World, par3StructureBoundingBox, 6, 5, 2, 6, 5, 4, MersEtOceans.briqueAbyssBulle.blockID, MersEtOceans.briqueAbyssBulle.blockID, false);

        for (int var4 = 0; var4 <= 6; ++var4)
        {
            for (int var5 = 0; var5 <= 6; ++var5)
            {
                this.fillCurrentPositionBlocksDownwards(par1World, MersEtOceans.briqueAbyss.blockID, 0, var4, -1, var5, par3StructureBoundingBox);
            }
        }

        return true;
    }
}
