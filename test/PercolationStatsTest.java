import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class PercolationStatsTest {
    
    final int N = 10;
    final int T = 10;
    private PercolationStats stats;
    
    @Before
    public void setUp() {
        stats = new PercolationStats(2, 2);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testZeroGridSize() {
        PercolationStats stats = new PercolationStats(0, 5);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testZeroExperiments() {
        PercolationStats stats = new PercolationStats(0, 5);
    }
}
