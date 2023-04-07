package com.focamacho.dupefixproject.mixin.embersrekindled;

import org.spongepowered.asm.mixin.Overwrite;
import teamroots.embers.tileentity.TileEntityFurnaceTop;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(value = TileEntityFurnaceTop.class, remap = false)
public class TileEntityFurnaceMixin{

    /**
     * @author
     * @reason fix TileEntityFurnaceTop
     */
    @Overwrite
    public void func_73660_a() {}
}
