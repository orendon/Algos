/*
 * Percolation system using WeightedQuickUnionUF algorithm
 * Monte Carlo simulation will be used to calculate threshold value
 *
 * @author Oscar Rendon
 */

public class Percolation {
    
    private int n;
    private boolean[] sitesStatus;
    
    // Create a NxN grid with all sites closed
    public Percolation(int N) {
        if (N <= 0) throw new IllegalArgumentException("Invalid grid size.");
        
        n = N;
        sitesStatus = new boolean[n*n];
    }
    
    // Open the site on row i and column j
    public void open(int i, int j) {
        sitesStatus[getSiteIndex(i, j)] = true;
    }
    
    // Check if a given site is open
    public boolean isOpen(int i, int j){
        return sitesStatus[getSiteIndex(i, j)];
    }
    
    // Check if a given  site is fully open
    public boolean isFull(int i, int j) {
        validateRowRanges(i, j);
        
        return false;
    }
    
    // Indicates if the system percolates
    public boolean percolates() {
        return false;
    }
    
    // Grid boundaries from (1,1) to (n,n)
    private void validateRowRanges(int i, int j) {
        if (i <= 0 || i > n || j <= 0 || j > n) {
            throw new IndexOutOfBoundsException("Invalid row, column indices.");
        }
    }
    
    // Transform matrix index into array index
    private int getSiteIndex(int i, int j) {
        return n*(i-1) + j-1;
    }
}
