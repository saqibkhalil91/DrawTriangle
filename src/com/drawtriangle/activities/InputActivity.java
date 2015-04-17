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
	private int length1;
	private int length2;
	private int angle;
	private double secondAngle;
	private double sinValue;
	private double thirdLength;
	private double triangleArea;
	private int checkToggle =0;
	private double angle1,angle2,length3;
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
			 secondAngle=findAngle(length1, length2, angle);
			 sinValue =givenAngleSinValue(length1, length2, angle);		
			 double sidesRatio=triangleSideRatio(length1, length2, secondAngle);
			 triangleArea =triangleArea(sidesRatio, length1, length2, thirdLength);
		}else if(checkToggle==1)
		{
			angle1 =Integer.parseInt(part1);
			angle2= Integer.parseInt(part2);
			length3=Integer.parseInt(part3);
		}
			 
	}
	private double findAngle(int length1,int length2,int angle)
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
	private double givenAngleSinValue(int length1,int lenght2,int angle)
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
	private double triangleSideRatio(int length1,int length2,double angle)
	{
		double length1Power=  Math.pow(length1, 2);
		double length2Power = Math.pow(length2, 2);
		double sidesProduct=length1*length2*2;
		double randianAngle = degreeToRadian(angle);
		double cosValue= Math.cos(randianAngle);
		double cosMultiplySidesProduct=sidesProduct*cosValue;
		double squarethirdLenght =length1Power+length2Power-cosMultiplySidesProduct;
		thirdLength=Math.sqrt(squarethirdLenght);
		double sides =length1+length2+thirdLength;
		double sideRatio= sides/2;
		return sideRatio;
		
	}
	private double triangleArea(double s,int length1,int lenth2,double lenth3)
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
	        Toast.makeText(this, "AAL", Toast.LENGTH_LONG).show();
	    } else {
	    	   Toast.makeText(this, "LLA", Toast.LENGTH_LONG).show();
	    	   checkToggle=0;
	    }
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
			
				Log.d("secondAngle", secondAngle+"");
				Log.d("sinValue", sinValue+"");
				Log.d("triangleArea", triangleArea+"");
				
				if(checkToggle==0){
					
					 sumTwoAngle=angle+secondAngle;
							if(!triangleValues.equals("null")&&triangleValues.length()>=5 ){
										if(sumTwoAngle>=180 ||sumTwoAngle==-8888.0|| sinValue>1||triangleArea<0 || triangleArea==-8888.0 ||secondAngle==-8888.0)
										{
											triangleNotValid();
											
										} else
										{
												Bundle bundle = new Bundle();
												 bundle.putInt("l1", length1);
											    bundle.putInt("l2", length2);
											    bundle.putInt("angle", angle);
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
					double sumAngle=angle1+angle2;
					if(sumAngle>=180)
					{
						triangleNotValid();
					}
					else
					{
						//set values in bundle and send data to next activity
						// Intent triangle = new Intent(this,Triangle.class);
						//startActivity(triangle);
					}
				}
			
			break;
		}
		
	}

	
}
