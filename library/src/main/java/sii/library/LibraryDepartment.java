package sii.library;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum LibraryDepartment {

    ACTION_ADVENTURE("Action and Adventure"),
    FANTASY("Fantasy"),
    HORROR("Horror"),
    DETECTIVE_MYSTERY("Detective and Mystery");

    private final String name;
}
