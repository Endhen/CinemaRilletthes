package bo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name="addresses")
@NamedQueries({
	@NamedQuery(
			// findAll + this.class 
			name="findAllAddress",
			query="SELECT a FROM Address a"),
	@NamedQuery(
			// find + this.class + ById 
			name="findAddressById",
			query="SELECT a FROM Address a WHERE a.id = :id")
})
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="street_number")
	private int number;
	@ManyToOne(
			cascade = CascadeType.ALL, 
			optional = false, 
			fetch = FetchType.EAGER)
	private StreetType type;
	@Column(name="street_name")
	private String name;
	@Column(name="city")
	private String city;
	@Column(name="area_code")
	private String areaCode;
	
	public Address() {}
	public Address(int number, StreetType type, String name, String city, String areaCode) {
		this.number = number;
		this.type = type;
		this.name = name;
		this.city = city;
		this.areaCode = areaCode;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public StreetType getType() {
		return type;
	}

	public void setType(StreetType type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
}
