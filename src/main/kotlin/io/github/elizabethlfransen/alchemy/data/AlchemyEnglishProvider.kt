package io.github.elizabethlfransen.alchemy.data

import net.minecraft.data.DataGenerator
import net.minecraftforge.common.data.LanguageProvider


class AlchemyEnglishProvider(gen: DataGenerator, modid: String, locale: String) : LanguageProvider(gen, modid, locale) {
    override fun addTranslations() {
        add("fluid.alchemy.raw_matter", "Raw Matter")
    }

}