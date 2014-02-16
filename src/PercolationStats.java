/*
 * Perform a serie of computational experiments over Percolation
 *
 * @author Oscar Rendon
 */

public class PercolationStats {
    
    private int n, t;
    
    // T experiments on a NxN grid
    public PercolationStats(int N, int T) {
        if (N <= 0) throw new IllegalArgumentException("Invalid grid size.");
        if (T <= 0) throw new IllegalArgumentException("Invalid number of experiments.");
        
        n = N;
        t = T;
    }
    
    // sample mean of percolation threshold
    public double mean() {
        return 0;
    }
    
    // sample standard deviation of percolation threshold
    public double stddev() {
        return 0;
    }
    
    // returns lower bound of the 95% confidence interval
    public double confidenceLo() {
        return 0;
    }
    
    // returns upper bound of the 95% confidence interval
    public double confidenceHi() {
        return 0;
    }
    
    // test client
    public static void main(String[] args) {
    }
}
