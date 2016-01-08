package com.akh.bean;


/**
 * @author csetty
 *
 */
public class LogoInformation {

	public String ImageId;
	public String imageName;
	public byte[] imageBlog;
	public String mimeType;
	public int width = 0;
	public int height = 0;
	private String imageInfo;
	public String getImageId() {
		return ImageId;
	}
	public void setImageId(String imageId) {
		ImageId = imageId;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public byte[] getImageBlog() {
		return imageBlog;
	}
	public void setImageBlog(byte[] imageBlog) {
		this.imageBlog = imageBlog;
	}
	public String getMimeType() {
		return mimeType;
	}
	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public String getImageInfo() {
		return imageInfo;
	}
	public void setImageInfo(String imageInfo) {
		this.imageInfo = imageInfo;
	}

}