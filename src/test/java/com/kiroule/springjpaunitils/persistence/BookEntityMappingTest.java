package com.kiroule.springjpaunitils.persistence;

import com.kiroule.example.springjpaunitils.domain.Book;
import com.kiroule.example.springjpaunitils.domain.builder.BookBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import java.math.BigDecimal;

import static org.junit.Assert.assertNotNull;

/**
 * JUnit-based entity mapping tests for the {@link Book} class.
 *
 * @author Igor Baiborodine
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:/META-INF/spring-config.xml")
public class BookEntityMappingTest {
    @PersistenceContext
    private EntityManager em;

    private static final String ISBN = "978-0-321-35668-0";
    private static final String AUTHOR = "Joshua Bloch";
    private static final String TITLE = "Effective Java";
    private static final BigDecimal PRICE = new BigDecimal("50.0");


    @Test
    public void entityManagerShouldNotBeNull() {
        assertNotNull(em);
    }

    @Test(expected = PersistenceException.class)
    public void entityMapping_shouldThrowPersistenceExceptionOnIsbnValueWithLengthGreaterThanMax() {
        final Book book = new BookBuilder(ISBN + "length is over the limit").build();
        em.persist(book);
    }
}