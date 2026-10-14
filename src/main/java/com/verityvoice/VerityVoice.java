package com.verityvoice;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

@Mod(VerityVoice.MOD_ID)
public final class VerityVoice {
    public static final String MOD_ID = "verityvoice";

    public static final DeferredRegister<SoundEvent> SOUNDS =
            DeferredRegister.create(Registries.SOUND_EVENT, MOD_ID);

    public static final RegistryObject<SoundEvent> VERITY_VOICE =
            SOUNDS.register("verity_voice", () ->
                    SoundEvent.createVariableRangeEvent(
                            ResourceLocation.fromNamespaceAndPath(
                                    MOD_ID, "verity_voice"
                            )
                    )
            );

    public VerityVoice(FMLJavaModLoadingContext context) {
        IEventBus modBus = context.getModEventBus();
        SOUNDS.register(modBus);
    }
}
