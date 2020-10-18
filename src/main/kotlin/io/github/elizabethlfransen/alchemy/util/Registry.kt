package io.github.elizabethlfransen.alchemy.util

import io.github.elizabethlfransen.alchemy.AlchemyMod
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.IForgeRegistry
import net.minecraftforge.registries.IForgeRegistryEntry

inline fun <reified T : IForgeRegistryEntry<T>> createDeferredRegister(modId: String = AlchemyMod.MOD_ID): DeferredRegister<T> =
    DeferredRegister.create(T::class.java, modId)

fun <T : IForgeRegistryEntry<T>> createDeferredRegister(registry: IForgeRegistry<T>, modId: String = AlchemyMod.MOD_ID): DeferredRegister<T> = DeferredRegister.create(registry, modId)