package com.skyscanner;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SearchResult {
    @JsonProperty
    private String title;

    @JsonProperty
    private String city;

    @JsonProperty
    private String kind;

    public SearchResult() {
        // Required for Jackson
    }

    public SearchResult(String title, String city, String kind) {
        this.title = title;
        this.city = city;
        this.kind = kind;
    }

    public String getTitle() {
        return title;
    }

    public String getCity() {
        return city;
    }

    public String getKind() {
        return kind;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }
}
