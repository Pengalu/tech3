package me.pengalu.tech.utils;

import org.jetbrains.annotations.NotNull;

import net.minecraft.fluid.Fluid;
import net.minecraft.registry.Registries;
import net.minecraft.text.Text;

public class FluidUtils {
    public static String getFluidName(@NotNull Fluid fluid) {
		return Text.translatable(fluid.getDefaultState().getBlockState().getBlock().getTranslationKey()).getString();
	}
    public static Fluid getFluidFromKey(@NotNull int rawId){
        return(Registries.FLUID.get(rawId));

    }
}
