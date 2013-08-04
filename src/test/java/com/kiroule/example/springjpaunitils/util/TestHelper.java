package com.kiroule.example.springjpaunitils.util;

import com.kiroule.example.springjpaunitils.domain.Book;
import com.kiroule.example.springjpaunitils.domain.builder.BookBuilder;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author Igor Baiborodine
 */
public class TestHelper {

    public static final Long ID = 1L;
    public static final String ISBN = "978-0-321-50362-6";
    public static final String AUTHOR = "Steve Freeman, Nat Pryce";
    public static final String TITLE = "Growing Object-Oriented Software, Guided by Tests";
    public static final BigDecimal PRICE = new BigDecimal("50.0");

    public static Book getNewBook() {
        return new BookBuilder(ISBN)
                .author(AUTHOR)
                .title(TITLE)
                .price(PRICE).build();
    }

    public static void assertBook(final Book book) {
        assertNotNull(book);
        assertEquals(ISBN, book.getIsbn());
        assertEquals(TITLE, book.getTitle());
        assertEquals(AUTHOR, book.getAuthor());
        assertEquals(0, PRICE.compareTo(book.getPrice()));
    }
}
