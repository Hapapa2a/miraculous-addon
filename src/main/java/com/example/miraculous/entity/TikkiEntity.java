package com.example.miraculous.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

import java.util.UUID;

public class TikkiEntity extends PathfinderMob {

    private float angle = 0F;

    // Dona da Tikki
    private UUID ownerUUID;

    public TikkiEntity(EntityType<? extends PathfinderMob> type, Level level) {
        super(type, level);

        // A movimentação será controlada manualmente
        this.setNoAi(true);
        this.setNoGravity(true);
    }

    /**
     * Define a dona da Tikki.
     */
    public void setOwner(Player player) {
        this.ownerUUID = player.getUUID();
    }

    /**
     * Retorna a UUID da dona.
     */
    public UUID getOwnerUUID() {
        return ownerUUID;
    }

    /**
     * Retorna a dona da Tikki.
     */
    public Player getOwner() {
        if (ownerUUID == null) {
            return null;
        }

        return this.level().getPlayerByUUID(ownerUUID);
    }

    @Override
    public void tick() {
        super.tick();

        if (this.level().isClientSide()) {
            return;
        }

        Player owner = getOwner();

        // Se perdeu a dona, desaparece
        if (owner == null || !owner.isAlive()) {
            this.discard();
            return;
        }

        angle += 0.06F;

        double radius = 1.6D;

        double x = owner.getX() + Math.cos(angle) * radius;
        double z = owner.getZ() + Math.sin(angle) * radius;

        double y = owner.getY() + 1.4D
                + Math.sin(angle * 2D) * 0.25D;

        this.setDeltaMovement(0, 0, 0);
        this.setPos(x, y, z);

        // Faz a Tikki olhar para a Marinette
        this.lookAt(owner, 360F, 360F);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return PathfinderMob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 10.0D)
                .add(Attributes.FOLLOW_RANGE, 32.0D)
                .add(Attributes.FLYING_SPEED, 0.5D)
                .add(Attributes.MOVEMENT_SPEED, 0.5D);
    }
}