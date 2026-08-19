import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        // Map to store row numbers and a set of their reserved seats
        Map<Integer, Set<Integer>> rowToSeats = new HashMap<>();
        
        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];
            
            // We only care about seats 2 through 9
            if (col >= 2 && col <= 9) {
                rowToSeats.putIfAbsent(row, new HashSet<>());
                rowToSeats.get(row).add(col);
            }
        }
        
        // Start by calculating groups for completely empty rows
        int totalGroups = (n - rowToSeats.size()) * 2;
        
        // Evaluate the rows that actually have reservations
        for (Set<Integer> reserved : rowToSeats.values()) {
            
            // Check availability of the three possible blocks
            boolean leftAvailable = !reserved.contains(2) && !reserved.contains(3) 
                                 && !reserved.contains(4) && !reserved.contains(5);
                                 
            boolean rightAvailable = !reserved.contains(6) && !reserved.contains(7) 
                                  && !reserved.contains(8) && !reserved.contains(9);
                                  
            boolean middleAvailable = !reserved.contains(4) && !reserved.contains(5) 
                                   && !reserved.contains(6) && !reserved.contains(7);
            
            // Greedy allocation
            if (leftAvailable && rightAvailable) {
                totalGroups += 2;
            } else if (leftAvailable || rightAvailable || middleAvailable) {
                totalGroups += 1;
            }
        }
        
        return totalGroups;
    }
}