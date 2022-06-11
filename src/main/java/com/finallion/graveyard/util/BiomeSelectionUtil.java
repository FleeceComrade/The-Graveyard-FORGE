package com.finallion.graveyard.util;


import com.finallion.graveyard.TheGraveyard;
import net.minecraft.core.Holder;
import net.minecraft.world.level.biome.Biome;

import java.util.List;

public class BiomeSelectionUtil {

    // structures
    public static boolean parseBiomes(List<String> biomeWhitelist, List<String> modIdWhitelist, Holder<Biome> biome) {
        if (biomeWhitelist == null || modIdWhitelist == null) {
            TheGraveyard.LOGGER.error("The Graveyard config file isn't up to date. Please delete the file in your .minecraft/config folder and restart the game to create a new config file. If the error keeps showing up, contact the mod developer via Github or Discord (links can be found here: https://www.curseforge.com/minecraft/mc-mods/the-graveyard-forge)!");
            return false;
        }

        String biomeName = biome.unwrapKey().orElseThrow().location().toString();
        String modId = biome.unwrapKey().orElseThrow().location().getNamespace();


        // mod is whitelisted, weights higher than biome whitelist
        if (modIdWhitelist.contains("#" + modId)) {
            return true;
        }

        // biome is whitelisted
        if (biomeWhitelist.contains(biomeName)) {
            return true;
        }

        return false;
    }

    // mobs
    public static boolean parseBiomes(List<String> biomeWhitelist, List<String> biomeBlacklist, List<String> modIdWhitelist, Holder<Biome> biome) {
        if (biomeWhitelist == null || modIdWhitelist == null || biomeBlacklist == null) {
            TheGraveyard.LOGGER.error("The Graveyard config file isn't up to date. Please delete the file in your .minecraft/config folder and restart the game to create a new config file. If the error keeps showing up, contact the mod developer via Github or Discord (links can be found here: https://www.curseforge.com/minecraft/mc-mods/the-graveyard-fabric)!");
            return false;
        }

        String biomeName = biome.unwrapKey().orElseThrow().location().toString();
        String modId = biome.unwrapKey().orElseThrow().location().getNamespace();

        // mod is whitelisted and not on the blacklist
        if (modIdWhitelist.contains("#" + modId) && !biomeBlacklist.contains(biomeName)) {
            return true;
        }

        // biome is whitelisted and not on the blacklist
        if (biomeWhitelist.contains(biomeName) && !biomeBlacklist.contains(biomeName)) {
            return true;
        }

        return false;
    }

}

