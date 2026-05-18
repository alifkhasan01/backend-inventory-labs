package com.inventorilab.dto.response;

import com.inventorilab.enums.KondisiBarang;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DetailPeminjamanResponse {
    private Long idDetail;
    private Long idBarang;
    private String namaBarang;
    private String kodeBarang;
    private Integer jumlah;
    private KondisiBarang kondisiKembali;
}
