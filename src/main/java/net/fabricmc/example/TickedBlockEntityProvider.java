package net.fabricmc.example;

import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Optional;
//Partially sourced from RebornCore, provided under the MIT license
//This is a pretty strange way to go about this, RebornCore does a much better implementation but for educational purposes, this will be fine.
public abstract class TickedBlockEntityProvider extends Block implements BlockEntityProvider {
	/*
	 * This abstract class is used to provide BlockEntities with methods you'd like to run on tick. Examples include furnaces/smelters, etc.
	 *
	 * 	USAGE:
	 *  Make sure your BlockEntity class implements BlockEntityTicker (net.minecraft.block.entity.BlockEntityTicker)
	 * 	Your Block class should inherit from this in the same way it'd inherit from BlockEntityProvider, this is just wrapper for it basically.
	 */
	protected TickedBlockEntityProvider(Settings builder) {
		super(builder);
	}

    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
		ExampleMod.LOGGER.info("getTicker()");
		return (world1, pos, state1, blockEntity) -> {
			if (blockEntity instanceof BlockEntityTicker) {
				ExampleMod.LOGGER.info("passed if");
				((BlockEntityTicker) blockEntity).tick(world1, pos, state1, blockEntity); //i don't care
			}
		};
	}
    
}
