package sii.library;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import sii.library.book.Book;
import sii.library.book.BookCard;
import sii.library.book.BookCardId;
import sii.library.book.BookCatalog;
import sii.library.book.Category;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static sii.library.LibraryDepartment.ACTION_ADVENTURE;
import static sii.library.LibraryDepartment.HORROR;

class LibraryUnitTest {


    private LibraryUnit libraryUnit;

    @BeforeEach
    void cokolwiek() {
        libraryUnit = new LibraryUnit("First Library Unit",List.of(ACTION_ADVENTURE, HORROR), new BookCatalog());
    }

    @Test
    @DisplayName("Should add book into book catalog")
    void shoudAddBook() {
        // given
        Book book = Book.SAMPLE_BOOK;

        // when
        BookCardId bookCardId = libraryUnit.addBook(book, libraryUnit, libraryUnit.getLibraryDepartments().get(0), Category.BESTSELLER);

        // then
        BookCard foundBookCard = libraryUnit.find(bookCardId)
                .orElseThrow(() -> new IllegalStateException("The book was not found"));
        assertEquals(book, foundBookCard.getBook());
    }

    @Test
    @DisplayName("Should delete book from book catalog")
    void shoudDelete() {

    }

    @Test
    @DisplayName("Should find books from book catalog by query params")
    void shoudSearch() {
        // given
        var book = Book.SAMPLE_BOOK;
        var bookCardId = libraryUnit.addBook(book, libraryUnit, libraryUnit.getLibraryDepartments().get(0), Category.BESTSELLER);
        var queryParams = new QueryParams(book.getTitle());

        // when
        List<BookCard> bookCards = libraryUnit.find(queryParams);

        // then
        assertTrue(bookCards.size() == 1);
        assertEquals(bookCardId, bookCards.get(0).getId());
    }

}