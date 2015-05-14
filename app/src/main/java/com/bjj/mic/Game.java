package com.bjj.mic;

public class Game
{
	public static final int LENGTH=14;
	public static final int RES_LENGTH=11;
	public static final int DIRT=0;
	public static final int SAND=1;
	public static final int CLAY=2;
	public static final int STONE=3;
	public static final int IRON=4;
	public static final int COAL=5;
	public static final int GOLD=6;
	public static final int DIAMOND=7;
	public static final int OBSIDIAN=8;
	public static final int REDOSTONE=9;
	public static final int WOOD=10;
	public static final int STEVE=11;
	public static final int CRAFT=12;
	public static final int FURNACE=13;
	//...

	//these carry rver resets
	private int prestige;
	private int dead;
	
	private float[] res;
	private float[] storage;
	private float[] steveInc;
	private float[] autoInc;
	private float[] steveBonus;
	private float[] autoBonus;
	private float[] consumption;
	
	protected Farm farm;
	protected Mine mine;
	//furnaces
	
	public Game()
	{
		prestige=0;
		dead=0;
		reset();
	}
	public void reset()
	{
		dead+=res[STEVE];
		//calc prestige
		
		res=new float[LENGTH];
		storage=new float[LENGTH];
		steveInc=new float[RES_LENGTH];
		autoInc=new float[RES_LENGTH];
		steveBonus=new float[RES_LENGTH];
		autoBonus=new float[RES_LENGTH];
		consumption=new float[RES_LENGTH];
		unlock(WOOD);
		unlock(STONE);
		unlock(DIRT);
		farm=new Farm();
		mine=new Mine();
	}
	
	private void unlock(int r)
	{
		steveBonus[r]=1;
		autoBonus[r]=1;
		storage[r]=64;//prestige?
	}
	private void resTick()
	{
		for(int i=0; i<RES_LENGTH; i++)
		{//worry about overflow?
			res[i]+=steveInc[i]*steveBonus[i]+autoInc[i]*autoBonus[i]-consumption[i];
			enforceMax(i);
		}
	}
	public boolean enforceMax(int r)
	{
		if(storage[r]<res[r])
		{
			res[r]=storage[r];
			return false;
		}
		return true;
	}
}
