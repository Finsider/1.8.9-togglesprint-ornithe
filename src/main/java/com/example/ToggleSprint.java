package com.example;

import net.fabricmc.api.ModInitializer;
import net.minecraft.client.options.KeyBinding;
import net.ornithemc.osl.keybinds.api.KeybindEvents;
import net.ornithemc.osl.keybinds.api.KeybindRegistry;

import net.ornithemc.osl.lifecycle.api.client.ClientWorldEvents;
import org.lwjgl.input.Keyboard;

public class ToggleSprint implements ModInitializer {

	public static KeyBinding toggleSprintKey;

	public static boolean isSprintToggled = false;

	@Override
	public void onInitialize() {
		KeybindEvents.REGISTER_KEYBINDS.register(this::keyInit);

		ClientWorldEvents.TICK_END.register(e -> {
			if (toggleSprintKey.isPressed()) isSprintToggled = !isSprintToggled;
		});
	}

	public void keyInit() {
		toggleSprintKey = KeybindRegistry.register("Toggle Sprint", Keyboard.KEY_I, "Toggle Sprint");
	}
}
