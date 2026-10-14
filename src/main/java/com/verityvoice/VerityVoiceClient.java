package com.verityvoice;

import net.minecraft.client.Minecraft;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(
        modid = VerityVoice.MOD_ID,
        value = Dist.CLIENT
)
public final class VerityVoiceClient {
    // Replace with the real entity registry ID from the The Verity mod.
    private static final ResourceLocation VERITY_ENTITY_ID =
            ResourceLocation.fromNamespaceAndPath("theverity", "verity");

    private static final double RADIUS = 12.0D;
    private static final int COOLDOWN_TICKS = 20 * 12;
    private static int cooldown = 0;

    private VerityVoiceClient() {}

    @SubscribeEvent
    public static void onClientTick(TickEvent.ClientTickEvent event) {
        if (event.phase != TickEvent.Phase.END) {
            return;
        }

        Minecraft minecraft = Minecraft.getInstance();
        if (minecraft.level == null || minecraft.player == null) {
            cooldown = 0;
            return;
        }

        if (cooldown > 0) {
            cooldown--;
            return;
        }

        var player = minecraft.player;
        var nearbyEntities = minecraft.level.getEntitiesOfClass(
                Entity.class,
                player.getBoundingBox().inflate(RADIUS),
                entity -> VERITY_ENTITY_ID.equals(
                        BuiltInRegistries.ENTITY_TYPE.getKey(entity.getType())
                )
        );

        if (nearbyEntities.isEmpty()) {
            return;
        }

        Entity entity = nearbyEntities.getFirst();
        if (player.distanceToSqr(entity) <= RADIUS * RADIUS) {
            minecraft.level.playLocalSound(
                    entity.getX(),
                    entity.getY(),
                    entity.getZ(),
                    VerityVoice.VERITY_VOICE.get(),
                    SoundSource.HOSTILE,
                    1.0F,
                    1.0F,
                    false
            );
            cooldown = COOLDOWN_TICKS;
        }
    }
}
