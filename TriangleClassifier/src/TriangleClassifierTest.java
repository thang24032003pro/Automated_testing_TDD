import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TriangleClassifierTest {

    @Test
    @DisplayName("Cạnh 2, 2, 2 -> tam giác đều")
    public void testEquilateralTriangle() {
        assertEquals("tam giác đều", TriangleClassifier.classify(2, 2, 2));
    }

    @Test
    @DisplayName("Cạnh 2, 2, 3 -> tam giác cân")
    public void testIsoscelesTriangle() {
        assertEquals("tam giác cân", TriangleClassifier.classify(2, 2, 3));
    }

    @Test
    @DisplayName("Cạnh 3, 4, 5 -> tam giác thường")
    public void testNormalTriangle() {
        assertEquals("tam giác thường", TriangleClassifier.classify(3, 4, 5));
    }

    @Test
    @DisplayName("Cạnh 8, 2, 3 -> không phải là tam giác")
    public void testNotATriangleCase1() {
        assertEquals("không phải là tam giác", TriangleClassifier.classify(8, 2, 3));
    }

    @Test
    @DisplayName("Cạnh -1, 2, 1 -> không phải là tam giác")
    public void testNotATriangleCase2() {
        assertEquals("không phải là tam giác", TriangleClassifier.classify(-1, 2, 1));
    }

    @Test
    @DisplayName("Cạnh 0, 2, 1 -> không phải là tam giác")
    public void testNotATriangleCase3() {
        assertEquals("không phải là tam giác", TriangleClassifier.classify(0, 2, 1));
    }
}