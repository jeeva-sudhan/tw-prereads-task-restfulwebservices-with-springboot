package com.tw.prereadstask.swiggycartsystem.model;

import javax.persistence.*;

@Entity
@Table(name = "usercart")
@IdClass(UserCartPK.class)
public class UserCart {
  @Id
  @OneToOne
  @JoinColumn(name = "user_id")
  private User user;

  @Id
  @OneToOne
  @JoinColumn(name = "cart_item_id")
  private CartItem cartItem;

  public UserCart(User user, CartItem cartItem) {
    this.user = user;
    this.cartItem = cartItem;
  }

  public UserCart() {}

  public User getUser() {
    return user;
  }

  public CartItem getCartItem() {
    return cartItem;
  }
}
