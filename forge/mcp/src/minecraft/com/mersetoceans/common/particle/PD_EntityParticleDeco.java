package com.mersetoceans.common.particle;

import net.minecraft.entity.EntityLiving;
import net.minecraft.src.ModLoader;
import net.minecraft.world.World;

public class PD_EntityParticleDeco extends EntityLiving {
	
	public int type;
	public boolean canBeColorized = false;
	public int direction = 0;

	public PD_EntityParticleDeco(World world) {
		this(world, 0, 64, 0, 0, false);
	}
	
	public PD_EntityParticleDeco(World world, int i, int j, int k, int l, boolean b) {
		super(world);
		this.type = l;
		//this.J = 0.4F;
		//this.H = 0.0F;
		//a(0.5F, 0.5F);
		//d(i + 0.5D, j, k + 0.5D);
		//this.bx = 1;
		//this.bm = "/ParticleDeco/pd_base.png";
		this.canBeColorized = b;
	}
	
	@Override
	public int getMaxHealth() {
		return 1;
	}
	
/*
public boolean glow = false;
public int color = 0;
public aan field_40058_a;
public aan field_40058_b;
public int ptheight = 100;
public boolean canBeColorized = false;
public boolean hasRPFunctionality = false;
public boolean camouflaged = false;
public boolean glowItself = false;
public boolean ParticleNoClip = false;
public boolean fireFXSetOnFire = false;
public PD_Inventory inventory = new PD_Inventory(this);
public int type;
public boolean active = true;


public boolean r_()
{
return true;
}

public String v_()
{
if (this.camouflaged) return "/ParticleDeco/pd_base_stealth.png";
switch (this.type) { case 0:
return "/ParticleDeco/pd_base_p.png";
case 1:
return "/ParticleDeco/pd_base_o.png";
case 2:
return "/ParticleDeco/pd_base_b.png";
case 3:
return "/ParticleDeco/pd_base_f.png";
case 4:
return "/ParticleDeco/pd_base_c.png";
case 5:
return "/ParticleDeco/pd_base_h.png";
case 6:
return "/ParticleDeco/pd_base_e.png";
case 7:
return "/ParticleDeco/pd_base_x.png"; }
return super.v_();
}

public void b(double d, double d1, double d2)
{
}

protected void b()
{
}

protected String n() {
return "";
}

protected String o()
{
return "step.stone";
}

public int b(float f)
{
if ((this.glow) && (this.glowItself) && (this.active)) return 983280;
return super.b(f);
}

public void a(ady nbttagcompound)
{
super.a(nbttagcompound);
if (nbttagcompound.c("pType"))
this.type = nbttagcompound.f("pType");
if (nbttagcompound.c("ParticleHgt"))
this.ptheight = nbttagcompound.f("ParticleHgt");
if (nbttagcompound.c("PTdirection"))
this.direction = nbttagcompound.f("PTdirection");
if (nbttagcompound.c("canColr"))
this.canBeColorized = nbttagcompound.o("canColr");
if (nbttagcompound.c("Active"))
this.active = nbttagcompound.o("Active");
if (nbttagcompound.c("hasRPFunc"))
this.hasRPFunctionality = nbttagcompound.o("hasRPFunc");
if (nbttagcompound.c("camouflaged"))
this.camouflaged = nbttagcompound.o("camouflaged");
if (nbttagcompound.c("glowItself"))
this.glowItself = nbttagcompound.o("glowItself");
if (nbttagcompound.c("fireFXSetOnFire"))
this.fireFXSetOnFire = nbttagcompound.o("fireFXSetOnFire");
if (nbttagcompound.c("ParticleNoClip"))
this.ParticleNoClip = nbttagcompound.o("ParticleNoClip");
if ((nbttagcompound.c("I_ItemID")) && (nbttagcompound.c("I_ItemCnt")) && (nbttagcompound.c("I_ItemDmg")) && (nbttagcompound.f("I_ItemID") == yr.aT.bQ))
this.field_40058_a = new aan(nbttagcompound.f("I_ItemID"), nbttagcompound.f("I_ItemCnt"), nbttagcompound.f("I_ItemDmg"));
if ((nbttagcompound.c("II_ItemID")) && (nbttagcompound.c("II_ItemCnt")) && (nbttagcompound.c("II_ItemDmg")) && (nbttagcompound.f("II_ItemID") == yr.aW.bQ))
this.field_40058_b = new aan(nbttagcompound.f("II_ItemID"), nbttagcompound.f("II_ItemCnt"), nbttagcompound.f("II_ItemDmg"));
}

public void b(ady nbttagcompound)
{
super.b(nbttagcompound);
nbttagcompound.a("pType", this.type);
nbttagcompound.a("ParticleHgt", this.ptheight);
nbttagcompound.a("PTdirection", this.direction);
nbttagcompound.a("Active", this.active);
nbttagcompound.a("hasRPFunc", this.hasRPFunctionality);
nbttagcompound.a("camouflaged", this.camouflaged);
nbttagcompound.a("glowItself", this.glowItself);
nbttagcompound.a("ParticleNoClip", this.ParticleNoClip);
nbttagcompound.a("fireFXSetOnFire", this.fireFXSetOnFire);
nbttagcompound.a("canColr", this.canBeColorized);
if ((this.field_40058_a != null) && (this.field_40058_a.c == yr.aT.bQ)) {
nbttagcompound.a("I_ItemID", this.field_40058_a.c);
nbttagcompound.a("I_ItemCnt", this.field_40058_a.a);
nbttagcompound.a("I_ItemDmg", this.field_40058_a.i());
} else {
nbttagcompound.a("I_ItemID", -1);
nbttagcompound.a("I_ItemCnt", 0);
nbttagcompound.a("I_ItemDmg", 0);
}

if ((this.field_40058_b != null) && (this.field_40058_b.c == yr.aW.bQ)) {
nbttagcompound.a("II_ItemID", this.field_40058_b.c);
nbttagcompound.a("II_ItemCnt", this.field_40058_b.a);
nbttagcompound.a("II_ItemDmg", this.field_40058_b.i());
} else {
nbttagcompound.a("II_ItemID", -1);
nbttagcompound.a("II_ItemCnt", 0);
nbttagcompound.a("II_ItemDmg", 0);
}
}

public float[] getColorFromDye() {
float[] color = { 1.0F, 1.0F, 1.0F };
if ((this.field_40058_b != null) && (this.field_40058_b.c == yr.aW.bQ)) {
switch (this.field_40058_b.i()) { case 0:
color = new float[] { 0.0F, 0.0F, 0.0F }; break;
case 1:
color = new float[] { 1.0F, 0.0F, 0.0F }; break;
case 2:
color = new float[] { 0.29F, 0.43F, 0.1F }; break;
case 3:
color = new float[] { 0.49F, 0.29F, 0.17F }; break;
case 4:
color = new float[] { 0.0F, 0.0F, 1.0F }; break;
case 5:
color = new float[] { 0.66F, 0.34F, 0.82F }; break;
case 6:
color = new float[] { 0.25F, 0.59F, 0.73F }; break;
case 7:
color = new float[] { 0.6F, 0.6F, 0.7F }; break;
case 8:
color = new float[] { 0.3F, 0.3F, 0.4F }; break;
case 9:
color = new float[] { 0.96F, 0.68F, 0.82F }; break;
case 10:
color = new float[] { 0.0F, 1.0F, 0.0F }; break;
case 11:
color = new float[] { 1.0F, 1.0F, 0.0F }; break;
case 12:
color = new float[] { 0.51F, 0.71F, 1.0F }; break;
case 13:
color = new float[] { 0.84F, 0.44F, 0.81F }; break;
case 14:
color = new float[] { 1.0F, 0.5F, 0.0F };
}
}
return color;
}

private float[] getMotionFromDir() {
float[] dir = { 0.0F, 1.1F, 0.0F, 0.0F, 0.2F, 0.0F };
switch (this.direction) { case 1:
dir = new float[] { 1.1F, 0.0F, 0.0F, 0.2F, 0.25F, 0.0F }; break;
case 2:
dir = new float[] { 1.5F, 0.0F, 0.0F, -0.2F, 0.25F, 0.0F }; break;
case 3:
dir = new float[] { 0.0F, 0.0F, 1.1F, 0.0F, 0.25F, 0.2F }; break;
case 4:
dir = new float[] { 0.0F, 0.0F, 1.5F, 0.0F, 0.25F, -0.2F };
}
return dir;
}

public void J_() {
boolean b = e(ModLoader.getMinecraftInstance().h) < 60.0F;
float[] f = getColorFromDye();
float[] f1 = getMotionFromDir();
if ((this.active) && (b)) {
for (int i = 0; i < 2; i++) {
switch (this.type)
{
case 7:
if ((i == 0) && (this.V % 2 == 0)) ModLoader.getMinecraftInstance().j.a(new PD_EntityXmasFX(this.k, this.o + f1[3], this.p + f1[4], this.q + f1[5], f1[0], f1[1], f1[2], this.glow, this.ParticleNoClip, this.ptheight, this.direction)); break;
default:
ModLoader.getMinecraftInstance().j.a(new PD_EntityDustFX(this.k, this.o, this.p + 0.2D, this.q, 0.0D, 1.100000023841858D, 0.0D, 0.0F, 0.0F, 0.0F, false, false, 100, 0));
}
}
}

if (this.bx < 1) {
for (int i = 0; i < 10; i++) ModLoader.getMinecraftInstance().j.a(new mc(this.k, this.o, this.p, this.q, 0.0D, 0.5D, 0.0D, pb.t, 0, 0));
if (!ModLoader.getMinecraftInstance().c.h()) a(new aan(mod_ParticleDeco.partdeco, 1, this.type), 0.0F);
if ((this.field_40058_a != null) && (this.field_40058_a.c == yr.aT.bQ)) a(this.field_40058_a, 0.0F);
if ((this.field_40058_b != null) && (this.field_40058_b.c == yr.aW.bQ)) a(this.field_40058_b, 0.0F);
A();
}

if (((this.field_40058_a != null) && (this.field_40058_a.c == yr.aT.bQ)) || (this.type == 3))
this.glow = true;
else {
this.glow = false;
}

if (this.hasRPFunctionality) {
int cPosX = (int)Math.floor(this.o);
int cPosY = (int)Math.floor(this.p);
int cPosZ = (int)Math.floor(this.q);

if ((this.k.w(cPosX, cPosY - 1, cPosZ)) || (this.k.w(cPosX, cPosY, cPosZ))) this.active = true; else this.active = false;
}

onPDUpdate();
}

private void onPDUpdate()
{
if ((M()) && (N()))
{
if (a(md.e, 1));
}
this.bF = this.bG;
if (this.bE > 0)
{
this.bE -= 1;
}
if (this.bA > 0)
{
this.bA -= 1;
}
if (this.Y > 0)
{
this.Y -= 1;
}
if (this.bx <= 0)
{
w_();
}
if (this.bV > 0)
{
this.bV -= 1;
}
else {
this.bO = null;
}
this.V += 1;
}

public boolean c(yw entityplayer)
{
ModLoader.openGUI(entityplayer, new PD_GuiParticleDeco_T1(entityplayer, this));
return true;
}
*/

}