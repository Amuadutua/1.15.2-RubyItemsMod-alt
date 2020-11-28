package com.turtywurty.tutorialmod.entities.projectiles;

import com.turtywurty.tutorialmod.init.BlockInit;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.WallTorchBlock;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class TnTArrowEntity extends ArrowEntity{
    public TnTArrowEntity(World worldIn, LivingEntity shooter) {
        super(worldIn, shooter);
    }



    protected void onHit(RayTraceResult raytraceResultIn) {
        super.onHit(raytraceResultIn);
        RayTraceResult.Type hitType = raytraceResultIn.getType();

        // Do something when it hits a block
        if (hitType == RayTraceResult.Type.BLOCK) {
            setToTnT((BlockRayTraceResult)raytraceResultIn);

            // dont stick in the ground as an arrow like a normal one would
            this.remove();
        }
    }

    private void setToTnT(BlockRayTraceResult hit) {
        Direction face = hit.getFace();
        BlockPos pos = hit.getPos().offset(face);
        boolean isAir = this.world.getBlockState(pos).isAir(this.world, pos);

        // if it hits the bottom of a block or somewhere that isnt air (ie water or inside a sign)
        if (face == Direction.DOWN){
            world.setBlockState(pos, Blocks.TNT.getDefaultState());
        }

        // if it hits the top of a block
        else if (face == Direction.UP){
            world.setBlockState(pos, Blocks.TNT.getDefaultState());
        }

        // if it hits the side of a block
        else if (face == Direction.NORTH){
            world.setBlockState(pos, Blocks.TNT.getDefaultState());
        }

        else if (face == Direction.EAST){
            world.setBlockState(pos, Blocks.TNT.getDefaultState());
        }

        else if (face == Direction.SOUTH){
            world.setBlockState(pos, Blocks.TNT.getDefaultState());
        }

        else if (face == Direction.WEST){
            world.setBlockState(pos, Blocks.TNT.getDefaultState());
        }
    }

    // do something when it hits an entity
    @Override
    protected void arrowHit(LivingEntity living) {
        super.arrowHit(living);

        living.setFire(15);
        living.addPotionEffect(new EffectInstance(Effects.GLOWING, 300, 0));
        living.addPotionEffect(new EffectInstance(Effects.INSTANT_DAMAGE, 100, 3));
    }
}