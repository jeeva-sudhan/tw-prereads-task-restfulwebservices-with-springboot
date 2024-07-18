package com.tw.prereadstask.swiggycartsystem.repository;

import com.tw.prereadstask.swiggycartsystem.model.UserCart;
import com.tw.prereadstask.swiggycartsystem.model.UserCartPK;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserCartRepository extends CrudRepository<UserCart, UserCartPK> {
  @Query(value = "SELECT * FROM usercart WHERE user_id = :userId",nativeQuery = true)
  Optional<List<UserCart>> fetchUserCart(@Param("userId") long userId);
}
