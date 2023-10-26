public class Bike extends Item{
    private static int n=1;
    public Bike(Promotion prom,  double price, int amount){
        super(prom,price,amount);
    }
    @Override
    public boolean Sell(int number){
        if(n==1) {
            System.out.println("First bike has been sold!");
        }
        n=0;
        return super.Sell(number);
    }

    public static Promotion ApplyBestPromotion(double[] prices,int[] tab){
        int[] result= new int[3];
        result[0]=0;
        result[1]=0;
        result[2]=0;
        for(int i=0;i< tab.length;i++){
            Bike i0= new Bike(Promotion.PERCENT,prices[0],tab[0]);
            Bike i1= new Bike(Promotion.AMOUNT,prices[1],tab[1]);
            Bike i2= new Bike(Promotion.TWOFORONE,prices[2],tab[2]);
            result[0]+= i0.GetCost(tab[0]);
            result[1]+= i1.GetCost(tab[1]);
            result[2]+= i2.GetCost(tab[2]);
        }
        if(result[0]<=result[1] && result[0]<=result[2]) return Promotion.PERCENT;
        else if (result[1]<=result[2] && result[1]<=result[0]) return Promotion.AMOUNT;
        return Promotion.TWOFORONE;
    }
}
