package by.company.kaliaha.util.plane_comparator;

import java.util.Comparator;

import by.company.kaliaha.plane.Aircraft;

public class AircraftComparatorBuilder {
    private Comparator<Aircraft> comparator;

    public AircraftComparatorBuilder(Comparator<Aircraft> comparator) {
        this.comparator = comparator;
    }

    public Comparator<Aircraft> build() {
        return comparator;
    }

    public AircraftComparatorBuilder compareByFreighterCapacity() {
        comparator = comparator.thenComparing(new FreinghterCapacityComparator());
        return this;
    }

    public AircraftComparatorBuilder compareByFuelConsumption() {
        comparator = comparator.thenComparing(new FuelConsumptionComparator());
        return this;
    }

    public AircraftComparatorBuilder compareByPassengerCapacity() {
        comparator = comparator.thenComparing(new PassengerCapacityComparator());
        return this;
    }

    public AircraftComparatorBuilder compareByPlaneName() {
        comparator = comparator.thenComparing(new AircraftNameComparator());
        return this;
    }
}
