package com.fin.togglesprint.mixin;

import com.fin.togglesprint.ToggleSprint;
import net.minecraft.client.entity.living.player.LocalClientPlayerEntity;
import net.minecraft.client.options.KeyBinding;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(LocalClientPlayerEntity.class)
public class ClientPlayerEntityMixin {

    /**
     * @param instance the sprint key that the user has bound
     * @return whether the user should try to sprint
     * @author DragonEggBedrockBreaking
     * <p>License: MPL-2.0</p>
     */
    @Redirect(method = "mobTick", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/options/KeyBinding;isPressed()Z"))
    private boolean redirectSprinting(KeyBinding instance) {
        return ToggleSprint.isSprintToggled || instance.isPressed();
    }
}
