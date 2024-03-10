package com.gilberto.rinhadebackend.models.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigInteger;
import java.time.LocalDateTime;

public record BalanceDTO(
    BigInteger total,
    @JsonProperty("data_extrato")
    LocalDateTime balanceDate,
    @JsonProperty("limite")
    BigInteger limit
) {

}
