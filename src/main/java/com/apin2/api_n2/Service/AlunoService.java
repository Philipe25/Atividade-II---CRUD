package com.apin2.api_n2.Service;

import com.apin2.api_n2.Interface.IService;
import com.apin2.api_n2.Model.Aluno;
import com.apin2.api_n2.Repository.AlunoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class AlunoService implements IService<Aluno, Long> {

    @Autowired
    private AlunoRepository alunoRepository;

    @Override
    public Aluno create(Aluno entity) {
        return alunoRepository.save(entity);
    }

    @Override
    public Aluno get(Long id) {

        Optional<Aluno> alunoEncontrado = alunoRepository.findById(id);
        if(alunoEncontrado.isPresent()){
            return alunoEncontrado.get();
        } else {
            return new Aluno();
        }
    }

    @Override
    public List<Aluno> get() {
        return alunoRepository.findAll();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Aluno update(Long id, Aluno entity) {

        Aluno alunoEncontrado = alunoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno não encontrado!"));
        entity.setId(id);

        return alunoRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        alunoRepository.deleteById(id);
    }
}
