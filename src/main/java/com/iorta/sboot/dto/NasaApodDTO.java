package com.iorta.sboot.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NasaApodDTO {

	private String title;
    private String explanation;

    @JsonProperty("url")
    private String imageUrl;

    @JsonProperty("hdurl")
    private String hdImageUrl;  // New field to store high-resolution image

    public NasaApodDTO(String title, String explanation, String imageUrl, String hdImageUrl) {
        this.title = title;
        this.explanation = explanation;
        this.imageUrl = imageUrl;
        this.hdImageUrl = hdImageUrl;
    }

    public NasaApodDTO() {}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public String getImageUrl() {
        return imageUrl != null ? imageUrl : hdImageUrl; // Prefer HD if available
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getHdImageUrl() {
        return hdImageUrl;
    }

    public void setHdImageUrl(String hdImageUrl) {
        this.hdImageUrl = hdImageUrl;
    }
}
