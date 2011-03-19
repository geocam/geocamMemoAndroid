package gov.nasa.arc.geocam.memo.bean;

import java.util.Date;

public class GeoCamMemoMessage {

	private int userId;
	private String authorName;
	private String content;
	private Date content_timestamp;
	private float latitude;
	private float longitude;
	private int accuracy;
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getUserId() {
		return userId;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getContent_timestamp() {
		return content_timestamp;
	}
	public void setContent_timestamp(Date content_timestamp) {
		this.content_timestamp = content_timestamp;
	}
	public float getLatitude() {
		return latitude;
	}
	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}
	public float getLongitude() {
		return longitude;
	}
	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}
	public int getAccuracy() {
		return accuracy;
	}
	public void setAccuracy(int accuracy) {
		this.accuracy = accuracy;
	}
}
