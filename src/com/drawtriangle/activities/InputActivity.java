package com.drawtriangle.activities;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;

public class InputActivity extends Activity implements OnClickListener {
	private Button enter;
	private EditText values;
	private double length1;
	private double length2,length3;
	private double angle,angle2,angle3;
	//private double secondAngle;
	private double sinValue;
	private double thirdLength;
	private double triangleArea;
	private int checkToggle =0;
	private double angle1A,angle2A,angle3A,length2A,length1A,length3A;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_input);
		getViews();
	}
	private void getViews()
	{
		enter =(Button)findViewById(R.id.btnEnter);
		enter.setOnClickListener(this);
		values = (EditText)findViewById(R.id.edtValues);
	}
	private void separateValues( String values)
	{
			String val =values;
			String [] parts = val.split(",");
			String part1 = parts[0]; 
			String part2 = parts[1]; 
			String part3 = parts[2];
		if(checkToggle==0){
			
			length1 =Integer.parseInt(part1);
			length2= Integer.parseInt(part2);
			angle=Integer.parseInt(part3);
			angle2=findAngle(length1, length2, angle);
				angle3=getAngle3(angle, angle2);
			 sinValue =givenAngleSinValue(length1, length2, angle);		
			 double sidesRatio=triangleSideRatio(length1, length2, angle2);
			 triangleArea =triangleArea(sidesRatio, length1, length2, thirdLength);
			 length3=thirdLength;
				
				
		}else if(checkToggle==1)
		{
			angle1A =Integer.parseInt(part1);
			angle2A= Integer.parseInt(part2);
			length1A=Integer.parseInt(part3);
			angle3A=getAngle3(angle1A, angle2A);
			length2A=findSide(angle1A, angle3A, length1A);
			length3A=findSide(angle2A, angle3A, length1A);
			
		}
			 
	}
	private double findAngle(double length1,double length2,double angle)
	{
		double radianValue = 0.017;
		double randianAngle = angle*radianValue;
		double sinValue= Math.sin(randianAngle);
		double ratio=sinValue/length2;
		double calculateAngle=length1*ratio;
		double  secondAngle=  Math.asin(calculateAngle);
		double AngleC = secondAngle*57.29;
		if(Double.isNaN(AngleC)==true){
			return -8888.0;	
		}else{
		
		return AngleC;	
		}
	}
	private double givenAngleSinValue(double length1,double lenght2,double angle)
	{
		double radianValue = 0.017;
		double randianAngle = angle*radianValue;
		double ratio = length1/lenght2;
		double sinAngle=Math.sin(randianAngle);
		double D =sinAngle*ratio;
		if(Double.isNaN(D)==true){
			 return -8888.0;
		}else{
		return D;
		}
	}
	private double triangleSideRatio(double length1,double length2,double angle)
	{
		double length1Power=  Math.pow(length1, 2);
		double length2Power = Math.pow(length2, 2);
		double sidesProduct=length1*length2*2;
		double randianAngle = degreeToRadian(angle);
		double cosValue= Math.cos(randianAngle);
		double cosMultiplySidesProduct=sidesProduct*cosValue;
		double squarethirdLenght =length1Power+length2Power-cosMultiplySidesProduct;
		thirdLength=Math.sqrt(squarethirdLenght);
		length3=thirdLength;
		double sides =length1+length2+thirdLength;
		double sideRatio= sides/2;
		return sideRatio;
		
	}
	private double triangleArea(double s,double length1,double lenth2,double lenth3)
	{
		double subtractlength1=s-length1;
		double subtractlenght2 = s-lenth2;
		double subtratlength3 = s-lenth3;
		double productArea = s*subtractlength1*subtractlenght2 *subtratlength3;
		double area =Math.sqrt(productArea);
		if(Double.isNaN(area)==true){
			return -8888.0;
		}else{
		
		return area;
		}
	}
	private double degreeToRadian(double degree)
	{
		double radianValue = 0.017;
		double radianAngle =degree*radianValue;
		return radianAngle;
	}
	
	private void triangleNotValid() {

		AlertDialog.Builder helpBuilder = new AlertDialog.Builder(this);
		helpBuilder.setTitle("Validity Issue");
		helpBuilder.setMessage("Your triangle is not valid");

		helpBuilder.setPositiveButton("Thank you",
				new DialogInterface.OnClickListener() {

					public void onClick(DialogInterface dialog, int which) {

					}
				});
		// Remember, create doesn't show the dialog
		AlertDialog helpDialog = helpBuilder.create();
		helpDialog.show();

	}
	public void onToggleClicked(View view) {
	    // Is the toggle on?
	    boolean on = ((ToggleButton) view).isChecked();
	    
	    if (on) {
	    	checkToggle=1;
	     
	    } else {
	    	 
	    	   checkToggle=0;
	    }
	}
	private double getAngle3(double angle1,double angle2)
	{
		double findThirdAngle =180.0-angle1;
		findThirdAngle=findThirdAngle-angle2;
		return findThirdAngle;
	}
	private double findSide(double angle1,double angle2,double c)
	{
		double randianAngle2 = degreeToRadian(angle2);
		double C=Math.sin(randianAngle2);
		double randianAngle1 = degreeToRadian(angle1);
		double B=Math.sin(randianAngle1);
		double productAnlgeLength=B*c;
		double b=productAnlgeLength/C;
		return b;
		
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		 getMenuInflater().inflate(R.menu.input, menu);
		return super.onCreateOptionsMenu(menu);
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub 
		int key = v.getId();
		switch(key)
		{
			case R.id.btnEnter:
				
				double sumTwoAngle;
				String triangleValues = values.getText().toString();
				
				separateValues(triangleValues);
			
				
				
				if(checkToggle==0){
					
					 sumTwoAngle=angle+angle2;
							if(!triangleValues.equals("null")&&triangleValues.length()>=5 ){
										if(sumTwoAngle>180 ||sumTwoAngle==-8888.0|| sinValue>1||triangleArea<0 || triangleArea==-8888.0 ||angle2==-8888.0||angle>90)
										{
											triangleNotValid();
											
										} else
										{
												Bundle bundle = new Bundle();
												bundle.putDouble("l1", length1);
											    bundle.putDouble("l2", length2);
											    bundle.putDouble("l3", length3);
											    bundle.putDouble("a1", angle);
											    bundle.putDouble("a2", angle2);
											    bundle.putDouble("a3", angle3);
											    bundle.putInt("toggle", checkToggle);
											    Intent triangle = new Intent(this,Triangle.class);
												triangle.putExtras(bundle);
												startActivity(triangle);
											}
							}
							else{
								Toast.makeText(this, "Enter values", Toast.LENGTH_SHORT).show();
							}
				}
				else if(checkToggle==1)
				{
					double sumAngle=angle1A+angle2A;
					if(sumAngle>=180)
					{
						triangleNotValid();
					}
					else
					{
						Bundle bundle = new Bundle();
						bundle.putDouble("l1", length1A);
					    bundle.putDouble("l2", length2A);
					    bundle.putDouble("l3", length3A);
					    bundle.putDouble("a1", angle1A);
					    bundle.putDouble("a2", angle2A);
					    bundle.putDouble("a3", angle3A);
					    bundle.putInt("toggle", checkToggle);
					    Intent triangle = new Intent(this,Triangle.class);
						triangle.putExtras(bundle);
						startActivity(triangle);
					}
				}
			
			break;
		}
		
	}

	
}
