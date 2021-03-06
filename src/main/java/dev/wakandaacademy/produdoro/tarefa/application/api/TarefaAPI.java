package dev.wakandaacademy.produdoro.tarefa.application.api;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

@RequestMapping("/v1/tarefas")
public interface TarefaAPI {

    @PostMapping("/tarefa/{idTarefa}/ativacao")
    @ResponseStatus(code = HttpStatus.CREATED)
    void defineTarefaAtiva(@RequestParam UUID idUsuario, @PathVariable UUID idTarefa);

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    TarefaResponse adicionaTarefa(@RequestBody @Valid TarefaRequest tarefaRequest);

    @DeleteMapping("/{idTarefa}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void deletaTarefa(@PathVariable UUID idTarefa);

	@GetMapping("/find-by-tarefa/{idTarefa}")
	@ResponseStatus(code = HttpStatus.OK)
	TarefaResponse detalhaTarefa(@PathVariable UUID idTarefa);

    @GetMapping("/find-by-usuario/{idUsuario}")
    @ResponseStatus(code = HttpStatus.OK)
    List<TarefaDTO> listaTarefasPorIdUsuario(@PathVariable UUID idUsuario);
}