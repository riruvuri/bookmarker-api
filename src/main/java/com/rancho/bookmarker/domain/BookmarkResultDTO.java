package com.rancho.bookmarker.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.List;

@Setter
@Getter
public class BookmarkResultDTO {
    private List<BookmarkDTO> data;
    private long totalElements;
    private int totalPages;
    private int currentPage;
    @JsonProperty("isFirstPage")
    private boolean isFirstPage;
    @JsonProperty("isLastPage")
    private boolean isLastPage;
    private boolean hasNextPage;
    private boolean hasPreviousPage;

    public BookmarkResultDTO(Page<BookmarkDTO> pageResult) {
        this.setData(pageResult.getContent());
        this.setTotalElements(pageResult.getTotalElements());
        this.setTotalPages(pageResult.getTotalPages());
        this.setCurrentPage(pageResult.getNumber() + 1);
        this.setFirstPage(pageResult.isFirst());
        this.setLastPage(pageResult.isLast());
        this.setHasNextPage(pageResult.hasNext());
        this.setHasPreviousPage(pageResult.hasPrevious());
    }
}
