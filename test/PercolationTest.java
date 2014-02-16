import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class PercolationTest {
    
    final int N = 10;
    private Percolation percolation;
    
    @Before
    public void setUp() {
        percolation = new Percolation(2);
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
    
    @Test
    public void testSiteOpening() {
        assertFalse(percolation.isOpen(1, 1));
        percolation.open(1, 1);
        assertTrue(percolation.isOpen(1, 1));
    }
    
    @Test
    public void testAGivenSiteIsFullyOpen() {
        percolation.open(1, 1);
        percolation.open(2, 2);
        assertFalse(percolation.isFull(2,2));
        
        percolation.open(1, 2);
        assertTrue(percolation.isFull(2,2));
    }
    
    @Test
    public void testTheWholeSystemPercolates() {
        percolation.open(2, 2);
        assertFalse(percolation.percolates());
        
        percolation.open(1, 2);
        assertTrue(percolation.percolates());
    }
}
