package net.fabricmc.example;

import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
//Partially sourced from RebornCore, provided under the MIT license
public class TickedBlockEntityProvider extends Block implements BlockEntityProvider {

	protected TickedBlockEntityProvider(Settings builder) {
		super(builder);
	}

    @Override
    public BlockEntity createBlockEntity(BlockPos arg0, BlockState arg1) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
