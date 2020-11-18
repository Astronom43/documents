package ru.sergsubin.documens.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

@Entity
@Table(name = "type")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Type {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "m_data_seq")
    @SequenceGenerator(name = "m_data_seq", sequenceName = "m_data_seq", allocationSize = 1)
    private Long id;

    @Column(name = "name_type")
    @NonNull
    private String nameType;

    @Column(name = "kod_type")
    @NonNull
    private String kodType;

}
