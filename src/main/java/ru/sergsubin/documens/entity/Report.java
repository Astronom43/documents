package ru.sergsubin.documens.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "report")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Report {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "m_data_sq")
    @SequenceGenerator(name = "m_data_sq",sequenceName = "m_data_sq",allocationSize = 1)
    private Long id;

    @Column(name = "date_signature")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateSignature;

    @Column(name = "date_execution")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateExecution;

    @ManyToOne
    @JoinColumn(name = "id_employee")
    private Employee employee;

}
