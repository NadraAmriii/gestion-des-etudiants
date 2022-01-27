package com.example.exam;


public class Etudiant {
	private int id;
	private String nom,pr�nom,classe,group,login,password;


	public int getId() {
		return id;
	}

public Etudiant(){
	
}
	public void setId(int id) {
		this.id = id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPr�nom() {
		return pr�nom;
	}


	public void setPr�nom(String pr�nom) {
		this.pr�nom = pr�nom;
	}


	public String getClasse() {
		return classe;
	}


	public void setClasse(String classe) {
		this.classe = classe;
	}


	public String getGroup() {
		return group;
	}


	public void setGroup(String group) {
		this.group = group;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Etudiant(int id, String nom, String pr�nom, String classe,String group, String login, String password) {
		super();
		this.id = id;
		this.nom = nom;
		this.pr�nom = pr�nom;
		this.classe = classe;
		this.group = group;
		this.login = login;
		this.password = password;
	}


	@Override
	public String toString() {
		return "Etudiant [id=" + id + ", nom=" + nom + ", pr�nom=" + pr�nom
				+ ", classe=" + classe + ", group=" + group + ", login="
				+ login + ", password=" + password + "]";
	}
	

}
