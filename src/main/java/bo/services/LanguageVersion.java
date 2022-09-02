package bo.services;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="language_versions")
@NamedQueries({
	@NamedQuery(
			// findAll + this.class 
			name="findAllLanguageVersion",
			query="SELECT v FROM LanguageVersion v"),
	@NamedQuery(
			// find + this.class + ById 
			name="findLanguageVersionById",
			query="SELECT v FROM LanguageVersion v WHERE v.id = :id")
})
public class LanguageVersion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "language_version_type")
	private String type;
	
	public LanguageVersion() {}
	public LanguageVersion(String type) {
		this.type = type;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
}
