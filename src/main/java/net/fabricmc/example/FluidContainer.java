package net.fabricmc.example;
import java.lang.System.Logger;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BeehiveBlockEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.fluid.Fluid;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public abstract class FluidContainer extends BlockEntity implements BlockEntityTicker {
    /*  
     * Provides an abstract class for a block which can contain fluids. Usecases include storage tanks/barrels, pipes, or smelters which take fluid as an intake.
     * 
     * TODO: good docs for this
     */
    private Fluid storedFluid;
    protected int mBCapacity;

    @Override
    public void writeNbt(NbtCompound nbt) {
        // Save the current capacity of this block to nbt
        nbt.putInt("mbCapacity", mBCapacity);
 
        super.writeNbt(nbt);
    }
    // Deserialize the BlockEntity
    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
    
        mBCapacity = nbt.getInt("mbCapacity");
    }

   // public FluidContainer(BlockPos pos, BlockState state, int mbCapacity){
        //super(ExampleMod.FLUID_CONTAINER, pos, state);
        //this.mBCapacity=mbCapacity;
    //}
    //public FluidContainer(BlockPos pos, BlockState state){
     //   super(ExampleMod.FLUID_CONTAINER, pos, state);


    //}
    public FluidContainer(BlockPos pos, BlockState state,BlockEntityType T){
        super(T, pos, state);
                

    }
    public Fluid getStoredFluid(){
        return(storedFluid);

    }
    
    

    public void tick(World world, BlockPos pos, BlockState state, BlockEntity blockEntity) {
        //placeholder, override with an implementation that fits the usecase of the class.
        
    }
}
