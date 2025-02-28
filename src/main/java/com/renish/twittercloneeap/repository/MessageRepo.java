package com.renish.twittercloneeap.repository;

import com.renish.twittercloneeap.model.Messages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepo extends JpaRepository<Messages, Integer> {

    @Query("SELECT m FROM Messages m WHERE m.producer.id IN " +
            "(SELECT s.producer.id FROM Subscriptions s WHERE s.subscriber.id = :subscriberId)")
    List<Messages> findMessagesBySubscriber(@Param("subscriberId") int subscriberId);
}
