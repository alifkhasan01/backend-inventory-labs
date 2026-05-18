package com.inventorilab.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "kategori")
public class Kategori {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_kategori")
    private Long idKategori;

    @Column(name = "nama_kategori", nullable = false)
    private String namaKategori;

    @Column(columnDefinition = "TEXT")
    private String deskripsi;
}
