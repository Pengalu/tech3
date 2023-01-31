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
public class FluidContainer extends BlockEntity implements BlockEntityTicker {
    private Fluid storedFluid;
    private int mBCapacity;

    @Override
    public void writeNbt(NbtCompound nbt) {
        // Save the current value of the number to the nbt
        nbt.putInt("mbCapacity", mBCapacity);
 
        super.writeNbt(nbt);
    }
    // Deserialize the BlockEntity
    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
    
        mBCapacity = nbt.getInt("mbCapacity");
    }

    public FluidContainer(BlockPos pos, BlockState state, int mbCapacity){
        super(ExampleMod.FLUID_CONTAINER, pos, state);
        this.mBCapacity=mbCapacity;
        ExampleMod.LOGGER.info("Placed blockentity");
    }
    public FluidContainer(BlockPos pos, BlockState state){
        super(ExampleMod.FLUID_CONTAINER, pos, state);
        this.mBCapacity=1000;
        ExampleMod.LOGGER.info("Placed blockentity");
    }
    public Fluid getStoredFluid(){
        return(storedFluid);

    }
    
    

    public void tick(World world, BlockPos pos, BlockState state, BlockEntity blockEntity) {
        
        
    }
}
