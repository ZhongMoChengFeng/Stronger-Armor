package com.zmcf.strongerArmor;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;

@EventBusSubscriber(modid = Main.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class Config {
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder().comment(" equivalentArmor = armor * (toughness / baseToughness + 1)").comment(" sufferDamage = damage * baseArmor / (equivalentArmor + baseArmor)\n");
    private static final ModConfigSpec.IntValue BASE_ARMOR = BUILDER.comment("The armor value of equivalent to twice health").comment("The Larger the value,the weaker the defense").defineInRange("baseArmor", 10, 1, 32768);
    private static final ModConfigSpec.IntValue BASE_TOUGHNESS = BUILDER.comment("The toughness value of equivalent to twice armor").comment("The Larger the value,the weaker the defense").defineInRange("baseToughness", 10, 1, 32768);
    private static final ModConfigSpec.BooleanValue IS_ONLY_CONSUME_ONE_DURABILITY = BUILDER.comment("Only consume one durability").define("isOnlyConsumeOneDurability", true);
    static final ModConfigSpec SPEC = BUILDER.build();
    public static float baseArmor;
    public static float baseToughness;
    public static boolean isOnlyConsumeOneDurability;

    @SubscribeEvent
    static void onLoad(final ModConfigEvent.Loading event) {
        baseArmor = BASE_ARMOR.get();
        baseToughness = BASE_TOUGHNESS.get();
        isOnlyConsumeOneDurability = IS_ONLY_CONSUME_ONE_DURABILITY.get();
    }
}
