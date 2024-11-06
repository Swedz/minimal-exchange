package com.thepigcat.minimal_exchange.util;

import com.mojang.serialization.Codec;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;

public final class RegistryUtils {
	/**
	 * Returns the resource key for a value on that registry.
	 */
	public static <T> ResourceKey<T> resourceKey(Registry<T> registry, T value) {
		return registry.getResourceKey(value).orElseThrow();
	}

	/**
	 * Returns the holder reference for a value on that registry.
	 */
	public static <T> Holder.Reference<T> holder(Registry<T> registry, T value) {
		return registry.getHolderOrThrow(resourceKey(registry, value));
	}

	/**
	 * Returns a codec using the resource location of the registry
	 */
	public static <T> Codec<T> registryCodec(Registry<T> registry) {
		return ResourceLocation.CODEC.xmap(registry::get, registry::getKey);
	}
}