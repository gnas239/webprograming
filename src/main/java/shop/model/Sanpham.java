package shop.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the sanpham database table.
 * 
 */
@Entity
@Table(name="sanpham")
@NamedQuery(name="Sanpham.findAll", query="SELECT s FROM Sanpham s")
public class Sanpham implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int maSP;

	private int giaSP;

	private String hinhSP;

	private String sizeSP;

	private int soluong;

	private String tenSP;

	//bi-directional many-to-one association to Hoadonsanpham
	@OneToMany(mappedBy="sanpham")
	private List<Hoadonsanpham> hoadonsanphams;

	public Sanpham() {
	}

	public int getMaSP() {
		return this.maSP;
	}

	public void setMaSP(int maSP) {
		this.maSP = maSP;
	}

	public int getGiaSP() {
		return this.giaSP;
	}

	public void setGiaSP(int giaSP) {
		this.giaSP = giaSP;
	}

	public String getHinhSP() {
		return this.hinhSP;
	}

	public void setHinhSP(String hinhSP) {
		this.hinhSP = hinhSP;
	}

	public String getSizeSP() {
		return this.sizeSP;
	}

	public void setSizeSP(String sizeSP) {
		this.sizeSP = sizeSP;
	}

	public int getSoluong() {
		return this.soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}

	public String getTenSP() {
		return this.tenSP;
	}

	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}

	public List<Hoadonsanpham> getHoadonsanphams() {
		return this.hoadonsanphams;
	}

	public void setHoadonsanphams(List<Hoadonsanpham> hoadonsanphams) {
		this.hoadonsanphams = hoadonsanphams;
	}

	public Hoadonsanpham addHoadonsanpham(Hoadonsanpham hoadonsanpham) {
		getHoadonsanphams().add(hoadonsanpham);
		hoadonsanpham.setSanpham(this);

		return hoadonsanpham;
	}

	public Hoadonsanpham removeHoadonsanpham(Hoadonsanpham hoadonsanpham) {
		getHoadonsanphams().remove(hoadonsanpham);
		hoadonsanpham.setSanpham(null);

		return hoadonsanpham;
	}

}