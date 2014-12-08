/**
 * 
 */
package com.webcontext.apps.gk2.restservice.model;

import java.io.Serializable;
import java.util.Date;

/**
 * A game sample.
 * 
 * @author Frederic Delorme<frederic.delorme@web-context.com
 *
 */
public class Game implements Serializable {
	/**
	 * Unique serial ID to perform serialization
	 */
	private static final long serialVersionUID = -404845487631522324L;
	private String title;
	private String tags;
	private String[] platforms;
	private String header;
	private String content;
	private Date createdAt;
	private String status;

	public Game() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param title
	 * @param header
	 * @param content
	 * @param createdAt
	 * @param status
	 */
	public Game(String title, String tags, String[] platforms, String header,
			String content, Date createdAt, String status) {
		super();
		this.title = title;
		this.tags = tags;
		this.platforms = platforms;
		this.header = header;
		this.content = content;
		this.createdAt = createdAt;
		this.status = status;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Game [title=").append(title).append(", header=")
				.append(header).append(", tags=").append(tags)
				.append(", platforms=").append(platforms).append(", content=")
				.append(content).append(", createdAt=").append(createdAt)
				.append(", status=").append(status).append("]");
		return builder.toString();
	}

}
