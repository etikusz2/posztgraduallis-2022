package edu.bbte.bibliospringspringdata;

import edu.bbte.bibliospringspringdata.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SimpleTest {

    private User user1;
    private User user2;

    @BeforeEach
    public void setUp() {
        user1 = new User();
        user2 = new User();

        user2.setUuid(user1.getUuid());
    }

    @Test
    void testAdd() {
        assertEquals(42, Integer.sum(21, 21), "A két szám összege nem 42");
    }


    @Test
    void testForException() {
        ArrayList arrayList = new ArrayList<>();
        assertThrows(IndexOutOfBoundsException.class, () -> arrayList.get(0));
    }

    @Test
    void testWithHamcast() {
        assertThat("Equal user object.", user1, equalTo(user2));
    }
}
