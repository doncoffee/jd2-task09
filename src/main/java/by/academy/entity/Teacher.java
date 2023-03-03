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
public class Teacher implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teacher_id")
    @EqualsAndHashCode.Include
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "administrator_id")
    private Administrator administrator;

}
