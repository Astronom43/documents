package ru.sergsubin.documens.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sergsubin.documens.entity.Instruction;
import ru.sergsubin.documens.service.InstructionService;

@Api(tags = "Контроллер по работе с инструкциями.")
@RestController
@RequestMapping("api/instruction")
public class InstructionController extends AbstractController<Instruction, InstructionService> {

    public InstructionController(InstructionService instructionService) {
        super(instructionService);
    }
}
