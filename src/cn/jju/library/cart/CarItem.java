package cn.jju.library.cart;

import cn.jju.library.entity.Item;

public class CarItem {
	private Item item;
	private boolean inStock;
	private double total;
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public boolean isInStock() {
		return inStock;
	}
	public void setInStock(boolean inStock) {
		this.inStock = inStock;
	}
	public double getTotal() {
		calculateTotal();
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
	//计算总价
	private void calculateTotal(){
		if(item !=null){
			total = item.getPrice() * item.getQuantity();
		}else{
			total = 0;
		}
	}
	public void incrementQuantity(){
		item.setQuantity(item.getQuantity()+1);
		calculateTotal();
		}
	@Override
	public String toString() {
		return "CarItem [item=" + item + ", inStock=" + inStock + ", total=" + total + "]";
	}
	
}
