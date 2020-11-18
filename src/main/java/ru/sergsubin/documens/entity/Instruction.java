package ru.sergsubin.documens.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

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
    private Long id;

    @Column(name = "instruction")
    private String instruction;

    @Column(name = "data_control")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataControl;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_decision")
    private Decision decision;

    @ManyToOne
    @JoinColumn(name = "id_employee")
    private Employee employee;

}
