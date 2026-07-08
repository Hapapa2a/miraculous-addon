package com.example.miraculous.client;

import net.minecraft.client.KeyMapping;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.client.settings.KeyModifier;
import org.lwjgl.glfw.GLFW;
import com.mojang.blaze3d.platform.InputConstants;

public class KeyBindings {

    public static final String CATEGORY = "key.categories.miraculous";

    public static final KeyMapping TRANSFORM_KEY = new KeyMapping(
            "key.miraculous.transform",
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_X,
            CATEGORY
    );

}