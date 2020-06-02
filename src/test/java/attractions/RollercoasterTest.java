package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.assertEquals;

public class RollercoasterTest {

    RollerCoaster rollerCoaster;

    @Before
    public void setUp() {
        rollerCoaster = new RollerCoaster("Blue Ridge", 10);
    }

    @Test
    public void hasName() {
        assertEquals("Blue Ridge", rollerCoaster.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(10, rollerCoaster.getRating());
    }

    @Test
    public void hasVisitCount() {
        assertEquals(0, rollerCoaster.getVisitCount());
    }

    @Test
    public void isAllowedWhen13And146CmTall() {
        Visitor visitor = new Visitor(13, 146, 100.00);
        assertEquals(true, rollerCoaster.isAllowedTo(visitor));
    }

    @Test
    public void isNotAllowedWhen12And146CmTall() {
        Visitor visitor = new Visitor(12, 146, 100.00);
        assertEquals(false, rollerCoaster.isAllowedTo(visitor));
    }

    @Test
    public void isNotAllowedWhen13And144CmTall() {
        Visitor visitor = new Visitor(13, 144, 100.00);
        assertEquals(false, rollerCoaster.isAllowedTo(visitor));
    }

    @Test
    public void hasDefaultPrice() {
        assertEquals(8.40, rollerCoaster.defaultPrice(), 0.01);
    }

    @Test
    public void chargesDefaultForUnder200Cm() {
        Visitor visitor = new Visitor(18, 199, 200);
        assertEquals(8.40, rollerCoaster.priceFor(visitor), 0.01);

    }

    @Test
    public void chargesDoubleForOver200Cm() {
        Visitor tallVisitor = new Visitor(18, 201, 200);
        assertEquals(16.80, rollerCoaster.priceFor(tallVisitor), 0.01);
    }

    @Test
    public void canIncrementCount() {
        rollerCoaster.incrementVisitCount(1);
        assertEquals(1, rollerCoaster.getVisitCount());
    }
}
