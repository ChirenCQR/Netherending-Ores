package org.icannt.netherendingores.common.registry;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.icannt.netherendingores.client.block.itemblock.ItemBlockBasic;
import org.icannt.netherendingores.client.block.itemblock.ItemBlockOreEndModded1;
import org.icannt.netherendingores.client.block.itemblock.ItemBlockOreEndModded2;
import org.icannt.netherendingores.client.block.itemblock.ItemBlockOreEndVanilla;
import org.icannt.netherendingores.client.block.itemblock.ItemBlockOreNetherModded1;
import org.icannt.netherendingores.client.block.itemblock.ItemBlockOreNetherModded2;
import org.icannt.netherendingores.client.block.itemblock.ItemBlockOreNetherVanilla;
import org.icannt.netherendingores.client.block.itemblock.ItemBlockOreOther1;
import org.icannt.netherendingores.common.block.blocks.BlockCreativeTab;
import org.icannt.netherendingores.common.block.blocks.BlockMonsterEndEndermite;
import org.icannt.netherendingores.common.block.blocks.BlockMonsterNetherNetherfish;
import org.icannt.netherendingores.common.block.blocks.BlockOreEndModded1;
import org.icannt.netherendingores.common.block.blocks.BlockOreEndModded2;
import org.icannt.netherendingores.common.block.blocks.BlockOreEndVanilla;
import org.icannt.netherendingores.common.block.blocks.BlockOreNetherModded1;
import org.icannt.netherendingores.common.block.blocks.BlockOreNetherModded2;
import org.icannt.netherendingores.common.block.blocks.BlockOreNetherVanilla;
import org.icannt.netherendingores.common.block.blocks.BlockOreOther1;
import org.icannt.netherendingores.lib.Config;
import org.icannt.netherendingores.lib.Info;
import org.icannt.netherendingores.lib.Log;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;

/**
 * Created by ICannt on 17/08/17.
 */

@GameRegistry.ObjectHolder(Info.MOD_ID)
public class BlockRegistry {

	@GameRegistry.ObjectHolder("creative_tab")
    public static final BlockCreativeTab CREATIVE_TAB = new BlockCreativeTab();

	@GameRegistry.ObjectHolder("block_end_endermite")
    public static final BlockMonsterEndEndermite BLOCK_END_ENDERMITE = new BlockMonsterEndEndermite();	
	
	@GameRegistry.ObjectHolder("block_nether_netherfish")
    public static final BlockMonsterNetherNetherfish BLOCK_NETHER_NETHERFISH = new BlockMonsterNetherNetherfish();	
       
    @GameRegistry.ObjectHolder("ore_end_modded_1")
    public static final BlockOreEndModded1 ORE_END_MODDED_1 = new BlockOreEndModded1();
    
    @GameRegistry.ObjectHolder("ore_end_modded_2")
    public static final BlockOreEndModded2 ORE_END_MODDED_2 = new BlockOreEndModded2();
    
    @GameRegistry.ObjectHolder("ore_end_vanilla")
    public static final BlockOreEndVanilla ORE_END_VANILLA = new BlockOreEndVanilla();
    
    @GameRegistry.ObjectHolder("ore_nether_modded_1")
    public static final BlockOreNetherModded1 ORE_NETHER_MODDED_1 = new BlockOreNetherModded1();
    
    @GameRegistry.ObjectHolder("ore_nether_modded_2")
    public static final BlockOreNetherModded2 ORE_NETHER_MODDED_2 = new BlockOreNetherModded2();
    
    @GameRegistry.ObjectHolder("ore_nether_vanilla")
    public static final BlockOreNetherVanilla ORE_NETHER_VANILLA = new BlockOreNetherVanilla();
    
    @GameRegistry.ObjectHolder("ore_other_1")
    public static final BlockOreOther1 ORE_OTHER_1 = new BlockOreOther1();

    private static final Block[] blocks = {
		CREATIVE_TAB,
		BLOCK_END_ENDERMITE,
		BLOCK_NETHER_NETHERFISH,
        ORE_END_MODDED_1,
        ORE_END_MODDED_2,
        ORE_END_VANILLA,
        ORE_NETHER_MODDED_1,
        ORE_NETHER_MODDED_2,
        ORE_NETHER_VANILLA,
        ORE_OTHER_1
    };
    
