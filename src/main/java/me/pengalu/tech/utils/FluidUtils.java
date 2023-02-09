package me.pengalu.tech.utils;

import org.jetbrains.annotations.NotNull;

import net.fabricmc.fabric.api.transfer.v1.fluid.FluidConstants;
import net.minecraft.fluid.Fluid;
import net.minecraft.registry.Registries;
import net.minecraft.text.Text;
    /**
    * Provides an easier syntax to fetch fluids and store them as NBT data by getting an int key.
    * Also gives some conversion utilities based on the FabricAPi experimental FluidConstants class.
    *
    * @author  Pengalu
    * @version 0.1
    * @since   2023-07-02 
    */
public class FluidUtils {

    public static String getFluidName(@NotNull Fluid fluid) {
		return Text.translatable(fluid.getDefaultState().getBlockState().getBlock().getTranslationKey()).getString();
	}
    public static Fluid getFluidFromKey(@NotNull int rawId){
        return(Registries.FLUID.get(rawId));

    }
    public static int getKeyFromFluid(@NotNull Fluid fluid){

        return Registries.FLUID.getRawId(fluid);
    }
    /*
     * 
     * This is really shitty, dumb, bad code but I feel like if I ever end up preforming math on
     * droplets, it'll be a pain in the ass to manually divide it / multiply it each time I'd like to use it,
     * Also, might make making text outputs easier.
     * 
     */
    public long bucketsToDroplet(long buckets){

        return(buckets*FluidConstants.BUCKET);
    }
    public long bottleToDroplet(long buckets){

        return(buckets*FluidConstants.BOTTLE);
    }
    public long dropletToBucket(long droplets){

        return(droplets/FluidConstants.BUCKET);
    }
    public long dropletToBottle(long droplets){

        return(droplets/FluidConstants.BOTTLE);
    }
}
