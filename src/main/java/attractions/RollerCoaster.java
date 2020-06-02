package attractions;

import behaviours.ISecurity;
import behaviours.ITicketed;
import people.Visitor;

public class RollerCoaster extends Attraction implements ISecurity, ITicketed {

    private double price;

    public RollerCoaster(String name, int rating) {
        super(name, rating);
        this.price = 8.40;
    }

    @Override
    public boolean isAllowedTo(Visitor visitor) {
        if(visitor.getHeight() > 145 && visitor.getAge() > 12) {
            return true;
        }
        return false;
    }

    @Override
    public double defaultPrice() {
        return price;
    }

    @Override
    public double priceFor(Visitor visitor) {
        if(visitor.getHeight() > 200) {
            return price * 2;
        }
        return price;
    }
}
