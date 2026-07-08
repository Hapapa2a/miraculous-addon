package com.example.miraculous.item;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Items;


public enum ModToolTiers implements Tier {


    YOYO(
            500,
            8.0F,
            3.0F,
            15,
            22
    );


    private final int uses;
    private final float speed;
    private final float damage;
    private final int level;
    private final int enchant;


    ModToolTiers(
            int uses,
            float speed,
            float damage,
            int level,
            int enchant
    ){

        this.uses = uses;
        this.speed = speed;
        this.damage = damage;
        this.level = level;
        this.enchant = enchant;

    }


    @Override
    public int getUses() {
        return uses;
    }


    @Override
    public float getSpeed() {
        return speed;
    }


    @Override
    public float getAttackDamageBonus() {
        return damage;
    }


    @Override
    public int getLevel() {
        return level;
    }


    @Override
    public int getEnchantmentValue() {
        return enchant;
    }


    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.of(Items.STRING);
    }

}