package AdminOperations;

public class Stagiaire extends User {
	private int id;
	private String nom;
	private String prenom;
	private String CIN;
	private String etablissment;
	private String filiere;
	private String adresse;
	private String numero_tele;
	private int age;
	public Stagiaire(int id, String nom, String prenom, String cIN, String etablissment, String filiere, String adresse,
			String numero_tele, int age) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		CIN = cIN;
		this.etablissment = etablissment;
		this.filiere = filiere;
		this.adresse = adresse;
		this.numero_tele = numero_tele;
		this.age = age;
	}
	public Stagiaire() {
		super();
	}
	protected int getId() {
		return id;
	}
	protected void setId(int id) {
		this.id = id;
	}
	protected String getNom() {
		return nom;
	}
	protected void setNom(String nom) {
		this.nom = nom;
	}
	protected String getPrenom() {
		return prenom;
	}
	protected void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	protected String getCIN() {
		return CIN;
	}
	protected void setCIN(String cIN) {
		CIN = cIN;
	}
	protected String getEtablissment() {
		return etablissment;
	}
	protected void setEtablissment(String etablissment) {
		this.etablissment = etablissment;
	}
	protected String getFiliere() {
		return filiere;
	}
	protected void setFiliere(String filiere) {
		this.filiere = filiere;
	}
	protected String getAdresse() {
		return adresse;
	}
	protected void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	protected String getNumero_tele() {
		return numero_tele;
	}
	protected void setNumero_tele(String numero_tele) {
		this.numero_tele = numero_tele;
	}
	protected int getAge() {
		return age;
	}
	protected void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Stagiaire [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", CIN=" + CIN + ", etablissment="
				+ etablissment + ", filiere=" + filiere + ", adresse=" + adresse + ", numero_tele=" + numero_tele
				+ ", age=" + age + "]";
	}
	
}
