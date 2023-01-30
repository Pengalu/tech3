package net.fabricmc.example;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExampleMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("modid");
	public static final ContainerBlockTest CONTAINER_BLOCK_TEST = new ContainerBlockTest(FabricBlockSettings.of(Material.STONE).hardness(4.0f));
	public static final BlockEntityType<FluidContainer> FLUID_CONTAINER = Registry.register(
        Registries.BLOCK_ENTITY_TYPE,
        new Identifier("tutorial", "demo_block_entity"),
        FabricBlockEntityTypeBuilder.create(FluidContainer::new, CONTAINER_BLOCK_TEST).build()
    );
	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
        Registry.register(Registries.BLOCK, new Identifier("tutorial", "example_block"), CONTAINER_BLOCK_TEST);
        Registry.register(Registries.ITEM, new Identifier("tutorial", "example_block"), new BlockItem(CONTAINER_BLOCK_TEST, new Item.Settings()));
		LOGGER.info("Hello Fabric world!");

	}
}
