package com.iorta.sboot.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PixabayImageDTO {

	@JsonProperty("totalHits")
	private int totalHits;

	@JsonProperty("hits")
	private List<ImageDetails> hits;

	public int getTotalHits() {
		return totalHits;
	}

	public void setTotalHits(int totalHits) {
		this.totalHits = totalHits;
	}

	public List<ImageDetails> getHits() {
		return hits;
	}

	public void setHits(List<ImageDetails> hits) {
		this.hits = hits;
	}


	public static class ImageDetails {
		@JsonProperty("id")
		private int id;

		@JsonProperty("pageURL")
		private String pageUrl;

		@JsonProperty("largeImageURL")
		private String imageUrl;

		@JsonProperty("tags")
		private String tags;

		@JsonProperty("user")
		private String photographer;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getPageUrl() {
			return pageUrl;
		}

		public void setPageUrl(String pageUrl) {
			this.pageUrl = pageUrl;
		}

		public String getImageUrl() {
			return imageUrl;
		}

		public void setImageUrl(String imageUrl) {
			this.imageUrl = imageUrl;
		}

		public String getTags() {
			return tags;
		}

		public void setTags(String tags) {
			this.tags = tags;
		}

		public String getPhotographer() {
			return photographer;
		}

		public void setPhotographer(String photographer) {
			this.photographer = photographer;
		}

	}


}
