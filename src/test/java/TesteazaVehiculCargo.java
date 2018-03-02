import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by miruna on 3/2/2018.
 */
public class TesteazaVehiculCargo {
    Class clasaVehiculCargo = VehiculCargo.class;

    @Test
    public void testeazaAtributulCapacitateKg() {
        try {
            Field serieField = clasaVehiculCargo.getDeclaredField("capacitateTransportKg");
            assertNotNull(serieField);
            assertTrue("Atributul 'capacitateTransportKg' este privat",  Modifier.isPrivate(serieField.getModifiers()));
            assertEquals("Atributul 'capacitateTransportKg' este de tip Float", serieField.getType(), Float.class);
        } catch (NoSuchFieldException nsfe) {
            fail("Atributul 'capacitateTransportKg' nu exista in clasa " + clasaVehiculCargo);
        }
    }

    @Test(expected = Exception.class)
    public void testeazaConstructorGenereazaExceptie() throws Exception{
        VehiculCargo vehiculCargo = new VehiculCargo(-20.0f, "ABC", 3.0f, "MARCA1");
    }

    @Test
    public void testeazaGetCapacitate() throws Exception {
        VehiculCargo vehiculCargo = new VehiculCargo(20.0f, "ABC", 3.0f, "MARCA1");
        assertEquals("getCapacitate() intoarce capacitatea in kilograme", vehiculCargo.getCapacitate(), new Float(20.0f));
    }

    @Test
    public void testeazaClone() {}

    @Test
    public void testeazaEquals() {}
}
