package ru.sergsubin.documens.entity;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "role")
public class Role implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "m_data_seq")
    @SequenceGenerator(name = "m_data_seq", sequenceName = "m_data_sq", allocationSize = 1)
    @JsonView(Views.IdBody.class)
    private Long id;

    @Column(name = "title")
    @NonNull
    @JsonView(Views.IdBody.class)
    private String title;

    @Column(name = "code")
    @NonNull
    @JsonView(Views.IdBody.class)
    private String code;

    @ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinTable(
            name = "employee_role",
            joinColumns = @JoinColumn(name = "id_role"),
            inverseJoinColumns = @JoinColumn(name = "id_employee")
    )
    /*@JsonView(Views.IdBodyRef.class)*/
    private Set<Employee> employees;
}
