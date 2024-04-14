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
    ERROR(null),
    VOID(null);

    private final Object defaultValue;

}
