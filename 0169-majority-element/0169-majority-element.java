class Solution {
        public int majorityElement(int[] nums) {
                Map<Integer, Integer> counts = new HashMap<>();
                        int target = nums.length / 2;

                                for (int num : nums) {
                                            int count = counts.getOrDefault(num, 0) + 1;
                                                        if (count > target) {
                                                                        return num;
                                                                                    }
                                                                                                counts.put(num, count);
                                                                                                        }

                                                                                                                return -1;
                                                                                                                    }
                                                                                                                    }
