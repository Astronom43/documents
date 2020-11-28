package ru.sergsubin.documens.controller;

import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sergsubin.documens.entity.Instruction;
import ru.sergsubin.documens.service.InstructionService;

@RestController
@RequestMapping("api/instruction")

public class InstructionController extends AbstractController<Instruction, InstructionService>{

    protected InstructionController(InstructionService instructionService) {
        super(instructionService);
    }
}
