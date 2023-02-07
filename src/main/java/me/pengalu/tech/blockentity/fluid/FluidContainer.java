package me.pengalu.tech.blockentity.fluid;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import me.pengalu.tech.ExampleMod;
import me.pengalu.tech.utils.FluidUtils;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.Packet;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.registry.Registries;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public abstract class FluidContainer extends BlockEntity implements BlockEntityTicker {
    /*  
     * Provides an abstract class for a block which can contain fluids. Usecases include storage tanks/barrels, pipes, or smelters which take fluid as an intake.
     * 
     * TODO: good docs for this
     */
    private Fluid storedFluid;
    protected int capacityDroplets;
    protected int levelDroplets;
    

    public int getStoredFluidKey(){
        return(Registries.FLUID.getRawId(storedFluid));

    }
    public void setStoredFluid(Fluid newFluid){
        storedFluid = newFluid;
        updateClient();  
    }
    public void addLevelDroplets(int addDrops){

        setLevelDroplets(this.levelDroplets+addDrops);

    }
    public void setLevelDroplets(int levelDroplets){
        if(this.capacityDroplets < this.levelDroplets){

            this.levelDroplets = levelDroplets;
        }
        else{
            this.levelDroplets=this.capacityDroplets;

        }
        updateClient();
    }
    public int getLevelDroplets(){
     
        updateClient();
        return(levelDroplets);
    }
    @Override
    public void writeNbt(NbtCompound nbt) {
        // Save the current capacity of this block to nbt
        ExampleMod.LOGGER.info("WRITING NBT");
        //capacityDroplets=0;
        nbt.putInt("capacityDroplets", capacityDroplets);
        nbt.putInt("levelDroplets", levelDroplets);
        nbt.putInt("fluid", getStoredFluidKey());
        super.writeNbt(nbt);
        updateClient();

    }
    // Deserialize the BlockEntity
    @Override
    public void readNbt(NbtCompound nbt) {
        ExampleMod.LOGGER.info("READING NBT");

        super.readNbt(nbt);
        int storedFluidId= nbt.getInt("fluid");
        storedFluid=FluidUtils.getFluidFromKey(storedFluidId);
        capacityDroplets = nbt.getInt("capacityDroplets");
        levelDroplets = nbt.getInt("levelDroplets");
        updateClient();

    }

   // public FluidContainer(BlockPos pos, BlockState state, int capacityDroplets){
        //super(ExampleMod.FLUID_CONTAINER, pos, state);
        //this.capacityDroplets=capacityDroplets;
    //}
    //public FluidContainer(BlockPos pos, BlockState state){
     //   super(ExampleMod.FLUID_CONTAINER, pos, state);


    //}
    public FluidContainer(BlockPos pos, BlockState state,BlockEntityType T){
     
        super(T, pos, state);
       storedFluid = Fluids.WATER;     

    }
    public Fluid getStoredFluid(){
        return(storedFluid);

    }
    private void updateClient(){
        if(currentState ==null)return;
        world.updateListeners(pos, previousState, currentState, Block.NOTIFY_LISTENERS);
    }   
    
    
    @Nullable
    @Override
    public Packet<ClientPlayPacketListener> toUpdatePacket() {
      return BlockEntityUpdateS2CPacket.create(this);
    }
   
    @Override
    public NbtCompound toInitialChunkDataNbt() {
      return createNbt();
    }
    BlockState previousState;
    BlockState currentState;
    public void tickEssential(World world, BlockPos pos, BlockState state, BlockEntity blockEntity) {
        //Contains debug stuff that should apply to all fluidcontainers
     
        if(currentState != null){previousState=currentState;}else{previousState=state;}
        currentState=state;
       
        if(storedFluid != null && world.isClient){

            //ExampleMod.LOGGER.info(getFluidName(storedFluid));
        }
        this.worldTick(world, pos, state, blockEntity);
    }
    public void worldTick(World world, BlockPos pos, BlockState state, BlockEntity blockEntity){
        //OVERRIDE WITH IMPLEMENTATION FOR SPECIFIC BLOCK ENTITY
        

    }
}
