package com.gilberto.rinhadebackend.models.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigInteger;
import java.time.LocalDateTime;

public record TransactionDTO(
    @JsonProperty("valor")
    BigInteger value,
    @JsonProperty("tipo")
    String type,
    @JsonProperty("descricao")
    String description,
    @JsonProperty("realizada_em")
    LocalDateTime realizedIn
) {

}
