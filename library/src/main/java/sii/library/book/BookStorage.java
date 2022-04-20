package sii.library.book;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class BookStorage {

    private final Map<BookCardId, BookCard> storage = new HashMap<>();

    public void save(BookCard bookCard) {
        storage.put(bookCard.getId(), bookCard);
    }

    public Optional<BookCard> find(BookCardId bookCardId) {
        return Optional.ofNullable(storage.get(bookCardId));
    }

    public List<BookCard> findByTitle(String title) {
        return storage.entrySet()
                .stream()
                .map(entry -> entry.getValue())
                .filter(bookCard -> bookCard.getBook().getTitle().equals(title))
                .collect(Collectors.toList());
    }
}
