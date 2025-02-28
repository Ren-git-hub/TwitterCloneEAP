package com.renish.twittercloneeap.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Subscriptions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "subscriber_id", referencedColumnName = "id")
    private Users subscriber;

    @ManyToOne
    @JoinColumn(name = "producer_id", referencedColumnName = "id")
    private Users producer;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Users getSubscriber() {
        return subscriber;
    }

    public void setSubscriber(Users subscriber) {
        this.subscriber = subscriber;
    }

    public Users getProducer() {
        return producer;
    }

    public void setProducer(Users producer) {
        this.producer = producer;
    }
}
