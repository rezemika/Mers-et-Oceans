package com.mersetoceans;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityEggInfo;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.MinecraftForge;

import com.mersetoceans.client.CreativeTabsMO;
import com.mersetoceans.client.meduse.EntityMeduse;
import com.mersetoceans.common.CommonProxy;
import com.mersetoceans.common.TileEntityVague;
import com.mersetoceans.common.blocks.BlockGrassMO;
import com.mersetoceans.common.blocks.BlockMO;
import com.mersetoceans.common.blocks.BlockOreMO;
import com.mersetoceans.common.blocks.BlockPaneMO;
import com.mersetoceans.common.blocks.BlockTorchMO;
import com.mersetoceans.common.blocks.BlockVague;
import com.mersetoceans.common.blocks.BlockWater;
import com.mersetoceans.common.dimension.BlockPortal;
import com.mersetoceans.common.items.ItemFoodMO;
import com.mersetoceans.common.items.ItemHuitreFermee;
import com.mersetoceans.common.items.ItemMO;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = "mersetoceans", name = "Mers Et Oceans", version = "1.3.6")
@NetworkMod(clientSideRequired = true, serverSideRequired = true)

public class MersEtOceans {
	
	@Instance("MersEtOceans")
	public static MersEtOceans instance;
	
	@SidedProxy(clientSide="com.mersetoceans.client.ClientProxy", serverSide="com.mersetoceans.common.CommonProxy")
	public static CommonProxy proxy;
	

	static int startEntityId = 300;
	public static int dimension = 20; 
	
	@Init
	public void load(FMLInitializationEvent event) {

        proxy.registerRenderThings();
        
		itemNames();
		itemRecipes();
		
		// Annulation block :
		Block.blocksList[9] = null;
		
		blockInit();
		blockNamesAndRegister();
		blockHarvest();
		blockRecipes();

		// Enregistrement des TileEntity
		GameRegistry.registerTileEntity(TileEntityVague.class, "TileEntityVague");
        
		/*
		EntityRegistry.registerModEntity(EntityOcean.class, "EntityOcean", 1, this, 80, 3, true);
		EntityRegistry.addSpawn(EntityOcean.class, 10, 2, 4, EnumCreatureType.monster, BiomeGenBase.desert, BiomeGenBase.desertHills, BiomeGenBase.forest);
		registerEntityEgg(EntityOcean.class, 0x7A65CF, 0x4DF200);
		DimensionManager.registerProviderType(dimension, WorldProviderMO.class, false);
		DimensionManager.registerDimension(dimension, dimension);
		*/
		
		EntityRegistry.registerModEntity(EntityMeduse.class, "EntityMob", 1, this, 80, 3, true);
		EntityRegistry.addSpawn(EntityMeduse.class, 10, 2, 4, EnumCreatureType.monster, BiomeGenBase.beach, BiomeGenBase.extremeHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.forest, BiomeGenBase.forestHills, BiomeGenBase.jungle, BiomeGenBase.jungleHills, BiomeGenBase.mushroomIsland, BiomeGenBase.mushroomIslandShore, BiomeGenBase.ocean, BiomeGenBase.plains, BiomeGenBase.river, BiomeGenBase.swampland);
		LanguageRegistry.instance().addStringLocalization("entity.Tutorial_Tutorialmod.Tutorial.name", "Tutorial");
		registerEntityEgg(EntityMeduse.class, 0xe2baba, 0xe2dddd);
		
	}

	public static int getUniqueEntityId() {
		do {
			startEntityId++;
		} while (EntityList.getStringFromID(startEntityId) != null);
			return startEntityId;
	}
	
	public static void registerEntityEgg(Class<? extends Entity> entity, int primaryColor, int secondaryColor) {
		int id = getUniqueEntityId();
		EntityList.IDtoClassMapping.put(id, entity);
		EntityList.entityEggs.put(id, new EntityEggInfo(id, primaryColor, secondaryColor));
	}
	
    // Ocean tabs
    
    public static CreativeTabs tabOceanMaterials = new CreativeTabsMO("OceansMaterials");
    public static CreativeTabs tabOceanFood = new CreativeTabsMO("OceansFood");
    public static CreativeTabs tabOceanBlock = new CreativeTabsMO("OceansBlock");
    
    
    // items

