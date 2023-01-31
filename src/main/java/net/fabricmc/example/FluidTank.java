package net.fabricmc.example;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;

public class FluidTank extends FluidContainer {

    public FluidTank(BlockPos pos, BlockState state, int mbCapacity){
        super(pos, state,ExampleMod.FLUID_TANK);
        this.mBCapacity=mbCapacity;
       
    }
    public FluidTank(BlockPos pos, BlockState state){
        super(pos, state,ExampleMod.FLUID_TANK);
        this.mBCapacity=1000;
        
    }
    
}
