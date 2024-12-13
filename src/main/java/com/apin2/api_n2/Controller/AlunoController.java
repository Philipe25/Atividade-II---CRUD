package com.apin2.api_n2.Controller;

import com.apin2.api_n2.Interface.IController;
import com.apin2.api_n2.Model.Aluno;
import com.apin2.api_n2.Service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/aluno")
public class AlunoController implements IController<Aluno, Long> {

    @Autowired
    private AlunoService alunoService;

    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @Override
    public Aluno create(@RequestBody Aluno entity) {
        return alunoService.create(entity);
    }

    @GetMapping(
            value = "{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @Override
    public Aluno get(@PathVariable Long id) {
        return alunoService.get(id);
    }

    @GetMapping(
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @Override
    public List<Aluno> get() {
        return alunoService.get();
    }

    @PutMapping(
            value = "{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @Override
    public Aluno update(@PathVariable Long id, @RequestBody Aluno entity) {
        return alunoService.update(id, entity);
    }

    @DeleteMapping(
            value = "{id}"
    )
    @Override
    public void delete(@PathVariable Long id) {
        alunoService.delete(id);
    }
}
