package ru.sergsubin.documens.repo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.sergsubin.documens.entity.Instruction;

@Repository
public interface InstructionRepo extends PagingAndSortingRepository<Instruction,Long> {
}
