package io.github.elizabethlfransen.alchemy.fluid.builder

import io.github.elizabethlfransen.alchemy.fluid.ModFluid
import net.minecraft.world.item.Item
import net.minecraft.world.level.block.LiquidBlock
import net.minecraftforge.fluids.FluidAttributes
import net.minecraftforge.fluids.ForgeFlowingFluid
import java.util.function.Supplier

@FluidBuilderMarker
class FluidBuilder(
    private val name: String,
    private val result: ModFluid
) {
    private var attributes: FluidAttributes.Builder? = null
    var canMultiply = false
    var bucket: Supplier<out Item>? = null
    var block: Supplier<out LiquidBlock>? = null
    var slopeFindDistance = 4
    var levelDecreasePerBlock = 1
    var explosionResistance = 1f
    var tickRate = 5


    fun attributes(attributesBuilder: FluidAttributesBuilder.() -> Unit = {}) {
        attributes = FluidAttributesBuilder(name)
            .apply(attributesBuilder)
            .build()
    }

    fun build(): ForgeFlowingFluid.Properties = ForgeFlowingFluid.Properties(
        result.source,
        result.flowing,
        attributes ?: throw IllegalStateException("attributes must be called before building")
    ).apply { if (canMultiply) canMultiply() }
        .bucket(bucket)
        .block(block)
        .slopeFindDistance(slopeFindDistance)
        .levelDecreasePerBlock(levelDecreasePerBlock)
        .explosionResistance(explosionResistance)
        .tickRate(tickRate)
}