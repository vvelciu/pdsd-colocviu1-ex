package ro.pub.cs.systems.pdsd.practicaltest01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PracticalTest01SecondaryActivity extends Activity {

	private class ButtonClickListener implements Button.OnClickListener {
		 
		  @Override
		  @SuppressWarnings("all")
		  public void onClick(View view) {
		    EditText text1 = (EditText)findViewById(R.id.editText1);
		    EditText text2 = (EditText)findViewById(R.id.editText2);
		    Intent intentToParent = new Intent();
		    switch(view.getId()) {
		    case R.id.button1:
		    	setResult(RESULT_OK, intentToParent);
		    	finish();
		    	break;
		    case R.id.button2:
		    	setResult(RESULT_CANCELED, intentToParent);
		    	finish();
		    	break;
		    }
		    
		   }
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_practical_test01_secondary);
		
		Button btn1 = (Button) findViewById(R.id.button1);
		Button btn2 = (Button) findViewById(R.id.button2);
		
		btn1.setOnClickListener(new ButtonClickListener());
		btn2.setOnClickListener(new ButtonClickListener());
		
		TextView text = (TextView) findViewById(R.id.editText1);
		Intent intent = getIntent();
		
		if(intent != null) {
			text.setText(intent.getStringExtra("counter"));
		}
	}
	
}
