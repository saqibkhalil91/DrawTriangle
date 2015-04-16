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
import android.widget.EditText;
import android.widget.Toast;

public class InputActivity extends Activity implements OnClickListener {
	private Button enter;
	private EditText values;
	private int length1;
	private int length2;
	private int angle;
	private double secondAngle;
	private double sinValue;
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
			length1 =Integer.parseInt(part1);
			length2= Integer.parseInt(part2);
			angle=Integer.parseInt(part3);
			 secondAngle=findAngle(length1, length2, angle);
			 sinValue =angleSize(length1, length2, angle);
			
			
			
	}
	private double findAngle(int length1,int length2,int angle)
	{
				double radianValue = 0.017;
				double randianAngle = angle*radianValue;
				double sinValue= Math.sin(randianAngle);
				double ratio=sinValue/length2;
				double calculateAngle=length1*ratio;
				double  secondAngle=  Math.asin(calculateAngle);
				Log.d("second angle", secondAngle+"");
				double AngleC = secondAngle*57.29;
				Log.d("AngleC", AngleC+"");
				return AngleC;				
	}
	private double angleSize(int length1,int lenght2,int angle)
	{
		double radianValue = 0.017;
		double randianAngle = angle*radianValue;
		double ratio = length1/lenght2;
		double sinAngle=Math.sin(randianAngle);
		double D =sinAngle*ratio;
		Log.d("value of D", D+"" );
		return D;	
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
				String triangleValues = values.getText().toString();
				
				separateValues(triangleValues);
				double sumAngle=angle+secondAngle;
				if(!triangleValues.equals("null")&&triangleValues.length()>=5 ){
							if(sumAngle>180 || sinValue>1 )
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
			
			break;
		}
		
	}

	
}
