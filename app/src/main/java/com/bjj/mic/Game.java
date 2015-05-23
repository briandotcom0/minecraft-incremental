package com.bjj.mic;
import android.content.*;
import java.util.*;

public class Game
{
	public static final int LENGTH=14;
	public static final int RES_LENGTH=11;
	
	
	
	// --mine
	// -shovel
	public static final int DIRT=0;
	public static final int SAND=1;
	public static final int CLAY=2;
	// -pik
	public static final int STONE=3;
	public static final int IRON=4;
	public static final int COAL=5;
	public static final int GOLD=6;
	public static final int DIAMOND=7;
	public static final int OBSIDIAN=8;
	public static final int REDSTONE=9;
	// -axe
	public static final int WOOD=10;
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

	//these carry over resets
	private int prestige;
	private int dead;
	//DR factor for steves
	
	//Map<int,float>?
	private Map<String,Float> res;
	private Map<String,Float> storage;
	private Map<String,Float> steveInc;
	private Map<String,Float> autoInc;
	private Map<String,Float> steveBonus;
	private Map<String,Float> autoBonus;
	private Map<String,Float> consumption;
	
	protected Farm farm;
	protected Mine mine;
	//furnaces
	
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
		resTick();
	}
	
	private void resTick()
	{
		for(String i : res.keySet())
		{//worry about overflow?
			res.put(i,res.get(i)+steveInc.get(i)*steveBonus.get(i)+autoInc.get(i)*autoBonus.get(i)-consumption.get(i));
			enforceMax(i);
		}
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
	
	public void save(SharedPreferences prefs)
	{
		SharedPreferences.Editor edit = prefs.edit();
		for(String item : res.keySet())
		{
			edit.putFloat(item, res.get(item));
			edit.putFloat(item+"Store", storage.get(item));
		}
		edit.apply();
	}
	public void load(SharedPreferences prefs)
	{
		for(String item : res.keySet())
		{
			res.put(item, prefs.getFloat(item,0));
			storage.put(item, prefs.getFloat(item+"Store",0));
		}
		//researches
		//buildings
		//steves
	}
	
//	protected class resPool  ? no
}
