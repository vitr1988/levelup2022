package ru.levelup.lesson10.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
public class GenreDto {
    @NotNull
    @Size(min = 1, max = 3)
    private String code;

    @NotNull
    @Size(min = 1, max = 120)
    private String name;

    public String getCodeStr() {
        return String.format("genre_%s", code);
    }
}
