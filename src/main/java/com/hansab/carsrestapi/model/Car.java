package com.hansab.carsrestapi.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String make;
    private String model;
    private String numberplate;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
//    @JsonIgnore
    private User user;
}
