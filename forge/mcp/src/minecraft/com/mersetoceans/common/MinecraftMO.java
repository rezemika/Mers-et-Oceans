package com.mersetoceans.common;

import java.awt.Canvas;

import net.minecraft.client.Minecraft;
import net.minecraft.client.MinecraftApplet;
import net.minecraft.crash.CrashReport;
import net.minecraft.util.Timer;

import java.lang.reflect.Field;

public class MinecraftMO extends Minecraft {

	public MinecraftMO(Canvas par1Canvas, MinecraftApplet par2MinecraftApplet, int par3, int par4, boolean par5) {
		super(par1Canvas, par2MinecraftApplet, par3, par4, par5);
	}

	@Override
	public void displayCrashReportInternal(CrashReport var1) {}
	
    private final static Class PARENT_CLASS = Minecraft.class;

	public Timer getTimer() {
        try {
            Field mytimer = PARENT_CLASS.getDeclaredField("timer");
            mytimer.setAccessible(true);
            Timer myObject = (Timer) mytimer.get(this);
            return myObject;
        } catch (Exception e) {
            e.printStackTrace();
        }
		return null;
	}

}
