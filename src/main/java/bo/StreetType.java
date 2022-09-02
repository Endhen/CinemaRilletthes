package bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="street_type")
@NamedQueries({
	@NamedQuery(
			name="findAllStreetType",
			query="SELECT t FROM StreetType t"),
	@NamedQuery(
			name="findStreetTypeById",
			query="SELECT t FROM StreetType t WHERE t.id = :id")
})
public class StreetType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "type_name")
	private String name;
	
	public StreetType() {}
	public StreetType(String name) {
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}	
}
