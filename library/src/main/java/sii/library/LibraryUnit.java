package sii.library;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import sii.library.book.Book;
import sii.library.book.BookCard;
import sii.library.book.BookCardId;
import sii.library.book.BookCatalog;
import sii.library.book.Category;

import java.util.List;
import java.util.Optional;

@Getter
@RequiredArgsConstructor
public class LibraryUnit {

    private final String name;
    private final List<LibraryDepartment> libraryDepartments;
    private final BookCatalog bookCatalog;

    public BookCardId addBook(Book book, LibraryUnit libraryUnit, LibraryDepartment libraryDepartment, Category category) {
        return bookCatalog.add(book, libraryUnit, libraryDepartment, category);
    }

    public Optional<BookCard> find(BookCardId bookCardId) {
        return bookCatalog.find(bookCardId);
    }

    public List<BookCard> find(QueryParams queryParams) {
        return bookCatalog.find(queryParams);
    }

    @Override
    public String toString() {
        return "LibraryUnit{" +
                "name='" + name + '\'' +
                '}';
    }
}
