package sii.library.book;

import lombok.Value;
import sii.library.LibraryDepartment;
import sii.library.LibraryUnit;

@Value
public class BookCard {

    private final String id;
    private final Book book;
    private final LibraryDepartment libraryDepartment;
    private final Category category;

    public BookCardId getId() {
        return new BookCardId(id);
    }
}
