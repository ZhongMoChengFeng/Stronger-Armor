package com.zmcf.strongerArmor.mixin;

import com.zmcf.strongerArmor.Config;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.CombatRules;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(CombatRules.class)
public abstract class CombatRulesMixin {
    @Inject(method = "getDamageAfterAbsorb(Lnet/minecraft/world/entity/LivingEntity;FLnet/minecraft/world/damagesource/DamageSource;FF)F", at = @At("HEAD"), cancellable = true)
    private static void getDamageLeft(LivingEntity entity, float damage, DamageSource damageSource, float armorValue, float armorToughness, CallbackInfoReturnable<Float> cir) {
        float armor = armorValue * (armorToughness / Config.baseToughness + 1.0f);
        float reducedRate = armor / (armor + Config.baseArmor);
        ItemStack itemstack = damageSource.getWeaponItem();
        if (itemstack != null && entity.level() instanceof ServerLevel serverlevel) {
            reducedRate = Mth.clamp(EnchantmentHelper.modifyArmorEffectiveness(serverlevel, itemstack, entity, damageSource, reducedRate), 0.0f, 1.0f);
        }
        cir.setReturnValue(damage * (1.0f - reducedRate));
    }
}
