import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;


public class TestMonkey {
    //This test checks to see that the corrected generated id is returned when a valid int is passed in
    @Test
    public void testGenerateIdCase1() {
        int offset = 223492;
        int n = 1;
        int expected = n + offset;

        int observed = new Monkey(n).generateId(n);
        assertEquals(expected, observed);
    }

    //This test checks to see that the corrected generated id is returned when a valid, bigger int is passed in
    @Test
    public void testGenerateIdCase2() {
        int offset = 223492;
        int n = 484;
        int expected = n + offset;

        int observed = new Monkey(n).generateId(n);
        assertEquals(expected, observed);
    }

    //This test checks to see that the corrected generated id is returned when a valid, even bigger int is passed in
    @Test
    public void testGenerateIdCase3() {
        int offset = 223492;
        int n = 1300;
        int expected = n + offset;

        int observed = new Monkey(n).generateId(n);
        assertEquals(expected, observed);
    }

    //This test the monkey constructor with monkey number of 0
    @Test
    public void testMonkey0() {
        int expected = 0;

        int observed = new Monkey(0).getMonkeyNum();
        assertEquals(expected, observed);
    }

    //This test the monkey constructor with monkey number of 0
    @Test
    public void testMonkey42() {
        int expected = 42;

        int observed = new Monkey(42).getMonkeyNum();
        assertEquals(expected, observed);
    }

}