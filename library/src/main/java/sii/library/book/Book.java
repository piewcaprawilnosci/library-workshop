package sii.library.book;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;

@Entity
@Getter
@RequiredArgsConstructor
public final class Book {

    public static final Book SAMPLE_BOOK = new Book("Jan Kowalski", "Szkoła Javy");

    private final String author;
    private final String title;


}
