package hello.core.order;

public class Order {

    private Long memberId;

    private int itemPrice;

    private String itemName;

    private int disCountPrice;

    public Order (Long memberId, String itemName, int itemPrice, int disCountPrice){
        this.memberId = memberId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.disCountPrice = disCountPrice;
    }

    public int calculatePrice(){
        return itemPrice - disCountPrice;
    }

    public Long getMemberId(){
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getDisCountPrice() {
        return disCountPrice;
    }

    public void setDisCountPrice(int disCountPrice) {
        this.disCountPrice = disCountPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "memberId=" + memberId +
                ", itemPrice=" + itemPrice +
                ", itemName='" + itemName + '\'' +
                ", disCountPrice=" + disCountPrice +
                '}';
    }
}
