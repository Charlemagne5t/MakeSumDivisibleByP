import java.util.HashMap;
import java.util.Map;

class Solution {
    public int minSubarray(int[] nums, int p) {
        long sum = 0L;
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] % p;
            sum += nums[i];
        }

        int res = Integer.MAX_VALUE;
        int target = (int) (sum % p);
        if (target == 0) {
            return 0;
        }


        Map<Integer, Integer> map = new HashMap<>();
        int ps = 0;
        for (int i = 0; i < nums.length; i++) {
            ps = (ps + nums[i]) % p;

            int t = (ps - target + p) % p;
            if (t == 0 && i != nums.length - 1) {
                res = Math.min(res, i + 1);
            }


            if (nums[i] == target) {
                return 1;
            }
            if (map.containsKey(t)) {
                res = Math.min(res, i - map.get(t));
            }

            map.put(ps, i);

        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }
}