import java.util.*;

class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
            // Bitmasks representing seat availability (bits 0 to 7 mapping to seats 2 to 9)
                    int left = 0b11110000;   // Seats 2, 3, 4, 5
                            int middle = 0b11000011; // Seats 4, 5, 6, 7
                                    int right = 0b00001111;  // Seats 6, 7, 8, 9

                                            Map<Integer, Integer> occupied = new HashMap<>();

                                                    // Build bitmask for occupied seats per row
                                                            for (int[] seat : reservedSeats) {
                                                                        int row = seat[0];
                                                                                    int col = seat[1];
                                                                                                if (col >= 2 && col <= 9) {
                                                                                                                int bitmask = occupied.getOrDefault(row, 0);
                                                                                                                                occupied.put(row, bitmask | (1 << (col - 2)));
                                                                                                                                            }
                                                                                                                                                    }

                                                                                                                                                            // Unoccupied rows can accommodate 2 families each
                                                                                                                                                                    int ans = (n - occupied.size()) * 2;

                                                                                                                                                                            // Evaluate rows with reserved seats
                                                                                                                                                                                    for (int bitmask : occupied.values()) {
                                                                                                                                                                                                boolean canFitLeft = (bitmask | left) == left;
                                                                                                                                                                                                            boolean canFitRight = (bitmask | right) == right;

                                                                                                                                                                                                                        if (canFitLeft && canFitRight) {
                                                                                                                                                                                                                                        ans += 2;
                                                                                                                                                                                                                                                    } else if (canFitLeft || canFitRight || (bitmask | middle) == middle) {
                                                                                                                                                                                                                                                                    ans += 1;
                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                        }

                                                                                                                                                                                                                                                                                                return ans;
                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                    }