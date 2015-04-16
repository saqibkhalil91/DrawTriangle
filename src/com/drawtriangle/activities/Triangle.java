package com.drawtriangle.activities;


import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class Triangle extends Activity {
	private int length1,length2,angle;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Bundle getBundle = this.getIntent().getExtras();
	     length1 = getBundle.getInt("l1");
	     length2 = getBundle.getInt("l2");
	     angle = getBundle.getInt("angle");
		setContentView(new MyView(this));
	
		
	
	   
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
	public class MyView extends View {
        public MyView(Context context) {
             super(context);
             // TODO Auto-generated constructor stub
        }

        @Override
        protected void onDraw(Canvas canvas) {
           // TODO Auto-generated method stub
           super.onDraw(canvas);
           Paint paint = new Paint();

           paint.setColor(android.graphics.Color.BLACK);
           canvas.drawPaint(paint);

         //  paint.setStrokeWidth(4);
           paint.setColor(android.graphics.Color.RED);
           paint.setStyle(Paint.Style.FILL_AND_STROKE);
           paint.setAntiAlias(true);
           int line1=length1*20;
           int line2=length2*20;
           //int angle = angle;
           Point point1 = new Point(100, 100);
           Point point2 = new Point(line1+100, 100);
           float radianValue =(float) 0.017;
           
           int cx = (int) (line2*Math.cos(angle*radianValue));
           int cy =(int)(line2*Math.sin(angle*radianValue));
           
           Point point3 = new Point(cx,cy);

           Path path = new Path();
          path.setFillType(FillType.EVEN_ODD);
          path.moveTo(point1.x, point1.y);
           path.lineTo(point2.x, point2.y);
           path.lineTo(point3.x, point3.y);
           path.lineTo(point1.x, point1.y);
           path.close();
           canvas.drawPath(path, paint);
       }
    }
}
