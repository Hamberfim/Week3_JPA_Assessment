
package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="appliance_items")
public class ListItem {
	//Anthony Hamlin
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	@Column(name="MAKER")
	private String maker;
	@Column(name="MODEL")
	private String model;
	@Column(name="CATEGORY")
	private String category;
	
	public ListItem() {
		super();
	}
	
	public ListItem(String maker, String model, String category) {
		super();
		this.maker = maker;
		this.model = model;
		this.category = category;
	}

	//Setters/Getters
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getMaker() {
		return maker;
	}
	public void setMaker(String maker) {
		this.maker = maker;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	public String returnItemDetails() {
		return maker + ", " + model + " " + category;
	}
	
}
