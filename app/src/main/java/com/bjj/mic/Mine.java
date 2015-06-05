package com.bjj.mic;
import android.content.*;

public class Mine
{
	public static int HANDS=0;
	public static int WOOD=1;
	public static int STONE=2;
	public static int IRON=3;
	public static int GOLD=4;
	public static int DIAMOND=5;
	//[stone coal iron gold diamond obsidian] red
	public static final double[] handProd=		{0,0,0,0,0,0};
	public static final double[] woodProd=		{1,0,0,0,0,0};
	public static final double[] stoneProd=		{1,.25,.1,0,0,0};
	public static final double[] ironProd=		{1,.3,.15,.07,.04,0};
	public static final double[] goldProd=		{.5,.4,.25,.09,.06,0};
	public static final double[] diamondProd=	{1,.35,.2,.08,.05,.02};

	public float[]miners;
	public float[]lumberjacks;

	public void tik(Game g)
	{
		
	}
	public void save(SharedPreferences pref)
	{

	}
	public void load(SharedPreferences pref)
	{

	}

}