	public static ItemHuitreFermee huitreFermee    = new ItemHuitreFermee (700, 15,    MersEtOceans.tabOceanFood);
	//public static  BouteillePlonge bouteillePlonge = new BouteillePlonge  (701, 43,    MersEtOceans.tabOceanMaterials);
	public static       ItemFoodMO huitreOuverte   = new ItemFoodMO       (702, 15+16, MersEtOceans.tabOceanFood, 4, .3F, false);
	public static           ItemMO cristalBulle    = new ItemMO           (703, 27,    MersEtOceans.tabOceanMaterials);
	//public static           Harpon harpon          = new Harpon           (704, 112,   MersEtOceans.tabOceanMaterials);
    public static           ItemMO longueVue       = new ItemMO           (705, 42,    MersEtOceans.tabOceanMaterials);
	public static       ItemFoodMO palourde        = new ItemFoodMO       (706, 14,    MersEtOceans.tabOceanFood, 4, .3F, false);
	public static           ItemMO perle           = new ItemMO           (707, 13,    MersEtOceans.tabOceanMaterials);
	public static           ItemMO pinceCrabeCrue  = new ItemMO           (708, 47,    MersEtOceans.tabOceanFood);
	public static       ItemFoodMO pinceCrabeCuite = new ItemFoodMO       (709, 46,    MersEtOceans.tabOceanFood, 4, .3F, false);
	public static           ItemMO aberlan         = new ItemMO           (710, 28,    MersEtOceans.tabOceanMaterials);
	public static       ItemFoodMO theSargasses    = new ItemFoodMO       (711, 30,    MersEtOceans.tabOceanFood, 4, .3F, false);
	public static           ItemMO lingotAberlan   = new ItemMO           (712, 44,    MersEtOceans.tabOceanMaterials);
	public static           ItemMO spinel          = new ItemMO           (714, 45,    MersEtOceans.tabOceanMaterials);
	public static           ItemMO lingoPerle      = new ItemMO           (715, 29,    MersEtOceans.tabOceanMaterials);
	public static           ItemMO poudreAberlan   = new ItemMO           (716, 12,    MersEtOceans.tabOceanMaterials);
	
    public static void itemNames() {
		setName(huitreFermee, "huitreFermee");
		setName(huitreOuverte, "huitreOuverte");
		setName(palourde, "palourde");
		setName(pinceCrabeCrue, "pinceCrabeCrue");
		setName(pinceCrabeCuite, "pinceCrabeCuite");
		setName(theSargasses, "theSargasses");
		setName(longueVue, "longueVue");
		setName(cristalBulle, "cristalBulle");
		setName(perle, "perle");
		setName(poudreAberlan, "poudreAbysse");
		setName(lingotAberlan, "lingotAberlan");
		setName(aberlan, "aberlan");
		setName(spinel, "spinel");
		setName(lingoPerle, "lingoPerle");
		//setItemName(bouteillePlonge, "bouteillePlonge");
		//setItemName(harpon, "harpon");
    }
   
    public static void itemRecipes() {}
    

    
    // block
    

	public static        BlockWater waterStill;
	public static           BlockMO rock             = new BlockMO          (700, 80, Material.rock);
	/* dev helper  public static BlockStartVague startvague = new BlockStartVague(701, Material.sponge);*/
	public static        BlockVague vague            = new BlockVague       (702, Material.water);
	public static      BlockGrassMO terreAbysse      = new BlockGrassMO     (703, 33);
	public static      BlockTorchMO torcheAbysse     = new BlockTorchMO     (704, 16);
	public static           BlockMO vannes           = new BlockMO          (705, 2,  Material.wood);
	public static           BlockMO briqueAbyss      = new BlockMO          (706, 4,  Material.rock);
	public static           BlockMO briqueAbyss1     = new BlockMO          (707, 20, Material.rock);
	public static           BlockMO briqueAbyss2     = new BlockMO          (708, 21, Material.rock);
	public static           BlockMO briqueAbyssBulle = new BlockMO          (709, 5,  Material.rock);
	public static           BlockMO lampeAberlan     = new BlockMO          (710, 3,  Material.glass);
	public static        BlockOreMO glowstoneAberlan = new BlockOreMO       (711, 81);
    public static             Block portal           = new BlockPortal      (712, 34);
    
	public static        BlockOreMO rocklisse        = new BlockOreMO       (714, 64);
	public static        BlockOreMO rockBulle        = new BlockOreMO       (715, 85);
	
	public static        BlockOreMO rockDiamonds     = new BlockOreMO       (717, 67);
	public static        BlockOreMO rockEmeraude     = new BlockOreMO       (718, 66);
	
