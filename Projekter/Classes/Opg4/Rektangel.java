public class Rektangel {
    private int yMin;
    private int yMax;
    private int xMin;
    private int xMax;

    /*
     * constructors
     */
    public Rektangel(int yMin, int yMax, int xMin, int xMax) {
        setAll(yMin, yMax, xMin, xMax);
    }

    public Rektangel(Rektangel other) {
        setAll(other.yMin, other.yMax, other.xMin, other.xMax);
    }

    /*
     * setAll
     */
    public void setAll(int yMin, int yMax, int xMin, int xMax) {
        this.yMin = yMin;
        this.yMax = yMax;
        this.xMin = xMin;
        this.xMax = xMax;
    }

    /*
     * general methods
     */
    public boolean equals(Rektangel other) {
        return this.xMax == other.xMax && this.xMin == other.xMin && this.yMax == other.yMax && this.yMin == other.yMin;
    } 

    public String toString() {
        return "Rektanglets x- og y min er: " + this.xMin + ", " + this.yMin + "| Rektanglets x- og y max er: " + this.xMax + ", " + this.yMax;
    }

    /*
     * specielle
     */
    public int areal() {
        return længde(xMin, xMax) * længde(yMin, yMax);
    }

    public int omkreds() {
        return 2 * længde(xMin, xMax) + 2 * længde(yMin, yMax);
    }

    public boolean overlap(Rektangel B) {
        return (B.xMin > this.xMin || B.xMax < this.xMax) && (B.yMin > this.yMin || B.yMax < this.yMax);
    }

    public void move(int deltaX, int deltaY) {
        setAll(yMin - deltaY, yMax - deltaY, xMin - deltaX, xMax - deltaY);
    }

    public Rektangel omkrandsende(Rektangel B) {
        Rektangel omkrandsendeRektangel = new Rektangel(yMin, yMax, xMin, xMax);

        if(this.xMin < B.xMin) {
            omkrandsendeRektangel.xMin = this.xMin;
        }
            else {
                omkrandsendeRektangel.xMin = B.xMin;
            }

        if(this.xMax > B.xMax) {
            omkrandsendeRektangel.xMax = this.xMax;
        }
            else {
                omkrandsendeRektangel.xMax = B.xMax;
            }
        if(this.yMin < B.yMin) {
            omkrandsendeRektangel.yMin = this.yMin;
        }
            else {
                omkrandsendeRektangel.yMin = B.yMin;
            }
        
        if(this.yMax > B.yMax) {
            omkrandsendeRektangel.yMax = this.yMax;
        }
        
            else {
                omkrandsendeRektangel.yMax = B.yMax;
            }
        
        return omkrandsendeRektangel;
    }

    /*
     * service metoder
     */
    private int længde(int zMin, int zMax) {
        return zMax - zMin;
    }
}
