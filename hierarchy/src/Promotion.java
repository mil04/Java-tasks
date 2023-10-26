public enum Promotion {
    NONE(0),
    PERCENT(0.4),
    AMOUNT(10),
    TWOFORONE(0.5);

    private double prom;
    Promotion(double prom){
        this.prom=prom;
    }
    public int CalculatePrice(int amount, double price){
        if (prom==0) return (int) (amount*price);
        else if (prom==0.4) {
            int r= (int) (price*(1-prom));
            return amount*r;
        } else if (prom==10) return (int) (amount*(price-10));
        return (int) (price*((amount/2)+amount%2));
    }
}
