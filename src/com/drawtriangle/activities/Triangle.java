package com.drawtriangle.activities;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class Triangle extends Activity {
	private double length1,length2,length3,angle1,angle2,angle3;
	int toggle_flag;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getBundleValues();
	     setContentView(new TriangleView(this,length1,length2,length3,angle1,angle2,angle3,toggle_flag));
	
		
	
	   
	}
	private void getBundleValues()
	{
		Bundle getBundle = this.getIntent().getExtras();
		 length1 = getBundle.getDouble("l1");
	     length2 = getBundle.getDouble("l2");
	     length3 = getBundle.getDouble("l3");
	     angle1 = getBundle.getDouble("a1");
	     angle2 = getBundle.getDouble("a2");
	     angle3 = getBundle.getDouble("a3");
	     toggle_flag=getBundle.getInt("toggle");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.triangle, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
}
