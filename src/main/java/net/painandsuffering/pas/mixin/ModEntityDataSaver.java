package net.painandsuffering.pas.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NbtCompound;
import net.painandsuffering.pas.util.IEntityDataSaver;

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
	
	@Inject(method = "writeNbt", at = @At("HEAD"))
    protected void injectWriteMethod(NbtCompound nbt, CallbackInfoReturnable info) {
        if (persistentData != null) {
            nbt.put("PaSData", persistentData);
        }
    }

    @Inject(method = "readNbt", at = @At("HEAD"))
    protected void injectReadMethod(NbtCompound nbt, CallbackInfo info) {
        if (nbt.contains("PaSData", 10)) {
            persistentData = nbt.getCompound("PaSData");
        }
    }
	
}
