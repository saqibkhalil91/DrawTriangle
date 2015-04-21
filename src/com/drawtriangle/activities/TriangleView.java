package com.drawtriangle.activities;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Path.FillType;
import android.util.Log;
import android.view.View;


public class TriangleView extends View {
	Point point1,point2,point3;
	double length1,length2,angle1,length3,angle2,angle3;
	int toggle;
	double scalingFactor;
    public TriangleView(Context context) {
         super(context);
        /* this.length1=l1;
         this.length2=l2;
         this.length3=l3;
         this.angle1=a1;
         this.angle2=a2;
         this.angle3=a3;
         this.toggle =toggle;*/
         // TODO Auto-generated constructor stub
    }
    public int getToggle() {
		return toggle;
	}
	public void setToggle(int toggle) {
		this.toggle = toggle;
	}
	public double getLength1() {
		return length1;
	}
	public void setLength1(double length1) {
		this.length1 = length1;
	}
	public double getLength2() {
		return length2;
	}
	public void setLength2(double length2) {
		this.length2 = length2;
	}
	public double getAngle1() {
		return angle1;
	}
	public void setAngle1(double angle1) {
		this.angle1 = angle1;
	}
	public double getLength3() {
		return length3;
	}
	public void setLength3(double length3) {
		this.length3 = length3;
	}
	public double getAngle2() {
		return angle2;
	}
	public void setAngle2(double angle2) {
		this.angle2 = angle2;
	}
	public double getAngle3() {
		return angle3;
	}
	public void setAngle3(double angle3) {
		this.angle3 = angle3;
	}
	public int getPx(int length)
    {
    	
    	double value = length*scalingFactor;
    	int scaleValue =(int) value;
    	return scaleValue;
    }
    public void setScaling(double length)
    {
    	 scalingFactor=getWidth()-40;
    	 scalingFactor=scalingFactor/length;
    }
    private double degreeToRadian(double degree)
	{
		double radianValue = 0.017;
		double radianAngle =degree*radianValue;
		return radianAngle;
	}
    private int drawX(int length)
    {
    	int width= getWidth()-40;
    	double scaleLength1=width-length1;
    	scaleLength1=scaleLength1/2;
    	int scaledlength1= (int) scaleLength1;
    	Log.d("scaledlength1", scaledlength1+"");
    	Log.d("width", width+"");
    	Log.d("length1", length1+"");
    	return scaledlength1;
    }
    public void drawPoints(int length1,int length2,double angle1)
    {
    	double maxLength=Math.max(this.length1, this.length2);
    	maxLength= Math.max(maxLength, length3);
    	setScaling(maxLength);
    	length1=   getPx(length1);
    	int scaledlength1 =drawX(length1);
    	scaledlength1=scaledlength1/2;
    	length2= getPx(length2);
    		angle1 = degreeToRadian(angle1);
    	// int half = length1/2;
        //int xCoordinate = getWidth()/2;
    		
      int  xCoordinate= (int) (scaledlength1+20);
         int yCoodinate= getHeight()/2;
         int half=length2/2;
         
         yCoodinate=yCoodinate+half;
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
           	 Log.d("max lenght",  maxLength+"");
           	 
           	 Log.d("length1", length1+"");
             Log.d("length2", length2+"");
             Log.d("length3", length3+"");
             Log.d("a1", this.angle1+"");
             Log.d("a2", this.angle2+"");
             Log.d("a3", this.angle3+"");
       	Log.d("point 3", point3+"");
       	Log.d("toggle", this.toggle+"");
       	
    }
    private void triangleCalculations()
    {
    	if(this.toggle==0){
    	int length1= (int) this.length1;
    		//int length1=(int) maxLength;
        int length2=(int) this.length2;
        double angle1=this.angle1; 
        drawPoints(length1,length2,angle1);
        	
        	
        }else if(this.toggle==1)
        {
        	
        	int length1= (int) this.length1;
            int length2=(int) this.length2;
            double angle1=this.angle1; 
            drawPoints(length1,length2,angle1);
            /*length1=   getPx(length1);
            int scaledlength1 =drawX(length1);
            	length2= getPx(length2);
            		angle1 = degreeToRadian(angle1);
            		 int  xCoordinate= (int) (scalingFactor+scaledlength1+20);
    	             int yCoodinate= getHeight()/2;
    	             int half=length2/2;
    	             yCoodinate=yCoodinate+half;
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
               	Log.d("toggle", this.toggle+"");*/


        }
    }
    @SuppressLint("DrawAllocation")
	@Override
    protected void onDraw(Canvas canvas) {
       // TODO Auto-generated method stub
       super.onDraw(canvas);


     
    
       Paint paint = new Paint();

       paint.setColor(android.graphics.Color.WHITE);
       canvas.drawPaint(paint);
    
       paint.setStrokeWidth(5);
       paint.setColor(android.graphics.Color.WHITE);
       paint.setStyle(Paint.Style.STROKE);
       paint.setAntiAlias(true);
       
    
        

       Path path = new Path();
      path.setFillType(FillType.EVEN_ODD);
      
      
      paint.setColor(Color.RED); 
     	paint.setTextSize(20); 
     	
     	
     
  
    	
     	triangleCalculations();
    	canvas.drawText(""+length1, point2.x,point2.y, paint);
       	canvas.drawText("Length2 is "+length2, 10,75, paint);
     	canvas.drawText("Length3 is "+length3, 10,105, paint);
     	canvas.drawText("Angle1 is "+angle1, 10,145, paint);
     	canvas.drawText("Angle2 is "+angle2, 10,185, paint);
     	canvas.drawText("Angle3 is "+angle3, 10,225, paint);
    	canvas.drawText("1 cm is = 5px", 10,255, paint);
      path.moveTo(point1.x, point1.y);
       path.lineTo(point2.x, point2.y);
     // path.moveTo(point2.x, point2.y);
      path.lineTo(point3.x, point3.y);
      path.lineTo(point1.x, point1.y);
       path.close();
       canvas.drawPath(path, paint);
   }
}
