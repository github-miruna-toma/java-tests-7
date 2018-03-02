import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import static org.junit.Assert.*;

/**
 * Created by miruna on 3/2/2018.
 */
public class TesteazaVehiculPasageri {

    Class vehiculPasageri = VehiculPasageri.class;

    @Test
    public void testeazaAtributulNrLocuri() {
        try {
            Field serieField = vehiculPasageri.getDeclaredField("nrLocuri");
            assertNotNull(serieField);
            assertTrue("Atributul 'nrLocuri' este privat",  Modifier.isPrivate(serieField.getModifiers()));
            assertEquals("Atributul 'nrLocuri' este de tip Float", serieField.getType(), Float.class);
        } catch (NoSuchFieldException nsfe) {
            fail("Atributul 'nrLocuri' nu exista in clasa " + vehiculPasageri);
        }
    }

    @Test(expected = Exception.class)
    public void testeazaConstructorGenereazaExceptie() throws Exception{
        VehiculPasageri vehiculPasageri = new VehiculPasageri(-2.0f, "ABC", 3.0f, "MARCA1");
    }

    @Test
    public void testeazaGetCapacitate() throws Exception {
        VehiculPasageri vehiculPasageri = new VehiculPasageri(2.0f, "ABC", 3.0f, "MARCA1");
        assertEquals("getCapacitate() intoarce numarul de locuri", vehiculPasageri.getCapacitate(), new Float(2.0f));
    }

    @Test
    public void testeazaClone() {}

    @Test
    public void testeazaEquals() {}
}
