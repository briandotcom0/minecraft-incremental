package com.bjj.mic;
import android.content.*;

public class Farm
{
	private double foodPer=0.1;
	private double woodPer=0.01;
	private double[] usePer={0,.2,.15,.1,.1,.05};
	
	public static int HANDS=0;
	public static int WOOD=1;
	public static int STONE=2;
	public static int IRON=3;
	public static int GOLD=4;
	public static int DIAMOND=5;

	public float[]wheatA;
	public float[]carrotsA;
	public float[]tatersA;
	
	
	public void tik(Game g)
	{
		float wood=g.res.get("wood");
		float stone=g.res.get("stone");
		float iron=g.res.get("iron");
		float gold=g.res.get("gold");
		float damond=g.res.get("diamond");
		float wheat=g.res.get("wheat");
		float carrots=g.res.get("carrots");
		float taters=g.res.get("taters");
		
		if(wood>woodPer*wheatA[0])
		{
			
		}
	}
	public void save(SharedPreferences pref)
	{

	}
	public void load(SharedPreferences pref)
	{

	}
	
}
