package com.gilberto.rinhadebackend.models.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Max;
import java.math.BigInteger;

public record TransactionForm(
    @JsonProperty("valor")
    BigInteger value,
    @JsonProperty("tipo")
    String type,
    @JsonProperty("descricao")
    @Max(10)
    String description
) {

}
