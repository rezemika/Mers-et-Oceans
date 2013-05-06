package mods.mersetoceans;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import mods.mersetoceans.armure.ArmurePerle;
import mods.mersetoceans.armure.ArmureScaphandre;
import mods.mersetoceans.client.CreativeTabsMO;
import mods.mersetoceans.common.CommonProxy;
import mods.mersetoceans.common.PotionMO;
import mods.mersetoceans.common.biome.BiomeGenAbysses;
import mods.mersetoceans.common.biome.WorldGeneratorMO;
import mods.mersetoceans.common.blocks.BlockGrassMO;
import mods.mersetoceans.common.blocks.BlockHuitre;
import mods.mersetoceans.common.blocks.BlockMO;
import mods.mersetoceans.common.blocks.BlockOreMO;
import mods.mersetoceans.common.blocks.BlockPalourdeSand;
import mods.mersetoceans.common.blocks.BlockPaneMO;
import mods.mersetoceans.common.items.ItemFoodMO;
import mods.mersetoceans.common.items.ItemHuitreFermee;
import mods.mersetoceans.common.items.ItemMO;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = "mersetoceans", name = "Mers Et Oceans", version = "2.0.10")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)

public class MersEtOceans {
	
    // Ocean tabs
    public static CreativeTabs tabOceanTools;
    public static CreativeTabs tabOceanMaterials;
    public static CreativeTabs tabOceanFood;
    public static CreativeTabs tabOceanBlock;
    
    // items
	public static ItemHuitreFermee huitreFermee = new ItemHuitreFermee (700, "huitreFermee");
	public static ItemFoodMO huitreOuverte = new ItemFoodMO (702, "huitreOuverte", 4, .3F, false);
	public static ItemMO perle = new ItemMO (707, "perle");
	public static ItemMO lingoPerle = new ItemMO (715, "lingoPerle");
	public static ItemFoodMO palourde = new ItemFoodMO (702, "palourde", 4, .3F, false);
	
