package com.renish.twittercloneeap.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Messages {
    @Id
    private int id;
    private String title;
    private String content;

    @OneToOne
    @JoinColumn(name = "producer_id", referencedColumnName = "id")
    private Users producer;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Users getProducer() {
        return producer;
    }

    public void setProducer(Users producer) {
        this.producer = producer;
    }
}
