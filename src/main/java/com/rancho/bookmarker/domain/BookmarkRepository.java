package com.rancho.bookmarker.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {

    @Query("select new com.rancho.bookmarker.domain.BookmarkDTO(b.id, b.name, b.url, b.createdAt) " +
            "from Bookmark b")
    Page<BookmarkDTO> findBookmark(Pageable pageable);
}
