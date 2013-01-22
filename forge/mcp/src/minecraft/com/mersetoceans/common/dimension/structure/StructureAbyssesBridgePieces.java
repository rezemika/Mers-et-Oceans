package com.mersetoceans.common.dimension.structure;

import java.util.List;
import java.util.Random;

public class StructureAbyssesBridgePieces {
	
    private static final StructureAbyssesBridgePieceWeight[] primaryComponents = new StructureAbyssesBridgePieceWeight[] {new StructureAbyssesBridgePieceWeight(ComponentAbyssesBridgeStraight.class, 30, 0, true), new StructureAbyssesBridgePieceWeight(ComponentAbyssesBridgeCrossing3.class, 10, 4), new StructureAbyssesBridgePieceWeight(ComponentAbyssesBridgeCrossing.class, 10, 4), new StructureAbyssesBridgePieceWeight(ComponentAbyssesBridgeStairs.class, 10, 3), new StructureAbyssesBridgePieceWeight(ComponentAbyssesBridgeThrone.class, 5, 2), new StructureAbyssesBridgePieceWeight(ComponentAbyssesBridgeEntrance.class, 5, 1)};
    private static final StructureAbyssesBridgePieceWeight[] secondaryComponents = new StructureAbyssesBridgePieceWeight[] {new StructureAbyssesBridgePieceWeight(ComponentAbyssesBridgeCorridor5.class, 25, 0, true), new StructureAbyssesBridgePieceWeight(ComponentAbyssesBridgeCrossing2.class, 15, 5), new StructureAbyssesBridgePieceWeight(ComponentAbyssesBridgeCorridor2.class, 5, 10), new StructureAbyssesBridgePieceWeight(ComponentAbyssesBridgeCorridor.class, 5, 10), new StructureAbyssesBridgePieceWeight(ComponentAbyssesBridgeCorridor3.class, 10, 3, true), new StructureAbyssesBridgePieceWeight(ComponentAbyssesBridgeCorridor4.class, 7, 2), new StructureAbyssesBridgePieceWeight(ComponentAbyssesBridgeAbyssesStalkRoom.class, 5, 2)};

    private static ComponentAbyssesBridgePiece createNextComponentRandom(StructureAbyssesBridgePieceWeight par0StructureAbyssesBridgePieceWeight, List par1List, Random par2Random, int par3, int par4, int par5, int par6, int par7)
    {
        Class var8 = par0StructureAbyssesBridgePieceWeight.weightClass;
        Object var9 = null;

        if (var8 == ComponentAbyssesBridgeStraight.class)
        {
            var9 = ComponentAbyssesBridgeStraight.createValidComponent(par1List, par2Random, par3, par4, par5, par6, par7);
        }
        else if (var8 == ComponentAbyssesBridgeCrossing3.class)
        {
            var9 = ComponentAbyssesBridgeCrossing3.createValidComponent(par1List, par2Random, par3, par4, par5, par6, par7);
        }
        else if (var8 == ComponentAbyssesBridgeCrossing.class)
        {
            var9 = ComponentAbyssesBridgeCrossing.createValidComponent(par1List, par2Random, par3, par4, par5, par6, par7);
        }
        else if (var8 == ComponentAbyssesBridgeStairs.class)
        {
            var9 = ComponentAbyssesBridgeStairs.createValidComponent(par1List, par2Random, par3, par4, par5, par6, par7);
        }
        else if (var8 == ComponentAbyssesBridgeThrone.class)
        {
            var9 = ComponentAbyssesBridgeThrone.createValidComponent(par1List, par2Random, par3, par4, par5, par6, par7);
        }
        else if (var8 == ComponentAbyssesBridgeEntrance.class)
        {
            var9 = ComponentAbyssesBridgeEntrance.createValidComponent(par1List, par2Random, par3, par4, par5, par6, par7);
        }
        else if (var8 == ComponentAbyssesBridgeCorridor5.class)
        {
            var9 = ComponentAbyssesBridgeCorridor5.createValidComponent(par1List, par2Random, par3, par4, par5, par6, par7);
        }
        else if (var8 == ComponentAbyssesBridgeCorridor2.class)
        {
            var9 = ComponentAbyssesBridgeCorridor2.createValidComponent(par1List, par2Random, par3, par4, par5, par6, par7);
        }
        else if (var8 == ComponentAbyssesBridgeCorridor.class)
        {
            var9 = ComponentAbyssesBridgeCorridor.createValidComponent(par1List, par2Random, par3, par4, par5, par6, par7);
        }
        else if (var8 == ComponentAbyssesBridgeCorridor3.class)
        {
            var9 = ComponentAbyssesBridgeCorridor3.createValidComponent(par1List, par2Random, par3, par4, par5, par6, par7);
        }
        else if (var8 == ComponentAbyssesBridgeCorridor4.class)
        {
            var9 = ComponentAbyssesBridgeCorridor4.createValidComponent(par1List, par2Random, par3, par4, par5, par6, par7);
        }
        else if (var8 == ComponentAbyssesBridgeCrossing2.class)
        {
            var9 = ComponentAbyssesBridgeCrossing2.createValidComponent(par1List, par2Random, par3, par4, par5, par6, par7);
        }
        else if (var8 == ComponentAbyssesBridgeAbyssesStalkRoom.class)
        {
            var9 = ComponentAbyssesBridgeAbyssesStalkRoom.createValidComponent(par1List, par2Random, par3, par4, par5, par6, par7);
        }

        return (ComponentAbyssesBridgePiece)var9;
    }

    static ComponentAbyssesBridgePiece createNextComponent(StructureAbyssesBridgePieceWeight par0StructureAbyssesBridgePieceWeight, List par1List, Random par2Random, int par3, int par4, int par5, int par6, int par7)
    {
        return createNextComponentRandom(par0StructureAbyssesBridgePieceWeight, par1List, par2Random, par3, par4, par5, par6, par7);
    }

    static StructureAbyssesBridgePieceWeight[] getPrimaryComponents()
    {
        return primaryComponents;
    }

    static StructureAbyssesBridgePieceWeight[] getSecondaryComponents()
    {
        return secondaryComponents;
    }
}
