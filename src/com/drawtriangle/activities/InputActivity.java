package com.drawtriangle.activities;





import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class InputActivity extends Activity implements OnClickListener {
	private Button enter;
	private EditText values;
	private int length1;
	private int length2;
	private int angle;
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
			
			Log.e("part1", part1);
			Log.e("part2", part2);
			Log.e("part3", part3);
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
				Bundle bundle = new Bundle();

			    bundle.putInt("l1", length1);
			    bundle.putInt("l2", length2);
			    bundle.putInt("angle", angle);
			    
				separateValues(triangleValues);
				Intent triangle = new Intent(this,Triangle.class);
				triangle.putExtras(bundle);
				startActivity(triangle);
			
			break;
		}
		
	}

	
}
