package sii.library.book;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import sii.library.LibraryDepartment;
import sii.library.LibraryUnit;
import sii.library.QueryParams;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static java.util.Objects.nonNull;

public class BookCatalog {

    private final BookStorage bookStorage = new BookStorage();

    public BookCardId add(Book book, LibraryUnit libraryUnit, LibraryDepartment libraryDepartment, Category category) {
        var bookCard = new BookCard(createId(), book, libraryDepartment, category);
        bookStorage.save(bookCard);
        return bookCard.getId();
    }

    public Optional<BookCard> find(BookCardId bookCardId) {
        return bookStorage.find(bookCardId);
    }

    private static String createId() {
        return UUID.randomUUID().toString();
    }

    public List<BookCard> find(QueryParams queryParams) {

        if (nonNull(queryParams.getTitle())){
            return bookStorage.findByTitle(queryParams.getTitle());
        }

        throw new UnsupportedOperationException("Other params are currently not supported");
    }
}
