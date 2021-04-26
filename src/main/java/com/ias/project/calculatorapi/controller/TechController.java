package com.ias.project.calculatorapi.controller;


import com.ias.project.calculatorapi.domain.Tech;
import com.ias.project.calculatorapi.model.*;
import com.ias.project.calculatorapi.repository.TechRepository;
import com.ias.project.calculatorapi.service.TechService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(TechController.RAIZ)
@CrossOrigin("http://localhost:4200")
public class TechController {

    /**
     * Cadena de texto raiz para acceder a RestController
     */
    public static final String RAIZ= "/tech";

    private final TechRepository repository;

    private final TechService service;

    public TechController(TechRepository repository, TechService service) {
        this.repository = repository;
        this.service = service;
    }

    @PostMapping
    public CreateTechOutput createTech(@RequestBody CreateTechInput input){
        return service.createTech(input);
    }

    @GetMapping("/list")
    public List<Tech> listTech(){
        return service.listTech();
    }

    @GetMapping("/list/{id}/{week}")
    public List<Tech> listFilterByIdAndWeek(@PathVariable String id, @PathVariable String week){
        return service.listTechFilterByIdAndWeek(id,week);
    }

    @DeleteMapping("/delete/{id}")
    public DeleteTechOutput deleteTech(@PathVariable("id") String id ){
        UUID techId = UUID.fromString(id);
        DeleteTechInput input = new DeleteTechInput(techId);
        return service.deleteTechOption(input);
    }
}
