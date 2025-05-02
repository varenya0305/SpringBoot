package com.iorta.sboot.dto;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenLibraryBookDTO {
	
	@JsonProperty("title")
	private String title;

	@JsonProperty("authors")
	private List<Author> authors;

	@JsonProperty("publish_date")
	private String publishDate;

	@JsonProperty("cover")
	private Map<String, String> cover;

	public OpenLibraryBookDTO() {}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	public String getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}

	public Map<String, String> getCover() {
		return cover;
	}

	public void setCover(Map<String, String> cover) {
		this.cover = cover;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class Author {
		@JsonProperty("name")
		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}
}
