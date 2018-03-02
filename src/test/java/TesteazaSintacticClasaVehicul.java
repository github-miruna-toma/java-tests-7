import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.Assert.*;

/**
 * Teste ce corespund punctajului 3
 * TODO: cum transmitem clasa ce trebuie verificata (se poate ca nu in toate jarurile sa se afle in acelasi pachet)
 */
public class TesteazaSintacticClasaVehicul {

    Class vehiculClass = Vehicul.class;

    @Test
    public void testeazaVehiculEsteClasaAbstracta() {
        assertTrue(Modifier.isAbstract(vehiculClass.getModifiers()));
    }

    @Test
    public void testeazaAtributulSerieAlClaseiVehicul() {
        try {
            Field serieField = vehiculClass.getDeclaredField("serie");
            assertNotNull(serieField);
            assertTrue("Atributul 'serie' este privat",  Modifier.isPrivate(serieField.getModifiers()));
            assertEquals("Atributul 'serie' este de tip String", serieField.getType(), String.class);
        } catch (NoSuchFieldException nsfe) {
            fail("Atributul 'serie' nu exista in clasa " + vehiculClass);
        }
    }

    @Test
    public void testeazaAtributulTonajAlClaseiVehicul() {
        try {
            Field tonajField = vehiculClass.getDeclaredField("tonaj");
            assertNotNull(tonajField);
            assertTrue("Atributul 'tonaj' este privat",  Modifier.isPrivate(tonajField.getModifiers()));
            assertEquals("Atributul 'tonaj' este de tip Float", tonajField.getType(), Float.class);
        } catch (NoSuchFieldException nsfe) {
            fail("Atributul 'tonaj' nu exista in clasa " + vehiculClass);
        }
    }

    @Test
    public void testeazaAtributulMarcaAlClaseiVehicul() {
        try {
            Field marcaField = vehiculClass.getDeclaredField("marca");
            assertNotNull(marcaField);
            assertTrue("Atributul 'marca' este privat",  Modifier.isPrivate(marcaField.getModifiers()));
            assertTrue("Atributul 'marca' este final",  Modifier.isFinal(marcaField.getModifiers()));
            assertEquals("Atributul 'marca' este de tip String", marcaField.getType(), String.class);
        } catch (NoSuchFieldException nsfe) {
            fail("Atributul 'marca' nu exista in clasa " + vehiculClass);
        }
    }

    @Test
    public void testeazaConstructorAlClaseiVehicul() {
        Constructor[] constructori = vehiculClass.getConstructors();
        assertEquals("Exista un singur constructor definit in clasa " + vehiculClass, constructori.length, 1);

        Constructor constructorDeclarat = constructori[0];
        assertEquals("Exista trei parametri definiti pentru constructorul clasei " + vehiculClass, constructorDeclarat.getParameterCount(), 3);

        Class[] tipuriParametri = constructorDeclarat.getParameterTypes();

        int numarParametriString = 0;
        int numarParametriFloat = 0;
        for(int i=0; i< tipuriParametri.length; i++) {
            numarParametriString = tipuriParametri[i].equals(String.class) ? numarParametriString + 1 : numarParametriString;
            numarParametriFloat = tipuriParametri[i].equals(Float.class) ? numarParametriFloat + 1 : numarParametriFloat;
        }

        assertEquals("Exista doi parametri String ", numarParametriString, 2);
        assertEquals("Exista un parametru Float ", numarParametriFloat, 1);
    }

    @Test
    public void testeazaMetodaDeAccesPentruCampulSerie() {
        try {
            Method metodaAccesSerie = vehiculClass.getMethod("getSerie");
            assertTrue("Metoda de acces serie este publica", Modifier.isPublic(metodaAccesSerie.getModifiers()));
            assertEquals("Metoda get serie intoarce String", metodaAccesSerie.getReturnType(), String.class);
        } catch(NoSuchMethodException nsme) {
            fail("Metoda de acces getSerie() nu este definita");
        }
    }

    @Test
    public void testeazaMetodaDeAccesPentruCampulTonaj() {
        try {
            Method metodaAccesTonaj = vehiculClass.getMethod("getTonaj");
            assertTrue("Metoda de acces tonaj este publica", Modifier.isPublic(metodaAccesTonaj.getModifiers()));
            assertEquals("Metoda get tonaj intoarce Float", metodaAccesTonaj.getReturnType(), Float.class);
        } catch(NoSuchMethodException nsme) {
            fail("Metoda de acces getTonaj() nu este definita");
        }
    }

    @Test
    public void testeazaMetodaDeAccesPentruCampulMarca() {
        try {
            Method metodaAccesMarca = vehiculClass.getMethod("getMarca");
            assertTrue("Metoda de acces marca este publica", Modifier.isPublic(metodaAccesMarca.getModifiers()));
            assertEquals("Metoda get marca intoarce String", metodaAccesMarca.getReturnType(), String.class);
        } catch(NoSuchMethodException nsme) {
            fail("Metoda de acces getMarca() nu este definita");
        }
    }

    @Test
    public void testeazaMetodaAbstractaGetCapacitate() {
        try {
            Method metodaGetCapacitate = vehiculClass.getMethod("getCapacitate");
            assertTrue("Metoda getCapacitate este publica", Modifier.isPublic(metodaGetCapacitate.getModifiers()));
            assertTrue("Metoda getCapacitate este abstracta", Modifier.isAbstract(metodaGetCapacitate.getModifiers()));
            assertEquals("Metoda get marca intoarce Float", metodaGetCapacitate.getReturnType(), Float.class);
        } catch(NoSuchMethodException nsme) {
            fail("Metoda de acces getCapacitate() nu este definita");
        }
    }

}
