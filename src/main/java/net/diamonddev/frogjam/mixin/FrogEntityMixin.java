package net.diamonddev.frogjam.mixin;

import net.diamonddev.frogjam.FrogJam;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.FrogEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(FrogEntity.class)
public abstract class FrogEntityMixin extends AnimalEntity {

    protected FrogEntityMixin(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(method = "tick", at = @At("HEAD"))
    private void frogjam$playFrogjamOnFrogs(CallbackInfo ci) {
        if (!this.world.isClient()) {
            int loopTime = (int) Math.round(FrogJam.frogjamLengthInSeconds * 20);
            if (this.age % loopTime == 0 || this.age == 1) {
                this.world.playSoundFromEntity(
                        null,
                        this,
                        FrogJam.FROGJAM,
                        SoundCategory.AMBIENT,
                        1.0f,
                        1.0f
                );
            }
        }
    }
}
