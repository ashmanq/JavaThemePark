import attractions.*;
import behaviours.IReviewed;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Attr;
import people.Visitor;
import stalls.*;

import java.util.ArrayList;
import java.util.HashMap;
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

    @Test
    public void visitorCanVisitAttraction() {
        Visitor visitor = new Visitor(18, 190, 200);
        Attraction rollerCoaster = new RollerCoaster("Big Bertha", 10);
        themepark.visit(visitor, rollerCoaster);
        assertEquals(1, rollerCoaster.getVisitCount());
        assertEquals(1, visitor.getVisitedAttractions().size());
    }

    @Test
    public void canGetAllReviewScoresWithNames() {

        Dodgems dodgems = new Dodgems("A Dodgem", 1);
        RollerCoaster rollerCoaster = new RollerCoaster("A Rollercoaster", 2);
        TobaccoStall tobaccoStall = new TobaccoStall("A Tobacco Stall", "Jim J", ParkingSpot.A2,7 );
        IceCreamStall iceCreamStall = new IceCreamStall("An Icecream stall", "Brian B", ParkingSpot.A3, 9);

        themepark.addReviewedPlace(dodgems);
        themepark.addReviewedPlace(rollerCoaster);
        themepark.addReviewedPlace(tobaccoStall);
        themepark.addReviewedPlace(iceCreamStall);

        HashMap<String,Integer> list = themepark.getReviews();

        list.get("A Rollercoaster");

        assertEquals(1, (int)list.get("A Dodgem"));
        assertEquals(2, (int)list.get("A Rollercoaster"));
        assertEquals(7, (int)list.get("A Tobacco Stall"));
        assertEquals(9, (int)list.get("An Icecream stall"));
    }

    @Test
    public void canGetAllowedForList() {
        Park park = new Park("Park", 8);
        Playground playground = new Playground("Playground", 7);
        Dodgems dodgems = new Dodgems("A Dodgem", 1);
        RollerCoaster rollerCoaster = new RollerCoaster("A Rollercoaster", 2);
        TobaccoStall tobaccoStall = new TobaccoStall("A Tobacco Stall", "Jim J", ParkingSpot.A2,7 );
        IceCreamStall iceCreamStall = new IceCreamStall("An Icecream stall", "Brian B", ParkingSpot.A3, 9);
        CandyflossStall candyflossStall = new CandyflossStall("Candyfloss", "Leam L", ParkingSpot.B1,4);

        themepark.addReviewedPlace(playground);
        themepark.addReviewedPlace(park);
        themepark.addReviewedPlace(dodgems);
        themepark.addReviewedPlace(rollerCoaster);
        themepark.addReviewedPlace(tobaccoStall);
        themepark.addReviewedPlace(iceCreamStall);
        themepark.addReviewedPlace(candyflossStall);

        Visitor visitor = new Visitor(10, 100, 100.00);
        ArrayList<IReviewed> allowedList = themepark.getAllAllowedFor(visitor);

        assertEquals(5, allowedList.size());
    }
}
