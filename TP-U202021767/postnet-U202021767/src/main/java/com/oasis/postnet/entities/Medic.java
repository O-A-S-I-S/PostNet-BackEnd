package com.oasis.postnet.entities;


import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

//notation to auto-generate gets and sets
//creates equals -> used to avoid duplicates in lists
@Data
//entity persistence -> will be created in db
@Entity
//indicate name -> table name must be plural
@Table(name = "medics")
@PrimaryKeyJoinColumn(name = "person_id")
public class Medic extends Person{
    @Column(name = "specialty", nullable = false, length = 20)
    private String specialty;

}
