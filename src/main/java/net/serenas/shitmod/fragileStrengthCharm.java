package net.serenas.shitmod;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class fragileStrengthCharm extends Item{

    public fragileStrengthCharm(Settings settings) {
        super(settings);
    }
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity Playerentity, Hand Hand) {
        Playerentity.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 20*1000000, 2));
        Playerentity.getMainHandStack().damage(50,Playerentity,e-> e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));
        return new TypedActionResult<ItemStack>(ActionResult.SUCCESS, Playerentity.getStackInHand(Hand));
    }

}
