package com.tw.prereadstask.swiggycartsystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="users")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @JsonIgnore
	private long id;

  @Column(name = "username")
  @JsonProperty
	private String userName;

  @Column(name = "mobile_number")
  @Pattern(regexp = "(^$|[0-9]{10})", message = "Phone number must have exactly 10 digits")
  @JsonProperty
	private String mobileNumber;

  @Column(name = "address")
  @JsonProperty
	private String address;

	public User() {}

	public User(long userId, String userName, String mobileNumber, String address) {
		super();
		this.id = userId;
		this.userName = userName;
		this.mobileNumber = mobileNumber;
		this.address = address;
	}


  public String getUserName() {
    return userName;
  }

  public @Pattern(regexp = "(^$|[0-9]{10})", message = "Phone number must have exactly 10 digits") String getMobileNumber() {
    return mobileNumber;
  }

  public String getAddress() {
    return address;
  }

  public long getId() {
    return id;
  }
}
