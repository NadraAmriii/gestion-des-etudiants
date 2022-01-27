package com.example.exam;


import java.util.List;



import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Effacer extends Activity {
	EditText nom,prenom;
	Button delete,Reset;
	EtudiantHandlerDb db;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout5);
		nom = (EditText)findViewById(R.id.edtN);
		prenom =(EditText)findViewById(R.id.edtP);
		delete =(Button)findViewById(R.id.btEff);
		Reset=(Button)findViewById(R.id.btAnn);
		db = new EtudiantHandlerDb(this);
		
		delete.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Etudiant e = new Etudiant();
			//String c=""	;
				String nom_eff =nom.getText().toString();
				String nom_up = prenom.getText().toString();
					//db.updatePlanete(nom_eff,e);
			e = db.getPlanete(nom_eff);
				e.setPrénom(nom_up);
				db.updatePlanete(nom_eff, e);
				if(e.getNom().equals(nom_eff)){
				
				
				Toast.makeText(Effacer.this, "update", Toast.LENGTH_LONG).show();
				}
				else if(e.getNom()!=nom_eff){
					Toast.makeText(Effacer.this, "no", Toast.LENGTH_LONG).show();
					
					
					
				}
					
				setResult(RESULT_OK);
				finish();
				
			}
		});
		Reset.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				setResult(RESULT_CANCELED);
				finish();
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.effacer, menu);
		return true;
	}

}