    /*
        Blocks.QUARTZ_ORE
    */
    
    private static final Block[] oreBlocks = {
        ORE_END_MODDED_1,
        ORE_END_MODDED_2,
        ORE_END_VANILLA,
        ORE_NETHER_MODDED_1,
        ORE_NETHER_MODDED_2,
        ORE_NETHER_VANILLA,
        ORE_OTHER_1
    };
    
    private static final ItemBlock[] itemBlocks = {
    	new ItemBlockBasic(CREATIVE_TAB),
    	new ItemBlockBasic(BLOCK_END_ENDERMITE),
    	new ItemBlockBasic(BLOCK_NETHER_NETHERFISH),
        new ItemBlockOreEndModded1(ORE_END_MODDED_1),
        new ItemBlockOreEndModded2(ORE_END_MODDED_2),
        new ItemBlockOreEndVanilla(ORE_END_VANILLA),
        new ItemBlockOreNetherModded1(ORE_NETHER_MODDED_1),
        new ItemBlockOreNetherModded2(ORE_NETHER_MODDED_2),
        new ItemBlockOreNetherVanilla(ORE_NETHER_VANILLA),
        new ItemBlockOreOther1(ORE_OTHER_1)
    };
    
    @Mod.EventBusSubscriber
    public static class RegistrationHandler {
    	
        public static final Set<ItemBlock> ITEM_BLOCKS = new HashSet<>();

        @SubscribeEvent
        public static void registerBlocks(RegistryEvent.Register<Block> event) {
        	
        	Log.debug("Registering Blocks");
        	
            final IForgeRegistry<Block> registry = event.getRegistry();
            registry.registerAll(blocks);
            
            Log.info("Registered Blocks");
            
        }

        @SubscribeEvent
        public static void registerItemBlocks(RegistryEvent.Register<Item> event) {
        	
        	Log.debug("Registering ItemBlocks");
        	
            final IForgeRegistry<Item> registry = event.getRegistry();
            for (ItemBlock iB : itemBlocks) {
                registry.register(iB.setRegistryName(iB.getBlock().getRegistryName()));
                ITEM_BLOCKS.add(iB);
            }
            
            Log.info("Registered ItemBlocks");
            
        }
        
        @SubscribeEvent
        public static void registerBiome(final RegistryEvent.Register<Biome> event) {
        	// Load the OreDict immediately after the Item registration event instead of during it, was causing problems with The Aether.
        	// Biome is the very next event.
        	OreDictionaryRegistry.registerDictionaryOres();
        }

    }
    
    @Mod.EventBusSubscriber
    public static class BlockEventHandler {
    	
    	// TODO: Find a new event, it needs to be an interaction event like blockbreak then cancel the explosion.
    	// Same goes for the pigmen it should be interaction with the block not breaking it.
    	
    	@SubscribeEvent
	    public static void onBlockBreak(BlockEvent.BreakEvent event) {

    		EntityPlayer player = event.getPlayer();
    		
    		if (!player.isCreative()) {
	        	
    			boolean silktouch = hasEnchant(player, Enchantments.SILK_TOUCH);
    			
		        World world = event.getWorld();
		        BlockPos blockPos = event.getPos();
		        IBlockState blockState = event.getState();
		
		        if (Config.zombiePigmanAnger && isAngeringOre(blockState)) {
		            if (!(silktouch && Config.zombiePigmanAngerSilkTouch)) angerPigmen(world, blockPos, player);
		        }
	        	
		        if (!(silktouch && Config.oreExplosionSilkTouch) && Config.oreExplosion) {
		        
		        	int blockDataOrdinal = getBlockDataOrdinal(blockState);
	        	
		        	if (blockDataOrdinal > -1) {		        		
		        		if (BlockData.values()[blockDataOrdinal].getOreExplosion()) {
		
			        		double fortuneMulti = 1;
			            	
			            	if (Config.oreExplosionFortune && Config.dropItems && BlockData.values()[blockDataOrdinal].getDropItems()) {
						        boolean fortune = hasEnchant(player, Enchantments.FORTUNE);
						        short fortuneLevel = getEnchantLevel(player, Enchantments.FORTUNE);
						        fortuneMulti = Config.oreExplosionFortune && fortune ? 1 + (0.1 * fortuneLevel * fortuneLevel) : 1;
			            	}
			            	
			            	double randExplodeChance = world.rand.nextDouble();
			            	
			                if (randExplodeChance <= Config.oreExplosionChance * fortuneMulti) {		                	
			                    world.createExplosion(player, blockPos.getX(), blockPos.getY(), blockPos.getZ(), (float) Config.oreExplosionStrength, true);
			                }			                
		        		}
		            }
		        }
	        }	
	    }
    }

