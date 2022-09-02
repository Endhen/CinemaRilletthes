package bo.services;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import bo.cinemas.Seat;
import bo.users.Client;

@Entity
@Table(name="reservations")
@NamedQueries({
	@NamedQuery(
			// findAll + this.class 
			name="findAllReservation",
			query="SELECT r FROM Reservation r"),
	@NamedQuery(
			// find + this.class + ById 
			name="findReservationById",
			query="SELECT r FROM Reservation r WHERE r.id = :id")
})
public class Reservation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
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
//	@ManyToOne(
//			cascade = CascadeType.ALL,
//			fetch = FetchType.LAZY,
//			optional = false)
//	private Client client;
	
	public Reservation() {}
	public Reservation(String qrCode, Session session, LocalDateTime creationDate, Client client) {
		this.qrCode = qrCode;
		this.session = session;
		this.creationDate = creationDate;
//		this.client = client;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQrCode() {
		return qrCode;
	}

	public void setQrCode(String qrCode) {
		this.qrCode = qrCode;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

//	public Client getClient() {
//		return client;
//	}
//
//	public void setClient(Client client) {
//		this.client = client;
//	}
}

