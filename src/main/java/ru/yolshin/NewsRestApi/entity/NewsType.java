package ru.yolshin.NewsRestApi.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.OneToMany;
import javax.persistence.FetchType;

import java.util.List;

@Entity
@Table(name = "news_type")
public class NewsType extends AbstractEntity {

  private String title;
  private String color;

  @OneToMany(mappedBy="newsType", fetch=FetchType.EAGER)
  private List<News> news;

  public NewsType() {}

  public NewsType(String title, String color) {
    this.title = title;
    this.color = color;
  }

  public String getTitle() {
    return title;
  }

  public String getColor() {
    return color;
  }

  @Override
  public String toString() {
    return "NewsType: {title = "+ title + ", color = " + color + "}";
  }
}
