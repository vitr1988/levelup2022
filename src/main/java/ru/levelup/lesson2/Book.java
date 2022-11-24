package ru.levelup.lesson2;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldNameConstants;

import java.math.BigDecimal;

@Getter
@Setter
@RequiredArgsConstructor
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@FieldNameConstants
public class Book {

//    private static final String ISBN = "isbn";

    private final String isbn;
    private final String name;
    private BigDecimal price;
}
