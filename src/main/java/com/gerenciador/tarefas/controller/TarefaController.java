package com.gerenciador.tarefas.controller;


import com.gerenciador.tarefas.model.Tarefa;
import com.gerenciador.tarefas.service.TarefaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController //Essa classe vai receber requisições HTTP
@RequestMapping("/tarefas") //Significa que tudo aqui dentro começa com: http://localhost:8080/tarefas
public class TarefaController {

    private final TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    //@RequestBody Diz que o JSON enviado será convertido automaticamente para um objeto Tarefa.
    @PostMapping //Essa anotação indica que esse método vai responder a requisições POST
    public Tarefa criar(@RequestBody Tarefa tarefa) {
        return tarefaService.salvar(tarefa);
    }

    @GetMapping
    public List<Tarefa> listar() {
        return tarefaService.listarTodas();
    }

    @GetMapping("/{id}")
    //Essa anotação indica que esse método vai responder a requisições GET com um ID na URL, tipo: http://localhost:8080/tarefas/1
    public ResponseEntity<Tarefa> buscarPorId(@PathVariable Long id) {

        Optional<Tarefa> tarefa = tarefaService.buscarPorId(id);

        if (tarefa.isPresent()) {
            return ResponseEntity.ok(tarefa.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<Tarefa> atualizar(
            @PathVariable Long id,
            @RequestBody Tarefa tarefa) {

        Optional<Tarefa> tarefaAtualizada = tarefaService.atualizar(id, tarefa);

        if (tarefaAtualizada.isPresent()) {
            return ResponseEntity.ok(tarefaAtualizada.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable long id) {
        
        boolean deletado = tarefaService.deletar(id);

        if (deletado) {
            return  ResponseEntity.ok().body(
                    java.util.Map.of("message", "Tarefa deletada com sucesso")
            );
        }else {
            return ResponseEntity.status(400).body(
                    java.util.Map.of("erro", "tarefa não encontrada")
            );
        }
    }





    }








