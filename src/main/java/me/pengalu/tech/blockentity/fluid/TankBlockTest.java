package me.pengalu.tech.blockentity.fluid;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import me.pengalu.tech.blockentity.TickedBlockEntityProvider;
import net.minecraft.block.BlockState;


public class TankBlockTest extends TickedBlockEntityProvider {
    public TankBlockTest(Settings settings){
        super(settings);

    }
    private FluidTank tank;
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return tank=new FluidTank(pos, state,1000);
    }
    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!world.isClient) {
            if(tank.getStoredFluid() != null && world.isClient){

                //ExampleMod.LOGGER.info(getFluidName(storedFluid));
            }
            
            player.sendMessage(Text.of(FluidContainer.getFluidName(tank.getStoredFluid())+" - "+tank.getLevelDroplets()+" Droplets"), true);
        }
 
        return ActionResult.SUCCESS;
    }

    
    
}
