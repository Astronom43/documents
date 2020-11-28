package ru.sergsubin.documens.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "file")
public class File {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "m_data_sq")
    @SequenceGenerator(name = "m_data_sq",sequenceName = "m_data_sq",allocationSize = 1)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "url")
    private String url;

    @ManyToOne
    @JoinColumn( name = "id_document")
    private Document document;
}
