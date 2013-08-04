package com.kiroule.example.springjpaunitils.persistence;

import com.kiroule.example.springjpaunitils.domain.Book;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.unitils.UnitilsJUnit4TestClassRunner;
import org.unitils.dbunit.annotation.DataSet;
import org.unitils.orm.jpa.annotation.JpaEntityManagerFactory;
import org.unitils.spring.annotation.SpringApplicationContext;
import org.unitils.spring.annotation.SpringBeanByType;

import static com.kiroule.example.springjpaunitils.util.TestHelper.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * JUnit/Unitils-based entity mapping tests for the {@link BookJpaDaoImpl} class.
 *
 * @author Igor Baiborodine
 *
 */
@RunWith(UnitilsJUnit4TestClassRunner.class)
@SpringApplicationContext({ "classpath:persistence-context-test.xml" })
@JpaEntityManagerFactory(persistenceUnit = "spring-jpa-unitils-pu")
public class BookJpaDaoImplTest {

    @SpringBeanByType
    private static BookJpaDaoImpl dao;

    @Before
    public void setUp() {
        dao.clear();
    }

    @Test
    @DataSet(value = "/datasets/empty.xml")
    public void create_shouldCreateNewBook() {
        Book book = getNewBook();
        dao.create(book);
        assertEquals(new Long("1"), book.getBookId());
        assertEquals(new Long("0"), book.getVersion());
    }
    /* does not work?!
    @Test(expected = PersistenceException.class)
    @DataSet(value = "/datasets/book.xml")
    @Transactional(TransactionMode.ROLLBACK)
    public void create_shouldThrowPersistenceExceptionOnDuplicateBook() {
        Book duplicateBook = getNewBook();
        dao.create(duplicateBook);
    }
    */
    @Test
    @DataSet(value = "/datasets/book.xml")
    public void read_shouldReadBookForExistingId() {
        assertBook(dao.read(ID));
    }

    @Test
    @DataSet(value = "/datasets/empty.xml")
    public void read_shouldNotReadBookForNonExistingId() {
        assertNull(dao.read(ID));
    }

    @Test
    @DataSet(value = "/datasets/book.xml")
    public void read_shouldReadByIsbnExistingBook() {
        assertBook(dao.readByIsbn(ISBN));
    }
}


