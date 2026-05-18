package com.inventorilab.dto.request;

import com.inventorilab.enums.KondisiBarang;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BarangRequest {

    @NotNull(message = "ID Kategori tidak boleh kosong!")
    private Long idKategori;

    @NotBlank(message = "Nama barang tidak boleh kosong!")
    private String namaBarang;

    @NotBlank(message = "Kode barang tidak boleh kosong!")
    private String kodeBarang;

    @NotNull(message = "Jumlah total tidak boleh kosong!")
    @Min(value = 1, message = "Jumlah total minimal adalah 1!")
    private Integer jumlahTotal;

    @NotNull(message = "Kondisi barang tidak boleh kosong!")
    private KondisiBarang kondisi;

    @NotBlank(message = "Lokasi barang tidak boleh kosong!")
    private String lokasi;
}
