package org.example;

import cam72cam.mod.ModCore;

@net.minecraftforge.fml.common.Mod(modid = Mod.MODID, name = "Example Mod", version = "0.0.1", dependencies = "required-after:universalmodcore@[1.0,1.1)", acceptedMinecraftVersions = "[1.12,1.13)")
public class Mod {
    public static final String MODID = "examplemod";

    static {
        try {
            ModCore.register(new org.example.ExampleMod());
        } catch (Exception e) {
            throw new RuntimeException("Could not load mod " + MODID, e);
        }
    }
}
