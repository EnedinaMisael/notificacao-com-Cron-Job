package com.eneds.first_spring_app.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.eneds.first_spring_app.Repository.FaturaRepository;
import com.eneds.first_spring_app.Repository.NotificacaoRepository;
import com.eneds.first_spring_app.enums.TipoAlerta;
import com.eneds.first_spring_app.model.FaturaModel;
import com.eneds.first_spring_app.model.NotificacaoModel;

@Service
public class NotificacaoService {

    @Autowired
    private FaturaRepository faturaRepository;

    @Autowired
    private NotificacaoRepository notificacaoRepository;

    // roda 1x por dia (exemplo: às 6h da manhã)
    @Scheduled(cron = "0 0 6 * * *")
    public void verificarFaturasVencendo() {
        List<FaturaModel> fatura = faturaRepository.findAll();
        LocalDate hoje = LocalDate.now();

        System.out.println("🔍 Data atual: " + hoje);
        System.out.println("🔍 Data limite (hoje + 25): " + hoje.plusDays(25));

        for (FaturaModel fat : fatura) {
            if (fat.getDataVencimento() != null) {
                long diasRestantes = java.time.temporal.ChronoUnit.DAYS.between(hoje, fat.getDataVencimento());

                if (diasRestantes <= 25 && diasRestantes >= 0) {
                    // 🔍 Aqui vai a verificação
                    Optional<NotificacaoModel> existente = notificacaoRepository
                            .findByFatura_IdAndFlgLidaFalse(fat.getId());

                    if (existente.isPresent()) {
                        System.out.println(" Já existe notificação para fatura id=" + fat.getId());
                        continue;
                    }

                    // Se chegou aqui, é porque ainda não existe
                    NotificacaoModel notificacao = new NotificacaoModel();
                    notificacao.setMensagem("Fatura vence em " + diasRestantes + " dia(s)");
                    notificacao.setTipoAlerta(TipoAlerta.INFORMATIVA);
                    notificacao.setTipoNotificacao("Fatura");
                    notificacao.setFlgLida(false);
                    notificacao.setFatura(fat);

                    notificacaoRepository.save(notificacao);
                }
            }
        }
    }

}
