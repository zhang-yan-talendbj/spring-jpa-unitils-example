package com.kiroule.example.springjpaunitils.persistence;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.unitils.UnitilsJUnit4TestClassRunner;
import org.unitils.orm.jpa.annotation.JpaEntityManagerFactory;
import org.unitils.spring.annotation.SpringApplicationContext;

import static org.junit.Assert.fail;

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

    @Test
    public void test() {
        fail("not implemented");
    }
}


