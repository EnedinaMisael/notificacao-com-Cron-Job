package com.eneds.first_spring_app.Controller;

import com.eneds.first_spring_app.model.FaturaModel;
import com.eneds.first_spring_app.Repository.FaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fatura")
public class FaturaController {

    @Autowired
    private FaturaRepository faturaRepository;

    // GET /fatura
    @GetMapping
    public List<FaturaModel> listarTodos() {
        return faturaRepository.findAll();
    }

    // POST /certificados
    @PostMapping
    public FaturaModel criar(@RequestBody FaturaModel fatura) {
        return faturaRepository.save(fatura);
    }
}
