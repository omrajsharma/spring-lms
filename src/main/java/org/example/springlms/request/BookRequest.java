package org.example.springlms.request;

import lombok.Data;

@Data
public class BookRequest {
    private String title;
    private String author;
    private String isbn;
}
