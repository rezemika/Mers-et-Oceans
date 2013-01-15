package com.mersetoceans;

import com.mersetoceans.client.RenderWater;
import com.mersetoceans.client.CreativeTabsMO;
import com.mersetoceans.client.meduse.EntityMeduse;
import com.mersetoceans.common.CommonProxy;
import com.mersetoceans.common.TileEntityVague;
import com.mersetoceans.common.blocks.BlockGrassMO;
import com.mersetoceans.common.blocks.BlockMO;
import com.mersetoceans.common.blocks.BlockOreMO;
import com.mersetoceans.common.blocks.BlockPaneMO;
import com.mersetoceans.common.blocks.BlockStartVague;
import com.mersetoceans.common.blocks.BlockStoneAbysses;
import com.mersetoceans.common.blocks.BlockTallGrassMO;
import com.mersetoceans.common.blocks.BlockTorchMO;
import com.mersetoceans.common.blocks.BlockVague;
import com.mersetoceans.common.blocks.BlockWater;
import com.mersetoceans.common.blocks.VerreRenforce;
import com.mersetoceans.common.dimension.BlockPortal;
import com.mersetoceans.common.dimension.EntityOcean;
import com.mersetoceans.common.dimension.WorldProviderMO;
import com.mersetoceans.common.items.ItemFoodMO;
import com.mersetoceans.common.items.ItemHuitreFermee;
import com.mersetoceans.common.items.ItemMO;

