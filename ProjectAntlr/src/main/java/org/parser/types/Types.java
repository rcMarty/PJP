package org.parser.types;
import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public enum Types {
    STRING(""),
    INT(0),
    FLOAT(0.0),
    BOOL(false),
    ERROR(null);

    private final Object defaultValue;

}
