package shop.model;

import java.io.Serializable;



public class LineItem implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Sanpham sanpham;
	private int quantity;
	
	public LineItem() {}
	
	public void setProduct(Sanpham p) {
		this.sanpham = p;
	}
	
	public Sanpham getProduct() {
		return this.sanpham;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public int getQuantity() {
		return this.quantity;
	}
	
	public double getTotal() {
		double total = quantity * sanpham.getGiaSP();
		return total;
	}
	@Override
    public String toString() {
		return "["+sanpham.getMaSP()+"."+quantity+"]";
    }
}
