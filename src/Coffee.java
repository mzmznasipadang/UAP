public class Coffee {

    private String name;
    private String flavor;
    private int price;
    private String ID;

    public Coffee(String name, String flavor, int price, String ID){

        this.name = name;
        this.flavor = flavor;
        this.price = price;
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
}
