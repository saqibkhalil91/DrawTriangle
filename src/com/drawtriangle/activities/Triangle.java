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
	     setContentView(new MyView(this,length1,length2,length3,angle1,angle2,angle3,toggle_flag));
	
		
	
	   
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
	public class MyView extends View {
		Point point1,point2,point3;
		double length1,length2,angle1,length3,angle2,angle3;
		int toggle;
        public MyView(Context context,double l1,double l2,double l3,double a1,double a2,double a3,int toggle) {
             super(context);
             this.length1=l1;
             this.length2=l2;
             this.length3=l3;
             this.angle1=a1;
             this.angle2=a2;
             this.angle3=a3;
             this.toggle =toggle;
             // TODO Auto-generated constructor stub
        }
        public int getPx(int length)
        {
        	int value = length*5;
        	return value;
        }
        private double degreeToRadian(double degree)
    	{
    		double radianValue = 0.017;
    		double radianAngle =degree*radianValue;
    		return radianAngle;
    	}
        private void getXCoordinate()
        {
        	
            if(this.toggle==0){
        	int length1= (int) this.length1;
            int length2=(int) this.length2;
            double angle1=this.angle1; 
           
            length1=   getPx(length1);
            	length2= getPx(length2);
            		angle1 = degreeToRadian(angle1);
	        	 int half = length1/2;
	             int xCoordinate = getWidth()/2;
	             xCoordinate= xCoordinate-half;
	             int yCoodinate= getHeight()/2;
	              point1 = new Point(xCoordinate, yCoodinate);
	              point2 = new Point(length1+xCoordinate, yCoodinate);
               	double cos =  Math.cos(angle1);
               	cos= cos*length2;
               	double xStart = length1+xCoordinate;
               	double  cx=cos+xStart; 
               	double sin = Math.sin(angle1);
               	sin= sin*length2;
               	double yStart = yCoodinate;
               	double cy =yStart-sin;
               	int ccx=(int) cx;
               	int ccy =(int)cy;
               	 point3 = new Point(ccx,ccy);
               	 Log.d("length1", length1+"");
                 Log.d("length2", length2+"");
                 Log.d("length3", length3+"");
                 Log.d("a1", this.angle1+"");
                 Log.d("a2", this.angle2+"");
                 Log.d("a3", this.angle3+"");
               	Log.d("point 3", point3+"");
               	Log.d("toggle", this.toggle+"");
               	
            }else if(this.toggle==1)
            {
            	
            	int length1= (int) this.length1;
                int length2=(int) this.length2;
                double angle1=this.angle1; 
               
                length1=   getPx(length1);
                	length2= getPx(length2);
                		angle1 = degreeToRadian(angle1);
    	        	 int half = length1/2;
    	             int xCoordinate = getWidth()/2;
    	             xCoordinate= xCoordinate-half;
    	             int yCoodinate= getHeight()/2;
    	              point1 = new Point(xCoordinate, yCoodinate);
    	              point2 = new Point(length1+xCoordinate, yCoodinate);
                   	double cos =  Math.cos(angle1);
                   	cos= cos*length2;
                   	double xStart = length1+xCoordinate;
                   	double  cx=cos+xStart; 
                   	double sin = Math.sin(angle1);
                   	sin= sin*length2;
                   	double yStart = yCoodinate;
                   	double cy =yStart-sin;
                   	int ccx=(int) cx;
                   	int ccy =(int)cy;
                   	 point3 = new Point(ccx,ccy);
                   	 Log.d("length1", length1+"");
                     Log.d("length2", length2+"");
                     Log.d("length3", length3+"");
                     Log.d("a1", this.angle1+"");
                     Log.d("a2", this.angle2+"");
                     Log.d("a3", this.angle3+"");
                   	Log.d("point 3", point3+"");
                   	Log.d("toggle", this.toggle+"");

  
            }
        }
        @SuppressLint("DrawAllocation")
		@Override
        protected void onDraw(Canvas canvas) {
           // TODO Auto-generated method stub
           super.onDraw(canvas);
    

         
        
           Paint paint = new Paint();

           paint.setColor(android.graphics.Color.BLACK);
           canvas.drawPaint(paint);
        
           paint.setStrokeWidth(5);
           paint.setColor(android.graphics.Color.WHITE);
           paint.setStyle(Paint.Style.STROKE);
           paint.setAntiAlias(true);
           
        
            

           Path path = new Path();
          path.setFillType(FillType.EVEN_ODD);
          
          
          paint.setColor(Color.RED); 
         	paint.setTextSize(30); 
         	
         	
         	canvas.drawText("Length1 is "+length1, 10,35, paint);
         	canvas.drawText("Length2 is "+length2, 10,75, paint);
         	canvas.drawText("Length3 is "+length3, 10,105, paint);
         	canvas.drawText("Angle1 is "+angle1, 10,145, paint);
         	canvas.drawText("Angle2 is "+angle2, 10,185, paint);
         	canvas.drawText("Angle3 is "+angle3, 10,225, paint);
        	canvas.drawText("1 cm is = 5px", 10,255, paint);
        	
         	getXCoordinate();
          path.moveTo(point1.x, point1.y);
           path.lineTo(point2.x, point2.y);
         // path.moveTo(point2.x, point2.y);
          path.lineTo(point3.x, point3.y);
          path.lineTo(point1.x, point1.y);
           path.close();
           canvas.drawPath(path, paint);
       }
    }
}
