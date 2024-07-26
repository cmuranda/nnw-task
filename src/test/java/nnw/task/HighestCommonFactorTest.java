package nnw.task;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class HighestCommonFactorTest {
    @InjectMocks
    private HighestCommonFactor highestCommonFactor;
    @Test
    void highestCommonFactor() {
        assertEquals(3, HighestCommonFactor.highestCommonFactor(27, 30));
        assertEquals(7, HighestCommonFactor.highestCommonFactor(14, 35));
    }

    @Test
    void highestCommonFactor_equalNumbers() {
        assertEquals(5, HighestCommonFactor.highestCommonFactor(5, 5));
        assertEquals(0, HighestCommonFactor.highestCommonFactor(0, 0));
    }

    @Test
    void highestCommonFactor_negativeValues() {
        assertEquals(-3, HighestCommonFactor.highestCommonFactor(-3, 6));
        assertEquals(-8, HighestCommonFactor.highestCommonFactor(-16, -8));
    }

    @Test
    void highestCommonFactor_noFactors() {
        assertEquals(1, HighestCommonFactor.highestCommonFactor(11, 97));
        assertEquals(1, HighestCommonFactor.highestCommonFactor(15, 19));
    }

    @Test
    void testHighestCommonFactor() {
        assertEquals(3, highestCommonFactor.highestCommonFactor(new int[]{3, 3}));
        assertEquals(1, highestCommonFactor.highestCommonFactor(new int[]{1, 2}));
        assertEquals(9, highestCommonFactor.highestCommonFactor(new int[]{45, 81, 918, 63}));
        assertEquals(6, highestCommonFactor.highestCommonFactor(new int[]{12, 48, 72, 18, 0}));
    }


    @Test
    void testHighestCommonFactor_emptySet() {
        assertEquals(0, highestCommonFactor.highestCommonFactor(new int[]{}));

    }
    @Test
    void testHighestCommonFactor_zeros() {
        assertEquals(0, highestCommonFactor.highestCommonFactor(new int[]{0, 0}));
        assertEquals(0, highestCommonFactor.highestCommonFactor(new int[]{0, 0, 0, 0}));
        assertEquals(0, highestCommonFactor.highestCommonFactor(new int[]{0}));

    }
    @Test
    void testHighestCommonFactor_negatives() {
        assertEquals(-3, highestCommonFactor.highestCommonFactor(new int[]{-3, 3}));
        assertEquals(-1, highestCommonFactor.highestCommonFactor(new int[]{-1, 2}));
        assertEquals(9, highestCommonFactor.highestCommonFactor(new int[]{45, 81, -918}));
    }

    @Test
    void testHighestCommonFactor_noFactors() {
        assertEquals(1, highestCommonFactor.highestCommonFactor(new int[]{31, 13}));
        assertEquals(1, highestCommonFactor.highestCommonFactor(new int[]{1, 2}));
        assertEquals(1, highestCommonFactor.highestCommonFactor(new int[]{45, 83, 17}));
        assertEquals(1, highestCommonFactor.highestCommonFactor(new int[]{1, 45, 67, 99}));
        assertEquals(1, highestCommonFactor.highestCommonFactor(new int[]{3, 11, 19, 31}));
    }
}