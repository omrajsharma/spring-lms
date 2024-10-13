package org.example.springlms.manager;

import org.example.springlms.dto.BookDTO;
import org.example.springlms.entity.Book;
import org.example.springlms.mapper.BookMapper;
import org.example.springlms.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookManager {
    @Autowired
    private BookRepository bookRepository;

    public List<BookDTO> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        return books.stream()
                .map(BookMapper::toDTO)
                .collect(Collectors.toList());
    }

    public BookDTO getBookById(int id) {
        Book book = bookRepository.findById(id).orElse(null);
        return book != null ? BookMapper.toDTO(book) : null;
    }

    public BookDTO saveBook(BookDTO bookDTO) {
        Book book = BookMapper.fromDTO(bookDTO);
        book = bookRepository.save(book);
        return BookMapper.toDTO(book);
    }

    public BookDTO deleteBook(int id) {
        Book book = bookRepository.findById(id).orElse(null);
        if (book != null) {
            bookRepository.delete(book);
            return BookMapper.toDTO(book);
        }
        return null;
    }
}
