package io.github.elizabethlfransen.alchemy.fluid.builder

import io.github.elizabethlfransen.alchemy.Alchemy
import net.minecraft.resources.ResourceLocation
import net.minecraft.sounds.SoundEvent
import net.minecraft.world.item.Rarity
import net.minecraftforge.fluids.FluidAttributes

@FluidAttributeBuilderMarker
class FluidAttributesBuilder(private val name: String) {
    var stillTexture: ResourceLocation? = null
    var flowingTexture: ResourceLocation? = null
    var overlayTexture: ResourceLocation? = null
    var color = -0x1
    var translationKey: String? = null
    var fillSound: SoundEvent? = null
    var emptySound: SoundEvent? = null
    var luminosity = 0
    var density = 1000
    var temperature = 300
    var viscosity = 1000
    var isGaseous = false
    var rarity = Rarity.COMMON

    /**
     * Sets the textures to
     * registryNamespace:block/${name}_(still|flow|overlay)
     */
    fun withNamedTextures(builder: WithNamedTexturesBuilder.() -> Unit) {
        val namedTexturesContext = WithNamedTexturesBuilder(name).apply(builder)
        stillTexture = ResourceLocation(Alchemy.ID, "block/${namedTexturesContext.name}_still")
        flowingTexture = ResourceLocation(Alchemy.ID, "block/${namedTexturesContext.name}_flow")
        if(namedTexturesContext.hasOverlay)
        overlayTexture = ResourceLocation(Alchemy.ID, "block/${namedTexturesContext.name}_overlay")
    }

    fun build(): FluidAttributes.Builder {
        return FluidAttributes.builder(
            stillTexture,
            flowingTexture
        )
            .overlay(overlayTexture)
            .color(color)
            .translationKey(translationKey)
            .sound(fillSound, emptySound)
            .luminosity(luminosity)
            .density(density)
            .temperature(temperature)
            .viscosity(viscosity)
            .apply { if (isGaseous) gaseous() }
            .rarity(rarity)
    }

}

@NamedTextureBuilderMarker
class WithNamedTexturesBuilder(fluidName: String) {
    var name: String = fluidName
    var hasOverlay = true
}