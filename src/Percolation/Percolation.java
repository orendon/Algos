/*
 * Percolation system using WeightedQuickUnionUF algorithm
 * Monte Carlo simulation will be used to calculate threshold value
 *
 * @author Oscar Rendon
 */

// TODO: Refactor methods in order to avoid for-loops
public class Percolation {
    
    private int n;
    private boolean[][] sitesStatus;
    private WeightedQuickUnionUF sites;
    
    // Create a NxN grid with all sites closed
    public Percolation(int N) {
        if (N <= 0) throw new IllegalArgumentException("Invalid grid size.");
        
        n = N;
        sites = new WeightedQuickUnionUF(n*n);
        sitesStatus = new boolean[n][n];
    }
    
    // Open the site on row i and column j
    public void open(int i, int j) {        
        if (!sitesStatus[i-1][j-1]) {
            connectNeighbors(i, j);
            sitesStatus[i-1][j-1] = true;
        }
    }
    
    // Check if a given site is open
    public boolean isOpen(int i, int j) {
        return sitesStatus[i-1][j-1];
    }
    
    // Check if a given  site is fully open
    public boolean isFull(int i, int j) {
        if (!isOpen(i, j)) return false;
        
        int siteIndex = getSiteIndex(i, j);
        int row = 1;
        for (int col = 1; col <= n; col++) {
            if (isOpen(row, col) && sites.connected(siteIndex, getSiteIndex(row, col))) {
                return true;
            }
        }
        
        return false;
    }
    
    // Indicates if the system percolates
    public boolean percolates() {
        int row = n;
        for (int col = 1; col <= n; col++) {
            if (isFull(row, col)) return true;
        }
        
        return false;
    }
    
    // Transform matrix index into array index, valid range (1,1) => (n,n)
    private int getSiteIndex(int i, int j) {
        if (i <= 0 || i > n || j <= 0 || j > n)
            throw new IndexOutOfBoundsException("Invalid row, column indices.");
        
        return n*(i-1) + j-1;
    }
    
    // takes a site, and connect his neighbors
    private void connectNeighbors(int i, int j) {
        int siteIndex = getSiteIndex(i, j);
        
        // upper site
        if (i > 1 && isOpen(i-1, j))
            sites.union(getSiteIndex(i-1, j), siteIndex);
        
        // right site
        if (j < n && isOpen(i, j+1))
            sites.union(getSiteIndex(i, j+1), siteIndex);
        
        // left site
        if (j > 1 && isOpen(i, j-1))
            sites.union(getSiteIndex(i, j-1), siteIndex);
        
        // down site
        if (i < n && isOpen(i+1, j))
            sites.union(getSiteIndex(i+1, j), siteIndex);
    }
}
