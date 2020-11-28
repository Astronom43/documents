package ru.sergsubin.documens.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "employee")
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

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "employee_role",
            joinColumns = @JoinColumn(name = "id_employee"),
            inverseJoinColumns = @JoinColumn(name = "id_role")
    )
   //   @JsonIgnore
    @JsonView(Views.IdBodyRef.class)
    private List<Role> roles;

    @OneToMany(mappedBy = "employee")
    @JsonIgnore
   // @JsonView(Views.IdBodyRef.class)
    private List<Instruction> instructions;

    @OneToMany(mappedBy = "employee")
    @JsonIgnore
   // @JsonView(Views.IdBodyRef.class)
    private List<Report> reports;

}
