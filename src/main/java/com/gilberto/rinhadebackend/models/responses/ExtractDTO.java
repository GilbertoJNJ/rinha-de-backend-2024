package com.gilberto.rinhadebackend.models.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public record ExtractDTO(
    @JsonProperty("saldo")
    BalanceDTO balance,
    @JsonProperty("ultimas_transacoes")
    List<TransactionDTO> lastTransactions
) {

}
