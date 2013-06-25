package com.kiroule.springjpaunitils.persistence;

import com.kiroule.example.springjpaunitils.domain.Book;
import com.kiroule.example.springjpaunitils.domain.builder.BookBuilder;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.unitils.UnitilsJUnit4TestClassRunner;
import org.unitils.database.annotations.Transactional;
import org.unitils.database.util.TransactionMode;
import org.unitils.spring.annotation.SpringApplicationContext;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import java.math.BigDecimal;

import static org.junit.Assert.assertNotNull;

/**
 * JUnit/Unitils-based entity mapping tests for the {@link Book} class.
 *
 * @author Igor Baiborodine
 */

@RunWith(UnitilsJUnit4TestClassRunner.class)
@SpringApplicationContext({ "classpath:/META-INF/persistence-context.xml" })
@Transactional(value = TransactionMode.ROLLBACK)
public class BookEntityMappingTest {

    @PersistenceContext(unitName="persistenceUnitPU")
    private EntityManager em;

    private static final String ISBN = "978-0-321-35668-0";
    private static final String AUTHOR = "Joshua Bloch";
    private static final String TITLE = "Effective Java";
    private static final BigDecimal PRICE = new BigDecimal("50.0");

    @After
    public void tearDown() {
        if (em != null) {
            em.clear();
        }
    }

    @Test(expected = PersistenceException.class)
    public void entityMapping_shouldThrowPersistenceExceptionOnIsbnValueWithLengthGreaterThanMax() {
        final Book book = new BookBuilder(ISBN + "length is over the limit").build();
        em.persist(book);
    }
}