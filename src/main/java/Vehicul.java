/**
 * Created by miruna on 3/2/2018.
 */
public abstract class Vehicul {
    private String serie;
    private Float tonaj;
    private final String marca;

    public Vehicul(String serie, Float tonaj, String marca) {
        this.serie = serie;
        this.tonaj = tonaj;
        this.marca = marca;
    }

    public String getSerie() {
        return this.serie;
    }

    public Float getTonaj() {
        return this.tonaj;
    }

    public String getMarca() {
        return this.marca;
    }

    public abstract Float getCapacitate();
}
