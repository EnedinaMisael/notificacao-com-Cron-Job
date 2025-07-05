package com.eneds.first_spring_app.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "tbl_fatura")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FaturaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dataVencimento;

    @OneToMany(mappedBy = "fatura")
    @JsonManagedReference // OU @JsonIgnore???
    private List<NotificacaoModel> notificacao;
}
