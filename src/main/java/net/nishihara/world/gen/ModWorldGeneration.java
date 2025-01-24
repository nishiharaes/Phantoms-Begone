package net.nishihara.world.gen;

import net.nishihara.PhantomsBegone;

public class ModWorldGeneration {

    public static void generateModWorldGen(){

        ModOreGeneration.generateOres();

        PhantomsBegone.LOGGER.info("Registering World Gen for " + PhantomsBegone.MOD_ID);
    }

}
