package org.skypro.model.search;

import java.util.UUID;

public interface Searchable {
    String getSearchTerm();

    String getSearchType();

    String getName();

    UUID getId();

    default String getStringRepresentation() {
        return "Имя объекта: " + getSearchTerm() + " - Тип объекта: " + getSearchType();
    }

}
