package shop.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the chitiethoadon database table.
 * 
 */
@Entity
@Table(name="chitiethoadon")
@NamedQuery(name="Chitiethoadon.findAll", query="SELECT c FROM Chitiethoadon c")
public class Chitiethoadon implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int mahoadon;

	private int tongtien;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="userName")
	private User user;

	//bi-directional many-to-one association to Hoadonsanpham
	@OneToMany(mappedBy="chitiethoadon")
	private List<Hoadonsanpham> hoadonsanphams;

	public Chitiethoadon() {
	}

	public int getMahoadon() {
		return this.mahoadon;
	}

	public void setMahoadon(int mahoadon) {
		this.mahoadon = mahoadon;
	}

	public int getTongtien() {
		return this.tongtien;
	}

	public void setTongtien(int tongtien) {
		this.tongtien = tongtien;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Hoadonsanpham> getHoadonsanphams() {
		return this.hoadonsanphams;
	}

	public void setHoadonsanphams(List<Hoadonsanpham> hoadonsanphams) {
		this.hoadonsanphams = hoadonsanphams;
	}

	public Hoadonsanpham addHoadonsanpham(Hoadonsanpham hoadonsanpham) {
		getHoadonsanphams().add(hoadonsanpham);
		hoadonsanpham.setChitiethoadon(this);

		return hoadonsanpham;
	}

	public Hoadonsanpham removeHoadonsanpham(Hoadonsanpham hoadonsanpham) {
		getHoadonsanphams().remove(hoadonsanpham);
		hoadonsanpham.setChitiethoadon(null);

		return hoadonsanpham;
	}

}