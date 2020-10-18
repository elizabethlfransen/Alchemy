package io.github.elizabethlfransen.alchemy.init

import io.github.elizabethlfransen.alchemy.base.block.ExampleRotatableBlock
import io.github.elizabethlfransen.alchemy.util.createDeferredRegister
import net.minecraft.block.Block
import net.minecraftforge.fml.RegistryObject
import net.minecraftforge.registries.ForgeRegistries

object ModBlocks {
    val BLOCKS = createDeferredRegister<Block>(ForgeRegistries.BLOCKS)

    val exampleRotatableBlock: RegistryObject<ExampleRotatableBlock> =
        BLOCKS.register("example_rotatable_block", ::ExampleRotatableBlock)
}