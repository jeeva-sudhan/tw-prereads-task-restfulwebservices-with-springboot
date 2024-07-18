package com.tw.prereadstask.swiggycartsystem.model;

import javax.persistence.*;

@Entity
@Table(name="restaurant")
public class Restaurant {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

  @Column(name="name")
	private String name;

  @Column(name="description")
	private String description;

  @Column(name="address")
	private String address;

	public Restaurant() {}

	public Restaurant(String name, String restaurantDesc, String address) {
		super();
		this.name = name;
		this.description = restaurantDesc;
		this.address = address;
	}

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public String getAddress() {
    return address;
  }

  public long getId() {
    return id;
  }
}
