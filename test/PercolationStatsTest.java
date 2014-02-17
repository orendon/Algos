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
        stats = new PercolationStats(0, 5);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testZeroExperiments() {
        stats = new PercolationStats(1, 0);
    }
    
    @Test
    public void testUndefinedStandarDeviation() {
        stats = new PercolationStats(1, 1);
        
        assertEquals(Double.NaN, stats.stddev(), 0.01);
    }
}
