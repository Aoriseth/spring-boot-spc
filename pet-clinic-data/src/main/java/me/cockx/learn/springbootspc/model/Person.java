package me.cockx.learn.springbootspc.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Person extends BaseEntity {

    @Column(name = "first_name") // Automatically done by hibernate as well
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
}
