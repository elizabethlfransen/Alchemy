package io.github.elizabethlfransen.alchemy

import io.github.elizabethlfransen.alchemy.AlchemyMod.MOD_ID
import io.github.elizabethlfransen.alchemy.init.ModBlocks
import io.github.elizabethlfransen.alchemy.init.ModItems
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent
import org.apache.logging.log4j.LogManager
import thedarkcolour.kotlinforforge.forge.MOD_BUS

@Mod(MOD_ID)
object AlchemyMod {
    const val MOD_ID = "alchemy"
    val logger = LogManager.getLogger()

    val itemGroup = object : ItemGroup("Alchemy") {
        override fun createIcon(): ItemStack = ItemStack(ModItems.exampleRotatableBlock.get())
    }

    init {
        MOD_BUS.addListener(AlchemyMod::setup)
        ModBlocks.BLOCKS.register(MOD_BUS)
        ModItems.ITEMS.register(MOD_BUS)
    }

    private fun setup(event: FMLCommonSetupEvent) {
        logger.info("Alchemy loading")
    }
}