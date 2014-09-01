package eu.execom.collections.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "book")
public class Book {
	public enum coverType {
		HARDCOVER, PAPERBACK
	}

	public enum genreType {
		FICTION, NONFICTION
	}

	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;

	@Column(name = "title", nullable = false)
	private String title;

	@Column(name = "author")
	private String author;

	@Column(name = "year_Of_publishing")
	private int yearOfPublishing;

	@Column(name = "genre")
	@Enumerated(EnumType.STRING)
	private genreType genre;

	@Column(name = "isbn")
	private long isbn;

	@Column(name = "cover")
	@Enumerated(EnumType.STRING)
	private coverType cover;

	@Column(name = "publisher")
	private String publisher;

	@Column(name = "city_of_publishing")
	private String cityOfPublishing;

	@Column(name = "series")
	private String series;

	@Column(name = "language")
	private String language;

	@Column(name = "edition_statement")
	private String editionStatement;

	@Lob
	@Column(name = "image", columnDefinition = "MEDIUMTEXT")
	private String image;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getYearOfPublishing() {
		return yearOfPublishing;
	}

	public void setYearOfPublishing(int yearOfPublishing) {
		this.yearOfPublishing = yearOfPublishing;
	}

	public genreType getGenre() {
		return genre;
	}

	public void setGenre(genreType genre) {
		this.genre = genre;
	}

	public long getIsbn() {
		return isbn;
	}

	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}

	public coverType getCover() {
		return cover;
	}

	public void setCover(coverType cover) {
		this.cover = cover;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getCityOfPublishing() {
		return cityOfPublishing;
	}

	public void setCityOfPublishing(String cityOfPublishing) {
		this.cityOfPublishing = cityOfPublishing;
	}

	public String getSeries() {
		return series;
	}

	public void setSeries(String series) {
		this.series = series;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getEditionStatement() {
		return editionStatement;
	}

	public void setEditionStatement(String editionStatement) {
		this.editionStatement = editionStatement;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime
				* result
				+ ((cityOfPublishing == null) ? 0 : cityOfPublishing.hashCode());
		result = prime * result + ((cover == null) ? 0 : cover.hashCode());
		result = prime
				* result
				+ ((editionStatement == null) ? 0 : editionStatement.hashCode());
		result = prime * result + ((genre == null) ? 0 : genre.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + (int) (isbn ^ (isbn >>> 32));
		result = prime * result
				+ ((language == null) ? 0 : language.hashCode());
		result = prime * result
				+ ((publisher == null) ? 0 : publisher.hashCode());
		result = prime * result + ((series == null) ? 0 : series.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		result = prime * result + yearOfPublishing;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (cityOfPublishing == null) {
			if (other.cityOfPublishing != null)
				return false;
		} else if (!cityOfPublishing.equals(other.cityOfPublishing))
			return false;
		if (cover != other.cover)
			return false;
		if (editionStatement == null) {
			if (other.editionStatement != null)
				return false;
		} else if (!editionStatement.equals(other.editionStatement))
			return false;
		if (genre != other.genre)
			return false;
		if (id != other.id)
			return false;
		if (image == null) {
			if (other.image != null)
				return false;
		} else if (!image.equals(other.image))
			return false;
		if (isbn != other.isbn)
			return false;
		if (language == null) {
			if (other.language != null)
				return false;
		} else if (!language.equals(other.language))
			return false;
		if (publisher == null) {
			if (other.publisher != null)
				return false;
		} else if (!publisher.equals(other.publisher))
			return false;
		if (series == null) {
			if (other.series != null)
				return false;
		} else if (!series.equals(other.series))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		if (yearOfPublishing != other.yearOfPublishing)
			return false;
		return true;
	}
	
	

}