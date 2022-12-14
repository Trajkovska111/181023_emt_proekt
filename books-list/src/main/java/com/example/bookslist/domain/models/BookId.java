package com.example.bookslist.domain.models;

import com.example.sharedkernel.domain.base.DomainObjectId;

import lombok.NonNull;

public class BookId extends DomainObjectId {
    
    private BookId() {
        super(BookId.randomId(BookId.class).getId());
    }

    public BookId(@NonNull String uuid) {
        super(uuid);
    }

    public static BookId of(String uuid) {
        BookId p = new BookId(uuid);
        return p;
    }

}
