public class Skateboard extends Item {

    private static double totalPrice = 0;
    private double boardPrice;

    public Skateboard(double price, int amount) {
        super(Promotion.PERCENT, price, amount);
        boardPrice = price;

        totalPrice += Promotion.PERCENT.CalculatePrice(amount, price);
    }

    @Override
    public boolean Sell(int requestedAmount) {

        boolean success = super.Sell(requestedAmount);
        totalPrice -= Promotion.PERCENT.CalculatePrice(requestedAmount, boardPrice);

        return success;

    }

    public static double TotalPrice() {
        return totalPrice;
    }

}
