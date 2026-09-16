package org.skypro.model.article;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.skypro.model.search.Searchable;

import java.util.Objects;
import java.util.UUID;

public final class Article implements Searchable {
    private final String name;
    private final String text;
    private final UUID id;

    public Article(String name, String text, UUID id) {
        this.name = name;
        this.text = text;
        this.id = id;
    }

    @Override
    public String toString() {
        return name + "\n" + text;
    }

    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }

    public UUID getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (getClass() != o.getClass()) {
            return false;
        }
        if (!(o instanceof Article article)) return false;
        return Objects.equals(name, article.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    @JsonIgnore
    public String searchType() {
        return "ARTICLE";
    }

    @Override
    @JsonIgnore
    public String searchTerm() {
        return toString();
    }
}
