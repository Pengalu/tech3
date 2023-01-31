package net.fabricmc.example;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import org.jetbrains.annotations.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;


public class ContainerBlockTest extends TickedBlockEntityProvider {
    public ContainerBlockTest(Settings settings){
        super(settings);

    }
    
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new FluidContainer(pos, state);
    }

    

    
    
}
