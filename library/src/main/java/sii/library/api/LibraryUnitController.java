package sii.library.api;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sii.library.LibraryUnit;
import sii.library.QueryParams;
import sii.library.book.BookCard;
import sii.library.book.BookCardId;

import java.util.List;

@RestController
@RequestMapping("/library")
@RequiredArgsConstructor
public class LibraryUnitController {

    private final LibraryUnit libraryUnit;

    @GetMapping("/books")
        // // localhost:8080/library/books?title=123
    List<BookCard> getAllBooks(@RequestParam String title) {
        return libraryUnit.find(new QueryParams(title));
    }


    @PostMapping("/books")
    BookCardId addBook(@RequestBody BookRequest bookRequest) {
        return libraryUnit.addBook(bookRequest.getBook(), libraryUnit, bookRequest.getLibraryDepartment(), bookRequest.getCategory());
    }

//    @DeleteMapping Mapping("/books/{id}")
//    BookCardId deleteBook(@RequestBody BookRequest bookRequest) {
//        return libraryUnit.addBook(bookRequest.getBook(), libraryUnit, bookRequest.getLibraryDepartment(), bookRequest.getCategory());
//    }

}
