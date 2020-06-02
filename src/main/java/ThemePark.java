import attractions.Attraction;
import behaviours.IReviewed;
import behaviours.ISecurity;
import com.sun.codemodel.internal.JForEach;
import people.Visitor;
import stalls.Stall;

import javax.smartcardio.ATR;
import java.util.ArrayList;
import java.util.HashMap;

public class ThemePark {

    private ArrayList<IReviewed> reviewedPlaces;
    String name;

    public ThemePark(String name) {

        this.name = name;
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

    public void visit(Visitor visitor, Attraction attraction) {

        visitor.addVisitedAttraction(attraction);
        attraction.incrementVisitCount(1);

    }

    public HashMap<String, Integer> getReviews() {
        HashMap<String, Integer> reviews = new HashMap<>();

        for(IReviewed reviewedPlace : this.reviewedPlaces) {
            String name = reviewedPlace.getName();
            Integer score = reviewedPlace.getRating();
            reviews.put(name, score);
        }
        return reviews;
    }

    public ArrayList<IReviewed> getAllAllowedFor(Visitor visitor) {
        ArrayList<IReviewed> allowedList = new ArrayList<>();

        for(IReviewed reviewedPlace : this.reviewedPlaces) {

            if(!(reviewedPlace instanceof ISecurity)) {
                allowedList.add(reviewedPlace);
            } else if(reviewedPlace instanceof ISecurity && ((ISecurity) reviewedPlace).isAllowedTo(visitor)) {
                allowedList.add(reviewedPlace);
            }
        }
        return allowedList;
    }

}
