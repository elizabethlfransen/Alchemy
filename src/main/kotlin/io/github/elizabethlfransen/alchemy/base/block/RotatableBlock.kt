package io.github.elizabethlfransen.alchemy.base.block

import net.minecraft.block.Block
import net.minecraft.block.BlockState
import net.minecraft.block.HorizontalBlock
import net.minecraft.item.BlockItemUseContext
import net.minecraft.state.DirectionProperty
import net.minecraft.state.StateContainer
import net.minecraft.util.Mirror
import net.minecraft.util.Rotation

open class RotatableBlock(properties: Properties) : Block(properties) {
    companion object {
        val FACING: DirectionProperty = HorizontalBlock.HORIZONTAL_FACING
    }

    override fun getStateForPlacement(context: BlockItemUseContext): BlockState =
        defaultState.with(FACING, context.placementHorizontalFacing.opposite)

    override fun rotate(state: BlockState, rot: Rotation): BlockState =
        state.with(FACING, rot.rotate(state.get(FACING)))

    override fun mirror(state: BlockState, mirrorIn: Mirror): BlockState =
        state.with(FACING, mirrorIn.mirror(state.get(FACING)))

    override fun fillStateContainer(builder: StateContainer.Builder<Block, BlockState>) {
        builder.apply {
            add(FACING)
        }
    }
}