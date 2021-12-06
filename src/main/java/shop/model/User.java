package shop.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@Table(name="user")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String userName;

	private String diachi;

	private String hoten;

	private byte isAdmin;

	private String password;

	private String sdt;

	//bi-directional many-to-one association to Chitiethoadon
	@OneToMany(mappedBy="user")
	private List<Chitiethoadon> chitiethoadons;

	public User() {
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getDiachi() {
		return this.diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public String getHoten() {
		return this.hoten;
	}

	public void setHoten(String hoten) {
		this.hoten = hoten;
	}

	public byte getIsAdmin() {
		return this.isAdmin;
	}

	public void setIsAdmin(byte isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSdt() {
		return this.sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public List<Chitiethoadon> getChitiethoadons() {
		return this.chitiethoadons;
	}

	public void setChitiethoadons(List<Chitiethoadon> chitiethoadons) {
		this.chitiethoadons = chitiethoadons;
	}

	public Chitiethoadon addChitiethoadon(Chitiethoadon chitiethoadon) {
		getChitiethoadons().add(chitiethoadon);
		chitiethoadon.setUser(this);

		return chitiethoadon;
	}

	public Chitiethoadon removeChitiethoadon(Chitiethoadon chitiethoadon) {
		getChitiethoadons().remove(chitiethoadon);
		chitiethoadon.setUser(null);

		return chitiethoadon;
	}

}