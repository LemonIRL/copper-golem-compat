package org.limitlesssmp.coppergolemcompat.mixin;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.animal.golem.CopperGolemAi;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.Predicate;

/**
 * Vanilla only lets copper golems deposit into {@code Blocks.CHEST}/{@code Blocks.TRAPPED_CHEST}
 * (see {@code CopperGolemAi.TRANSPORT_ITEM_DESTINATION_BLOCK}), a hardcoded identity check that
 * ignores subclassed/modded blocks entirely. This widens that predicate to also accept
 * Reinforced Chests (except the copper tier, which stays source-only like vanilla copper chests)
 * and Reinforced Barrels tiers.
 */
@Mixin(CopperGolemAi.class)
public abstract class CopperGolemAiMixin {

	@Mutable
	@Shadow
	private static Predicate<BlockState> TRANSPORT_ITEM_DESTINATION_BLOCK;

	@Inject(method = "<clinit>", at = @At("TAIL"))
	private static void coppergolemcompat$widenDestinations(CallbackInfo ci) {
		Predicate<BlockState> vanilla = TRANSPORT_ITEM_DESTINATION_BLOCK;
		TRANSPORT_ITEM_DESTINATION_BLOCK = vanilla.or(CopperGolemAiMixin::isReinforcedStorage);
	}

	private static boolean isReinforcedStorage(BlockState state) {
		Identifier id = BuiltInRegistries.BLOCK.getKey(state.getBlock());
		if (id == null) {
			return false;
		}
		String namespace = id.getNamespace();
		if (namespace.equals("reinfbarrel")) {
			return true;
		}
		if (namespace.equals("reinfchest")) {
			// Copper tier stays source-only, matching vanilla's copper chest behavior.
			return !id.getPath().equals("copper_chest");
		}
		return false;
	}
}
