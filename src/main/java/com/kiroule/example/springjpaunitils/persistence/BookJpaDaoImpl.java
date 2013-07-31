package com.kiroule.example.springjpaunitils.persistence;

import com.google.common.base.Optional;
import com.kiroule.example.springjpaunitils.domain.Book;

/**
 * @author Igor Baiborodine
 */
public class BookJpaDaoImpl extends AbstractJpaDao<Book, Long> {

    public Book readByIsbn(String isbn) {
        // TODO: to implement by using named query
        return null;
    }
}
