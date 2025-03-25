package com.renish.twittercloneeap.repository;

import com.renish.twittercloneeap.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepo extends JpaRepository<Users, Integer> {
    @Query("SELECT u FROM Users u WHERE u.is_producer = :isProducer")
    List<Users> findUsersByIs_producer(@Param("isProducer") boolean isProducer);

    @Query("SELECT u FROM Users u WHERE u.is_subscriber=:isSubscriber")
    List<Users> findUsersByIs_subscriber(@Param("isSubscriber") boolean isSubscriber);


    Users findUsersByUsername(String username);
}
