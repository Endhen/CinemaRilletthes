package m2i.cinema.bo.cinema;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import m2i.cinema.bo.GenericBean;
import m2i.cinema.bo.location.Address;

@Data @Entity
@AllArgsConstructor
@Table(name="cinemas")
@EqualsAndHashCode(callSuper=false)
public class Cinema extends GenericBean {
	
	@Column(name = "cinema_name")
	private String name;

	@OneToOne(
			cascade = CascadeType.ALL, 
			fetch = FetchType.LAZY, // EAGER
			optional = false)
	private Address address;
	
	// @OneToOne(
	// 		cascade = CascadeType.ALL, 
	// 		fetch = FetchType.LAZY, 
	// 		optional = false)
	// private SuperUser manager; 

	@OneToMany(
			cascade = CascadeType.ALL, 
			fetch = FetchType.LAZY)
	private List<Room> rooms;
	
	public Cinema() {}
}
