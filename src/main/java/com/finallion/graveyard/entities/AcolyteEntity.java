package com.finallion.graveyard.entities;

import com.finallion.graveyard.TheGraveyard;
import com.finallion.graveyard.init.TGAdvancements;
import com.finallion.graveyard.item.DaggerItem;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class AcolyteEntity extends CorruptedIllager {

    public AcolyteEntity(EntityType<? extends CorruptedIllager> entityType, Level world) {
        super(entityType, world, "acolyte");
    }

    protected void populateDefaultEquipmentSlots(DifficultyInstance p_34084_) {
        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Registry.ITEM.get(new ResourceLocation(TheGraveyard.MOD_ID, "bone_dagger"))));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.MOVEMENT_SPEED, 0.3499999940395355D).add(Attributes.FOLLOW_RANGE, 12.0D).add(Attributes.ATTACK_DAMAGE, 5.0D).add(Attributes.MAX_HEALTH, 24.0D);
    }


    @Override
    public void playAmbientSound() {
        this.playSound(SoundEvents.VINDICATOR_AMBIENT, 1.0F, 1.0F);
    }

    @Override
    protected void playHurtSound(DamageSource source) {
        this.playSound(SoundEvents.VINDICATOR_HURT, 1.0F, 1.0F);
    }

    @Override
    public void die(DamageSource source) {
        super.die(source);
        this.playSound(SoundEvents.VINDICATOR_DEATH, 1.0F, 1.0F);
    }


    @Override
    public void createWitherRose(@Nullable LivingEntity adversary) {
        if (adversary instanceof ServerPlayer player) {
            if (player.getMainHandItem().getItem() instanceof DaggerItem) {
                TGAdvancements.KILLED_BY_BONE_DAGGER.trigger(player);
            }
        }
        super.setLastHurtByMob(adversary);
    }
}
