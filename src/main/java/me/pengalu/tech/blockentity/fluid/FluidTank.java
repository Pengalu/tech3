package me.pengalu.tech.blockentity.fluid;
import net.minecraft.util.math.Direction;

import me.pengalu.tech.ExampleMod;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidConstants;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class FluidTank extends FlowableFluidContainer {



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

        super.tickEssential(world, pos, state, blockEntity);
    }
    
    
}
