package ave.bertrand.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "my_first_embedded_elastic_search_index", type = "books")
public class Book {

	@Id
	private String id;
	private String title;
	private String author;

	private Date releaseDate;

	public Book() {
	}

	public Book(String id, String title, String author, Date releaseDate) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.releaseDate = releaseDate;
	}

	// getters and setters

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	@Override
	public String toString() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		return "Book{" + "id='" + id + '\'' + ", title='" + title + '\'' + ", author='" + author + '\''
				+ ", releaseDate='" + dateFormat.format(releaseDate) + '\'' + '}';
	}
}
