package com.tw.prereadstask.swiggycartsystem.model;

import javax.persistence.*;

@Entity
@Table(name="fooditem")
public class FoodItem {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

  @Column(name = "name")
	private String name;

	public FoodItem() {}

	public FoodItem(long foodItemId, String name) {
		super();
		this.id = foodItemId;
		this.name = name;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
