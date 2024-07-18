package com.tw.prereadstask.swiggycartsystem.repository;

import com.tw.prereadstask.swiggycartsystem.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {
  @Query(value = "SELECT * FROM users WHERE mobile_number= :mobileNumber",nativeQuery = true)
  Optional<User> findUserByMobileNumber(@Param("mobileNumber") String mobileNumber);
}
