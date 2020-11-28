package ru.sergsubin.documens.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "instruction")
public class Instruction {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "m_date_seq")
    @SequenceGenerator(name = "m_data_seq", sequenceName = "m_data_sq", allocationSize = 1)
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

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_owner")
    @JsonView(Views.IdBodyRef.class)
    private List<Instruction> instructions;
}