    private static void angerPigmen(World world, BlockPos blockPos, EntityPlayer player) {

        BlockPos start = new BlockPos(blockPos).add(-Config.zombiePigmanAngerRangeRadius, -Config.zombiePigmanAngerRangeHeight, -Config.zombiePigmanAngerRangeRadius);
        BlockPos end = new BlockPos(blockPos).add(+Config.zombiePigmanAngerRangeRadius, +Config.zombiePigmanAngerRangeHeight, +Config.zombiePigmanAngerRangeRadius);

        AxisAlignedBB aabb  = new AxisAlignedBB(start, end);

        List<EntityPigZombie> list = world.getEntitiesWithinAABB(EntityPigZombie.class, aabb);
        for (EntityPigZombie pigman : list) pigman.setRevengeTarget(player);

    }

    private static boolean hasEnchant(EntityPlayer player, Enchantment enchant) {

        if (player == null || player.getHeldItemMainhand().isEmpty()) return false;

        NBTTagList list = player.getHeldItemMainhand().getEnchantmentTagList();

        for (int i = 0; i < list.tagCount(); i++) {
            short enchantId = list.getCompoundTagAt(i).getShort("id");
            if (Enchantment.getEnchantmentByID(enchantId) == enchant) return true;
        }

        return false;

    }
    
    private static short getEnchantLevel(EntityPlayer player, Enchantment enchant) {

        if (player == null || player.getHeldItemMainhand().isEmpty()) return 0;

        NBTTagList list = player.getHeldItemMainhand().getEnchantmentTagList();

        for (int i = 0; i < list.tagCount(); i++) {
            short enchantId = list.getCompoundTagAt(i).getShort("id");
            short enchantLvl = list.getCompoundTagAt(i).getShort("lvl");
            if (Enchantment.getEnchantmentByID(enchantId) == enchant) {
            	return enchantLvl;
            }
        }

        return 0;

    }

    //
    private static boolean isAngeringOre(IBlockState blockState) {

        //if (Loader.isModLoaded("tconstruct") && blockState.getBlock() == TinkerCommons.blockOre) return true;
        //if (blockState == TFBlocks.blockOreFluid.getStateFromMeta(3)) return true;
    	
        for (Block block : oreBlocks) {
        	if (blockState.getBlock() == block) return true;
        }

        return false;

    }
    
    //
    private static int getBlockDataOrdinal(IBlockState blockState) {
    	   	
        for (Block block : oreBlocks) {
        	if (blockState.getBlock() == block) {
    	        for (BlockData blockData : BlockData.values()) {
    	        	if (blockData.getModBlock() == blockState.getBlock() && blockData.getBlockMeta() == blockState.getBlock().getMetaFromState(blockState)) {
   	        			return blockData.ordinal();
    	        	}
    	        }
        	}
        }
        
        return -1;

    }
    
    @SideOnly(Side.CLIENT)
    public static void initModels() {
    	
    	CREATIVE_TAB.initItemBlockModels();
    	BLOCK_END_ENDERMITE.initItemBlockModels();
    	BLOCK_NETHER_NETHERFISH.initItemBlockModels();
    	
    	for (BlockData blockData : BlockData.values()) {    					
    		ModelLoader.setCustomModelResourceLocation(blockData.getModBlockItem(), blockData.getBlockMeta(), new ModelResourceLocation(blockData.getModBlockItem().getRegistryName(), "blocks=" + blockData.getModBlockStateNameValue()));
    	}
    	
    }

}
