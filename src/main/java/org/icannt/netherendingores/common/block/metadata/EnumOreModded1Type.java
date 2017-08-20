package org.icannt.netherendingores.common.block.metadata;

import net.minecraft.item.EnumRarity;
import net.minecraft.util.IStringSerializable;

/**
 * Created by ICannt on 17/08/17.
 */
public enum EnumOreModded1Type implements IStringSerializable {
	
    ALUMINUM_ORE ("aluminum_ore", EnumRarity.COMMON, "", "oreAluminum", 0, 1, 3, 15),
    COPPER_ORE ("copper_ore", EnumRarity.COMMON, "", "oreCopper", 0, 1, 3, 15),
    IRIDIUM_ORE ("iridium_ore", EnumRarity.UNCOMMON, "", "oreIridium", 0, 3, 3, 15),
    LEAD_ORE ("lead_ore", EnumRarity.COMMON, "", "oreLead", 0, 2, 3, 15),
    MITHRIL_ORE ("mithril_ore", EnumRarity.RARE, "", "oreMithril", 0, 3, 3, 15),
    NICKEL_ORE ("nickel_ore", EnumRarity.COMMON, "", "oreNickel", 0, 2, 3, 15),
    PLATINUM_ORE ("platinum_ore", EnumRarity.UNCOMMON, "", "orePlatinum", 0, 3, 3, 15),
    SILVER_ORE ("silver_ore", EnumRarity.COMMON, "", "oreSilver", 0, 2, 3, 15),
    TIN_ORE ("tin_ore", EnumRarity.COMMON, "", "oreTin", 0, 1, 3, 15);

    private String name;
    private EnumRarity rarity;
    private String recipeOreDict;
    private String furnaceOreDict;
    private int light;
    private int harvestLevel;
    private float hardness;
    private float resistance;

    EnumOreModded1Type(String name, EnumRarity rarity, String recipeOreDict, String furnaceOreDict, int light, int harvestLevel, float hardness, float resistance) {
        this.name = name;
        this.rarity = rarity;
        this.recipeOreDict = recipeOreDict;
        this.furnaceOreDict = furnaceOreDict;
        this.light = light;
        this.harvestLevel = harvestLevel;
        this.hardness = hardness;
        this.resistance = resistance;
    }

    @Override
    public String getName() {
        return name;
    }
    
    public EnumRarity getRarity() {
        return rarity;
    }
    
    public String getRecipeOreDict() {
        return recipeOreDict;
    }
    
    public String getFurnaceOreDict() {
        return furnaceOreDict;
    }

    public int getLight() {
        return light;
    }
    
    public int getHarvestLevel() {
        return harvestLevel;
    }

    public float getHardness() {
        return hardness;
    }

    public float getResistance() {
        return resistance;
    }
    
}
