package Assestment_6;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolitaireGameTest {

    @Test
    void initializeList() {
        ArrayListWithIterator<Integer> theList = new ArrayListWithIterator<>();
        SolitaireGame.initializeList(theList);
        assertEquals(40, theList.size(), "The list should have 40 elements");
        for (int number : theList) {
            assertTrue(number >= 10 && number <= 99, "The numbers should be between 10 and 99");
        }
    }

    @Test
    void removable() {
        assertTrue(SolitaireGame.removable(23, 25), "Both numbers have the same tens digit");
        assertTrue(SolitaireGame.removable(44, 84), "Both numbers have the same units digit");
        assertFalse(SolitaireGame.removable(23, 56), "Different tens and units digits");
    }

    @Test
    void scanAndRemovePairs_noRemovablePairs() {
        ArrayListWithIterator<Integer> theList = new ArrayListWithIterator<>();
        List<Integer> expectedList = new ArrayList<>();

        theList.add(11);
        theList.add(22);
        theList.add(33);
        theList.add(44);
        theList.add(55);

        expectedList.add(11);
        expectedList.add(22);
        expectedList.add(33);
        expectedList.add(44);
        expectedList.add(55);

        System.out.println("List before checking for removable pairs: " + Arrays.toString(theList.toArray()));
        boolean removed = SolitaireGame.scanAndRemovePairs(theList);
        System.out.println("List after checking for removable pairs: " + Arrays.toString(theList.toArray()));
        System.out.println("- - - - - - - - - - - - - - - - - - -");
        assertFalse(removed, "No pairs should be removed");
        assertEquals(Arrays.toString(expectedList.toArray()), Arrays.toString(theList.toArray()), "The lists should match after checking for removable pairs");
    }

    @Test
    void scanAndRemovePairs() {
        ArrayListWithIterator<Integer> theList = new ArrayListWithIterator<>();
        List<Integer> expectedList = new ArrayList<>();

        theList.add(72);
        theList.add(76);
        theList.add(80);
        theList.add(46);

        expectedList.add(72);
        expectedList.add(80);
        expectedList.add(46);

        System.out.println("List before checking for removable pairs: " + Arrays.toString(theList.toArray()));
        boolean removed = SolitaireGame.scanAndRemovePairs(theList);
        System.out.println("List after checking for removable pairs: " + Arrays.toString(theList.toArray()));
        System.out.println("- - - - - - - - - - - - - - - - - - -");
        assertTrue(removed, "At least one pair should be removed");
        assertEquals(Arrays.toString(expectedList.toArray()), Arrays.toString(theList.toArray()), "The lists should match after removing pairs");
    }
}

