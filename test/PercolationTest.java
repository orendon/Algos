import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class PercolationTest {
    
    final int N = 10;
    private Percolation percolation;
    
    @Before
    public void setUp() {
        percolation = new Percolation(N);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testZeroGridArguments() {
        Percolation percolation = new Percolation(0);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testNegativeGridArguments() {
        Percolation percolation = new Percolation(-1);
    }
    
    @Test(expected=IndexOutOfBoundsException.class)
    public void testInvalidRangeWhileOpeningASite() {
        percolation.open(0, 0);
    }
    
    @Test(expected=IndexOutOfBoundsException.class)
    public void testInvalidRangeWhileCheckingOpenSite() {
        percolation.isOpen(N, N+1);
    }
    
    @Test(expected=IndexOutOfBoundsException.class)
    public void testInvalidRangeWhileCheckingFullSite() {
        percolation.isFull(N+1, 0);
    }
    
}
