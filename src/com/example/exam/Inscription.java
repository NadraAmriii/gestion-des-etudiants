package com.example.exam;



import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Inscription extends Activity {
	Button B_OK;
	Button B_AN;
	EtudiantHandlerDb db ;
	EditText nom;
	EditText prenom;
	EditText classe;
	EditText groupe;
	EditText login;
	EditText password;
	EditText etud_id;
	Button update;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout2);
		
		B_OK=(Button)findViewById(R.id.boutton1);
		B_AN=(Button)findViewById(R.id.boutton2);
		nom = (EditText)findViewById(R.id.editText1);
		prenom = (EditText)findViewById(R.id.editText2);
		classe = (EditText)findViewById(R.id.editText3);
		groupe = (EditText)findViewById(R.id.editText4);
		login = (EditText)findViewById(R.id.editText5);
		password = (EditText)findViewById(R.id.editText6);
	

		
		db = new EtudiantHandlerDb(this);
		B_OK.setOnClickListener (new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Etudiant e = new Etudiant();
				e.setNom(nom.getText().toString());
				e.setPrénom(prenom.getText().toString());
				e.setClasse(classe.getText().toString());
				e.setGroup(groupe.getText().toString());
				e.setLogin(login.getText().toString());
				e.setPassword(password.getText().toString());
				db.Insert(e); 
				
				setResult(RESULT_OK);
				finish();
				
				
			}
		});
			 B_AN.setOnClickListener (new View.OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					setResult(RESULT_CANCELED);
					finish();
					
				}}
			);
			 
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.inscription, menu);
		return true;
	}

}
