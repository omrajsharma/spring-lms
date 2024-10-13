package org.example.springlms.mapper;

import org.example.springlms.dto.BookDTO;
import org.example.springlms.entity.Book;
import org.example.springlms.request.BookRequest;
import org.example.springlms.response.BookResponse;

public class BookMapper {
    public static BookDTO toDTO(Book book) {
        BookDTO dto = new BookDTO();
        dto.setId(book.getId());
        dto.setTitle(book.getTitle());
        dto.setAuthor(book.getAuthor());
        dto.setIsbn(book.getIsbn());
        dto.setAvailable(book.isAvailable());
        return dto;
    }

    public static Book fromDTO(BookDTO dto) {
        Book book = new Book();
        book.setId(dto.getId());
        book.setTitle(dto.getTitle());
        book.setAuthor(dto.getAuthor());
        book.setIsbn(dto.getIsbn());
        book.setAvailable(dto.isAvailable());
        return book;
    }

    public static BookDTO fromRequest(BookRequest request) {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setTitle(request.getTitle());
        bookDTO.setAuthor(request.getAuthor());
        bookDTO.setIsbn(request.getIsbn());
        bookDTO.setAvailable(true);  // Set available by default
        return bookDTO;
    }

    public static BookResponse toResponse(BookDTO dto) {
        BookResponse response = new BookResponse();
        response.setId(dto.getId());
        response.setTitle(dto.getTitle());
        response.setAuthor(dto.getAuthor());
        response.setIsbn(dto.getIsbn());
        response.setAvailable(dto.isAvailable());
        return response;
    }
}
