import org.junit.Test;
import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;



public class TestMonkeySim {
    //This test checks to make sure 3 valid strings with correct use of the program multiple by 3 and plus 1 algorithm can be formatted
    @Test
    public void testStringifyResultsCase1() {
        String expected = "//Round 1: Threw banana from Monkey (#5 / ID 223497) to Monkey (#16 / ID 223508)";
        Monkey m1 = Mockito.mock(Monkey.class);
        Monkey m2 = Mockito.mock(Monkey.class);
        Mockito.when(m1.getMonkeyNum()).thenReturn(5);
        Mockito.when(m2.getMonkeyNum()).thenReturn(16);
        try {
            Mockito.when(m1.getId()).thenReturn(223497);
            Mockito.when(m2.getId()).thenReturn(223508);
        } catch (NoIdException nie) {
            fail();
        }
        String observed = MonkeySim.stringifyResults(1, m1, m2);

        assertEquals(expected, observed);
    }

    //This test checks to make sure 3 valid strings with correct use of the program even/divide algorithm can be formatted (continuation of previous test)
    @Test
    public void testStringifyResultsCase2() {
        String expected = "//Round 2: Threw banana from Monkey (#16 / ID 223508) to Monkey (#8 / ID 223500)";
        Monkey m1 = Mockito.mock(Monkey.class);
        Monkey m2 = Mockito.mock(Monkey.class);
        Mockito.when(m1.getMonkeyNum()).thenReturn(16);
        Mockito.when(m2.getMonkeyNum()).thenReturn(8);
        try {
            Mockito.when(m1.getId()).thenReturn(223508);
            Mockito.when(m2.getId()).thenReturn(223500);
        } catch (NoIdException nie) {
            fail();
        }
        String observed = MonkeySim.stringifyResults(2, m1, m2);

        assertEquals(expected, observed);
    }

    //This test checks to make sure 3 valid strings with correct use of the program even/divide algorithm can be formatted (continuation of previous test)
    @Test
    public void testStringifyResultsCase3() {
        String expected = "//Round 3: Threw banana from Monkey (#8 / ID 223500) to Monkey (#4 / ID 223496)";
        Monkey m1 = Mockito.mock(Monkey.class);
        Monkey m2 = Mockito.mock(Monkey.class);
        Mockito.when(m1.getMonkeyNum()).thenReturn(8);
        Mockito.when(m2.getMonkeyNum()).thenReturn(4);
        try {
            Mockito.when(m1.getId()).thenReturn(223500);
            Mockito.when(m2.getId()).thenReturn(223496);
        } catch (NoIdException nie) {
            fail();
        }
        String observed = MonkeySim.stringifyResults(3, m1, m2);

        assertEquals(expected, observed);
    }

    //This tests checks to see if a null pointer is thrown if null is passed into the get first monkey function
    @Test
    public void testGetFirstMonkeyNull() {
        try {
            MonkeySim.getFirstMonkey(null);
            fail();
        } catch (NullPointerException npe) {
            assertTrue(true);
        }
    }

    //This test checks to see if null is returned with zero monkeys in the list
    public void testGetFirstMonkeyEmpty() {
        List<Monkey> ms = new LinkedList<>();
        Monkey expected = null;
        Monkey observed = MonkeySim.getFirstMonkey(ms);
        assertEquals(expected, observed);
    }

    //This test checks to see if null is returned with one monkey in the list
    @Test
    public void testGetFirstMonkeySingleton() {
        Monkey m1 = Mockito.mock(Monkey.class);
        Mockito.when(m1.getMonkeyNum()).thenReturn(0);
        List<Monkey> ms = new LinkedList<>();
        ms.add(m1);

        Monkey expected = null;
        Monkey observed = MonkeySim.getFirstMonkey(ms);
        assertEquals(expected, observed);
    }

    //This test checks to see if null is returned with two monkeys in the list
    @Test
    public void testGetFirstMonkeyTwoElements() {
        Monkey m1 = Mockito.mock(Monkey.class);
        Monkey m2 = Mockito.mock(Monkey.class);
        Mockito.when(m1.getMonkeyNum()).thenReturn(0);
        Mockito.when(m2.getMonkeyNum()).thenReturn(1);
        List<Monkey> ms = new LinkedList<>();
        ms.add(m1);
        ms.add(m2);

        Monkey expected = null;
        Monkey observed = MonkeySim.getFirstMonkey(ms);
        assertEquals(expected, observed);
    }

    //This test checks to see if the first monkey in the list is returned with three monkeys in the monkey list
    @Test
    public void testGetFirstMonkeyThreeElements() {
        Monkey m1 = Mockito.mock(Monkey.class);
        Monkey m2 = Mockito.mock(Monkey.class);
        Monkey m3 = Mockito.mock(Monkey.class);
        Mockito.when(m1.getMonkeyNum()).thenReturn(0);
        Mockito.when(m2.getMonkeyNum()).thenReturn(1);
        Mockito.when(m3.getMonkeyNum()).thenReturn(2);
        List<Monkey> ms = new LinkedList<>();
        ms.add(m1);
        ms.add(m2);
        ms.add(m3);

        Monkey expected = m2;
        Monkey observed = MonkeySim.getFirstMonkey(ms);
        assertEquals(expected, observed);
    }

    //This test checks the prime monkey sequence for 15
    @Test
    public void testPrimeSequence15() {
        List<Integer> seq = MonkeySim.primeSequence(15);
        Object[] observed = seq.toArray();
        Object[] expected = {15, 13, 11, 7, 5, 3, 2, 1};
        assertArrayEquals(expected, observed);
    }

    //This test checks the prime monkey sequence for 8
    @Test
    public void testPrimeSequence8() {
        List<Integer> seq = MonkeySim.primeSequence(8);
        Object[] observed = seq.toArray();
        Object[] expected = {8, 7, 5, 3, 2, 1};
        assertArrayEquals(expected, observed);
    }

    //This test checks the prime monkey sequence for 3
    @Test
    public void testPrimeSequence3() {
        List<Integer> seq = MonkeySim.primeSequence(3);
        Object[] observed = seq.toArray();
        Object[] expected = {3, 2, 1};
        assertArrayEquals(expected, observed);
    }

    //This test checks the prime monkey sequence for 1
    @Test
    public void testPrimeSequence1() {
        List<Integer> seq = MonkeySim.primeSequence(1);
        Object[] observed = seq.toArray();
        Object[] expected = {1};
        assertArrayEquals(expected, observed);
    }


}