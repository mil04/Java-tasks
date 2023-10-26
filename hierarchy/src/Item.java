public abstract class Item implements Sellable{
    private Promotion prom;
    private int amount;
    private double price;
    public Item(Promotion prom,  double price, int amount ){
        this.price=price;
        this.prom=prom;
        this.amount=amount;
    }
    public int GetAmount(){
        return amount;
    }
    public int GetCost(int number){
        return prom.CalculatePrice(number,price);
    }
    public boolean IsAvailable(int number){
        return amount>=number;
    }

    @Override
    public boolean Sell(int number) {
        if(IsAvailable(number)){
            amount-=number;
            return true;
        }
        System.out.println("Amount not available!");
        return false;
    }
}
