package ru.sergsubin.documens.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "decision")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Decision {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "m_data_sq")
    @SequenceGenerator(name = "m_data_sq",sequenceName = "m_data_sq", allocationSize = 1)
    private Long id;

    @Column(name = "date_signature")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateSignature;

    @Column(name = "date_control")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateControl;

    @Column(name = "date_execution")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateExecution;

    @OneToOne
    @JoinTable(name = "document_decision", joinColumns = @JoinColumn(name = "id_decision"),
    inverseJoinColumns = @JoinColumn(name = "id_document"))
    private Document document;

    @OneToMany(mappedBy = "decision")
    private Set<Instruction> instruction;

}
