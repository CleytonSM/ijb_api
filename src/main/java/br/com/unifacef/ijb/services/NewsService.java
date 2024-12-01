package br.com.unifacef.ijb.services;

import br.com.unifacef.ijb.models.entities.News;
import br.com.unifacef.ijb.repositories.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class NewsService {

    @Autowired
    private NewsRepository newsRepository;

    public List<News> findAll() {
        return newsRepository.findAll();
    }

    public Optional<News> findById(Integer id) {
        return newsRepository.findById(id);
    }

    public News save(News news) {
        news.setCreatedAt(LocalDateTime.now());
        return newsRepository.save(news);
    }

    public News update(Integer id, News updatedNews) {
        return newsRepository.findById(id).map(existingNews -> {
            existingNews.setTags(updatedNews.getTags());
            existingNews.setVolunteer(updatedNews.getVolunteer());
            existingNews.setNewsImage(updatedNews.getNewsImage());
            existingNews.setLocalDateTime(updatedNews.getLocalDateTime());
            existingNews.setViewStatus(updatedNews.getViewStatus());
            existingNews.setNewsAuthor(updatedNews.getNewsAuthor());
            existingNews.setImageURL(updatedNews.getImageURL());
            existingNews.setNewsDescription(updatedNews.getNewsDescription());
            existingNews.setUpdatedAt(LocalDateTime.now());
            return newsRepository.save(existingNews);
        }).orElseThrow(() -> new RuntimeException("Notícia não encontrada " + id));
    }

    public void delete(Integer id) {
        newsRepository.findById(id).ifPresent(news -> {
            news.setDeletedAt(LocalDateTime.now());
            newsRepository.save(news);
        });
    }

    public void deletePermanently(Integer id) {
        newsRepository.deleteById(id);
    }
}
