package m2i.cinema.bo.service;

import java.time.LocalDate;
import java.time.LocalTime;

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
import m2i.cinema.bo.cinema.Room;

@Data @Entity
@AllArgsConstructor
@Table(name="session")
@EqualsAndHashCode(callSuper=false)
public class Session extends GenericBean {

	@ManyToOne(
			cascade = CascadeType.ALL, 
			fetch = FetchType.LAZY, //EAGER
			optional = false)
	private Movie movie;

	@ManyToOne(
			cascade = CascadeType.ALL, 
			fetch = FetchType.LAZY,
			optional = false) 
	private Room room;

	@Column(name="screening_date")
	private LocalDate screeningDate;

	@Column(name="screening_time")
	private LocalTime screeningTime;
	
	public Session() {}
}
