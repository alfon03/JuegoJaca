package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import procedimientos.Element;
import procedimientos.ElementType;

import org.junit.Assert;


public class ElementTest {

    @Test
    public void testToString() {
        Element element = new Element(ElementType.ROCA);
        String expected = "Elemento, tipo = ROCA";
        String actual = element.toString();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetTipo() {
        Element element = new Element(ElementType.ELFO);
        ElementType expected = ElementType.ELFO;
        ElementType actual = element.getTipo();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testHashCode() {
        Element element1 = new Element(ElementType.DINERO);
        Element element2 = new Element(ElementType.DINERO);
        Assert.assertEquals(element1.hashCode(), element2.hashCode());
    }

    @Test
    public void testEquals() {
        Element element1 = new Element(ElementType.DINERO);
        Element element2 = new Element(ElementType.DINERO);
        Element element3 = new Element(ElementType.GEMA);
        Assert.assertEquals(element1, element2);
        Assert.assertNotEquals(element1, element3);
    }
}

