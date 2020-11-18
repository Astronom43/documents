package ru.sergsubin.documens.entity;

import lombok.NonNull;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "role")
public class Role {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "m_data_seq")
    @SequenceGenerator(name = "m_data_seq",sequenceName = "m_data_sq", allocationSize = 1)
    private Long id;

    @Column(name = "title")
    @NonNull
    private String title;

    @Column(name = "code")
    @NonNull
    private String code;

    @ManyToMany(cascade = CascadeType.REFRESH)
    @JoinTable(name = "employee_role", joinColumns = @JoinColumn(name = "id_role"),
    inverseJoinColumns = @JoinColumn(name = "id_employee"))
    private Set<Employee> employees;
}
