import java.util.HashMap;
import java.util.Map;

class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
            if (numerator == 0) return "0";

                    StringBuilder sb = new StringBuilder();
                            
                                    // Handle negative sign (using XOR to check if signs differ)
                                            if ((numerator < 0) ^ (denominator < 0)) {
                                                        sb.append("-");
                                                                }

                                                                        // Convert to long to avoid integer overflow with Integer.MIN_VALUE (-2147483648)
                                                                                long num = Math.abs((long) numerator);
                                                                                        long den = Math.abs((long) denominator);

                                                                                                // Integer part
                                                                                                        sb.append(num / den);
                                                                                                                long remainder = num % den;

                                                                                                                        if (remainder == 0) return sb.toString();

                                                                                                                                // Fractional part
                                                                                                                                        sb.append(".");
                                                                                                                                                Map<Long, Integer> map = new HashMap<>();

                                                                                                                                                        while (remainder != 0) {
                                                                                                                                                                    // If remainder already exists, we found a repeating cycle
                                                                                                                                                                                if (map.containsKey(remainder)) {
                                                                                                                                                                                                int index = map.get(remainder);
                                                                                                                                                                                                                sb.insert(index, "(");
                                                                                                                                                                                                                                sb.append(")");
                                                                                                                                                                                                                                                break;
                                                                                                                                                                                                                                                            }

                                                                                                                                                                                                                                                                        // Record remainder and its starting position in the string
                                                                                                                                                                                                                                                                                    map.put(remainder, sb.length());
                                                                                                                                                                                                                                                                                                remainder *= 10;
                                                                                                                                                                                                                                                                                                            sb.append(remainder / den);
                                                                                                                                                                                                                                                                                                                        remainder %= den;
                                                                                                                                                                                                                                                                                                                                }

                                                                                                                                                                                                                                                                                                                                        return sb.toString();
                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                            }