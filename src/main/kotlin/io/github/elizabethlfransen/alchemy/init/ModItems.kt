package io.github.elizabethlfransen.alchemy.init

import io.github.elizabethlfransen.alchemy.AlchemyMod
import io.github.elizabethlfransen.alchemy.util.createDeferredRegister
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import net.minecraftforge.fml.RegistryObject
import net.minecraftforge.registries.ForgeRegistries

object ModItems {
    val ITEMS = createDeferredRegister<Item>(ForgeRegistries.ITEMS)

    val exampleRotatableBlock: RegistryObject<BlockItem> = ITEMS.register("example_rotatable_block") {
        BlockItem(ModBlocks.exampleRotatableBlock.get(), Item.Properties().group(AlchemyMod.itemGroup))
    }
}