import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.block.BlockPane;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityEggInfo;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemCoal;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.src.BaseMod;
import net.minecraft.src.ModLoader;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.biome.BiomeGenBase;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = "mersetoceans", name = "Mers Et Oceans", version = "1.3.4")
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
		blockNames();
		blockRegistration();
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
	public static       ItemFoodMO huitreOuverte   = new ItemFoodMO       (702, 15+16, MersEtOceans.tabOceanFood, 4, .3F, false);
	public static       ItemFoodMO palourde        = new ItemFoodMO       (706, 14,    MersEtOceans.tabOceanFood, 4, .3F, false);
	public static       ItemFoodMO pinceCrabeCuite = new ItemFoodMO       (709, 46,    MersEtOceans.tabOceanFood, 4, .3F, false);
	public static       ItemFoodMO theSargasses    = new ItemFoodMO       (711, 29,    MersEtOceans.tabOceanFood, 4, .3F, false);
	public static           ItemMO pinceCrabeCrue  = new ItemMO           (708, 47,    MersEtOceans.tabOceanFood);
	public static           ItemMO perle           = new ItemMO           (707, 13,    MersEtOceans.tabOceanMaterials);
	public static           ItemMO longueVue       = new ItemMO           (705, 42,    MersEtOceans.tabOceanMaterials);
	public static           ItemMO cristalBulle    = new ItemMO           (703, 27,    MersEtOceans.tabOceanMaterials);
	public static           ItemMO poudreAbysse    = new ItemMO           (716, 12,    MersEtOceans.tabOceanMaterials);
	public static           ItemMO lingotAberlan   = new ItemMO           (712, 44,    MersEtOceans.tabOceanMaterials);
	public static           ItemMO lingotAberlan2  = new ItemMO           (713, 44+16, MersEtOceans.tabOceanMaterials);
	public static           ItemMO spinel          = new ItemMO           (714, 45,    MersEtOceans.tabOceanMaterials);
	public static           ItemMO lingoPerle      = new ItemMO           (715, 28,    MersEtOceans.tabOceanMaterials);
	//public static  BouteillePlonge bouteillePlonge = new BouteillePlonge  (702, 43,    MersEtOceans.tabOceanMaterials);
	//public static           Harpon harpon          = new Harpon           (704, 112,   MersEtOceans.tabOceanMaterials);

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
		setName(poudreAbysse, "poudreAbysse");
		setName(lingotAberlan, "lingotAberlan");
		setName(lingotAberlan2, "lingotAberlan2");
		setName(spinel, "spinel");
		setName(lingoPerle, "lingoPerle");
		//setItemName(bouteillePlonge, "bouteillePlonge");
		//setItemName(harpon, "harpon");
    }
   
    public static void itemRecipes() {}
    

    
    // block
    

	public static  BlockTallGrassMO Herbe1           = new BlockTallGrassMO (712, 9,  1);
	public static  BlockTallGrassMO herbe2           = new BlockTallGrassMO (713, 25, 6);
	public static      BlockTorchMO torcheAbysse     = new BlockTorchMO     (704, 16);
	public static           BlockMO basalte          = new BlockMO          (728, 0,  Material.rock);
	public static      BlockGrassMO terreAbysse      = new BlockGrassMO     (703, 33);
	public static           BlockMO vannes           = new BlockMO          (705, 2,  Material.wood);
	public static           BlockMO briqueAbyss      = new BlockMO          (706, 5,  Material.rock);
	public static           BlockMO briqueAbyss1     = new BlockMO          (707, 6,  Material.rock);
	public static           BlockMO briqueAbyss2     = new BlockMO          (708, 7,  Material.rock);
	public static           BlockMO briqueAbyssBulle = new BlockMO          (709, 4,  Material.rock);
	public static           BlockMO lampeAbysse      = new BlockMO          (710, 3,  Material.glass);
	public static           BlockMO rockBulle        = new BlockMO          (715, 71, Material.rock);
	public static           BlockMO rockIron         = new BlockMO          (720, 69, Material.rock);
	public static           BlockMO rockOr           = new BlockMO          (722, 68, Material.rock);
	public static           BlockMO cubeAbysse       = new BlockMO          (726, 49, Material.rock);
	public static        BlockOreMO glowstoneAbysse  = new BlockOreMO       (711, 82, poudreAbysse.itemID);
	public static        BlockOreMO rockCoal         = new BlockOreMO       (716, 70, Item.coal.itemID);
	public static        BlockOreMO rockDiamonds     = new BlockOreMO       (717, 67, Item.diamond.itemID);
	public static        BlockOreMO rockEmeraude     = new BlockOreMO       (718, 66, Item.emerald.itemID);
	public static        BlockOreMO rockLapis        = new BlockOreMO       (721, 84, Item.dyePowder.itemID);
	public static        BlockOreMO rockRedstone     = new BlockOreMO       (723, 83, Item.redstone.itemID);
	public static        BlockOreMO rockSpinel       = new BlockOreMO       (724, 85, spinel.itemID);
	public static        BlockOreMO mineraiAbysses1  = new BlockOreMO       (725, 65, poudreAbysse.itemID);
	public static        BlockOreMO mineraiPerle     = new BlockOreMO       (714, 40, perle.itemID);
	public static BlockStoneAbysses rock             = new BlockStoneAbysses(700);
	public static       BlockPaneMO verreRenforce    = new BlockPaneMO      (727, 34, 148, Material.glass, true);
    public static             Block portal           = new BlockPortal      (251, 34);
	public static        BlockWater waterStill;
	public static        BlockVague vague            = new BlockVague       (702, Material.glass);
	/* dev helper  public static BlockStartVague startvague = new BlockStartVague(701, Material.sponge);*/

	private void blockInit() {
		Herbe1           .setCreativeTab(this.tabOceanMaterials);
		herbe2           .setCreativeTab(this.tabOceanMaterials);
		torcheAbysse     .setCreativeTab(this.tabOceanMaterials).setHardness(0F)                     .setLightValue(0.9375F);
		basalte          .setCreativeTab(this.tabOceanBlock)    .setHardness(1.5F).setResistance(10F);
		terreAbysse      .setCreativeTab(this.tabOceanBlock)    .setHardness(.5F);
		vannes           .setCreativeTab(this.tabOceanBlock)    .setHardness(2.5F);
		briqueAbyss      .setCreativeTab(this.tabOceanBlock)    .setHardness(1.5F).setResistance(10F);
		briqueAbyss1     .setCreativeTab(this.tabOceanBlock)    .setHardness(1.5F).setResistance(10F);
		briqueAbyss2     .setCreativeTab(this.tabOceanBlock)    .setHardness(1.5F).setResistance(10F);
		briqueAbyssBulle .setCreativeTab(this.tabOceanBlock)    .setHardness(1.5F).setResistance(10F);
		lampeAbysse      .setCreativeTab(this.tabOceanBlock)    .setHardness(.3F)                                        .setStepSound(Block.soundGlassFootstep);
		rockBulle        .setCreativeTab(this.tabOceanBlock)    .setHardness(1.5F).setResistance(10F);
		rockIron         .setCreativeTab(this.tabOceanBlock)    .setHardness(3F)  .setResistance(5F)                     .setStepSound(Block.soundStoneFootstep);
		rockOr           .setCreativeTab(this.tabOceanBlock)    .setHardness(3F)  .setResistance(5F)                     .setStepSound(Block.soundStoneFootstep);
		cubeAbysse       .setCreativeTab(this.tabOceanBlock)    .setHardness(3F)  .setResistance(5F);
		glowstoneAbysse  .setCreativeTab(this.tabOceanBlock)    .setHardness(.3F)                    .setLightValue(1.0F).setStepSound(Block.soundGlassFootstep);
		rockCoal         .setCreativeTab(this.tabOceanBlock)    .setHardness(3F)  .setResistance(5F)                     .setStepSound(Block.soundStoneFootstep);
		rockDiamonds     .setCreativeTab(this.tabOceanBlock)    .setHardness(3F)  .setResistance(5F)                     .setStepSound(Block.soundStoneFootstep);
		rockEmeraude     .setCreativeTab(this.tabOceanBlock)    .setHardness(3F)  .setResistance(5F)                     .setStepSound(Block.soundStoneFootstep);
		rockLapis        .setCreativeTab(this.tabOceanBlock)    .setHardness(3F)  .setResistance(5F)                     .setStepSound(Block.soundStoneFootstep);
		rockRedstone     .setCreativeTab(this.tabOceanBlock)    .setHardness(3F)  .setResistance(5F)                     .setStepSound(Block.soundStoneFootstep);
		rockSpinel       .setCreativeTab(this.tabOceanBlock)    .setHardness(3F)  .setResistance(5F)                     .setStepSound(Block.soundStoneFootstep);
		mineraiAbysses1  .setCreativeTab(this.tabOceanBlock)    .setHardness(3F)  .setResistance(5F)                     .setStepSound(Block.soundStoneFootstep);
		mineraiPerle     .setCreativeTab(this.tabOceanBlock)    .setHardness(3F)  .setResistance(5F)                     .setStepSound(Block.soundStoneFootstep);
        portal           .setCreativeTab(this.tabOceanBlock);
		waterStill       = new BlockWater(9, Material.water);
		verreRenforce    .setCreativeTab(this.tabOceanBlock)    .setHardness(0.3F)                                       .setStepSound(Block.soundGlassFootstep);
		vague            .setCreativeTab(this.tabOceanBlock);
		
	}
    
    public static void blockNames() {
		setName(basalte, "basalte");
		setName(terreAbysse, "terreAbysse");
		setName(torcheAbysse, "torcheAbysse");
		setName(vannes, "vannes");
		setName(briqueAbyss, "briqueAbyss");
		setName(briqueAbyss1, "briqueAbyss1");
		setName(briqueAbyss2, "briqueAbyss2");
		setName(briqueAbyssBulle, "briqueAbyssBulle");
		setName(lampeAbysse, "lampeAbysse");
		setName(glowstoneAbysse, "glowstoneAbysse");
		setName(Herbe1, "Herbe1");
		setName(herbe2, "herbe2");
		setName(rock, "rock");
		setName(rockBulle, "rockBulle");
		setName(rockCoal, "rockCoal");
		setName(rockDiamonds, "rockDiamonds");
		setName(rockEmeraude, "rockEmeraude");
		setName(rockIron, "rockIron");
		setName(rockLapis, "rockLapis");
		setName(rockOr, "rockOr");
		setName(rockRedstone, "rockRedstone");
		setName(rockSpinel, "rockSpinel");
		setName(mineraiAbysses1, "mineraiAbysses1");
		setName(cubeAbysse, "cubeAbysse");
		setName(mineraiPerle, "mineraiPerle");
		setName(waterStill, "water");
		setName(portal, "portal");
		setName(verreRenforce, "verreRenforce");
		setName(vague, "vague");
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
		MinecraftForge.setBlockHarvestLevel(glowstoneAbysse, "pickaxe", 0);
		MinecraftForge.setBlockHarvestLevel(mineraiPerle, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(rock, "pickaxe", 0);
		MinecraftForge.setBlockHarvestLevel(rockBulle, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(rockCoal, "pickaxe", 0);
		MinecraftForge.setBlockHarvestLevel(rockDiamonds, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(rockEmeraude, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(rockIron, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(rockLapis, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(rockOr, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(rockRedstone, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(rockSpinel, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(mineraiAbysses1, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(cubeAbysse, "pickaxe", 0);
	}
   
    public static void blockRegistration() {
		GameRegistry.registerBlock(verreRenforce, "verreRenforce");
		GameRegistry.registerBlock(basalte, "basalte");
		GameRegistry.registerBlock(terreAbysse, "terreAbysse");
		GameRegistry.registerBlock(torcheAbysse, "torcheAbysse");
		GameRegistry.registerBlock(vannes, "vannes");
		GameRegistry.registerBlock(briqueAbyss, "briqueAbyss");
		GameRegistry.registerBlock(briqueAbyss1, "briqueAbyss1");
		GameRegistry.registerBlock(briqueAbyss2, "briqueAbyss2");
		GameRegistry.registerBlock(briqueAbyssBulle, "briqueAbyssBulle");
		GameRegistry.registerBlock(lampeAbysse, "lampeAbysse");
		GameRegistry.registerBlock(glowstoneAbysse, "glowstoneAbysse");
		GameRegistry.registerBlock(Herbe1, "Herbe1");
		GameRegistry.registerBlock(herbe2, "herbe2");
		GameRegistry.registerBlock(rock, "rock");
		GameRegistry.registerBlock(rockBulle, "rockBulle");
		GameRegistry.registerBlock(rockCoal, "rockCoal");
		GameRegistry.registerBlock(rockDiamonds, "rockDiamonds");
		GameRegistry.registerBlock(rockEmeraude, "rockEmeraude");
		GameRegistry.registerBlock(rockIron, "rockIron");
		GameRegistry.registerBlock(rockLapis, "rockLapis");
		GameRegistry.registerBlock(rockOr, "rockOr");
		GameRegistry.registerBlock(rockRedstone, "rockRedstone");
		GameRegistry.registerBlock(rockSpinel, "rockSpinel");
		GameRegistry.registerBlock(mineraiAbysses1, "mineraiAbysses1");
		GameRegistry.registerBlock(cubeAbysse, "cubeAbysse");
    	GameRegistry.registerBlock(mineraiPerle, "mineraiPerle");
        GameRegistry.registerBlock(portal, "portal");
		GameRegistry.registerBlock(vague, "vague");
		//GameRegistry.registerBlock(startvague, "startvague");
    }
   
    public static void blockRecipes() {
		GameRegistry.addRecipe(new ItemStack(torcheAbysse, 1), new Object[] { "X", "O", 'X', poudreAbysse, 'O', Item.stick });
		GameRegistry.addRecipe(new ItemStack(lampeAbysse,  1), new Object[] { " O ", "OXO", " O ", 'X', briqueAbyss, 'O', poudreAbysse });
	}

    
    
    
    
    
    
    
    public static void setName( Item item, String name) {
    	item.setItemName(name);
		LanguageRegistry.addName(item, name);
    }
    
    public static void setName( Block block, String name) {
    	block.setBlockName(name);
		LanguageRegistry.addName(block, name);
    }
	
}
