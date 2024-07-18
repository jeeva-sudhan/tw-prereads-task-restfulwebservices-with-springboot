package com.tw.prereadstask.swiggycartsystem.model;

import java.io.Serializable;

public class UserCartPK implements Serializable {
  private Long user;
  private Long cartItem;

  public UserCartPK(Long user, Long cartItem) {
    this.user = user;
    this.cartItem = cartItem;
  }

  public UserCartPK() {}
}
