package m2i.cinema.entity.cinema;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import m2i.cinema.entity.GenericEntity;
import m2i.cinema.entity.location.Address;

@Data @Entity
@AllArgsConstructor
@Table(name="cinemas")
@EqualsAndHashCode(callSuper=true)
public class Cinema extends GenericEntity {
	
	@Column(name = "cinema_name")
	private String name;

	@OneToOne(
			cascade = CascadeType.ALL, 
			fetch = FetchType.EAGER,
			optional = false)
	private Address address;
	
	// @OneToOne(
	// 		cascade = CascadeType.ALL, 
	// 		fetch = FetchType.EAGER, 
	// 		optional = false)
	// private SuperUser manager; 

	@OneToMany( // Rooms are excusive
			cascade = CascadeType.ALL, 
			fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SELECT) // OR SUBSELECT
	// @LazyCollection(LazyCollectionOption.FALSE) without "fetch = FetchType.EAGER"
	private List<Room> rooms;
	
	public Cinema() {}
}
