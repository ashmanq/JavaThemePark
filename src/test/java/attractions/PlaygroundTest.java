package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.assertEquals;

public class PlaygroundTest {
    Playground playground;

    @Before
    public void setUp() throws Exception {
        playground = new Playground("Fun Zone", 7);
    }

    @Test
    public void hasName() {
        assertEquals("Fun Zone", playground.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(7, playground.getRating());
    }

    @Test
    public void hasVisitCount() {
        assertEquals(0, playground.getVisitCount());
    }

    @Test
    public void isAllowedWhenUnder16() {
        Visitor visitor = new Visitor(12, 100, 100.00);
        assertEquals(true, playground.isAllowedTo(visitor));
    }

    @Test
    public void isNotAllowedWhenOver15() {
        Visitor visitor = new Visitor(16, 150, 100.00);
        assertEquals(false, playground.isAllowedTo(visitor));
    }

    @Test
    public void canIncrementCount() {
        playground.incrementVisitCount(1);
        assertEquals(1, playground.getVisitCount());
    }
}
