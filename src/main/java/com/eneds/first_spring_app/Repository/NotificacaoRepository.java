package com.eneds.first_spring_app.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eneds.first_spring_app.enums.TipoAlerta;
import com.eneds.first_spring_app.model.NotificacaoModel;

public interface NotificacaoRepository extends JpaRepository<NotificacaoModel, Long> {
    Optional<NotificacaoModel> findByFatura_IdAndFlgLidaFalse(Long fatura);

    // 🔍 Retorna todas as notificações que ainda não foram lidas
    List<NotificacaoModel> findByFlgLidaFalse();
    List<NotificacaoModel> findByTipoAlerta(TipoAlerta tipo);

}