	public static           BlockMO rockIron         = new BlockMO          (720, 69, Material.rock);
	public static        BlockOreMO rockLapis        = new BlockOreMO       (721, 83);
	public static           BlockMO rockOr           = new BlockMO          (722, 68, Material.rock);
	public static        BlockOreMO rockRedstone     = new BlockOreMO       (723, 82);
	public static        BlockOreMO rockSpinel       = new BlockOreMO       (724, 84);
	public static        BlockOreMO rockAberlan      = new BlockOreMO       (725, 65);
	public static           BlockMO cubeAberlan      = new BlockMO          (726, 49, Material.rock);
	public static       BlockPaneMO verreRenforce    = new BlockPaneMO      (727, 34, 148, Material.glass, true);
	public static           BlockMO basalte          = new BlockMO          (728, 0,  Material.rock);

	private void blockInit() {
		torcheAbysse     .setCreativeTab(this.tabOceanMaterials).setHardness(0F)                     .setLightValue(0.9375F);
		basalte          .setCreativeTab(this.tabOceanBlock)    .setHardness(1.5F).setResistance(10F);
		terreAbysse      .setCreativeTab(this.tabOceanBlock)    .setHardness(.5F);
		vannes           .setCreativeTab(this.tabOceanBlock)    .setHardness(2.5F);
		briqueAbyss      .setCreativeTab(this.tabOceanBlock)    .setHardness(1.5F).setResistance(10F);
		briqueAbyss1     .setCreativeTab(this.tabOceanBlock)    .setHardness(1.5F).setResistance(10F);
		briqueAbyss2     .setCreativeTab(this.tabOceanBlock)    .setHardness(1.5F).setResistance(10F);
		briqueAbyssBulle .setCreativeTab(this.tabOceanBlock)    .setHardness(1.5F).setResistance(10F);
		lampeAberlan     .setCreativeTab(this.tabOceanBlock)    .setHardness(.3F)                                        .setStepSound(Block.soundGlassFootstep);
		rockBulle        .setCreativeTab(this.tabOceanBlock)    .setHardness(1.5F).setResistance(10F);
		rockIron         .setCreativeTab(this.tabOceanBlock)    .setHardness(3F)  .setResistance(5F)                     .setStepSound(Block.soundStoneFootstep);
		rockOr           .setCreativeTab(this.tabOceanBlock)    .setHardness(3F)  .setResistance(5F)                     .setStepSound(Block.soundStoneFootstep);
		cubeAberlan      .setCreativeTab(this.tabOceanBlock)    .setHardness(3F)  .setResistance(5F);
		glowstoneAberlan .setCreativeTab(this.tabOceanBlock)    .setHardness(.3F)                    .setLightValue(1.0F).setStepSound(Block.soundGlassFootstep);
		rockDiamonds     .setCreativeTab(this.tabOceanBlock)    .setHardness(3F)  .setResistance(5F)                     .setStepSound(Block.soundStoneFootstep);
		rockEmeraude     .setCreativeTab(this.tabOceanBlock)    .setHardness(3F)  .setResistance(5F)                     .setStepSound(Block.soundStoneFootstep);
		rockLapis        .setCreativeTab(this.tabOceanBlock)    .setHardness(3F)  .setResistance(5F)                     .setStepSound(Block.soundStoneFootstep);
		rockRedstone     .setCreativeTab(this.tabOceanBlock)    .setHardness(3F)  .setResistance(5F)                     .setStepSound(Block.soundStoneFootstep);
		rockSpinel       .setCreativeTab(this.tabOceanBlock)    .setHardness(3F)  .setResistance(5F)                     .setStepSound(Block.soundStoneFootstep);
		rockAberlan      .setCreativeTab(this.tabOceanBlock)    .setHardness(3F)  .setResistance(5F)                     .setStepSound(Block.soundStoneFootstep);
		portal           .setCreativeTab(this.tabOceanBlock);
		waterStill       = new BlockWater(9, Material.water);
		verreRenforce    .setCreativeTab(this.tabOceanBlock)    .setHardness( .3F)                                       .setStepSound(Block.soundGlassFootstep);
		vague            .setCreativeTab(this.tabOceanBlock);
		rock             .setCreativeTab(this.tabOceanBlock)    .setHardness(2F)  .setResistance(10F)                    .setStepSound(Block.soundStoneFootstep);
		rocklisse        .setCreativeTab(this.tabOceanBlock)    .setHardness(3F)  .setResistance(5F)                     .setStepSound(Block.soundStoneFootstep);
		
	}
    
