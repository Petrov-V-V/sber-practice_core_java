package oop_1.Task5;

public class PizzaOrder {
    private String title;
    private Size size;
    private boolean sauce;
    private String address;
    private boolean accepted = false;

    enum Size {
        SMALL, 
        MEDIUM, 
        BIG
    }

    public PizzaOrder(String title, Size size, boolean sauce, String address){
        this.title = title;
        this.size = size;
        this.sauce = sauce;
        this.address = address;
    }

    public void order(){
        if(accepted){
            System.out.println("The order has already been accepted");
        }else{
            String sauceStr;
            if (sauce){
                sauceStr = "with sauce";
            } else {
                sauceStr = "without sauce";
            }
            System.out.println("Order accepted. " + size + " pizza \"" 
                                + title + "\" " + sauceStr + " to the address "
                                + address);
            accepted = true;
        }
    }

    public void cancel(){
        if (accepted){
            accepted = false;
            System.out.println("Order have cancelled");
        } else {
            System.out.println("The order haven't accepted");
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public boolean isSauce() {
        return sauce;
    }

    public void setSauce(boolean sauce) {
        this.sauce = sauce;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "PizzaOrder (Address = " + address + ", accepted = " + accepted + ", Sauce = " + sauce + ", Size = "
                + size + ", Title = " + title + ")";
    }
}