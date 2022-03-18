package net.painandsuffering.pas;


import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class Cookie_Dough extends Item{

	public Cookie_Dough(Settings settings) {
		super(settings);
	}
	
	public TypedActionResult<ItemStack> interact(World world, PlayerEntity playerEntity, Hand hand) {
        playerEntity.openEditSignScreen(null);
        return TypedActionResult.success(playerEntity.getStackInHand(hand));
    }

}
