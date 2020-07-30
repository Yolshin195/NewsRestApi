package ru.yolshin.NewsRestApi.component;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import ru.yolshin.NewsRestApi.repository.*;
import ru.yolshin.NewsRestApi.entity.*;

@Component
public class DatabaseLoader implements CommandLineRunner {

	private final NewsRepository newsRepository;
	private final NewsTypeRepository newsTypeRepository;

	public DatabaseLoader(NewsRepository newsRepository, 
                        NewsTypeRepository newsTypeRepository) 
  {
		this.newsRepository = newsRepository;
		this.newsTypeRepository = newsTypeRepository;
	}

	@Override
	public void run(String... strings) throws Exception {
    var success = newsTypeRepository.save(new NewsType("success", "green"));
    var danger  = newsTypeRepository.save(new NewsType("danger", "red"));

    News news1 = new News(
      "First news", 
      "Short description news...",
      "Description news"
    );
    news1.setNewsType(success);

    newsRepository.save(news1);

    News news2 = new News(
      "danger news", 
      "danger news...",
      "Description danger news"
    );
    news2.setNewsType(danger);

    newsRepository.save(news2);

	}
}
