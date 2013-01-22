package com.mersetoceans;

import net.minecraft.src.ModLoader;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

public class PD_EntityXmasFX /*extends PD_EntityParticlesFX*/ {
	
	  float reddustParticleScale;

	  public PD_EntityXmasFX(World world, double d, double d1, double d2, double d3, double d4, double d5, boolean b, boolean b1, int i, int j)
	  {
	    //super(world, d, d1, d2, d3, d4, d5, 0.0F, 0.0F, 0.0F, b, b1, i, j);
	  }
/*
	  public void initParticle(World world, double d, double d1, double d2, double d3, double d4, double d5, float f, float f1, float f2, float f3) {
		  
	    if (d3 < 0.001D)
	      this.r *= 0.1000000014901161D;
	    else {
	      this.r = (d3 * 0.2000000029802322D + (float)(Math.random() * 2.0D - 1.0D) * 0.02F);
	    }
	    if (d4 < 0.001D)
	      this.s *= 0.1000000014901161D;
	    else {
	      this.s = (d4 * 0.2000000029802322D + (float)(Math.random() * 2.0D - 1.0D) * 0.02F);
	    }
	    if (d5 < 0.001D)
	      this.t *= 0.1000000014901161D;
	    else {
	      this.t = (d5 * 0.2000000029802322D + (float)(Math.random() * 2.0D - 1.0D) * 0.02F);
	    }
	    float f4 = (float)Math.random() * 0.4F + 0.6F;
	    float f5 = (float)(Math.random() * 0.2000000029802322D) + 0.8F;
	    this.ao = (this.ap = this.aq = 1.0F);
	    this.am *= 0.75F;
	    this.am *= f;
	    this.reddustParticleScale = this.am;
	    this.e = ((int)(8.0D / (Math.random() * 0.8D + 0.2D)));
	    this.e = ((int)(this.e * f));
	    c(world.r.nextInt(2));
	  }

	  public void a(adz tessellator, float f, float f1, float f2, float f3, float f4, float f5)
	  {
	    GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

	    adz tessellator1 = new adz();
	    tessellator1.b();
	    tessellator1.b(b(f));

	    float f6 = (this.d + f) / this.e * 32.0F;
	    if (f6 < 0.0F)
	    {
	      f6 = 0.0F;
	    }
	    if (f6 > 1.0F)
	    {
	      f6 = 1.0F;
	    }
	    this.am = (this.reddustParticleScale * f6);
	    GL11.glBindTexture(3553, ModLoader.getMinecraftInstance().p.b("/ParticleDeco/PDparticles.png"));
	    float f0 = s() % 16 / 16.0F;
	    float f7 = f0 + 0.0624375F;
	    float f8 = s() / 16 / 16.0F;
	    float f9 = f8 + 0.0624375F;
	    float f10 = 0.1F * this.am;
	    float f11 = (float)(this.l + (this.o - this.l) * f - ar);
	    float f12 = (float)(this.m + (this.p - this.m) * f - as);
	    float f13 = (float)(this.n + (this.q - this.n) * f - at);
	    float f14 = 1.0F;
	    tessellator1.a(this.ao * f14, this.ap * f14, this.aq * f14);
	    tessellator1.a(f11 - f1 * f10 - f4 * f10, f12 - f2 * f10, f13 - f3 * f10 - f5 * f10, f7, f9);
	    tessellator1.a(f11 - f1 * f10 + f4 * f10, f12 + f2 * f10, f13 - f3 * f10 + f5 * f10, f7, f8);
	    tessellator1.a(f11 + f1 * f10 + f4 * f10, f12 + f2 * f10, f13 + f3 * f10 + f5 * f10, f0, f8);
	    tessellator1.a(f11 + f1 * f10 - f4 * f10, f12 - f2 * f10, f13 + f3 * f10 - f5 * f10, f0, f9);

	    tessellator1.a();
	    GL11.glBindTexture(3553, ModLoader.getMinecraftInstance().p.b("/particles.png"));
	  }

	  public void J_()
	  {
	    this.l = this.o;
	    this.m = this.p;
	    this.n = this.q;
	    if (this.d++ >= this.e)
	    {
	      A();
	    }
	    moveParticle();
	  }*/
	}