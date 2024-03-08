package com.focamacho.dupefixproject.mixin.immersiveengineering;

import blusunrize.immersiveengineering.common.blocks.*;

import net.minecraft.block.state.IBlockState;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = BlockIEMultiblock.class, remap = false)
public abstract class TileEntityMultiblockPartMixin {
    @Unique private long dupefixproject$currentTick = 0L;

    /**
     * @author xinyihl
     * @reason 修复沉浸工程范围挖掘多方快刷物品
     */
    @Inject(method = "func_180663_b", at = @At("HEAD"), cancellable = true, require = 1, remap = false)
    public void func_180663_b(World world, BlockPos pos, IBlockState state, CallbackInfo ci) {
        if (world.getTotalWorldTime() == dupefixproject$currentTick) ci.cancel();
        dupefixproject$currentTick = world.getTotalWorldTime();
    }
}

