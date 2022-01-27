package com.example.exam;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class Contact extends Activity {
	Button btn1;
	Button btn2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout4);
		btn1 = (Button)findViewById(R.id.boutton1);
		btn2 = (Button)findViewById(R.id.boutton2);
		
		btn1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				 Uri uri = Uri.parse("tel:95331745");
			     Intent intent = new Intent(Intent.ACTION_CALL, uri);
			     startActivity(intent);
				
			}
		});
		btn2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				Uri uri = Uri.parse("http://www.google.fr/");
				Intent intent = new Intent(Intent.ACTION_VIEW,uri);
				startActivity(intent);
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.contact, menu);
		return true;
	}

}