    // block
	public static BlockMO rock = (BlockMO) new BlockMO (251, "rock", Material.rock).setHardness(2.0F).setResistance(10.0F).setStepSound(Block.soundStoneFootstep);
	public static BlockOreMO rocklisse = (BlockOreMO) new BlockOreMO (252, "rocklisse", rock.blockID, 1, 1).setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundStoneFootstep);
	public static BlockGrassMO grassAbysse = (BlockGrassMO) new BlockGrassMO (253, "grassAbysse_1").setHardness(0.6F).setStepSound(Block.soundGrassFootstep);
	public static BlockHuitre blockHuitre = (BlockHuitre) new BlockHuitre (254, "blockHuitre");
	public static BlockPaneMO verreRenforce = (BlockPaneMO) new BlockPaneMO (727, "verreRenforce", Material.glass).setStepSound(Block.soundGlassFootstep);
	public static BlockPalourdeSand palourdeSand = new BlockPalourdeSand (255, "sand");
    
    // tools
	public static EnumToolMaterial materielperle = EnumHelper.addToolMaterial("materielperle", 4, 2343, 10.0F, 4, 15);
    public static Item swordPerle   = new ItemSword(900, materielperle).setUnlocalizedName("mersetoceans:swordPerle");
    public static Item pickaxePerle = new ItemPickaxe(901, materielperle).setUnlocalizedName("mersetoceans:pickaxePerle");
    public static Item axePerle     = new ItemAxe(902, materielperle).setUnlocalizedName("mersetoceans:axePerle");
    public static Item shovelPerle  = new ItemSpade(903, materielperle).setUnlocalizedName("mersetoceans:shovelPerle");
    public static Item hoePerle     = new ItemHoe(904, materielperle).setUnlocalizedName("mersetoceans:hoePerle");
	
    // armor
	public static EnumArmorMaterial armureperle = EnumHelper.addArmorMaterial("armureperle", 40, new int[]{4, 9, 7, 4}, 15);
	public static Item helmetPerle     = new ArmurePerle(800, armureperle, 0).setUnlocalizedName("mersetoceans:helmetPerle");
	public static Item chestplatePerle = new ArmurePerle(801, armureperle, 1).setUnlocalizedName("mersetoceans:chestplatePerle");
	public static Item leggingsPerle   = new ArmurePerle(802, armureperle, 2).setUnlocalizedName("mersetoceans:leggingsPerle");
	public static Item bootsPerle      = new ArmurePerle(803, armureperle, 3).setUnlocalizedName("mersetoceans:bootsPerle");

	public static EnumArmorMaterial armurescaphandre = EnumHelper.addArmorMaterial("armurescaphandre", 10,new int[]{10, 1, 1, 1}, 5);
	public static Item helmetScaphandre     = new ArmureScaphandre(804, armurescaphandre, 0).setUnlocalizedName("mersetoceans:helmetScaphandre");
	public static Item chestplateScaphandre = new ArmureScaphandre(805, armurescaphandre, 1).setUnlocalizedName("mersetoceans:chestplateScaphandre");
	public static Item leggingsScaphandre   = new ArmureScaphandre(806, armurescaphandre, 2).setUnlocalizedName("mersetoceans:leggingsScaphandre");
	public static Item bootsScaphandre      = new ArmureScaphandre(807, armurescaphandre, 3).setUnlocalizedName("mersetoceans:bootsScaphandre");

	
	// biome
	public static WorldGeneratorMO worldGen = new WorldGeneratorMO();
	
	public static BiomeGenBase abysses;
	
	


	
	
	private void registerBlock() {
		GameRegistry.registerBlock(rock, "rock");
		GameRegistry.registerBlock(rocklisse, "rocklisse");
		GameRegistry.registerBlock(grassAbysse, "grassAbysse");
		GameRegistry.registerBlock(blockHuitre, "blockHuitre");
		GameRegistry.registerBlock(verreRenforce, "Verre Renforcé");
		GameRegistry.registerBlock(palourdeSand, "Palourde Sand");
		
		MinecraftForge.setBlockHarvestLevel(rock, "pickaxe", 0);
		MinecraftForge.setBlockHarvestLevel(rocklisse, "pickaxe", 0);
		MinecraftForge.setBlockHarvestLevel(grassAbysse, "showel", 0);
		MinecraftForge.setBlockHarvestLevel(blockHuitre, "pickaxe", 0);
		MinecraftForge.setBlockHarvestLevel(palourdeSand, "showel", 0);
	}
	

	private void Recipes() {
		
		GameRegistry.addRecipe(new ItemStack(verreRenforce, 1),
				new Object[] {  "XYX" , "YYY" , "XYX" , 'X', Block.thinGlass, 'Y', Item.ingotIron });
		
		GameRegistry.addRecipe(new ItemStack(lingoPerle, 1),
				new Object[] {  "XXX" , "XXX" , "XXX" , 'X', perle });
		
		GameRegistry.addRecipe(new ItemStack(swordPerle, 1),
			new Object[] {  "X" ,  "X" ,  "I" , 'I', Item.stick, 'X', lingoPerle });
		GameRegistry.addRecipe(new ItemStack(pickaxePerle, 1),
			new Object[] { "XXX", " I ", " I ", 'I', Item.stick, 'X', lingoPerle });
		GameRegistry.addRecipe(new ItemStack(axePerle, 1),
			new Object[] { "XX" , "XI" , " I" , 'I', Item.stick, 'X', lingoPerle });
		GameRegistry.addRecipe(new ItemStack(shovelPerle, 1),
			new Object[] {  "X" ,  "I" ,  "I" , 'I', Item.stick, 'X', lingoPerle });
		GameRegistry.addRecipe(new ItemStack(hoePerle, 1),
			new Object[] { "XX" , " I" , " I" , 'I', Item.stick, 'X', lingoPerle });

		GameRegistry.addRecipe(new ItemStack(chestplatePerle, 1),
				new Object[] { "X X", "XXX", "XXX", 'X', lingoPerle });
		GameRegistry.addRecipe(new ItemStack(helmetPerle, 1),
				new Object[] { "XXX", "X X"       , 'X', lingoPerle });
		GameRegistry.addRecipe(new ItemStack(leggingsPerle, 1),
				new Object[] { "XXX", "X X", "X X", 'X', lingoPerle });
		GameRegistry.addRecipe(new ItemStack(bootsPerle, 1),
				new Object[] { "X X", "X X",        'X', lingoPerle });
		
		GameRegistry.addRecipe(new ItemStack(chestplateScaphandre, 1),
				new Object[] { "X X", "XXX", "OOO", 'X', Item.leather, 'O', Item.ingotIron });
		GameRegistry.addRecipe(new ItemStack(helmetScaphandre, 1),
				new Object[] { "XXX", "X#X", "OOO", 'X', Item.leather, 'O', Item.ingotIron, '#', verreRenforce });
		GameRegistry.addRecipe(new ItemStack(leggingsScaphandre, 1),
				new Object[] { "OOO", "X X", "O O", 'X', Item.leather, 'O', Item.ingotIron });
		GameRegistry.addRecipe(new ItemStack(bootsScaphandre, 1),
				new Object[] { "X X", "O O",        'X', Item.leather, 'O', Item.ingotIron });
	}
	
	
	private void registerLang() {
		LanguageRegistry.addName(huitreFermee, "Huitre");
		LanguageRegistry.addName(huitreOuverte, "Huitre Ouverte");
		LanguageRegistry.addName(perle, "Perle");
		LanguageRegistry.addName(lingoPerle, "Lingo perle");
		LanguageRegistry.addName(palourde, "palourde");
		
		LanguageRegistry.addName(rock, "Rock");
		LanguageRegistry.addName(rocklisse, "Rock Lisse");
		LanguageRegistry.addName(grassAbysse, "Grass Abysse");
		LanguageRegistry.addName(blockHuitre, "Huitre");
		LanguageRegistry.addName(verreRenforce, "Verre Renforcé");
		LanguageRegistry.addName(palourdeSand, "Palourde Sand");
		
		LanguageRegistry.addName(swordPerle, "Epée de Perle");
		LanguageRegistry.addName(pickaxePerle, "Pioche de Perle");
		LanguageRegistry.addName(axePerle, "Hache de Perle");
		LanguageRegistry.addName(shovelPerle, "Pelle de Perle");
		LanguageRegistry.addName(hoePerle, "Houe de Perle");
		
		LanguageRegistry.addName(helmetPerle, "Casque de Perle");
		LanguageRegistry.addName(chestplatePerle, "Plastron de Perle");
		LanguageRegistry.addName(leggingsPerle, "Jambiere de Perle");
		LanguageRegistry.addName(bootsPerle, "Bottes de Perle");
		
		LanguageRegistry.addName(helmetScaphandre, "Casque du Scaphandre");
		LanguageRegistry.addName(chestplateScaphandre, "Plastron du Scaphandre");
		LanguageRegistry.addName(leggingsScaphandre, "Jambiere du Scaphandre");
		LanguageRegistry.addName(bootsScaphandre, "Bottes du Scaphandre");
	}


	private void registerTab() {
	    tabOceanTools =  new CreativeTabsMO("OceansTools", swordPerle);
	    tabOceanMaterials = new CreativeTabsMO("OceansMaterials", perle);
		tabOceanFood = new CreativeTabsMO("OceansFood", huitreOuverte);
		tabOceanBlock = new CreativeTabsMO("OceansBlock", rock);
		
		huitreFermee.setCreativeTab(tabOceanFood);
		huitreOuverte.setCreativeTab(tabOceanFood);
		perle.setCreativeTab(tabOceanMaterials);
		lingoPerle.setCreativeTab(tabOceanMaterials);
		palourde.setCreativeTab(tabOceanFood);
		
		rock.setCreativeTab(tabOceanBlock);
		rocklisse.setCreativeTab(tabOceanBlock);
		grassAbysse.setCreativeTab(tabOceanBlock);
		verreRenforce.setCreativeTab(tabOceanBlock);
		palourdeSand.setCreativeTab(tabOceanBlock);
		
		swordPerle.setCreativeTab(this.tabOceanTools);
		pickaxePerle.setCreativeTab(this.tabOceanTools);
		axePerle.setCreativeTab(this.tabOceanTools);
		shovelPerle.setCreativeTab(this.tabOceanTools);
		hoePerle.setCreativeTab(this.tabOceanTools);
		
		helmetPerle.setCreativeTab(this.tabOceanTools);
		chestplatePerle.setCreativeTab(this.tabOceanTools);
		leggingsPerle.setCreativeTab(this.tabOceanTools);
		bootsPerle.setCreativeTab(this.tabOceanTools);

		helmetScaphandre.setCreativeTab(this.tabOceanTools);
		chestplateScaphandre.setCreativeTab(this.tabOceanTools);
		leggingsScaphandre.setCreativeTab(this.tabOceanTools);
		bootsScaphandre.setCreativeTab(this.tabOceanTools);
	}


	private void registerBiome() {
		abysses = new BiomeGenAbysses(40);
		GameRegistry.addBiome(abysses);
		BiomeDictionary.registerBiomeType(abysses, Type.WATER, Type.MAGICAL);
		
        GameRegistry.registerWorldGenerator(worldGen);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	@Instance("MersEtOceans")
	public static MersEtOceans instance;
	
	@SidedProxy(clientSide="mods.mersetoceans.client.ClientProxy", serverSide="mods.mersetoceans.common.CommonProxy", bukkitSide="mods.mersetoceans.common.CommonProxy")
	public static CommonProxy proxy;
	
	@PreInit
	public void initConfig(FMLPreInitializationEvent event) {
		proxy.registerRender();
		instance = this;
	}
	
	@Init
	public void load(FMLInitializationEvent event) {

		registerBlock();
		registerTab();
		registerBiome();
		Recipes();
		registerLang();

	}
	
}
