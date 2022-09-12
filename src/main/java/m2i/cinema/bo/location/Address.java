package m2i.cinema.bo.location;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import m2i.cinema.bo.GenericBean;

@Data @Entity
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
@Table(name="addresses")
public class Address extends GenericBean {

	@Column(name="street_number")
	private int number;

	@ManyToOne(
			cascade = CascadeType.ALL, 
			optional = false, 
			fetch = FetchType.LAZY) // EAGER
	private StreetType type;

	@Column(name="street_name")
	private String name;

	private String city;

	@Column(name="area_code")
	private String areaCode;
	
	public Address() {}
}
