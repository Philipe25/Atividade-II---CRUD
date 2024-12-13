package com.apin2.api_n2.Repository;

import com.apin2.api_n2.Model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
