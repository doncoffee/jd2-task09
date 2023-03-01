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
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    @EqualsAndHashCode.Include
    private Integer id;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "student_course",
            joinColumns = {@JoinColumn(name = "student_id")},
            inverseJoinColumns = {@JoinColumn(name = "course_id")})
    private Set<Course> courses = new HashSet<>();
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "student_assignment",
            joinColumns = {@JoinColumn(name = "student_id")},
            inverseJoinColumns = {@JoinColumn(name = "assignment_id")})
    private Set<Assignment> assignments = new HashSet<>();

}
