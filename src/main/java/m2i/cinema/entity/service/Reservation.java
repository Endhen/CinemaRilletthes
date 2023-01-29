package m2i.cinema.entity.service;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import m2i.cinema.entity.GenericEntity;
import m2i.cinema.entity.cinema.Seat;
import m2i.cinema.entity.user.Client;

@Data @Entity
@AllArgsConstructor
@Table(name="reservations")
@EqualsAndHashCode(callSuper=false)
public class Reservation extends GenericEntity {

	@Column(name = "qr_code")
	private String qrCode;

	@OneToOne(
			cascade = CascadeType.ALL, 
			fetch = FetchType.LAZY, 
			optional = false)
	private Session session;

	@OneToOne(
			cascade = CascadeType.ALL, 
			fetch = FetchType.LAZY, 
			optional = false)
	private Seat seat;

	@Column(name = "creation_date")
	private LocalDateTime creationDate;

	@ManyToOne(
			cascade = CascadeType.ALL,
			fetch = FetchType.LAZY,
			optional = false)
	private Client client;
	
	public Reservation() {}
}

