package com.ada.gerenciamento;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalTime;

@Data
@Builder
public class GerenciamentoResponse {
    private Long id;
    private LocalTime horarioEntrada;
    private LocalTime horarioSaida;
    private TipoDeVeiculo tipoDeVeiculo;
    private String placa;
    private BigDecimal valor;
}
