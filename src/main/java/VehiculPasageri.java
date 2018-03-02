import java.util.Set;

/**
 * Created by miruna on 3/2/2018.
 */
public class VehiculPasageri extends Vehicul{

    private Float nrLocuri;
    private Set<String> cnpPasageri;

    public VehiculPasageri(Float nrLocuri, String serie, Float tonaj, String marca) throws Exception{
        super(serie, tonaj, marca);
        if(nrLocuri < 0) throw new Exception("Numarul de locuri nu poate fi negativ");
        this.nrLocuri = nrLocuri;
    }

    public Float getCapacitate() {
        return this.nrLocuri;
    }

    public void setCnpPasageri(Set<String> cnpPasageri) {
        this.cnpPasageri = cnpPasageri;
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
