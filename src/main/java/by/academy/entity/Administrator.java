package by.academy.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Administrator implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "administrator_id")
    @EqualsAndHashCode.Include
    private Integer id;
    @OneToMany(mappedBy = "administrator")
    private Set<Course> courses = new HashSet<>();
    @OneToMany(mappedBy = "administrator")
    private Set<Teacher> teachers = new HashSet<>();

}
