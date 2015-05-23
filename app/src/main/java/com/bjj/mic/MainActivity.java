package com.bjj.mic;

import android.app.*;
import android.os.*;

public class MainActivity extends Activity 
{

	private Game game;
	//buttons
	
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

	@Override
	protected void onStart()
	{// TODO: Implement this method
		super.onStart();
		game.load(getSharedPreferences("RES",0));
	}

	@Override
	protected void onStop()
	{// TODO: Implement this method
		super.onStop();
		game.save(getSharedPreferences("RES",0));
	}
	
	private void tick()
	{
		game.tick();
		//en/disable buttons
	}
	
}
