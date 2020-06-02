import attractions.Attraction;
import attractions.DodgemTest;
import attractions.Dodgems;
import org.junit.Before;
import org.junit.Test;
import stalls.CandyflossStall;
import stalls.ParkingSpot;
import stalls.Stall;

import java.util.concurrent.CancellationException;

import static org.junit.Assert.assertEquals;

public class ThemeParkTest {

    private ThemePark themepark;

    @Before
    public void before() {
        themepark = new ThemePark("Bullfrog's Theme Park");
    }

    @Test
    public void hasName() {
        assertEquals("Bullfrog's Theme Park", themepark.getName());
    }

    @Test
    public void startsWithNoAttractions() {
        assertEquals(0, themepark.getNoReviewedPlaces());
    }

    @Test
    public void startsWithNoStalls() {
        assertEquals(0, themepark.getNoReviewedPlaces());
    }

    @Test
    public void canAddAttraction() {
        Dodgems dodgems = new Dodgems("Dodgem", 5);
        themepark.addReviewedPlace(dodgems);
        assertEquals(1, themepark.getNoReviewedPlaces());
    }

    @Test
    public void canAddStall() {
        CandyflossStall candyflossStall = new CandyflossStall("Candy R Us", "Jim Jones", ParkingSpot.A1, 8);
        themepark.addReviewedPlace(candyflossStall);
        assertEquals(1, themepark.getNoReviewedPlaces());
    }

    @Test
    public void canGetAllReviewedPlaces() {
        Dodgems dodgems = new Dodgems("Dodgem", 5);
        themepark.addReviewedPlace(dodgems);
        CandyflossStall candyflossStall = new CandyflossStall("Candy R Us", "Jim Jones", ParkingSpot.A1, 8);
        themepark.addReviewedPlace(candyflossStall);
        assertEquals(2, themepark.getNoReviewedPlaces());
    }
}
