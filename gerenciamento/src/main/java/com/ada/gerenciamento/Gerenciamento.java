package com.ada.gerenciamento;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.text.DateFormat;
import java.time.LocalTime;

@Entity
@Data
public class Gerenciamento {
    @Id
    private Long id;
    private LocalTime horarioEntrada;
    private TipoDeVeiculo tipoDeVeiculo;
    private String placa;
}
