package ru.sergsubin.documens.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "decision")
public class Decision {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "m_data_sq")
    @SequenceGenerator(name = "m_data_sq", sequenceName = "m_data_sq", allocationSize = 1)
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
    @JoinTable(
            name = "document_decision",
            joinColumns = @JoinColumn(name = "id_decision"),
            inverseJoinColumns = @JoinColumn(name = "id_document")
    )
    private Document document;

    @OneToMany(mappedBy = "decision")
    private Set<Instruction> instruction;

}
