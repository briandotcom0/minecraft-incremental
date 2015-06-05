package com.bjj.mic;
import android.content.*;
import java.util.*;
import android.app.*;

public class Game
{
	public static final int LENGTH=14;
	public static final int RES_LENGTH=11;
	
	public static final String[] STRINGS={"hands","wood","stone","iron","gold","diaamond"};
	
	// --mine
	// -shovel
	//DIRT=0;
	//SAND=1;
	//CLAY=2;
	// -pik
	//STONE=3;
	//IRON=4;
	//COAL=5;
	//GOLD=6;
	//DIAMOND=7;
	//OBSIDIAN=8;
	//REDSTONE=9;
	// -axe
	//WOOD
	/*
	// --food
	// -hoe
	SEEDS
	CARROTS
	TATERS
	// -ingredients
	MILK
	SUGAR
	COCO
	WHEAT
	EGG
	//shrooms?
	// -fud
	BREAD
	CAKE
	COOKIE
	BAKED_TATER
	//soup?
	// -meat
	MUTTON
	BEEF
	BACON
	WING
	FISH
	// --animals
	SHEEP
	COW
	PIG
	CHICKEN
	// --potion ingredients
	// --potions
	// --other
	// -ppl
	STEVE
	// -buildings
	FURNACE
	//redstone auto stuffs
	*/
	public final double[] mult={.1,.5,1,1.5,2.2,2.5};
	//per tik fud consumption
	public final double[] fudCons={.1,.1,.1,.5,.2,.2};
	public final double foodPer=0.1;
	//per tik use
	public final double[] use={.1,.1,.25,.15,.25,.1};
	public final double woodToolUse=.05;
	
	//these carry over resets
	private int prestige;
	private int dead;
	//DR factor for steves
	
	//Map<int,float>?
	public Map<String,Float> res;
	public Map<String,Float> storage;
	private Map<String,Float> steveInc;
	private Map<String,Float> autoInc;
	protected Map<String,Float> steveBonus;
	protected Map<String,Float> autoBonus;
	private Map<String,Float> consumption;
	
	protected Farm farm;
	protected Mine mine;
	protected Ranch ranch;
	protected Kitchen kitchen;
	protected Redstone structs;
	
	
	public Game()
	{
		prestige=0;
		dead=0;
		reset();
	}
	//save(Settings)
	//load(Settings)
	public void reset()
	{
		//dead+=res[STEVE];
		//calc prestige
		
		res=new HashMap<String,Float>(LENGTH);
		storage=new HashMap<String,Float>(LENGTH);
		steveInc=new HashMap<String,Float>(RES_LENGTH);
		autoInc=new HashMap<String,Float>(RES_LENGTH);
		steveBonus=new HashMap<String,Float>(RES_LENGTH);
		autoBonus=new HashMap<String,Float>(RES_LENGTH);
		consumption=new HashMap<String,Float>(RES_LENGTH);
		unlock("wood");
		unlock("stone");
		unlock("dirt");
		farm=new Farm();
		mine=new Mine();
	}
	
	
	private void unlock(String r)
	{
		steveBonus.put(r,1.0f);
		autoBonus.put(r,1.0f);
		storage.put(r,1.0f);//prestige?
	}
	
	public void tick()
	{
		farm.tik(this);
		ranch.tik(this);
		mine.tik(this);
		kitchen.tik(this);
		structs.tik(this);
		resTick();
	}
	
	private void resTick()
	{
		//anything?
	}
	public boolean enforceMax(String r)
	{
		if(storage.get(r)<res.get(r))
		{
			res.put(r,storage.get(r));
			return false;
		}
		return true;
	}
	
	public void save(Activity act)
	{
		SharedPreferences prefs=act.getSharedPreferences("RES",0);
		SharedPreferences.Editor edit = prefs.edit();
		for(String item : res.keySet())
		{
			edit.putFloat(item, res.get(item));
			edit.putFloat(item+"Store", storage.get(item));
		}
		edit.apply();
		farm.save(act.getSharedPreferences("FARM",0));
		kitchen.save(act.getSharedPreferences("KITCHEN",0));
		mine.save(act.getSharedPreferences("MINE",0));
		ranch.save(act.getSharedPreferences("RANCH",0));
		structs.save(act.getSharedPreferences("REDSTONE",0));
	}
	public void load(Activity act)
	{
		SharedPreferences prefs=act.getSharedPreferences("RES",0);
		for(String item : res.keySet())
		{
			res.put(item, prefs.getFloat(item,0));
			storage.put(item, prefs.getFloat(item+"Store",0));
		}
		//researches
		//buildings
		//steves
		farm.load(act.getSharedPreferences("FARM",0));
		kitchen.load(act.getSharedPreferences("KITCHEN",0));
		mine.load(act.getSharedPreferences("MINE",0));
		ranch.load(act.getSharedPreferences("RANCH",0));
		structs.load(act.getSharedPreferences("REDSTONE",0));
	}
	
//	protected class resPool  ? no
}
