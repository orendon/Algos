/*
 * Percolation system using WeightedQuickUnionUF algorithm
 * Monte Carlo simulation will be used to calculate threshold value
 *
 * @author Oscar Rendon
 */

public class Percolation {
    
    private int n;
    private boolean[] sitesStatus;
    private WeightedQuickUnionUF sites;
    
    // Create a NxN grid with all sites closed
    public Percolation(int N) {
        if (N <= 0) throw new IllegalArgumentException("Invalid grid size.");
        
        n = N;
        sites = new WeightedQuickUnionUF(n*n);
        sitesStatus = new boolean[n*n];
    }
    
    // Open the site on row i and column j
    public void open(int i, int j) {
        int index = getSiteIndex(i, j);
        
        if (!sitesStatus[index]) {
            connectNeighbors(i, j);
            sitesStatus[index] = true;
        }
    }
    
    // Check if a given site is open
    public boolean isOpen(int i, int j){
        return sitesStatus[getSiteIndex(i, j)];
    }
    
    // Check if a given  site is fully open
    public boolean isFull(int i, int j) {        
        int siteIndex = getSiteIndex(i, j);
        int row = 1;
        boolean connectedToTop = false;
        
        for(int col=1; col<=n; col++) {
            if (isOpen(row, col) && sites.connected(siteIndex, getSiteIndex(row, col))) {
                connectedToTop = true;
                break;
            }
        }
        
        return connectedToTop;
    }
    
    // Indicates if the system percolates
    public boolean percolates() {
        int row = n;
        boolean connectedToTop = false;
        
        for(int col=1; col<=n; col++) {
            if (isOpen(row, col) && isFull(row, col)) {
                connectedToTop = true;
                break;
            }
        }
        
        return connectedToTop;
    }
    
    // Grid boundaries from (1,1) to (n,n)
    private void validateRowRanges(int i, int j) {
        if (i <= 0 || i > n || j <= 0 || j > n) {
            throw new IndexOutOfBoundsException("Invalid row, column indices.");
        }
    }
    
    // Transform matrix index into array index
    private int getSiteIndex(int i, int j) {
        validateRowRanges(i, j);
        return n*(i-1) + j-1;
    }
    
    // takes a site, and connect his neighbors
    private void connectNeighbors(int i, int j) {
        int siteIndex = getSiteIndex(i, j);
        
        // upper site
        if(i>1 && isOpen(i-1, j))
            sites.union(getSiteIndex(i-1, j), siteIndex);
        
        // right site
        if(j<n && isOpen(i, j+1))
            sites.union(getSiteIndex(i, j+1), siteIndex);
        
        // left site
        if(j>1 && isOpen(i, j-1))
            sites.union(getSiteIndex(i, j-1), siteIndex);
        
        // down site
        if(i<n && isOpen(i+1, j))
            sites.union(getSiteIndex(i+1, j), siteIndex);
    }
}
