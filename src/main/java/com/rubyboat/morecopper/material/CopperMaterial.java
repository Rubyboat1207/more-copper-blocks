package com.rubyboat.morecopper.material;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class CopperMaterial implements ToolMaterial {
    float miningSpeed = 0;

    public static CopperMaterial INSTANCE = new CopperMaterial();

    public void setMiningSpeedMultiplier(float Speed)
    {
        miningSpeed = Speed;
    }
    @Override
    public int getDurability() {
        return 400;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return miningSpeed;
    }

    @Override
    public float getAttackDamage() {
        return 1;
    }

    @Override
    public int getMiningLevel() {
        return 2;
    }

    @Override
    public int getEnchantability() {
        return 18;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return null;
    }
}
