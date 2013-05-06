package mods.mersetoceans.common.biome;

import mods.mersetoceans.MersEtOceans;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.SpawnListEntry;
import cpw.mods.fml.common.Mod;

public class BiomeGenAbysses extends BiomeGenBase {
	
    public BiomeGenAbysses(int id) {
        super(id);
        
        setColor(16421912);
        setBiomeName("Abysses");
        setTemperatureRainfall(2.0F, 0.0F);
        setMinMaxHeight(-1.9F, 1.5F);
        
        
        this.spawnableCreatureList.clear();
        this.spawnableMonsterList.clear();
        this.spawnableWaterCreatureList.clear ();
        this.spawnableWaterCreatureList.add(new SpawnListEntry(EntitySquid.class, 20, 10, 10));
        //this.spawnableCreatureList.add(new SpawnListEntry(EntityWolf.class, 8, 4, 4));// permet de faire spawner les mobs de votre choix en remplaçant EntityWolf. 8 correspond au nombre de mobs par groupe.
        
        this.topBlock = (byte)MersEtOceans.grassAbysse.blockID;
        this.fillerBlock = (byte)MersEtOceans.rocklisse.blockID;
        
        //this.waterColorMultiplier = 0x0d3222;
    }
    
    /*@SideOnly(Side.CLIENT)
    public int getBiomeGrassColor() {
        double var1 = (int)((1.0D + 1.0D) / 255D);
        double var3 = (int)((1.0D + 1.0D) / 255D);
        var3 /= var1;
        return (ColorizerGrass.getGrassColor(var1, var3) & 16438071);
    }*/
    
    /*@SideOnly(Side.CLIENT)
    public int getBiomeFoliageColor() {
        double var1 = (int)((1.0D + 1.0D) / 255D);
        double var3 = (int)((1.0D + 1.0D) / 255D);
        var3 /= var1;
        return (ColorizerGrass.getGrassColor(var1, var3) & 0x4A4344);
    }*/
    
    //public int getSkyColorByTemp(float par1) { return 0x181d75; }
    
}
