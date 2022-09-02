package bo.cinemas;

import java.util.List;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="sections")
@NamedQueries({
	@NamedQuery(
			// findAll + this.class 
			name="findAllSection",
			query="SELECT s FROM Section s"),
	@NamedQuery(
			// find + this.class + ById 
			name="findSectionById",
			query="SELECT s FROM Section s WHERE s.id = :id")
})
public class Section {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	@Column(name = "group_name")
	private String name;
	@Column(name = "group_code")
	private String code;
	@Column(name = "pos_length")
	private int lengthPosition;
	@Column(name = "pos_width")
	private int widthPosition;
	@Column(name = "height")
	private int height;
	@Column(name = "width")
	private int width;
	
	@OneToMany(
			cascade = CascadeType.ALL, 
			fetch = FetchType.EAGER, 
			orphanRemoval = true)
	private List<Seat> seats;
	
	@ManyToOne(
			cascade = CascadeType.ALL,
			fetch = FetchType.LAZY, 
			optional = false)
	private Room room;
	
	public Section() {}
	public Section(
			String name, 
			String code, 
			int lengthPosition, 
			int widthPosition, 
			int height,
			int width,
			List<Seat> seats, 
			Room room) {
		this.name = name;
		this.code = code;
		this.lengthPosition = lengthPosition;
		this.widthPosition = widthPosition;
		this.height = height;
		this.width = width;
		this.seats = seats;
		this.room = room;
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
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public int getLengthPosition() {
		return lengthPosition;
	}
	public void setLengthPosition(int lengthPosition) {
		this.lengthPosition = lengthPosition;
	}
	public int getWidthPosition() {
		return widthPosition;
	}
	public void setWidthPosition(int widthPosition) {
		this.widthPosition = widthPosition;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public List<Seat> getSeats() {
		return seats;
	}
	public void setSeats(List<Seat> seats) {
		this.seats = seats;
	}
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
}
