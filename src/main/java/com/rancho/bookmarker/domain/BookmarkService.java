package com.rancho.bookmarker.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class BookmarkService {
    private final BookmarkRepository bookmarkRepository;
    //private final BookmarkMapper bookmarkMapper;

    @Transactional(readOnly = true)
    public BookmarkResultDTO getBookmarks(Integer page) {
        int pageNo = page < 1 ? 0 : page-1;
        Pageable pageable = PageRequest.of(pageNo, 10, Sort.Direction.DESC, "createdAt");
        //Page<BookmarkDTO> bookmarkDTOPage = bookmarkRepository.findAll(pageable).map(bookmarkMapper::convertToDTO);

        Page<BookmarkDTO> bookmarkDTOPage = bookmarkRepository.findBookmark(pageable);
        return new BookmarkResultDTO(bookmarkDTOPage);
    }
}
