package shop.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Cart implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<LineItem> items;

	public Cart() {
        items = new ArrayList<LineItem>();
    }

    public ArrayList<LineItem> getItems() {
        return items;
    }

    public int getCount() {
        return items.size();
    }
    
    public void addItem(LineItem item) {
        int code = item.getProduct().getMaSP();
        int quantity = item.getQuantity();
        for (int i = 0; i < items.size(); i++) {
            LineItem lineItem = items.get(i);
            if (lineItem.getProduct().getMaSP() == code) {
                lineItem.setQuantity(quantity);
                return;
            }
        }
        items.add(item);
    }

    public void removeItem(LineItem item) {
        int code = item.getProduct().getMaSP();
        for (int i = 0; i < items.size(); i++) {
            LineItem lineItem = items.get(i);
            if (lineItem.getProduct().getMaSP() == code) {
                items.remove(i);
                return;
            }
        }
    }
    public long totalMoney() {
    	long total = 0;
    	for (int i = 0; i < items.size(); i++) {
    		LineItem lineItem = items.get(i);
    		total += lineItem.getTotal();
    	}
    	return total;
    }
    @Override
    public String toString() {
		return "["+items+"]";
    	
    }
}
