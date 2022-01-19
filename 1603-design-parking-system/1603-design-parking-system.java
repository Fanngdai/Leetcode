class ParkingSystem {
    int big, medium, small;
    
    public ParkingSystem(int big, int medium, int small) {
        this.big = big;
        this.medium = medium;
        this.small = small;
    }
    
    public boolean addCar(int carType) {
        switch(carType) {
            case 1:
                // big car
                return this.big-- > 0 ? true : false;
            case 2:
                return this.medium-- > 0 ? true : false;
            case 3:
                // small car
                return this.small-- > 0 ? true : false;
            default:
                return false;
        }
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */