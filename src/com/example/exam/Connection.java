package com.example.exam;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Connection extends Activity {
	Button bt1;
	Button bt2;
	EtudiantHandlerDb db ;
	EditText nom;
	EditText passmo;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout3);
		bt1 =(Button)findViewById(R.id.boutton1);
		bt2 =(Button)findViewById(R.id.boutton2);
		nom = (EditText)findViewById(R.id.log);
		passmo = (EditText)findViewById(R.id.pass);
		db = new EtudiantHandlerDb(this);
		 
		bt1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				List<Etudiant> etudiants = db.getAllEtudiants();
				String l = nom.getText().toString();
				String p = passmo.getText().toString();
				
				//Etudiant etud;
				for(Etudiant etud :etudiants ){
					if(l== etud.getLogin().toString()&& p==etud.getPassword().toString()){
						//Toast.makeText(Connection.this, "connexion avec succes", Toast.LENGTH_SHORT).show();
						
						setResult(RESULT_OK);
						finish();
					}
					else{
						Toast.makeText(Connection.this, "connexion avec echec", Toast.LENGTH_SHORT).show();
						
					}
				}
				}
				
				
			
		});
		bt2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				setResult(RESULT_CANCELED);
				finish();
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.connection, menu);
		return true;
	}

}
