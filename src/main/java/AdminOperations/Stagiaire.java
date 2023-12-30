package AdminOperations;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import usermanagment.model.User;
@Entity
@Table(name="Stagiaire")
public class Stagiaire{
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
	private int id;
	@Column(name="nom")
	private String nom;
	@Column(name="prenom")
	private String prenom;
	@Column(name="CIN")
	private String CIN;
	@Column(name="etablissment")
	private String etablissment;
	@Column(name="filiere")
	private String filiere;
	@Column(name="adresse")
	private String adresse;
	@Column(name="numero_tele")
	private String numero_tele;
	@Column(name="stage")
	private String stage;
	public Stagiaire(String nom, String prenom, String cIN, String etablissment, String filiere, String adresse,
			String numero_tele, String stage) {
		super();
		
		this.nom = nom;
		this.prenom = prenom;
		CIN = cIN;
		this.etablissment = etablissment;
		this.filiere = filiere;
		this.adresse = adresse;
		this.numero_tele = numero_tele;
		this.stage = stage;
	}
	
	public Stagiaire(int id, String nom, String prenom, String cIN, String etablissment, String filiere, String adresse,
			String numero_tele, String stage) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		CIN = cIN;
		this.etablissment = etablissment;
		this.filiere = filiere;
		this.adresse = adresse;
		this.numero_tele = numero_tele;
		this.stage = stage;
	}

	public Stagiaire() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	protected void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getCIN() {
		return CIN;
	}
	protected void setCIN(String cIN) {
		CIN = cIN;
	}
	public String getEtablissment() {
		return etablissment;
	}
	public void setEtablissment(String etablissment) {
		this.etablissment = etablissment;
	}
	public String getFiliere() {
		return filiere;
	}
	public void setFiliere(String filiere) {
		this.filiere = filiere;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getNumero_tele() {
		return numero_tele;
	}
	public void setNumero_tele(String numero_tele) {
		this.numero_tele = numero_tele;
	}
	public String getStage() {
		return stage;
	}
	public void setStage(String stage) {
		this.stage = stage;
	}
	@Override
	public String toString() {
		return "Stagiaire [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", CIN=" + CIN + ", etablissment="
				+ etablissment + ", filiere=" + filiere + ", adresse=" + adresse + ", numero_tele=" + numero_tele
				+ ", age=" + stage + "]";
	}
	
}
