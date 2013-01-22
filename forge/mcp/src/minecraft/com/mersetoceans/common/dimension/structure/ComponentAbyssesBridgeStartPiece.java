package com.mersetoceans.common.dimension.structure;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class ComponentAbyssesBridgeStartPiece extends ComponentAbyssesBridgeCrossing3 {
	
    /** Instance of StructureAbyssesBridgePieceWeight. */
    public StructureAbyssesBridgePieceWeight theAbyssesBridgePieceWeight;

    /**
     * Contains the list of valid piece weights for the set of nether bridge structure pieces.
     */
    public List primaryWeights = new ArrayList();

    /**
     * Contains the list of valid piece weights for the secondary set of nether bridge structure pieces.
     */
    public List secondaryWeights;
    public ArrayList field_74967_d = new ArrayList();

    public ComponentAbyssesBridgeStartPiece(Random par1Random, int par2, int par3)
    {
        super(par1Random, par2, par3);
        StructureAbyssesBridgePieceWeight[] var4 = StructureAbyssesBridgePieces.getPrimaryComponents();
        int var5 = var4.length;
        int var6;
        StructureAbyssesBridgePieceWeight var7;

        for (var6 = 0; var6 < var5; ++var6)
        {
            var7 = var4[var6];
            var7.field_78827_c = 0;
            this.primaryWeights.add(var7);
        }

        this.secondaryWeights = new ArrayList();
        var4 = StructureAbyssesBridgePieces.getSecondaryComponents();
        var5 = var4.length;

        for (var6 = 0; var6 < var5; ++var6)
        {
            var7 = var4[var6];
            var7.field_78827_c = 0;
            this.secondaryWeights.add(var7);
        }
    }
}
