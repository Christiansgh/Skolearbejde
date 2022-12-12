package Opg1.Post;

public abstract class Forsendelse {
    private int gram;

    public Forsendelse(int gram) {
        this.gram = gram;
    }

    public int getGram() {
        return gram;
    }

    public abstract double porto();

    protected double ranges(int lowerBound, int upperBound, int weight, double price) {
        if(lowerBound < weight && weight > upperBound) {
            return price;
        }
        return Double.NaN;
    }
}
