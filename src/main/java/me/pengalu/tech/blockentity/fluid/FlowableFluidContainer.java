package me.pengalu.tech.blockentity.fluid;

import org.apache.http.impl.client.NullBackoffStrategy;
import org.joml.Math;

import me.pengalu.tech.ExampleMod;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
    /**
     * An interface for fluid containers that can flow to eachother. Examples include pipes, smelteries, etc.
     * @author Pengalu
     * @version 0.1
     * @since 2023-08-02
     * 
     * 
     * 
     */
public class FlowableFluidContainer extends FluidContainer{

  
    double flowRateModifier=1;
    private Direction[] outputs={Direction.DOWN,Direction.EAST,Direction.NORTH,Direction.WEST,Direction.SOUTH};
    private Direction[] inputs={Direction.UP};
    /**
     * This should return the rate at which fluid can currently flow through this object.
     * Take into account viscosity (See FluidConstants from FabricAPI)
     * @return double flowRate
     */
   
        //return(flowModifier);
    public FlowableFluidContainer(BlockPos pos, BlockState state, BlockEntityType T) {
        super(pos, state, T);
            //TODO Auto-generated constructor stub
    }

    
    public double getFlowRate() {
        // TODO Auto-generated method stub,implement fluid viscosity eventually
        return 1*flowRateModifier;
    }
    
    public Direction[] getOutputDirections() {
        
        return outputs;
    }
   
    public Direction[] getInputDirections() {
        
        return inputs;
    }
    public void flowFluid(Direction direction, BlockPos position,FluidContainer me){
       // ExampleMod.LOGGER.info("searching...");
        BlockPos flowPosition = position.offset(direction);
        BlockEntity targetEntity = world.getBlockEntity(flowPosition);
        if(targetEntity==null)return;
        if(!(targetEntity instanceof FluidContainer))return;
        FluidContainer targetContainer = (FluidContainer) targetEntity;
        
        long flowAmount = (long)getFlowRate();
        
        if(me.getLevelDroplets()-flowAmount<0){

            flowAmount=me.getLevelDroplets();

        }
        if(flowAmount<0){
            flowAmount=0;

        }
        ExampleMod.LOGGER.info(String.valueOf(me==targetContainer));
      //  me.subLevelDroplets(flowAmount);
        targetContainer.addLevelDroplets(flowAmount);
    }
    @Override
    public void tick(World world, BlockPos pos, BlockState state, BlockEntity blockEntity) {
        // TODO Auto-generated method stub
        //flowFluid(Direction.DOWN, pos);
    }
    @Override
    public void worldTick(World world, BlockPos pos, BlockState state, BlockEntity blockEntity){
        //OVERRIDE WITH IMPLEMENTATION FOR SPECIFIC BLOCK ENTITY
        if(world.isClient)return;
        flowFluid(Direction.DOWN, pos,(FluidContainer) blockEntity);

    }

}
