package com.example.exam;



import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class EtudiantHandlerDb extends SQLiteOpenHelper {
	
	private static final int DATABASE_VERSION = 1;
	private static final String DATABASE_NAME = "EtudiantsDB"; 
	private static final String TABLE_ETUDIANTS = "table_etudiants";
	private static final String COLONNE_ID = "id";
	private static final String COLONNE_NOM = "nom";
	private static final String COLONNE_PRENOM = "prenom";
	private static final String COLONNE_CLASSE = "classe";
	private static final String COLONNE_GROUPE = "groupe";
	private static final String COLONNE_LOGIN = "login";
	private static final String COLONNE_PASSWORD = "password";
	private static final String REQUETE_CREATION_BD = "create table "+ TABLE_ETUDIANTS + " (" + COLONNE_ID+ " integer primary key autoincrement, "+ 
	 COLONNE_NOM +  " TEXT not null, " +
	 COLONNE_PRENOM +  " TEXT not null, " +
	 COLONNE_CLASSE +  " TEXT not null, " +
	 COLONNE_GROUPE +  " TEXT not null, " +
	 COLONNE_LOGIN +  " TEXT not null, " +
	 COLONNE_PASSWORD + " TEXT not null );  ";
	private SQLiteDatabase db; 
	 
	public EtudiantHandlerDb(Context context, String name,
			CursorFactory factory, int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}
	public EtudiantHandlerDb(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(REQUETE_CREATION_BD);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
		// TODO Auto-generated method stub
		db.execSQL("DROP TABLE" +  TABLE_ETUDIANTS+ ";"); 
		onCreate(db); 
		
	}
	public boolean Insert(Etudiant etudiant){
		SQLiteDatabase maBD = this.getWritableDatabase(); 
		 
		ContentValues valeurs = new ContentValues(); 
		 
		valeurs.put(COLONNE_NOM, etudiant.getNom()); 
		valeurs.put(COLONNE_PRENOM, etudiant.getPrénom());
		valeurs.put(COLONNE_CLASSE, etudiant.getClasse());
		valeurs.put(COLONNE_GROUPE, etudiant.getGroup());
		valeurs.put(COLONNE_LOGIN, etudiant.getLogin());
		valeurs.put(COLONNE_PASSWORD, etudiant.getPassword());

		long inserted = maBD.insert(TABLE_ETUDIANTS, null, valeurs); 
		maBD.close(); 
		return true;
	}
	public ArrayList<Etudiant> getAllEtudiants() { 
		 
		SQLiteDatabase  maBD = this.getReadableDatabase(); 
		 
		Cursor c = maBD.query(TABLE_ETUDIANTS,  new String[] { COLONNE_ID, COLONNE_NOM,COLONNE_PRENOM,COLONNE_CLASSE,COLONNE_GROUPE,COLONNE_LOGIN,COLONNE_PASSWORD },  null, null, null,null, null);
		return cursorToEtud(c); 
}
	private Etudiant cursorToPlanete(Cursor c) {
		// Si la requête ne renvoie pas de résultat.
		if (c==null || c.getCount() == 0)
		return null;
		c.moveToFirst();
		Etudiant retPlanete = new Etudiant();
		// Extraction des valeurs depuis le curseur.
		retPlanete.setId(c.getInt(0));
		retPlanete.setNom(c.getString(1));
		retPlanete.setPrénom(c.getString(2 ));
		retPlanete.setGroup(c.getString(3 ));
		retPlanete.setClasse(c.getString(4 ));
		retPlanete.setLogin(c.getString(5));
		retPlanete.setPassword(c.getString(6));
		
		// Ferme le curseur pour libérer les ressources.
		c.close();
		return retPlanete;
		}
	private ArrayList<Etudiant> cursorToEtud(Cursor c) {
		// TODO Auto-generated method stub
		if (c.getCount() == 0)  return new ArrayList<Etudiant>(0); 
		ArrayList<Etudiant> resEtudiants = new ArrayList<Etudiant>(c.getCount()); 
		c.moveToFirst(); 
		do{
			Etudiant resEtudiant = new Etudiant(); 
			resEtudiant.setId(c.getInt(0));
			resEtudiant.setNom(c.getString(1));
			resEtudiant.setPrénom(c.getString(2 ));
			resEtudiant.setGroup(c.getString(3 ));
			resEtudiant.setClasse(c.getString(4 ));
			resEtudiant.setLogin(c.getString(5));
			resEtudiant.setPassword(c.getString(6));
			resEtudiants.add(resEtudiant);
		} while(c.moveToNext());
		
		c.close(); 
		return resEtudiants; 
	}



public void removePlanete(String nom) {
	SQLiteDatabase maBD = this.getWritableDatabase();
	maBD.delete(TABLE_ETUDIANTS, COLONNE_NOM + " = ?", new String[] { nom});
/* OU
maBD.delete(TABLE_PLANETES, 
COLONNE_NOM + " LIKE "+ nom, null);*/
maBD.close();
}
public Boolean updatePlanete(String nom, Etudiant planeteToUpdate) {
	SQLiteDatabase maBD = this.getWritableDatabase();
	ContentValues valeurs = new ContentValues();
	//valeurs.put(COLONNE_NOM,planeteToUpdate.getNom());
	valeurs.put(COLONNE_PRENOM,planeteToUpdate.getPrénom());
	//maBD.update(TABLE_ETUDIANTS, valeurs,COLONNE_NOM + " = "+ nom, null);

maBD.update(TABLE_ETUDIANTS, valeurs,
		COLONNE_NOM + " = ?", new String[]{String.valueOf(nom) }); 
	maBD.close();
	return true;
}
public Etudiant getPlanete(String nom) {
	SQLiteDatabase maBD =this.getReadableDatabase();
	Cursor c = maBD.query(TABLE_ETUDIANTS,
			new String[] {COLONNE_ID, COLONNE_NOM,COLONNE_PRENOM,COLONNE_CLASSE,COLONNE_GROUPE,COLONNE_LOGIN,COLONNE_PASSWORD },COLONNE_NOM + " =? " ,
			new String[]{String.valueOf(nom)},null, null, null);
	return cursorToPlanete(c);
	
	
}


}
