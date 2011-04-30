// __BEGIN_LICENSE__
// Copyright (C) 2008-2010 United States Government as represented by
// the Administrator of the National Aeronautics and Space Administration.
// All Rights Reserved.
// __END_LICENSE__

package gov.nasa.arc.geocam.memo.bean;

//A comment to try to get this to commit

import java.util.Date;


/**
 * An android representation of a GeoCam Memo Message.
 */
public class GeoCamMemoMessage {

	/** The message id. */
	private Integer		messageId;
	
	/** The author id. */
	private Integer  	authorId;
	
	/** The author user name. */
	private String 		authorUsername;
	
	/** The author full name. */
	private String		authorFullname;
	
	/** The content. */
	private String 		content;
	
	/** The content timestamp. */
	private Long 		contentTimestamp;
	
	/** The latitude. */
	private Double 		latitude;
	
	/** The longitude. */
	private Double 		longitude;
	
	/** The accuracy. */
	private Integer 	accuracy;
	
	/** The has geolocation. */
	private Boolean		hasGeolocation;
	
	/**
	 * Gets the message id.
	 *
	 * @return the message id
	 */
	public int getMessageId() {
		return messageId;
	}
	
	/**
	 * Sets the message id.
	 *
	 * @param messageId the new message id
	 */
	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}
	
	/**
	 * Sets the author id.
	 *
	 * @param authorId the new author id
	 */
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	
	/**
	 * Gets the author id.
	 *
	 * @return the author id
	 */
	public Integer getAuthorId() {
		return authorId;
	}
	
	/**
	 * Gets the author username.
	 *
	 * @return the author username
	 */
	public String getAuthorUsername() {
		return authorUsername;
	}
	
	/**
	 * Sets the author username.
	 *
	 * @param authorUsername the new author username
	 */
	public void setAuthorUsername(String authorUsername) {
		this.authorUsername = authorUsername;
	}
	
	/**
	 * Gets the content.
	 *
	 * @return the content
	 */
	public String getContent() {
		return content;
	}
	
	/**
	 * Gets the author fullname.
	 *
	 * @return the author fullname
	 */
	public String getAuthorFullname() {
		return authorFullname;
	}
	
	/**
	 * Sets the author fullname.
	 *
	 * @param authorFullname the new author fullname
	 */
	public void setAuthorFullname(String authorFullname) {
		this.authorFullname = authorFullname;
	}
	
	/**
	 * Sets the content.
	 *
	 * @param content the new content
	 */
	public void setContent(String content) {
		this.content = content;
	}
	
	/**
	 * Gets the content timestamp.
	 *
	 * @return the content timestamp
	 */
	public Long getContentTimestamp() {
		return this.contentTimestamp;
	}
	
	/**
	 * Sets the content timestamp.
	 *
	 * @param contentTimestamp the new content timestamp
	 */
	public void setContentTimestamp(Long contentTimestamp) {
		this.contentTimestamp = contentTimestamp;
	}
	
	/**
	 * Gets the content timestamp date.
	 *
	 * @return the content timestamp date
	 */
	public Date getContentTimestampDate() {
		return new Date(this.contentTimestamp);
	}
	
	/**
	 * Sets the content timestamp.
	 *
	 * @param contentTimestamp the new content timestamp
	 */
	public void setContentTimestamp(Date contentTimestamp) {
		this.contentTimestamp = contentTimestamp.getTime();
	}
	
	/**
	 * Gets the latitude.
	 *
	 * @return the latitude
	 */
	public Double getLatitude() {
		return latitude;
	}
	
	/**
	 * Sets the latitude.
	 *
	 * @param latitude the new latitude
	 */
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	
	/**
	 * Gets the longitude.
	 *
	 * @return the longitude
	 */
	public Double getLongitude() {
		return longitude;
	}
	
	/**
	 * Sets the longitude.
	 *
	 * @param longitude the new longitude
	 */
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	/**
	 * Gets the accuracy.
	 *
	 * @return the accuracy
	 */
	public Integer getAccuracy() {
		return accuracy;
	}
	
	/**
	 * Sets the accuracy.
	 *
	 * @param accuracy the new accuracy
	 */
	public void setAccuracy(int accuracy) {
		this.accuracy = accuracy;
	}
	
	/**
	 * Checks for geolocation.
	 *
	 * @return true, if successful
	 */
	public boolean hasGeolocation() {
		return hasGeolocation;
	}
	
	/**
	 * Sets the checks for geolocation.
	 *
	 * @param hasGeolocation the new checks for geolocation
	 */
	public void setHasGeolocation(boolean hasGeolocation) {
		this.hasGeolocation = hasGeolocation;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object o) {
		GeoCamMemoMessage other = (GeoCamMemoMessage)o;
		
		return 
		equalOrBothNull(messageId, other.messageId) && 	
		equalOrBothNull(authorId, other.authorId) &&
		equalOrBothNull(authorUsername, other.authorUsername) &&
		equalOrBothNull(authorFullname, other.authorFullname) &&
		equalOrBothNull(content, other.content) &&
		equalOrBothNull(contentTimestamp, other.contentTimestamp) &&
		equalOrBothNull(latitude, other.latitude) &&
		equalOrBothNull(longitude, other.longitude) &&
		equalOrBothNull(accuracy, other.accuracy) &&
		equalOrBothNull(hasGeolocation, other.hasGeolocation);
	}
	
	// TODO: Revisit this if we need other helper methods. Maybe move to global helper function?
	// Jakarta Commons library may provide some additional methods that would be useful
	/**
	 * Equal or both null.
	 *
	 * @param a the a
	 * @param b the b
	 * @return true, if successful
	 */
	public static boolean equalOrBothNull(Object a, Object b)
	{
		if(a != null && b != null)
		{
			return a.equals(b);
		}
		else if(a == null && b == null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
}
