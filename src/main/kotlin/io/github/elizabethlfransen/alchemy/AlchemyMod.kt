package io.github.elizabethlfransen.alchemy

import io.github.elizabethlfransen.alchemy.AlchemyMod.MOD_ID
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent
import org.apache.logging.log4j.LogManager
import thedarkcolour.kotlinforforge.forge.MOD_BUS

@Mod(MOD_ID)
object AlchemyMod {
    const val MOD_ID = "alchemy"
    val logger = LogManager.getLogger()

    init {
        MOD_BUS.addListener(AlchemyMod::setup)
    }

    private fun setup(event: FMLCommonSetupEvent) {
        logger.info("Alchemy loading")
    }
}