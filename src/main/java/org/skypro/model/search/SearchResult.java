package org.skypro.model.search;

public final class SearchResult {
    private final String id;
    private final String name;
    private final String contentType;

    public SearchResult(String id, String name, String contentType) {
        this.id = id;
        this.name = name;
        this.contentType = contentType;
    }

    public static SearchResult fromSearchable(Searchable searchable) {
        String id = searchable.getId().toString();
        String name = searchable.getName();
        String contentType = searchable.getSearchType();
        return new SearchResult(id, name, contentType);
    }


}
