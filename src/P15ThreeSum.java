import java.util.*;

/**
 * Created by xilingyuli on 2017/3/21.
 */
public class P15ThreeSum {
    public List<List<Integer>> threeSum0(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {              // skip same result
                continue;
            }
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                if (nums[i]+nums[j]+nums[k] < 0) {
                    j++;
                } else if (nums[i]+nums[j]+nums[k] > 0) {
                    k--;
                } else {
                    lists.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) j++;  // skip same result
                    while (j < k && nums[k] == nums[k + 1]) k--;  // skip same result
                }
            }
        }
        return lists;
    }
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        HashSet<Integer> startSet = new HashSet<>();
        LinkedHashMap<Integer,Integer> endMap = new LinkedHashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(endMap.containsKey(nums[i]))
                endMap.put(nums[i],endMap.get(nums[i])+1);
            else
                endMap.put(nums[i],1);
        }
        for(int i=0;i<nums.length;i++){
            if(i>0&&nums[i]==nums[i-1])
                continue;
            int num2 = nums[i];
            int count = endMap.get(num2);
            endMap.remove(num2);
            for(int num1: startSet){
                if(endMap.containsKey(-num1-num2)){
                    lists.add(Arrays.asList(num1,num2,-num1-num2));
                }
            }
            if(count>=2){
                if(startSet.contains(-2*num2))
                    lists.add(Arrays.asList(-2*num2,num2,num2));
                else if(endMap.containsKey(-2*num2))
                    lists.add(Arrays.asList(num2,num2,-2*num2));
            }
            if(count>=3 && num2==0)
                lists.add(Arrays.asList(num2,num2,num2));
            startSet.add(num2);
        }
        return lists;
    }
    public static void main(String[] args){
        new P15ThreeSum().threeSum(new int[]{-1,0,1,2,-1,-4});
    }
}
