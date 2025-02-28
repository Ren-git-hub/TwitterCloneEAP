package com.renish.twittercloneeap.repository;

import com.renish.twittercloneeap.model.Subscriptions;
import com.renish.twittercloneeap.model.Users;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SubscriptionRepo extends CrudRepository<Subscriptions, Integer> {

    @Query("SELECT s.subscriber FROM Subscriptions s WHERE s.producer.id = :producerId")
    List<Users> findSubscribersByProducer(@Param("producerId") int producerId);

}
