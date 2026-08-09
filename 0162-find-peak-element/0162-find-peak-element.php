class Solution {

        /**
             * @param Integer[] $nums
                  * @return Integer
                       */
                           function findPeakElement($nums) {
                                   $left = 0;
                                           $right = count($nums) - 1;

                                                   while ($left < $right) {
                                                               $mid = intdiv($left + $right, 2);

                                                                           if ($nums[$mid] > $nums[$mid + 1]) {
                                                                                           $right = $mid;
                                                                                                       } else {
                                                                                                                       $left = $mid + 1;
                                                                                                                                   }
                                                                                                                                           }

                                                                                                                                                   return $left;
                                                                                                                                                       }
                                                                                                                                                       }
