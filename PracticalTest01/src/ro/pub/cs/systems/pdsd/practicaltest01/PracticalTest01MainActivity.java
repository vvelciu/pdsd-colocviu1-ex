package ro.pub.cs.systems.pdsd.practicaltest01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PracticalTest01MainActivity extends Activity {

	
	int total = 0;
	private class ButtonClickListener implements Button.OnClickListener {
		 
		  @Override
		  @SuppressWarnings("all")
		  public void onClick(View view) {
		    EditText text1 = (EditText)findViewById(R.id.editText1);
		    EditText text2 = (EditText)findViewById(R.id.editText2);
		    
		    switch(view.getId()) {
		    case R.id.button1:
		    	Integer val1 = Integer.parseInt(text1.getText().toString());
		    	val1++;
		    	text1.setText(val1.toString());
		    	total++;
		    	break;
		    case R.id.button2:
		    	Integer val2 = Integer.parseInt(text2.getText().toString());
		    	val2++;
		    	text2.setText(val2.toString());
		    	total++;
		    	break;
		    case R.id.button3:
		    	Intent intent = new Intent("ro.pub.cs.systems.pdsd.practicaltest01.PracticalTest01SecondaryActivity");
		    	intent.putExtra("counter", total + "");
		    	startActivityForResult(intent, 1);
		    }
		 }
	}
	
	public void onActivityResult(int requestCode, int resultCode, Intent intent) {
		  switch(requestCode) {
		    case 1:
		      if (resultCode == Activity.RESULT_OK) {
		    	  Toast.makeText(getApplicationContext(), "OK returned", Toast.LENGTH_LONG).show();
		      }
		      if (resultCode == Activity.RESULT_CANCELED) {
		    	  Toast.makeText(getApplicationContext(), "CANCELED returned", Toast.LENGTH_LONG).show();
			      }
		      break;
		  }
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_practical_test01_main);
		
		Button btn1 = (Button) findViewById(R.id.button1);
		Button btn2 = (Button) findViewById(R.id.button2);
		Button btn3 = (Button) findViewById(R.id.button3);
		
		btn1.setOnClickListener(new ButtonClickListener());
		btn2.setOnClickListener(new ButtonClickListener());
		btn3.setOnClickListener(new ButtonClickListener());
	}
	
	@Override
	protected void onSaveInstanceState(Bundle savedInstanceState) {
	  super.onSaveInstanceState(savedInstanceState);
	  
	  EditText text1 = (EditText)findViewById(R.id.editText1);
	  EditText text2 = (EditText)findViewById(R.id.editText2);
	  
	  savedInstanceState.putString("text1", text1.getText().toString());
	  savedInstanceState.putString("text2", text2.getText().toString());
	}
	
	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
	  super.onRestoreInstanceState(savedInstanceState);
	  
	  EditText text1 = (EditText)findViewById(R.id.editText1);
	  EditText text2 = (EditText)findViewById(R.id.editText2);
	  
	  if (savedInstanceState.getString("text1") != null) {
	      text1.setText(savedInstanceState.getString("text1"));
	  }
	  if (savedInstanceState.getString("text2") != null) {
	      text2.setText(savedInstanceState.getString("text2"));
	  }
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.practical_test01_main, menu);
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
