import java.util.Set;

/**
 * Created by miruna on 3/2/2018.
 */
public class VehiculCargo extends Vehicul {

    private Float capacitateTransportKg;
    private Set<String> serieMarfuri;

    public VehiculCargo(Float capacitate, String serie, Float tonaj, String marca) throws Exception{
        super(serie, tonaj, marca);
        if(capacitate < 0) throw new Exception("Capacitatea de transport nu poate fi negativa");
        this.capacitateTransportKg = capacitate;
    }

    public Float getCapacitate() {
        return this.capacitateTransportKg;
    }

    public void setSerieMarfuri(Set<String> serieMarfuri) {
        this.serieMarfuri = serieMarfuri;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
