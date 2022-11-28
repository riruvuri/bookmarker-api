package com.rancho.bookmarker;

import com.rancho.bookmarker.domain.BookmarkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookmarkDataInitializer implements CommandLineRunner {
    private final BookmarkRepository bookmarkRepository;

    @Override
    public void run(String... args) throws Exception {
        /*
        bookmarkRepository.save(new Bookmark(null, "scikit-learn: machine learning in Python", "http://scikit-learn.org/stable/index.html", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "Kaggle", "https://www.kaggle.com/learn/python", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "Kaggle1", "https://www.kaggle.com/learn/python", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "Kaggle2", "https://www.kaggle.com/learn/python", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "Kaggle3", "https://www.kaggle.com/learn/python", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "Kaggle4", "https://www.kaggle.com/learn/python", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "Kaggle5", "https://www.kaggle.com/learn/python", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "Kaggle6", "https://www.kaggle.com/learn/python", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "Kaggle7", "https://www.kaggle.com/learn/python", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "Kaggle8", "https://www.kaggle.com/learn/python", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "Kaggle9", "https://www.kaggle.com/learn/python", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "Kaggle10", "https://www.kaggle.com/learn/python", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "Kaggle11", "https://www.kaggle.com/learn/python", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "Kaggle12", "https://www.kaggle.com/learn/python", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "Kaggle13", "https://www.kaggle.com/learn/python", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "Kaggle14", "https://www.kaggle.com/learn/python", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "Kaggle15", "https://www.kaggle.com/learn/python", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "Kaggle16", "https://www.kaggle.com/learn/python", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "Kaggle17", "https://www.kaggle.com/learn/python", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "Kaggle18", "https://www.kaggle.com/learn/python", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "Kaggle19", "https://www.kaggle.com/learn/python", Instant.now()));
        */
    }
}