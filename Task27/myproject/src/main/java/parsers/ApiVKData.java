package parsers;

public class ApiVKData {
	private String accessToken;
	private String ownerId;
	private String version;
	private String newMessage;
	private String editMessage;
	private String uriBuilderPost;
	private String uriBuilderEdit;
	private String uriBuilderDelete;
	private String photoId;

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getNewMessage() {
		return newMessage;
	}

	public void setNewMessage(String newMessage) {
		this.newMessage = newMessage;
	}

	public String getEditMessage() {
		return editMessage;
	}

	public void setEditMessage(String editMessage) {
		this.editMessage = editMessage;
	}

	public String getUriBuilderPost() {
		return uriBuilderPost;
	}

	public void setUriBuilderPost(String uriBuilderPost) {
		this.uriBuilderPost = uriBuilderPost;
	}

	public String getUriBuilderEdit() {
		return uriBuilderEdit;
	}

	public void setUriBuilderEdit(String uriBuilderEdit) {
		this.uriBuilderEdit = uriBuilderEdit;
	}

	public String getUriBuilderDelete() {
		return uriBuilderDelete;
	}

	public void setUriBuilderDelete(String uriBuilderDelete) {
		this.uriBuilderDelete = uriBuilderDelete;
	}

	public String getPhotoId() {
		return photoId;
	}

	public void setPhotoId(String photoId) {
		this.photoId = photoId;
	}

	public static class Builder {
		private ApiVKData newApiVKData;

		public Builder() {
			newApiVKData = new ApiVKData();
		}

		public Builder withAccessToken(String accessToken) {
			newApiVKData.accessToken = accessToken;
			return this;
		}

		public Builder withOwnerId(String ownerId) {
			newApiVKData.ownerId = ownerId;
			return this;
		}

		public Builder withVersion(String version) {
			newApiVKData.version = version;
			return this;
		}

		public Builder withNewMessage(String newMessage) {
			newApiVKData.newMessage = newMessage;
			return this;
		}

		public Builder withEditMessage(String editMessage) {
			newApiVKData.editMessage = editMessage;
			return this;
		}

		public Builder withUriBuilderPost(String uriBuilderPost) {
			newApiVKData.uriBuilderPost = uriBuilderPost;
			return this;
		}

		public Builder withUriBuilderEdit(String uriBuilderEdit) {
			newApiVKData.uriBuilderEdit = uriBuilderEdit;
			return this;
		}

		public Builder withUriBuilderDelete(String uriBuilderDelete) {
			newApiVKData.uriBuilderDelete = uriBuilderDelete;
			return this;
		}

		public Builder withPhotoId(String photoId) {
			newApiVKData.photoId = photoId;
			return this;
		}

		public ApiVKData build() {
			return newApiVKData;
		}
	}

	@Override
	public String toString() {
		return "ApiVKData::\n accessToken=" + this.accessToken + "\n ownerId=" + this.ownerId + "\n version="
				+ this.version + "\n newMessage=" + this.newMessage + "\n editMessage=" + this.editMessage
				+ "\n uriBuilderPost=" + this.uriBuilderPost + "\n uriBuilderEdit=" + this.uriBuilderEdit
				+ "\n uriBuilderDelete=" + this.uriBuilderDelete + "\n photoId=" + this.photoId;
	}
}
