package ru.levelup.lesson10.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Data
@Accessors(chain = true)
public class AccountDto {

    @Min(0)
    @Max(Long.MAX_VALUE)
    private Long id;

    @NotBlank
    @JsonProperty("account_number")
    private String accountNumber;

    @NotNull
    private BigDecimal balance;

    @NotBlank
    private String owner;
}
