package org.example.springlms.service;

import org.example.springlms.dto.BookDTO;
import org.example.springlms.manager.BookManager;
import org.example.springlms.mapper.BookMapper;
import org.example.springlms.request.BookRequest;
import org.example.springlms.response.BookResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {
    @Autowired
    private BookManager bookManager;

    /**
     * Get all books.
     *
     * @return List of BookResponse
     */
    public List<BookResponse> getAllBooks() {
        List<BookDTO> bookDTOs = bookManager.getAllBooks();
        return bookDTOs.stream()
                .map(BookMapper::toResponse)
                .collect(Collectors.toList());
    }

    /**
     * Get book by ID.
     *
     * @param id - Book ID
     * @return BookResponse
     */
    public BookResponse getBookById(int id) {
        BookDTO bookDTO = bookManager.getBookById(id);
        return bookDTO != null ? BookMapper.toResponse(bookDTO) : null;
    }

    /**
     * Add a new book.
     *
     * @param request - BookRequest
     * @return BookResponse
     */
    public BookResponse addBook(BookRequest request) {
        BookDTO bookDTO = BookMapper.fromRequest(request);
        BookDTO savedBook = bookManager.saveBook(bookDTO);
        return BookMapper.toResponse(savedBook);
    }

    /**
     * Update book information.
     *
     * @param id - Book ID
     * @param request - BookRequest
     * @return BookResponse
     */
    public BookResponse updateBook(int id, BookRequest request) {
        BookDTO bookDTO = bookManager.getBookById(id);
        if (bookDTO != null) {
            // Update fields from request
            bookDTO.setTitle(request.getTitle());
            bookDTO.setAuthor(request.getAuthor());
            bookDTO.setIsbn(request.getIsbn());

            // Save updated book
            BookDTO updatedBook = bookManager.saveBook(bookDTO);
            return BookMapper.toResponse(updatedBook);
        }
        return null;
    }

    /**
     * Delete a book by ID.
     *
     * @param id - Book ID
     * @return BookResponse
     */
    public BookResponse deleteBook(int id) {
        BookDTO deletedBook = bookManager.deleteBook(id);
        return deletedBook != null ? BookMapper.toResponse(deletedBook) : null;
    }
}
