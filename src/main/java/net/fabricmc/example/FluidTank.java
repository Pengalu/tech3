package net.fabricmc.example;

import net.fabricmc.fabric.api.transfer.v1.fluid.FluidConstants;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class FluidTank extends FluidContainer {


    public FluidTank(BlockPos pos, BlockState state, int capacityDroplets){
        super(pos, state,ExampleMod.FLUID_TANK);

        this.capacityDroplets=capacityDroplets;
       
    }
    public FluidTank(BlockPos pos, BlockState state){
        super(pos, state,ExampleMod.FLUID_TANK);
        this.capacityDroplets=(int) (1*FluidConstants.BUCKET);
        
    }
 
    @Override
    public void tick(World world, BlockPos pos, BlockState state, BlockEntity blockEntity) {
        //ExampleMod.LOGGER.info("Tick!");
        //No tick impl. yet
        super.tick(world, pos, state, blockEntity);
    }
    
}
