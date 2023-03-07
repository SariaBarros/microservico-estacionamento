package com.ada.gerenciamento;

import lombok.Data;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

@Service
@Data
public class GerenciamentoService {
    private final GerenciamentoRepository gerenciamentoRepository;

    public void gerarTicket(Gerenciamento gerenciamento) {
        gerenciamentoRepository.save(gerenciamento);
    }
    public GerenciamentoResponse validarTicket(Long id){
        Gerenciamento gerenciamentoTicket = gerenciamentoRepository.findById(id).get();
        LocalTime horaChegada = gerenciamentoTicket.getHorarioEntrada();
        LocalTime horaSaida = LocalTime.now();
        Long tempoTotal = ChronoUnit.MINUTES.between(horaChegada, horaSaida);
        BigDecimal totalPagamento = BigDecimal.valueOf(tempoTotal * 4);
        GerenciamentoResponse gerenciamentoResponse = GerenciamentoResponse.builder()
                .id(gerenciamentoTicket.getId())
                .horarioEntrada(gerenciamentoTicket.getHorarioEntrada())
                .horarioSaida(horaSaida)
                .tipoDeVeiculo(gerenciamentoTicket.getTipoDeVeiculo())
                .placa(gerenciamentoTicket.getPlaca())
                .valor(totalPagamento)
                .build();
        return gerenciamentoResponse;
    }
}
