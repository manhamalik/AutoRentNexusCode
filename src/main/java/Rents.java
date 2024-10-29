import java.util.List;
import java.util.ArrayList;

public class Rents {
    private List<Rent> rents;
    private List<Integer> carIDs;

    public Rents() {
        this.rents = new ArrayList<>();
        this.carIDs = new ArrayList<>();
    }

    public void addRent(Rent rent) {
        rents.add(rent);
    }

    public void removeRent(Rent rent) {
        rents.remove(rent);
    }

    public List<Rent> getRents() {
        return rents;
    }

    public List<Integer> getCarIDs() {
        return carIDs;
    }
}
