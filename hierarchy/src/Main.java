public class Main {
    public static void main(String[] args) {
        // ETAP 1
        System.out.println("Part 1");

        int amount = 5;
        double price = 100;

        System.out.println("Buying " + amount +  " items of price " + price + ": ");

        for(Promotion p : Promotion.values()) {
            System.out.println(p.name() + " price: " + p.CalculatePrice(amount, price));
        }
        System.out.println();

        // ETAP 2
        System.out.println("Part 2");

        Item[] items = {
                new Bike(Promotion.NONE, 1000, 3),
                new Bike(Promotion.AMOUNT, 1000, 4),
                new Skateboard(400, 5),
                new Bike(Promotion.TWOFORONE, 5000, 1),
        };

        for(Item i : items) {
            System.out.println(i.getClass().toString().split(" ")[1]);
            System.out.println("Amount: " + i.GetAmount());
            System.out.println("Can buy 4: " + i.IsAvailable(4));
            System.out.println("Price for 2: " + i.GetCost(2));
            System.out.println();
        }
//
//        // ETAP 3
        System.out.println("Part 3");

        for(Item i : items) {
            System.out.println(i.getClass().toString().split(" ")[1]);
            System.out.println("Amount: " + i.GetAmount());
            System.out.println("Buying two items...");
            i.Sell(2);
            System.out.println("Amount: " + i.GetAmount());
            System.out.println();
        }

        // ETAP 4
        System.out.println("Part 4");
        System.out.println("Total price: " + Skateboard.TotalPrice());
        new Skateboard(100, 10);
        System.out.println("Total price: " + Skateboard.TotalPrice());
        new Skateboard(0, 100);
        System.out.println("Total price: " + Skateboard.TotalPrice());
        System.out.println();

        // ETAP 5
        System.out.println("Part 5");
        int[] amounts1 = { 1, 2, 3, 4, 5};
        int[] amounts2 = { 2, 2, 2, 2, 2};
        int[] amounts3 = { 3, 3, 3, 3, 3};

        double[] prices1 = { 10, 10, 10, 10, 10};
        double[] prices2 = { 1000, 1000, 1000, 1000, 1000};
        double[] prices3 = { 100000, 100000, 100000, 100000, 100000};

        System.out.println(Bike.ApplyBestPromotion(prices1, amounts1));
        System.out.println(Bike.ApplyBestPromotion(prices2, amounts2));
        System.out.println(Bike.ApplyBestPromotion(prices3, amounts3));
        System.out.println();
    }
}