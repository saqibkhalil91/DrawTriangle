package com.drawtriangle.activities;

import java.text.DecimalFormat;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Path.FillType;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;


public class TriangleView extends View {
	Point point1,point2,point3;
	double length1,length2,angle1,length3,angle2,angle3;
	int toggle;
	double scalingFactor;
    public TriangleView(Context context) {
         super(context);
//         LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//         View view=layoutInflater.inflate(R.layout.triangleview,this);
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
/*    public void drawPoints(int length1,int length2,double angle1)
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
    		
     // int  xCoordinate= (int) (scaledlength1+20);
    		int xCoordinate =0;
         int yCoodinate= getHeight()/2;
         int half=length2/2;
         
         yCoodinate=yCoodinate+half;
          point1 = new Point((int) (xCoordinate*0.8474), yCoodinate);
          int sum =length1+xCoordinate;
          point2 = new Point((int) (sum*0.8474), yCoodinate);
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
           	
           	 point3 = new Point((int) (ccx*0.8474),ccy);
           	 Log.d("max lenght",  maxLength+"");
           	 Log.d("length1", length1+"");
             Log.d("length2", length2+"");
             Log.d("length3", length3+"");
             Log.d("a1", this.angle1+"");
             Log.d("a2", this.angle2+"");
             Log.d("a3", this.angle3+"");
             Log.d("point 1", point1+"");
             Log.d("point 2", point2+"");
             Log.d("point 3", point3+"");
             Log.d("hight", getHeight()+"");
             Log.d("toggle", this.toggle+"");
       	
    }*/
    public void factorRatio(){
    	
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
    		//int xCoordinate =0;
         int yCoodinate= getHeight()/2;
         int half=length2/4;
         
         
         yCoodinate=yCoodinate+half;
          point1 = new Point(xCoordinate, yCoodinate);
          int sum =length1+xCoordinate;
          point2 = new Point(sum, yCoodinate);
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
             Log.d("point 1", point1+"");
             Log.d("point 2", point2+"");
             Log.d("point 3", point3+"");
             Log.d("hight", getHeight()+"");
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
        
            }
    }
    public double getFactor(int xPoint,int width)
    {
    	double factor = width/xPoint;
    	
    	return  factor;
    }
    public float pointsDifference(float p1,float p2)
    {
    	float sum=p1+p2;
      	sum =sum/2;
      	return sum;
    }
    public float pointsDifferenc(int p1,int p2)
    {
    	float sum=p1+p2;
      	sum =sum/2;
      	return sum;
    }
    private String numberFormatter(double length)
    {
    	DecimalFormat numberFormat = new DecimalFormat("#.0");

		String formatLength = numberFormat.format(length)+"";
		return formatLength;
    }
    private void drawTriangle()
    {
    	
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
     	paint.setTextSize(40); 
     	triangleCalculations();
    	double w=getWidth()+0.0;
  		double p=point3.x+0.0;
  		double f=w/p;
  		f=f-0.2;
     	int checkWidth = getWidth();
     	float point1XF=(float) (point1.x*f);
     	float point2XF =(float) (point2.x*f); 
     	float point3XF =(float) (point3.x*f);
      	float sum1 =pointsDifference(point1XF,point2XF);
      	
      	
      	float sum2 = pointsDifferenc(point2.y, point3.y);
    	float sum3 = pointsDifferenc(point1.y, point3.y);
    

		String formatLength = numberFormatter(length3);
		String formatAngle1= numberFormatter(angle1);
		String formatAngle2= numberFormatter(angle2);
		String formatAngle3= numberFormatter(angle3);
	
     	if(point3.x>checkWidth || point2.x>checkWidth || point1.x>checkWidth)
     	{
   
     	  	Log.d("checkWidth", canvas.getWidth()+"");
      		Log.d("point3.x", point3.x+"");
      	
      	Log.d("f", f+"");
      	paint.setAntiAlias(true);
      	
      		
      		
          	canvas.drawText(""+length1, sum1,point1.y, paint);
          	canvas.drawText(""+length2, (float) (point2XF),sum2, paint);
           	canvas.drawText(""+formatLength,point1.x+10,sum3, paint);
           
           	
           	Log.d("length1 Text", sum1+","+(float) (point1.y+40*f));
        	Log.d("length2 Text", (float) (point2.x+20*f)+","+(float) (sum2-40*f));
        	Log.d("length3 Text", (float) point1.x+60+","+(float) (sum3*f));
        	
        	
        
        	canvas.drawText(""+formatAngle3, point3XF,point3.y, paint);
           	canvas.drawText(""+formatAngle1,point1XF,point1.y, paint);
         	canvas.drawText(" "+formatAngle2, point2XF,point2.y, paint);
         	
         	
         	
         	
           	path.moveTo((float) (point1XF), point1.y);
           	path.lineTo((float) (point2XF), point2.y);
           	path.moveTo((float) (point2XF), point2.y);
           	path.lineTo((float) (point3XF), point3.y);
      
           	path.lineTo((float) (point1XF), point1.y);
           	path.close();
           	canvas.drawPath(path, paint);
       
     	}else {
     		Log.d("formatSum", length3+"");
     		canvas.drawText(""+length1, sum1,point2.y+40, paint);
     		canvas.drawText(""+length2, point2.x+20,sum2, paint);
     	   	canvas.drawText(""+formatLength, point1.x+10,sum3, paint);
     	   	
     		canvas.drawText(""+formatAngle3, point1.x+10,point1.y, paint);
        	canvas.drawText(""+formatAngle1, point2.x+10,point2.y, paint);
        	canvas.drawText(" "+formatAngle2, point3.x+10,point3.y, paint);
     	      path.moveTo(point1.x, point1.y);
     	       path.lineTo(point2.x, point2.y);
     	      path.moveTo(point2.x, point2.y);
     	      path.lineTo(point3.x, point3.y);
     	      path.lineTo(point1.x, point1.y);
     	       path.close();
     	      canvas.drawPath(path, paint);
     	}
   }
	
}
