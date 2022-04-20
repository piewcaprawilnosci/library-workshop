package sii.library.api;

import lombok.Value;
import sii.library.LibraryDepartment;
import sii.library.book.Book;
import sii.library.book.Category;

@Value
public class BookRequest {

    Book book;
    LibraryDepartment libraryDepartment;
    Category category;
}
