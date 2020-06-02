import attractions.Attraction;
import behaviours.IReviewed;
import stalls.Stall;

import javax.smartcardio.ATR;
import java.util.ArrayList;

public class ThemePark {

    private ArrayList<Attraction> attractions;
    private ArrayList<Stall> stalls;
    private ArrayList<IReviewed> reviewedPlaces;
    String name;

    public ThemePark(String name) {
        this.name = name;
        this.attractions = new ArrayList<>();
        this.stalls = new ArrayList<>();
        this.reviewedPlaces = new ArrayList<>();
    }

    public String getName() {
        return name;
    }


    public int getNoReviewedPlaces() {
        return this.reviewedPlaces.size();
    }


    public void addReviewedPlace(IReviewed place) {
        this.reviewedPlaces.add(place);
    }

    public ArrayList<IReviewed> getAllReviewed() {
        return this.reviewedPlaces;
    }
}
