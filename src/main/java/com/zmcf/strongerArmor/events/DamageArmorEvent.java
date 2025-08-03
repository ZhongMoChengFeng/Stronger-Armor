package com.zmcf.strongerArmor.events;

import com.zmcf.strongerArmor.Config;
import com.zmcf.strongerArmor.Main;
import net.minecraft.world.entity.EquipmentSlot;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.ArmorHurtEvent;

@EventBusSubscriber(modid = Main.MOD_ID)
public class DamageArmorEvent {
    @SubscribeEvent
    public static void onArmorHurt(ArmorHurtEvent event) {
        if (Config.isOnlyConsumeOneDurability) {
            for (var entry : event.getArmorMap().entrySet()) {
                EquipmentSlot equipmentSlot = entry.getKey();
                if (equipmentSlot.getType() == EquipmentSlot.Type.HUMANOID_ARMOR) {
                    event.setNewDamage(equipmentSlot, 1.0f);
                }
            }
        }
    }
}
