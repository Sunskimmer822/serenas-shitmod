package net.serenas.shitmod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

public class Shitmod implements ModInitializer {

    public static final Item FABRIC_ITEM = new FabricItem(new Item.Settings().group(ItemGroup.MISC));

    public static final Block FABRIC_BLOCK = new FabricBlock();

    public static final Item HAUSBOMMER_ITEM = new Hausbommer(new Item.Settings().group(ItemGroup.MISC));

    public static final Item LEAN = new Lean(new Item.Settings().group(ItemGroup.FOOD).rarity(Rarity.UNCOMMON));

    public static final StatusEffect EXP = new ExpStatusEffect();

    public static final StatusEffect LEAN_EFFECT = new LeanStatusEffect();
    
    @Override
    public void onInitialize() {

        Registry.register(Registry.ITEM, new Identifier("shitmod", "fabric_item"), FABRIC_ITEM);

        Registry.register(Registry.BLOCK, new Identifier("shitmod", "fabric_block"), FABRIC_BLOCK);
        Registry.register(Registry.ITEM, new Identifier("shitmod", "fabric_block"), new BlockItem(FABRIC_BLOCK, new FabricItemSettings().group(ItemGroup.MISC)));

        Registry.register(Registry.ITEM, new Identifier("shitmod", "hausbommer"), HAUSBOMMER_ITEM);

        Registry.register(Registry.ITEM, new Identifier("shitmod", "lean"), LEAN);

        Registry.register(Registry.STATUS_EFFECT, new Identifier("shitmod", "exp"), EXP);

        Registry.register(Registry.STATUS_EFFECT, new Identifier("shitmod", "lean"), LEAN_EFFECT);

        CustomPortalBuilder.beginPortal()  
.frameBlock(Blocks.DIAMOND_BLOCK)  
.lightWithItem(Items.ENDER_EYE)  
.destDimID(new Identifier("the_end"))  
.tintColor(45,65,101)  
.registerPortal();
    }
    
}