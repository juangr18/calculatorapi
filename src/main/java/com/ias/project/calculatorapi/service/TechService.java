package com.ias.project.calculatorapi.service;

import com.ias.project.calculatorapi.domain.Tech;
import com.ias.project.calculatorapi.domain.TechHour;
import com.ias.project.calculatorapi.model.*;
import com.ias.project.calculatorapi.repository.TechRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class TechService {
    private final TechRepository repository;

    public TechService(TechRepository repository) {
        this.repository = repository;
    }

    public List<Tech> listTech() {
        return repository.listTech();
    }

    public List<TechHour> listTechFilterByIdAndWeek(String id, String week) {
        return repository.findTechByIdTechAndWeek(id, week);
    }

    public CreateTechOutput createTech(CreateTechInput input) {
        UUID id = UUID.randomUUID();
        Tech tech = new Tech(id,
                input.getIdTech(),
                input.getIdService(),
                input.getHoraInicial(),
                input.getHoraFinal()
        );
        repository.storeTech(tech);
        return new CreateTechOutput(tech);
    }

    public DeleteTechOutput deleteTechOption(DeleteTechInput input) {
        UUID techId = input.getTechID();
        Optional<Tech> techById = repository.findTechById(techId);
        if (techById.isPresent()) {
            Tech dbTech = techById.get();
            repository.deleteTech(dbTech.getId());
            return new DeleteTechOutput(dbTech);
        } else {
            throw new IllegalArgumentException("Registry: " + techId + " does not exist in db.");
        }
    }
}
