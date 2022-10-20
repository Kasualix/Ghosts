package com.wanmine.ghosts.client.renderers.layers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.wanmine.ghosts.Ghosts;
import com.wanmine.ghosts.entities.SmallGhostEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import software.bernie.geckolib3.geo.render.built.GeoBone;
import software.bernie.geckolib3.renderers.geo.GeoLayerRenderer;
import software.bernie.geckolib3.renderers.geo.IGeoRenderer;

@OnlyIn(Dist.CLIENT)
public class SmallGhostItemInHandLayer<T extends SmallGhostEntity> extends GeoLayerRenderer<T> {
    public SmallGhostItemInHandLayer(IGeoRenderer<T> p_116686_) {
        super(p_116686_);
    }

    public void render(PoseStack stack, MultiBufferSource p_116700_, int p_116701_, SmallGhostEntity entity, float p_116703_, float p_116704_, float p_116705_, float p_116706_, float p_116707_, float p_116708_) {
        stack.pushPose();

        GeoBone armBone = this.getRenderer().getGeoModelProvider().getModel(new ResourceLocation(Ghosts.MODID, "geo/small_ghost.geo.json")).getBone("right_arm").orElseThrow();

        stack.translate((armBone.getPositionX() * 0.1f) - (0.2f * 0.1f), (armBone.getPositionY() * 0.1f) + (0.8f * 0.1f), (armBone.getPositionZ() * 0.1f) + (3f * 0.1f) - 0.25f);
        stack.scale(0.6f, 0.6f, 0.6f);
        ItemStack itemstack = entity.getHoldItem();
        Minecraft.getInstance().getItemInHandRenderer().renderItem(entity, itemstack, ItemTransforms.TransformType.GROUND, false, stack, p_116700_, p_116701_);
        stack.popPose();
    }
}