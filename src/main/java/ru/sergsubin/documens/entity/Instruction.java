package ru.sergsubin.documens.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "instruction")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Instruction {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "m_date_seq")
    @SequenceGenerator(name = "m_data_seq",sequenceName = "m_data_sq",allocationSize = 1)
    @JsonView(Views.IdBody.class)
    private Long id;

    @Column(name = "instruction")
    @JsonView(Views.IdBody.class)
    @org.hibernate.annotations.Type(type = "text")
    private String instruction;

    @Column(name = "data_control")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonView(Views.IdBody.class)
    private Date dataControl;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_decision")
    @JsonView(Views.IdBody.class)
    private Decision decision;

    @ManyToOne
    @JoinColumn(name = "id_employee")
    @JsonView(Views.IdBody.class)
    private Employee employee;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id", updatable = false, insertable = false)
    @JsonIgnore
    private Instruction owner;

    @OneToMany (mappedBy = "owner")
    @JsonView(Views.IdBodyRef.class)
    private Set<Instruction> instructions;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Instruction that = (Instruction) o;

        if (!id.equals(that.id)) return false;
        if (instruction != null ? !instruction.equals(that.instruction) : that.instruction != null) return false;
        if (dataControl != null ? !dataControl.equals(that.dataControl) : that.dataControl != null) return false;
        if (decision != null ? !decision.equals(that.decision) : that.decision != null) return false;
        if (employee != null ? !employee.equals(that.employee) : that.employee != null) return false;
        if (owner != null ? !owner.equals(that.owner) : that.owner != null) return false;
        return instructions != null ? instructions.equals(that.instructions) : that.instructions == null;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (instruction != null ? instruction.hashCode() : 0);
        result = 31 * result + (dataControl != null ? dataControl.hashCode() : 0);
        result = 31 * result + (decision != null ? decision.hashCode() : 0);
        result = 31 * result + (employee != null ? employee.hashCode() : 0);
        return result;
    }
}
