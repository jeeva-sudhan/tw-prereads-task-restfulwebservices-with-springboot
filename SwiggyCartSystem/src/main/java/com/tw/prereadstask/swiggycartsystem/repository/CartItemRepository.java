package com.tw.prereadstask.swiggycartsystem.repository;

import com.tw.prereadstask.swiggycartsystem.model.CartItem;
import org.springframework.data.repository.CrudRepository;

public interface CartItemRepository extends CrudRepository<CartItem,Long> {
}
