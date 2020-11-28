package ru.sergsubin.documens.service;

import org.springframework.stereotype.Service;
import ru.sergsubin.documens.entity.Instruction;
import ru.sergsubin.documens.repo.InstructionRepo;

@Service
public class InstructionService extends AbstractService<Instruction, InstructionRepo> {

    protected InstructionService(InstructionRepo repo) {
        super(repo);
    }

}
