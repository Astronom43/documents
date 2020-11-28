package ru.sergsubin.documens.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "employee")
@Data
@NoArgsConstructor
public class Employee {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "m_data_seq")
    @SequenceGenerator(name = "m_data_seq", sequenceName = "m_data_sq", allocationSize = 1)
    @JsonView(Views.IdBody.class)
    private Long id;

    @Column(name = "login")
    @NonNull
    @JsonView(Views.IdBody.class)
    private String login;

    @Column(name = "password")
    @NonNull
  /*  @JsonView(Views.IdBody.class)*/
    private String password;

    @Column(name = "is_active")
    @JsonView(Views.IdBody.class)
    private Boolean isActive;

    @Column(name = "first_name")
    @NonNull
    @JsonView(Views.IdBody.class)
    private String firstName;

    @Column(name = "middle_name")
    @JsonView(Views.IdBody.class)
    private String middleName;

    @Column(name = "last_name")
    @NonNull
    @JsonView(Views.IdBody.class)
    private String lastName;

    @ManyToMany
    @JoinTable(name = "employee_role", joinColumns = @JoinColumn(name = "id_employee"),
            inverseJoinColumns = @JoinColumn(name = "id_role"))
  //  @JsonIgnore
    @JsonView(Views.IdBodyRef.class)
    private Set<Role> roles = new HashSet<>();

    @OneToMany(mappedBy = "employee")
    @JsonIgnore
    @JsonView(Views.IdBodyRef.class)
    private Set<Instruction> instructions = new HashSet<>();

    @OneToMany(mappedBy = "employee")
    @JsonIgnore
    @JsonView(Views.IdBodyRef.class)
    private Set<Report> reports = new HashSet<>();

}
