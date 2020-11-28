package ru.sergsubin.documens.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "document")
public class Document {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "m_data_sq")
    @SequenceGenerator(name = "m_data_sq", sequenceName = "m_data_sq", allocationSize = 1)
    private Long id;

    @Column(name = "nom")
    private Long nom;

    @Column(name = "nom_s")
    private String nomS;

    @Column(name = "description")
    private String description;

    @ManyToOne(optional = false)
    @JoinColumn(name = "respondent_from")
    private Respondent respondentFrom;

    @ManyToOne(optional = false)
    @JoinColumn(name = "respondent_to")
    private Respondent respondentTo;

    @Column(name = "subj")
    private String subj;

    @Column(name = "body")
    @org.hibernate.annotations.Type(type = "text")
    private String body;

    @ManyToOne
    @JoinColumn(name = "id_type")
    private Type type;

    @OneToMany(mappedBy = "document")
    private Set<File> files;

    @OneToOne(optional = false)
    @JoinTable(
            name = "document_decision",
            joinColumns = @JoinColumn(name = "id_document"),
            inverseJoinColumns = @JoinColumn(name = "id_decision")
    )
    private Decision decision;
}
