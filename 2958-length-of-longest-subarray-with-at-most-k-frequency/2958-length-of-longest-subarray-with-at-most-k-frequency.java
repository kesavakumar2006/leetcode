class Solution {
        public int maxSubarrayLength(int[] nums, int k) {
                Map<Integer, Integer> freq = new HashMap<>();
                        int ans = 0, start = 0;

                                for (int end = 0; end < nums.length; end++) {
                                            freq.put(nums[end], freq.getOrDefault(nums[end], 0) + 1);

                                                        while (freq.get(nums[end]) > k) {
                                                                        freq.put(nums[start], freq.get(nums[start]) - 1);
                                                                                        start++;
                                                                                                    }

                                                                                                                ans = Math.max(ans, end - start + 1);
                                                                                                                        }

                                                                                                                                return ans;
                                                                                                                                    }
                                                                                                                                    }
