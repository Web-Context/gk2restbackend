/**
 * 
 */
package com.webcontext.apps.gk2.restservice.model;

import java.net.URL;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.webcontext.apps.gk2.restservice.persistence.model.MongoEntity;
/**
 * A sample entity manipulated by the Rest server and the MongoDBRepository.
 * 
 * @author Frédéric Delorme<frederic.delorme@web-context.com>
 * 
 */
public class Game extends MongoEntity {

	public String id, title;
	public Map<String, URL> cover;
	public List<String> tags;
	public List<String> platform;
	public Map<String, Integer> rate;
	public Map<String, String> content;
	public Date publicationDate;
	public String editor;
	public String developer;
	public String rated;

	public Game() {
		super();
	}

	/**
	 * @param id
	 * @param title
	 * @param cover
	 * @param tags
	 * @param rate
	 * @param content
	 * @param publicationDate
	 * @param editor
	 * @param developer
	 * @param rated
	 */
	public Game(String id, String title, Map<String, URL> cover,
			List<String> tags, List<String> platform,
			Map<String, Integer> rate, Map<String, String> content,
			Date publicationDate, String editor, String developer, String rated) {
		this();
		this.id = id;
		this.title = title;
		this.cover = cover;
		this.tags = tags;
		this.platform = platform;
		this.rate = rate;
		this.content = content;
		this.publicationDate = publicationDate;
		this.editor = editor;
		this.developer = developer;
		this.rated = rated;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the cover
	 */
	public Map<String, URL> getCover() {
		return cover;
	}

	/**
	 * @param cover
	 *            the cover to set
	 */
	public void setCover(Map<String, URL> cover) {
		this.cover = cover;
	}

	/**
	 * @return the tags
	 */
	public List<String> getTags() {
		return tags;
	}

	/**
	 * @param tags
	 *            the tags to set
	 */
	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	/**
	 * @return the rate
	 */
	public Map<String, Integer> getRate() {
		return rate;
	}

	/**
	 * @param rate
	 *            the rate to set
	 */
	public void setRate(Map<String, Integer> rate) {
		this.rate = rate;
	}

	/**
	 * @return the content
	 */
	public Map<String, String> getContent() {
		return content;
	}

	/**
	 * @param content
	 *            the content to set
	 */
	public void setContent(Map<String, String> content) {
		this.content = content;
	}

	/**
	 * @return the publicationDate
	 */
	public Date getPublicationDate() {
		return publicationDate;
	}

	/**
	 * @param publicationDate
	 *            the publicationDate to set
	 */
	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}

	/**
	 * @return the editor
	 */
	public String getEditor() {
		return editor;
	}

	/**
	 * @param editor
	 *            the editor to set
	 */
	public void setEditor(String editor) {
		this.editor = editor;
	}

	/**
	 * @return the developer
	 */
	public String getDeveloper() {
		return developer;
	}

	/**
	 * @param developer
	 *            the developer to set
	 */
	public void setDeveloper(String developer) {
		this.developer = developer;
	}

	/**
	 * @return the rated
	 */
	public String getRated() {
		return rated;
	}

	/**
	 * @param rated
	 *            the rated to set
	 */
	public void setRated(String rated) {
		this.rated = rated;
	}

	/**
	 * @return the platform
	 */
	public List<String> getPlatform() {
		return platform;
	}

	/**
	 * @param platform
	 *            the platform to set
	 */
	public void setPlatform(List<String> platform) {
		this.platform = platform;
	}

	/**
	 * 
	 * @param language
	 * @return
	 */
	public String getContent(String language) {
		return content.get(language);
	}

	/**
	 * Replace in language content, all <code>"."</code> character by
	 * <code>"<br/>"</code>.
	 * 
	 * @param language
	 * @return
	 */
	public String getContentFormat(String language) {
		return content.get(language).replace(".", ".<br/>");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		final int maxLen = 10;
		StringBuilder builder = new StringBuilder();
		builder.append("Game [");
		if (id != null)
			builder.append("id=").append(id).append(", ");
		if (title != null)
			builder.append("title=").append(title).append(", ");
		if (cover != null)
			builder.append("cover=").append(toString(cover.entrySet(), maxLen))
					.append(", ");
		if (tags != null)
			builder.append("tags=").append(toString(tags, maxLen)).append(", ");
		if (platform != null)
			builder.append("platform=").append(toString(platform, maxLen))
					.append(", ");
		if (rate != null)
			builder.append("rate=").append(toString(rate.entrySet(), maxLen))
					.append(", ");
		if (content != null)
			builder.append("content=")
					.append(toString(content.entrySet(), maxLen)).append(", ");
		if (publicationDate != null)
			builder.append("publicationDate=").append(publicationDate)
					.append(", ");
		if (editor != null)
			builder.append("editor=").append(editor).append(", ");
		if (developer != null)
			builder.append("developer=").append(developer).append(", ");
		if (rated != null)
			builder.append("rated=").append(rated);
		builder.append("]");
		return builder.toString();
	}

	private String toString(Collection<?> collection, int maxLen) {
		StringBuilder builder = new StringBuilder();
		builder.append("[");
		int i = 0;
		for (Iterator<?> iterator = collection.iterator(); iterator.hasNext()
				&& i < maxLen; i++) {
			if (i > 0)
				builder.append(", ");
			builder.append(iterator.next());
		}
		builder.append("]");
		return builder.toString();
	}

}
