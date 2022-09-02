package bo.cinemas;

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
@Table(name="seats")
@NamedQueries({
	@NamedQuery(
			// findAll + this.class 
			name="findAllSeat",
			query="SELECT s FROM Seat s"),
	@NamedQuery(
			// find + this.class + ById 
			name="findSeatById",
			query="SELECT s FROM Seat s WHERE s.id = :id")
})
public class Seat {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "col_placement")
	private int columnPlacement;
	@Column(name = "row_placement")
	private char rowPlacement;
	@Column(name = "pmr")
	private boolean PMR;
	@ManyToOne(
			cascade = CascadeType.ALL, 
			fetch = FetchType.LAZY,
			optional = false)
	private Section group;
	
	public Seat() {}
	public Seat(int columnPlacement, char rowPlacement, boolean pMR, Section group) {
        this.columnPlacement = columnPlacement;
		this.rowPlacement = rowPlacement;
		this.PMR = pMR;
		this.group = group;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getColumnPlacement() {
		return columnPlacement;
	}

	public void setColumnPlacement(int columnPlacement) {
		this.columnPlacement = columnPlacement;
	}

	public char getRowPlacement() {
		return rowPlacement;
	}

	public void setRowPlacement(char rowPlacement) {
		this.rowPlacement = rowPlacement;
	}

	public boolean isPMR() {
		return PMR;
	}

	public void setPMR(boolean pMR) {
		PMR = pMR;
	}

	public Section getGroup() {
		return group;
	}

	public void setGroup(Section group) {
		this.group = group;
	}
}
