package com.eneds.first_spring_app.Controller;

import com.eneds.first_spring_app.enums.TipoAlerta;
import com.eneds.first_spring_app.model.NotificacaoModel;
import com.eneds.first_spring_app.Repository.NotificacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.eneds.first_spring_app.service.NotificacaoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/notificacoes")
public class NotificacaoController {

    @Autowired
    private NotificacaoRepository notificacaoRepository;

    // GET /notificacoes
    @GetMapping
    public List<NotificacaoModel> listarTodas() {
        return notificacaoRepository.findAll();
    }

    // POST /notificacoes
    @PostMapping
    public NotificacaoModel criar(@RequestBody NotificacaoModel notificacao) {
        return notificacaoRepository.save(notificacao);
    }

    @Autowired
    private NotificacaoService notificacaoService;

    @GetMapping("/gerar-automaticas")
    public void gerarNotificacoesAutomaticas() {
        notificacaoService.verificarFaturasVencendo();
    }
    @GetMapping("/nao-lidas")
    public List<NotificacaoModel> listarNaoLidas() {
        return notificacaoRepository.findByFlgLidaFalse();
    }
    @PatchMapping("/{id}/marcar-como-lida")
    public ResponseEntity<String> marcarComoLida(@PathVariable Long id) {
        Optional<NotificacaoModel> notOpt = notificacaoRepository.findById(id);

        if (notOpt.isPresent()) {
            NotificacaoModel notificacao = notOpt.get();
            notificacao.setFlgLida(true);
            notificacaoRepository.save(notificacao);
            return ResponseEntity.ok("Notificação marcada como lida!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Notificação não encontrada");
        }
    }
    @GetMapping("/tipo/{tipo}")
    public List<NotificacaoModel> buscarPorTipo(@PathVariable TipoAlerta tipo) {
        return notificacaoRepository.findByTipoAlerta(tipo);
    }
}
