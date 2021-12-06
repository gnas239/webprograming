package shop.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the hoadonsanpham database table.
 * 
 */
@Entity
@Table(name="hoadonsanpham")
@NamedQuery(name="Hoadonsanpham.findAll", query="SELECT h FROM Hoadonsanpham h")
public class Hoadonsanpham implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private int soluong;

	//bi-directional many-to-one association to Chitiethoadon
	@ManyToOne
	@JoinColumn(name="mahoadon")
	private Chitiethoadon chitiethoadon;

	//bi-directional many-to-one association to Sanpham
	@ManyToOne
	@JoinColumn(name="maSP")
	private Sanpham sanpham;

	public Hoadonsanpham() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSoluong() {
		return this.soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}

	public Chitiethoadon getChitiethoadon() {
		return this.chitiethoadon;
	}

	public void setChitiethoadon(Chitiethoadon chitiethoadon) {
		this.chitiethoadon = chitiethoadon;
	}

	public Sanpham getSanpham() {
		return this.sanpham;
	}

	public void setSanpham(Sanpham sanpham) {
		this.sanpham = sanpham;
	}

}