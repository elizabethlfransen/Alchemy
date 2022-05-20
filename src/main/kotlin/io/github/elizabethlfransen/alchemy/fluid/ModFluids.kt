package io.github.elizabethlfransen.alchemy.fluid

import io.github.elizabethlfransen.alchemy.Alchemy
import io.github.elizabethlfransen.alchemy.fluid.builder.registerFluid
import net.minecraft.world.level.material.Fluid
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import net.minecraftforge.registries.RegistryObject
import kotlin.contracts.ExperimentalContracts

data class ModFluid(
    val source: RegistryObject<Fluid>,
    val flowing: RegistryObject<Fluid>
)


@Suppress("MemberVisibilityCanBePrivate", "unused")
object ModFluids {
    val FLUIDS: DeferredRegister<Fluid> = DeferredRegister.create(ForgeRegistries.FLUIDS, Alchemy.ID)


    val RAW_MATTER = FLUIDS.registerFluid("raw_matter") {
        attributes {
            color = 0xFFD0D0D0.toInt()
            withNamedTextures {
                hasOverlay = false
            }
        }
    }
}