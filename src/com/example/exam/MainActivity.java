package com.example.exam;



import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
	Button bouton_1;
	Button bouton_2;
	Button bouton_3;
	Button bouton_4;
	Button bouton_5;
	Button bouton_6;
	EtudiantHandlerDb db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout1);
        
        db = new EtudiantHandlerDb(this);
        setTitle("Gestion Etudiant");
       
        bouton_1=(Button)findViewById(R.id.bouton);
        bouton_2=(Button)findViewById(R.id.bouton1);
        bouton_3=(Button)findViewById(R.id.Button2);
        bouton_4=(Button)findViewById(R.id.button3);
        bouton_6=(Button)findViewById(R.id.button4);
      
        
        bouton_1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(MainActivity.this,Inscription.class);
		        		 startActivityForResult(intent,1);
		        		 }
		        		 });
				
			
        bouton_2.setOnClickListener(new  View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				 Intent intent=new
				       		Intent(MainActivity.this,Connection.class);
				       		 startActivityForResult(intent,2);
				
			}
		});
       		
        bouton_3.setOnClickListener(new View.OnClickListener(){
          		 public void onClick (View view){
          		 Intent intent=new Intent(MainActivity.this,Contact.class);
          		 startActivityForResult(intent,3);
     				
          		 }
          		 });
        bouton_4.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				List<Etudiant> l = db.getAllEtudiants();
				String mes = "";
				for(Etudiant e:l){
					mes+=e;
				}
				Toast.makeText(MainActivity.this, mes,
						Toast.LENGTH_SHORT).show();
          		 }
				
			
		});
        bouton_6.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				 Intent intent=new
				       		Intent(MainActivity.this,Effacer.class);
				       		 startActivityForResult(intent,4);
				
				
			}
		});
     
    }
    public void onActivityResult (int requestCode, int
    		resultCode, Intent data){
    		switch (requestCode){
    		 case (1): switch (resultCode){
    		case RESULT_OK:
    		 Toast.makeText(this,"Inscription avec Succés",
    		Toast.LENGTH_SHORT).show();
    		return;
    		case RESULT_CANCELED:
    		 Toast.makeText(this,"Inscription Annulée",
    		 Toast.LENGTH_SHORT).show();
    		return;
    		}
    		 case (2): switch (resultCode){
    		case RESULT_OK:
    		 Toast.makeText(this,"Connection avec Succés",
    		 Toast.LENGTH_SHORT).show();
    		return;
    		case RESULT_CANCELED:
    		 Toast.makeText(this,"Connection  Annulée",
    		 Toast.LENGTH_SHORT).show();
    		return;
    		}
    		
    		 case (4): switch (resultCode){
     		case RESULT_OK:
     		 Toast.makeText(this,"suppression avec succes",
     		 Toast.LENGTH_SHORT).show();
     		return;
     		case RESULT_CANCELED:
     		 Toast.makeText(this,"suppression  Annulée",
     		 Toast.LENGTH_SHORT).show();
     		return;
     		}
     		
    		
    }


    }}
    

