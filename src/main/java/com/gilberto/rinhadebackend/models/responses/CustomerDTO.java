package com.gilberto.rinhadebackend.models.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigInteger;

public record CustomerDTO(
    @JsonProperty("limite")
    BigInteger limit,
    @JsonProperty("saldo")
    BigInteger balance
) {

}
