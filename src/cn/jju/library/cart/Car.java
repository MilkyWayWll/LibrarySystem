package cn.jju.library.cart;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import cn.jju.library.entity.Item;


public class Car {
	private Map<Integer,CarItem> itemMap =
			new HashMap<Integer,CarItem>();
	
	public Map<Integer, CarItem> getItemMap() {
		return itemMap;
	}
	public void setItemMap(Map<Integer, CarItem> itemMap) {
		this.itemMap = itemMap;
	}
	//private Collection<CarItem>get
	
	public int getItemSize(){
		return itemMap.size();
	}
	public boolean containsItemId(String itemId){
		return itemMap.containsKey(itemId);
	}
	public void addItem(Item item,boolean isInStock){
		try{
		CarItem carItem = itemMap.get(item.getId());
		if(carItem ==null){
			item.setQuantity(1);
			carItem = new CarItem();
			carItem.setItem(item);
			carItem.setInStock(isInStock);
			itemMap.put(item.getId(), carItem);
			//items = itemMap.values();
			}else{
		carItem.incrementQuantity();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	//ɾ�����ﳵ��ָ��Item��item
	public Item removeItemById(int itemId){
		CarItem carItem = itemMap.remove(itemId);
		if(carItem == null){
			return null;
		}else{
			//items = itemMap.values();
			return carItem.getItem();
		}
	}
	//����itemId��ָ��item������1
	public void incrementQuantityByItemId(int itemId){
		CarItem carItem = itemMap.get(itemId);
		carItem.incrementQuantity();
	}
	//��������item��ֵ
	public void setQuantityByItemId(int itemId, int quantity){
		CarItem carItem = itemMap.get(itemId);
		carItem.getItem().setQuantity(quantity);
	}
	//���㹺�ﳵ����Ʒ
	public double getSubTotal(){
		double subTotal = 0;
		Iterator<CarItem> iterator = itemMap.values().iterator();
		while(iterator.hasNext()){
			CarItem carItem =  iterator.next();
			Item item = carItem.getItem();
			double price = item.getPrice();
			int quantity = item.getQuantity();
			subTotal += price * quantity;
		}
		return subTotal;
	}
	//��չ��ﳵ
	public void  clear(){
		itemMap.clear();
	}
}
