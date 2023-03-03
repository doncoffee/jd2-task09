package by.academy.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Assignment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "assignment_id")
    @EqualsAndHashCode.Include
    private Integer id;
    @Column
    private Integer mark;
    @Column
    private String review;

}
