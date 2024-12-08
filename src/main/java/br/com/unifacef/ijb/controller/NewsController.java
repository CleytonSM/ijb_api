package br.com.unifacef.ijb.controller;

import br.com.unifacef.ijb.models.entities.News;
import br.com.unifacef.ijb.models.entities.Volunteer;
import br.com.unifacef.ijb.services.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/ijb/news")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @GetMapping
    public ResponseEntity<List<News>> findAll() {
        List<News> newsList = newsService.findAll();
        return ResponseEntity.ok(newsList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<News> findById(@PathVariable Integer id) {
        return newsService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<News> create(
            @RequestParam("tags") String tags,
            @RequestParam("volunteerId") Integer volunteerId,
            @RequestParam("localDateTime") String localDateTime,
            @RequestParam("viewStatus") Boolean viewStatus,
            @RequestParam("newsAuthor") String newsAuthor,
            @RequestParam(value = "newsImage", required = false) MultipartFile newsImage,
            @RequestParam("imageURL") String imageURL,
            @RequestParam("newsDescription") String newsDescription
    ) {
        try {
            News news = new News();
            news.setTags(tags);
            news.setVolunteer(new Volunteer());
            news.getVolunteer().setId(volunteerId);
            news.setLocalDateTime(LocalDateTime.parse(localDateTime));
            news.setViewStatus(viewStatus);
            news.setNewsAuthor(newsAuthor);
            news.setImageURL(imageURL);
            news.setNewsDescription(newsDescription);

            if (newsImage != null && !newsImage.isEmpty()) {
                news.setNewsImage(newsImage.getBytes());
            }

            News createdNews = newsService.save(news);
            return ResponseEntity.status(201).body(createdNews);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<News> update(@PathVariable Integer id, @RequestBody News news) {
        try {
            News updatedNews = newsService.update(id, news);
            return ResponseEntity.ok(updatedNews);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        newsService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}/permanent")
    public ResponseEntity<Void> deletePermanently(@PathVariable Integer id) {
        newsService.deletePermanently(id);
        return ResponseEntity.noContent().build();
    }
}