    public static void blockNamesAndRegister() {
		setNameAndRegister(basalte, "basalte");
		setNameAndRegister(terreAbysse, "terreAbysse");
		setNameAndRegister(torcheAbysse, "torcheAbysse");
		setNameAndRegister(vannes, "vannes");
		setNameAndRegister(briqueAbyss, "briqueAbyss");
		setNameAndRegister(briqueAbyss1, "briqueAbyss1");
		setNameAndRegister(briqueAbyss2, "briqueAbyss2");
		setNameAndRegister(briqueAbyssBulle, "briqueAbyssBulle");
		setNameAndRegister(lampeAberlan, "lampeAberlan");
		setNameAndRegister(glowstoneAberlan, "glowstoneAberlan");
		setNameAndRegister(rock, "rock");
		setNameAndRegister(rocklisse, "rocklisse");
		setNameAndRegister(rockBulle, "rockBulle");
		setNameAndRegister(rockDiamonds, "rockDiamonds");
		setNameAndRegister(rockEmeraude, "rockEmeraude");
		setNameAndRegister(rockIron, "rockIron");
		setNameAndRegister(rockLapis, "rockLapis");
		setNameAndRegister(rockOr, "rockOr");
		setNameAndRegister(rockRedstone, "rockRedstone");
		setNameAndRegister(rockSpinel, "rockSpinel");
		setNameAndRegister(rockAberlan, "rockAberlan");
		setNameAndRegister(cubeAberlan, "cubeAberlan");
		setNameAndRegister(waterStill, "water");
		setNameAndRegister(portal, "portal");
		setNameAndRegister(verreRenforce, "verreRenforce");
		setNameAndRegister(vague, "vague");
		//setName(startvague, "startvague");
    }

	private void blockHarvest() {
		MinecraftForge.setBlockHarvestLevel(basalte, "pickaxe", 0);
		MinecraftForge.setBlockHarvestLevel(terreAbysse, "shovel", 0);
		MinecraftForge.setBlockHarvestLevel(vannes, "axe", 0);
		MinecraftForge.setBlockHarvestLevel(briqueAbyss, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(briqueAbyss1, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(briqueAbyss2, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(briqueAbyssBulle, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(glowstoneAberlan, "pickaxe", 0);
		MinecraftForge.setBlockHarvestLevel(rock, "pickaxe", 0);
		MinecraftForge.setBlockHarvestLevel(rocklisse, "pickaxe", 0);
		MinecraftForge.setBlockHarvestLevel(rockBulle, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(rockDiamonds, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(rockEmeraude, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(rockIron, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(rockLapis, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(rockOr, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(rockRedstone, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(rockSpinel, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(rockAberlan, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(cubeAberlan, "pickaxe", 0);
	}
   
    public static void blockRecipes() {
		GameRegistry.addRecipe(new ItemStack(torcheAbysse,  1),
				new Object[] {  "X",   "O",         'X', poudreAberlan,   'O', Item.stick    });
		GameRegistry.addRecipe(new ItemStack(lampeAberlan,  1),
				new Object[] { " O ", "OXO", " O ", 'X', briqueAbyss,     'O', poudreAberlan });
		GameRegistry.addRecipe(new ItemStack(verreRenforce, 1),
				new Object[] { "XOX", "OOO", "XOX", 'X', Block.thinGlass, 'O', Item.ingotIron });
		
		GameRegistry.addRecipe(new ItemStack(briqueAbyss, 4),
				new Object[] { "XX",  "XX",         'X', rocklisse });
		GameRegistry.addShapelessRecipe(new ItemStack(briqueAbyss1, 1),
				new Object[] { briqueAbyss });
		GameRegistry.addShapelessRecipe(new ItemStack(briqueAbyss2, 1),
				new Object[] { briqueAbyss1 });
		GameRegistry.addShapelessRecipe(new ItemStack(briqueAbyss, 1),
				new Object[] { briqueAbyss2 });
		
		GameRegistry.addShapelessRecipe(new ItemStack(briqueAbyssBulle, 1),
				new Object[] { briqueAbyss, cristalBulle });
		GameRegistry.addShapelessRecipe(new ItemStack(briqueAbyssBulle, 1),
				new Object[] { briqueAbyss1, cristalBulle });
		GameRegistry.addShapelessRecipe(new ItemStack(briqueAbyssBulle, 1),
				new Object[] { briqueAbyss2, cristalBulle });
	}

    
    
    
    
    
    
    
    public static void setName( Item item, String name) {
    	item.setItemName(name);
		LanguageRegistry.addName(item, name);
    }
    
    public static void setNameAndRegister( Block block, String name) {
    	block.setBlockName(name);
		LanguageRegistry.addName(block, name);
		GameRegistry.registerBlock(block, name);
    }
	
}
