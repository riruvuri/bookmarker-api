package com.rancho.bookmarker.api;

import com.rancho.bookmarker.domain.Bookmark;
import com.rancho.bookmarker.domain.BookmarkRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.hamcrest.CoreMatchers;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@TestPropertySource(properties = {
        "spring.datasource.url=jdbc:tc:postgresql:14-alpine:///demo"
})
public class BookmarkControllerTest {
    @Autowired
    private MockMvc mvc;

    @Autowired
    BookmarkRepository bookmarkRepository;

    private List<Bookmark> bookmarks;

    @BeforeEach
    void setUp() {
        bookmarkRepository.deleteAllInBatch();
        bookmarks = new ArrayList<>();

        bookmarks.add(new Bookmark(null, "SivaLabs", "https://sivalabs.in", Instant.now()));
        bookmarks.add(new Bookmark(null, "SpringBlog", "https://spring.io/blog", Instant.now()));
        bookmarks.add(new Bookmark(null, "Quarkus", "https://quarkus.io/", Instant.now()));
        bookmarks.add(new Bookmark(null, "Micronaut", "https://micronaut.io/", Instant.now()));
        bookmarks.add(new Bookmark(null, "JOOQ", "https://www.jooq.org/", Instant.now()));
        bookmarks.add(new Bookmark(null, "VladMihalcea", "https://vladmihalcea.com", Instant.now()));
        bookmarks.add(new Bookmark(null, "Thoughts On Java", "https://thorben-janssen.com/", Instant.now()));
        bookmarks.add(new Bookmark(null, "DZone", "https://dzone.com/", Instant.now()));
        bookmarks.add(new Bookmark(null, "DevOpsBookmarks", "http://www.devopsbookmarks.com/", Instant.now()));
        bookmarks.add(new Bookmark(null, "Kubernetes docs", "https://kubernetes.io/docs/home/", Instant.now()));
        bookmarks.add(new Bookmark(null, "Expressjs", "https://expressjs.com/", Instant.now()));
        bookmarks.add(new Bookmark(null, "Marcobehler", "https://www.marcobehler.com", Instant.now()));
        bookmarks.add(new Bookmark(null, "baeldung", "https://www.baeldung.com", Instant.now()));
        bookmarks.add(new Bookmark(null, "devglan", "https://www.devglan.com", Instant.now()));
        bookmarks.add(new Bookmark(null, "linuxize", "https://linuxize.com", Instant.now()));

        bookmarkRepository.saveAll(bookmarks);
    }

    @ParameterizedTest
    @CsvSource({
            "1,15,2,1,true,false,true,false",
            "2,15,2,2,false,true,false,true"
    })
    void bookmark_success(int pageNo, int totalElements, int totalPages, int currentPage,
                          boolean isFirst, boolean isLast,
                          boolean hasNext, boolean hasPrevious) throws Exception {
        mvc.perform(get("/api/bookmark?page="+pageNo))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.totalElements", CoreMatchers.equalTo(totalElements)))
                .andExpect(jsonPath("$.totalPages", CoreMatchers.equalTo(totalPages)))
                .andExpect(jsonPath("$.currentPage", CoreMatchers.equalTo(currentPage)))
                .andExpect(jsonPath("$.isFirstPage", CoreMatchers.equalTo(isFirst)))
                .andExpect(jsonPath("$.isLastPage", CoreMatchers.equalTo(isLast)))
                .andExpect(jsonPath("$.hasNextPage", CoreMatchers.equalTo(hasNext)))
                .andExpect(jsonPath("$.hasPreviousPage", CoreMatchers.equalTo(hasPrevious)))
        ;
    }
}
