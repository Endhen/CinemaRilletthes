package bo.services;

import java.time.LocalDate;
import java.time.LocalTime;

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

import bo.cinemas.Room;

@Entity
@Table(name="session")
@NamedQueries({
	@NamedQuery(
			// findAll + this.class 
			name="findAllSession",
			query="SELECT s FROM Session s"),
	@NamedQuery(
			// find + this.class + ById 
			name="findSessionById",
			query="SELECT s FROM Session s WHERE s.id = :id")
})
public class Session {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne(
			cascade = CascadeType.ALL, 
			fetch = FetchType.EAGER,
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
	public Session(
			Movie movie, 
			Room room, 
			LocalDate screeningDate, 
			LocalTime screeningTime) {
		this.movie = movie;
		this.room = room;
		this.screeningDate = screeningDate;
		this.screeningTime = screeningTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public LocalDate getScreeningDate() {
		return screeningDate;
	}

	public void setScreeningDate(LocalDate screeningDate) {
		this.screeningDate = screeningDate;
	}

	public LocalTime getScreeningTime() {
		return screeningTime;
	}

	public void setScreeningTime(LocalTime screeningTime) {
		this.screeningTime = screeningTime;
	}
}
