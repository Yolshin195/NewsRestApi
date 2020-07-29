package ru.yolshin.NewsRestApi.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.ManyToOne;

@Entity
@Table(name="news")
public class News extends AbstractEntity {

  private String title;
  private String shortDescription;
  private String description;

  @ManyToOne
  private NewsType newsType;

  public News() {}

  public News(String title, String shortDescription, String description) {
    this.title            = title;
    this.description      = description;
    this.shortDescription = shortDescription;
  }

  public NewsType getNewsType() {
    return newsType;
  }

  public void setNewsType(NewsType newsType) {
    this.newsType = newsType;
  }

  public String getTitle() {
    return title;
  }

  public String getShortDescription() {
    return shortDescription;
  }

  public String getDescription() {
    return description;
  }

  @Override
  public String toString() {
    return "\nNews: {\n"
      + "\ttitle = " + title + ", \n"
      + "\tshortDescription = " + shortDescription + ", \n"
      + "\tdescription = " + description + ", \n"
      + "\tnewsType = " + newsType.toString() + "\n"
      + "}";
  }
}
