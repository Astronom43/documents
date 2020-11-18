package ru.sergsubin.documens.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "employee")
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode
public class Employee {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "m_data_seq")
    @SequenceGenerator(name = "m_data_seq",sequenceName = "m_data_sq", allocationSize = 1)
    private Long id;

    @Column(name = "login")
    @NonNull
    private String login;

    @Column(name = "password")
    @NonNull
    private String password;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "first_name")
    @NonNull
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "last_name")
    @NonNull
    private String lastName;

    @ManyToMany
    @JoinTable(name = "employee_role", joinColumns = @JoinColumn(name = "id_employee"),
    inverseJoinColumns = @JoinColumn(name = "id_role"))
    private Set<Role> roles;

    @OneToMany(mappedBy = "employee")
    private Set<Instruction> instructions;

    @OneToMany(mappedBy = "employee")
    private Set<Report> reports;

}
