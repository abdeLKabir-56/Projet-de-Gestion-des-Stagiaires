package Persistance;

import java.sql.Connection;

public class DAOStagiaire {
	private Connection conn = new DBConnexion().getconnexion();
	private static final String INSERT_STAGIAIRES = "INSERT INTO stagiaire ( nom, prenom, CIN, etablissement, filiere, adresse, age, id_stage) VALUES (?,?,?,?,?,?,?,?)";
	private static final String SELECT_ALL_STAGIAIRES = "SELECT * FROM stagiaire";
	private static final String DELETE_STAGIAIRES = "DELETE FROM stagiaire WHRE id = ?";
	private static final String UPDATE_STAGIAIRES = "UPDATE stagiaire SET nom = ?, prenom = ?, CIN = ?, etablissement = ?, filiere = ?, adresse = ?, age = ? id_stage = ? WHERE id = ?";
	public DAOStagiaire() {
		super();
	}
	
}
