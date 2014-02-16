import org.junit.Test;
import static org.junit.Assert.*;

public class PercolationTest {
    
    public PercolationTest() {
    }
    
    @Test(expected=IndexOutOfBoundsException.class)
    public void testZeroGridArguments() {
        Percolation percolation = new Percolation(0);
    }
    
    @Test(expected=IndexOutOfBoundsException.class)
    public void testNegativeGridArguments() {
        Percolation percolation = new Percolation(-1);
    }
    
}
