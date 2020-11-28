package ru.sergsubin.documens.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "respondent")
public class Respondent {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "m_seq")
    @SequenceGenerator(name = "m_seq", sequenceName = "m_data_sq", allocationSize = 1)
    private Long id;

    @Column(name = "name")
    @NonNull
    private String name;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "phone_cod")
    private String phoneCod;

    @Column(name = "phone_nom")
    private String phoneNom;

    @Column(name = "e_mail")
    private String eMail;

    @Column(name = "post_index")
    private String postIndex;

    @Column(name = "region")
    private String region;

    @Column(name = "district")
    private String district;

    @Column(name = "town")
    private String town;

    @Column(name = "street")
    private String street;

    @Column(name = "house_nome")
    private String houseNome;

    @Column(name = "office")
    private String office;

    @OneToMany (mappedBy = "respondentFrom")
    private Set<Document> respFrom;

    @OneToMany(mappedBy = "respondentTo")
    private Set<Document> respTo;
}
