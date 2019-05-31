package unit;

import java.io.Serializable;

public class Year implements Serializable {
    private double vir;
    private double prib;
    private long date;

    public Year(double vir, double prib, long date) {
        this.vir = vir;
        this.prib = prib;
        this.date = date;
    }

    public double getVir() {
        return vir;
    }

    public void setVir(double vir) {
        this.vir = vir;
    }

    public double getPrib() {
        return prib;
    }

    public void setPrib(double prib) {
        this.prib = prib;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }
}
