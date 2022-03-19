package net.painandsuffering.pas.mixin;

import org.spongepowered.asm.mixin.Mixin;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NbtCompound;
import net.painandsuffering.util.IEntityDataSaver;

@Mixin(Entity.class)
public abstract class ModEntityDataSaver implements IEntityDataSaver{
	private NbtCompound persistentData;
	
	@Override
	public NbtCompound getPersistentData() {
		if(this.persistentData == null) {
			this.persistentData = new NbtCompound();
		}
		return persistentData;
	}
	
}
