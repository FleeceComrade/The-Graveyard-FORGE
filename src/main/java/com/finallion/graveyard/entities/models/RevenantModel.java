package com.finallion.graveyard.entities.models;

import com.finallion.graveyard.TheGraveyard;
import com.finallion.graveyard.entities.RevenantEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class RevenantModel extends AnimatedGeoModel<RevenantEntity> {

    @Override
    public ResourceLocation getModelResource(RevenantEntity object) {
        return new ResourceLocation(TheGraveyard.MOD_ID, "geo/revenant.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(RevenantEntity object) {
        return new ResourceLocation(TheGraveyard.MOD_ID, "textures/entity/revenant.png");
    }

    @Override
    public ResourceLocation getAnimationResource(RevenantEntity animatable) {
        return new ResourceLocation(TheGraveyard.MOD_ID, "animations/revenant/revenant.animation.json");
    }
}
