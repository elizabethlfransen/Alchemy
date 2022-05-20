package io.github.elizabethlfransen.alchemy.fluid.builder

import io.github.elizabethlfransen.alchemy.fluid.ModFluid
import net.minecraft.world.level.material.Fluid
import net.minecraftforge.fluids.ForgeFlowingFluid
import net.minecraftforge.registries.DeferredRegister

fun DeferredRegister<Fluid>.registerFluid(
    name: String,
    props: FluidBuilder.(modFluid: ModFluid) -> Unit
): ModFluid {
    var result: ModFluid? = null
    fun createFluid(fluid: (property: ForgeFlowingFluid.Properties) -> Fluid) = fluid(
        FluidBuilder(name, result!!)
            .apply { props(result!!) }
            .build()
    )
    result = ModFluid(
        register(name) { createFluid(ForgeFlowingFluid::Source) },
        register("${name}_flowing") { createFluid(ForgeFlowingFluid::Flowing) },
    )
    return result
}