package ru.sergsubin.documens.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "document")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Document {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "m_data_sq")
    @SequenceGenerator(name = "m_data_sq",sequenceName = "m_data_sq",allocationSize = 1)
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

    @OneToMany (mappedBy = "document")
    private Set<File> files;

    @OneToOne(optional = false)
    @JoinTable(name = "document_decision",joinColumns = @JoinColumn(name = "id_document"),
    inverseJoinColumns = @JoinColumn(name = "id_decision"))
    private Decision decision;




}
