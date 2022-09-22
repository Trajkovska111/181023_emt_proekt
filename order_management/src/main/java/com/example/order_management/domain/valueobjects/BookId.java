package com.example.order_management.domain.valueobjects;

import com.example.sharedkernel.domain.base.DomainObjectId;

import javax.persistence.Embeddable;

@Embeddable
public class BookId extends DomainObjectId {

    protected BookId() {
        super(BookId.randomId(BookId.class).getId());
    }

    public BookId(String uuid) {
        super(uuid);
    }

}
