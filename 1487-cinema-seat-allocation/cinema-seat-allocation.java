import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        // Map row number to a single integer (our bitmask)
        Map<Integer, Integer> rowToSeats = new HashMap<>();
        
        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];
            
            // Set the 'col'th bit to 1 by using bitwise OR
            rowToSeats.put(row, rowToSeats.getOrDefault(row, 0) | (1 << col));
        }
        
        // Start by calculating groups for completely empty rows
        int totalGroups = (n - rowToSeats.size()) * 2;
        
        // Magic numbers representing our seat blocks in binary
        int leftMask = 60;   // Represents seats 2, 3, 4, 5
        int rightMask = 960; // Represents seats 6, 7, 8, 9
        int middleMask = 240;// Represents seats 4, 5, 6, 7
        
        // Evaluate the rows that actually have reservations
        for (int mask : rowToSeats.values()) {
            
            // Bitwise AND checks if ANY reserved seats overlap with our blocks
            boolean leftAvailable = (mask & leftMask) == 0;
            boolean rightAvailable = (mask & rightMask) == 0;
            boolean middleAvailable = (mask & middleMask) == 0;
            
            if (leftAvailable && rightAvailable) {
                totalGroups += 2;
            } else if (leftAvailable || rightAvailable || middleAvailable) {
                totalGroups += 1;
            }
        }
        
        return totalGroups;
    }
}
