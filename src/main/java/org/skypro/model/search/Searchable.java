package org.skypro.model.search;

import java.util.UUID;

public interface Searchable {
    String searchTerm();

    String searchType();

    String getName();

    default String getStringRepresentation() {
        return "Имя объекта: " + searchTerm() + " - Тип объекта: " + searchType();
    }

    default UUID getId() {
        return UUID.randomUUID();
    }

}
