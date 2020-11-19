package ru.sergsubin.documens.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "role")
@Data
@NoArgsConstructor
public class Role implements Serializable {
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

    @ManyToMany(cascade = CascadeType.REFRESH,fetch = FetchType.LAZY)
    @JoinTable(name = "employee_role", joinColumns = @JoinColumn(name = "id_role"),
    inverseJoinColumns = @JoinColumn(name = "id_employee"))
    @JsonIgnore
    private Set<Employee> employees;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role role = (Role) o;

        if (!id.equals(role.id)) return false;
        if (!title.equals(role.title)) return false;
        if (!code.equals(role.code)) return false;
        return employees != null ? employees.equals(role.employees) : role.employees == null;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + title.hashCode();
        result = 31 * result + code.hashCode();
        return result;
    }
}
