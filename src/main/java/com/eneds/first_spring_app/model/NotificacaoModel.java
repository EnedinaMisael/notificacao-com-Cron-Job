package com.eneds.first_spring_app.model;

import com.eneds.first_spring_app.enums.TipoAlerta;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_notificacao")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class NotificacaoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // gerar id sequencial
    private Long id;
    private String mensagem;
    private String tipoNotificacao;
    private Boolean flgLida;

    @ManyToOne
    @JoinColumn(name = "fatura_id", nullable = false) // chave estrangeira
    @JsonBackReference
    private FaturaModel fatura;

    @Enumerated(EnumType.STRING)
    private TipoAlerta tipoAlerta;


}



