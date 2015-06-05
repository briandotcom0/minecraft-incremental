package com.bjj.mic;

import android.view.*;
import android.app.*;
import android.os.*;
import android.widget.*;
import android.content.*;

public class MainActivity extends Activity implements android.view.View.OnClickListener
{

	private Game game;
	//buttons
	
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		
		Context c= getApplicationContext();
		Toolbar multiplier=new Toolbar(c);
		Button min=new Button(c);
		min.setText("<<");
		min.setOnClickListener(this);
		multiplier.addView(min);
    }

	@Override
	protected void onResume()
	{// TODO: Implement this method
		super.onResume();
		game.load(this);
	}

	@Override
	protected void onPause()
	{// TODO: Implement this method
		super.onPause();
		game.save(this);
	}
	
	private void tick()
	{
		game.tick();
		//en/disable buttons with flag for what view i care about
	}
	
	//call to switch view to mine
	//just setting contentView will probably be bad
	private void onMine()
	{
		setContentView(R.layout.mine);
		//toolbar
		((TextView) findViewById(R.id.lumberHandT)).setText(""+game.mine.lumberjacks[game.mine.HANDS]);
		((TextView) findViewById(R.id.lumberWoodT)).setText(""+game.mine.lumberjacks[game.mine.WOOD]);
		((TextView) findViewById(R.id.lumberStoneT)).setText(""+game.mine.lumberjacks[game.mine.STONE]);
		//etc..
	}
	
	public void onClick(View v)
	{//todo: big long switch :/
		switch(v.getId())
		{
			case R.id.lumberDiamondM:
				break;
			case R.id.lumberDiamondP:
				break;
			case R.id.lumberGoldM:
				break;
			case R.id.lumberGoldP:
				break;
			case R.id.lumberIronM:
				break;
			case R.id.lumberIronP:
				break;
			case R.id.lumberWoodM:
				break;
			case R.id.lumberWoodP:
				break;
			case R.id.lumberStoneM:
				break;
			case R.id.lumberStoneP:
				break;
			case R.id.lumberHandM:
				break;
			case R.id.lumberHandP:
				break;
			case R.id.multMax:
				break;
			case R.id.multMin:
				break;
			case R.id.multPlus:
				break;
			case R.id.multMinus:
				break;
		}//switch
		
	}//onClick(v)
}//MainActivity
