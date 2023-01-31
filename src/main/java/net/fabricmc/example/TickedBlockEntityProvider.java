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
public abstract class TickedBlockEntityProvider extends Block implements BlockEntityProvider {

	protected TickedBlockEntityProvider(Settings builder) {
		super(builder);
	}

    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
		ExampleMod.LOGGER.info("getTicker()");
		return (world1, pos, state1, blockEntity) -> {
			if (blockEntity instanceof BlockEntityTicker) {
				ExampleMod.LOGGER.info("passed if");
				((BlockEntityTicker) blockEntity).tick(world1, pos, state1, blockEntity);
			}
		};
	}
    
}
