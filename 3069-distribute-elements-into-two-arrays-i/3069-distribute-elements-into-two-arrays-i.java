import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] resultArray(int[] nums) {
            List<Integer> arr1 = new ArrayList<>();
                    List<Integer> arr2 = new ArrayList<>();

                            // 1. Initial operations
                                    arr1.add(nums[0]);
                                            arr2.add(nums[1]);

                                                    // 2. Process remaining elements starting from index 2
                                                            for (int i = 2; i < nums.length; i++) {
                                                                        if (arr1.get(arr1.size() - 1) > arr2.get(arr2.size() - 1)) {
                                                                                        arr1.add(nums[i]);
                                                                                                    } else {
                                                                                                                    arr2.add(nums[i]);
                                                                                                                                }
                                                                                                                                        }

                                                                                                                                                // 3. Concatenate arr1 and arr2 into result array
                                                                                                                                                        int[] result = new int[nums.length];
                                                                                                                                                                int idx = 0;

                                                                                                                                                                        for (int num : arr1) {
                                                                                                                                                                                    result[idx++] = num;
                                                                                                                                                                                            }
                                                                                                                                                                                                    for (int num : arr2) {
                                                                                                                                                                                                                result[idx++] = num;
                                                                                                                                                                                                                        }

                                                                                                                                                                                                                                return result;
                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                    }