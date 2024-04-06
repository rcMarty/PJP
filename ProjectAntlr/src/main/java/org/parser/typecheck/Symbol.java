package org.parser.typecheck;

import lombok.Data;
import org.parser.types.Types;

@Data
public class Symbol {
    private String name;
    private Types type;
    private Object value;

    public Symbol(String name, Types type) {
        this.name = name;
        this.type = type;
        this.value = type.getDefaultValue();
    }
    public void setName(String name) {
        this.name = name.trim();
    }

}
