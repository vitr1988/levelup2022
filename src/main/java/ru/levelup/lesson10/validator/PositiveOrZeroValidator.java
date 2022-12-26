package ru.levelup.lesson10.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PositiveOrZeroValidator implements ConstraintValidator<PositiveOrZero, Integer> {

    private PositiveOrZero annotation;

    @Override
    public void initialize(PositiveOrZero annotation) {
        this.annotation = annotation;
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        final int i = this.annotation.originValue();
        if (value < 0) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Возникла ошибка проверки значения")
                    .addPropertyNode(annotation.property())
                    .addConstraintViolation();
            return false;
        }
        return true;
    }
}
