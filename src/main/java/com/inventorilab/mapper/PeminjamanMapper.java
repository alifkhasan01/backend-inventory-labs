package com.inventorilab.mapper;

import com.inventorilab.dto.response.DetailPeminjamanResponse;
import com.inventorilab.dto.response.PeminjamanResponse;
import com.inventorilab.entity.DetailPeminjaman;
import com.inventorilab.entity.Peminjaman;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class PeminjamanMapper {

    public static PeminjamanResponse toResponse(Peminjaman peminjaman) {
        if (peminjaman == null) {
            return null;
        }

        List<DetailPeminjamanResponse> detailResponses = Collections.emptyList();
        if (peminjaman.getDetails() != null) {
            detailResponses = peminjaman.getDetails().stream()
                    .map(PeminjamanMapper::toDetailResponse)
                    .collect(Collectors.toList());
        }

        return PeminjamanResponse.builder()
                .idPeminjaman(peminjaman.getIdPeminjaman())
                .peminjam(UserMapper.toResponse(peminjaman.getPeminjam()))
                .petugas(UserMapper.toResponse(peminjaman.getPetugas()))
                .tglPinjam(peminjaman.getTglPinjam())
                .tglKembali(peminjaman.getTglKembali())
                .status(peminjaman.getStatus())
                .catatan(peminjaman.getCatatan())
                .details(detailResponses)
                .build();
    }

    public static DetailPeminjamanResponse toDetailResponse(DetailPeminjaman detail) {
        if (detail == null) {
            return null;
        }

        Long idBarang = null;
        String namaBarang = null;
        String kodeBarang = null;
        if (detail.getBarang() != null) {
            idBarang = detail.getBarang().getIdBarang();
            namaBarang = detail.getBarang().getNamaBarang();
            kodeBarang = detail.getBarang().getKodeBarang();
        }

        return DetailPeminjamanResponse.builder()
                .idDetail(detail.getIdDetail())
                .idBarang(idBarang)
                .namaBarang(namaBarang)
                .kodeBarang(kodeBarang)
                .jumlah(detail.getJumlah())
                .kondisiKembali(detail.getKondisiKembali())
                .build();
    }
}
