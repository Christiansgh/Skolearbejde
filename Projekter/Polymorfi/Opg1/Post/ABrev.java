package Opg1.Post;
public class ABrev extends Brev {
    public ABrev(int gram) {
        super(gram);
    }

    @Override
    public double porto() {
        if(getGram() > 0 && getGram() < 2000)
            ranges(0, 20, getGram(), 4);
            ranges(20, 100, getGram(), 5.25);
            ranges(20, 100, getGram(), 9.25);
            ranges(20, 100, getGram(), 16);
            ranges(20, 100, getGram(), 20);
            ranges(20, 100, getGram(), 28);
    }
    

}
