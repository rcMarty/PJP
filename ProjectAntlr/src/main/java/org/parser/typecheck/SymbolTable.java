package org.parser.typecheck;
import lombok.Data;

import java.util.HashMap;
import java.util.Optional;

@Data
public class SymbolTable {
    private HashMap<String, Symbol> table = new HashMap<>();

    public Optional<Boolean> addSymbol(Symbol symbol) {
        if (table.containsKey(symbol.getName()))
            return Optional.empty();

        table.put(symbol.getName(), symbol);
        return Optional.of(true);
    }

    public Optional<Symbol> getSymbol(String name) {
        if (!table.containsKey(name))
            return Optional.empty();

        return Optional.of(table.get(name));
    }
}
