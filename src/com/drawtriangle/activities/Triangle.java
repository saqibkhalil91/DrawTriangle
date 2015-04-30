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
	private double length1, length2, length3, angle1, angle2, angle3,abc;
	int toggle_flag;
	TriangleView triangle;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getBundleValues();
		setContentView(triangle);
		//triangle=(TriangleView)findViewById(R.id.shapeSelector);

	}

	private void getBundleValues() {
		triangle = new TriangleView(this);
		Bundle getBundle = this.getIntent().getExtras();
		length1 = getBundle.getDouble("l1");
		triangle.setLength1(length1);
		length2 = getBundle.getDouble("l2");
		triangle.setLength2(length2);
		length3 = getBundle.getDouble("l3");
		triangle.setLength3(length3);
		angle1 = getBundle.getDouble("a1");
		triangle.setAngle1(angle1);
		angle2 = getBundle.getDouble("a2");
		triangle.setAngle2(angle2);
		angle3 = getBundle.getDouble("a3");
		triangle.setAngle3(angle3);
		toggle_flag = getBundle.getInt("toggle");
		triangle.setToggle(toggle_flag);
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
