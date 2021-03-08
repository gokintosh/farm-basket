package com.gokul.farmbasketbackend.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;


@Entity
@Data
@Table(name="users")
@NoArgsConstructor
public class User implements Serializable {

    private static final long serialVersionUID = -1567762702554171087L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NaturalId
    @NotEmpty
    private String email;
    

}
