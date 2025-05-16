import java.util.ArrayList;
import java.util.List;

public class Main {

    public static int[] twoSum(int[] nums, int target) {
            List<Integer> list = new ArrayList<>();
            for (int num : nums)
                list.add(num);
            for (int i = 0; i < list.size(); i++){
                for (int j = i + 1; j < list.size(); j++){
                    int sum = list.get(i) + list.get(j);
                    if(sum == target){
                        return new int[]{i,j};
                    }
                }
            }
            return null;
    }

        public boolean isPalindrome(int x) {
            String s = String.valueOf(x);

            return true;
        }
    public int lengthOfLongestSubstring(String s) {
       String[] strs = new String[s.length()];
       int mcount = 0;
       int max = 0;
       for(int i = 0; i < s.length(); i++){
           strs[i] = String.valueOf(s.charAt(i));
           if(strs[i] !=(strs[i+1])){
               mcount++;
               max = mcount;
           }else{
               mcount = 0;
           }
       }

       return max;
    }

    public boolean isValid(String s) {
        List<Character> arr = new ArrayList<>();

        for(int i = 0; i <s.length(); i++){
            arr.add(s.charAt(i));
        }
        return false;
    }

    public int reverse(int x) {
        int ans=0;
        while(x!=0){
            int num=x%10;
            if(ans>Integer.MAX_VALUE/10 || (ans==Integer.MAX_VALUE/10 && num>7))return 0;
            if(ans<Integer.MIN_VALUE/10 || (ans==Integer.MIN_VALUE/10 && num<-8))return 0;
            ans=ans*10+num;
            x/=10;
        }
        return ans;
    }

    public String longestCommonPrefix(String[] strs) {
        String ans ="";
        int max = 0;
        for(int i =0; i < strs.length; i++){
            for(int j = 0; j < strs[i].length(); j++){
                char c = strs[i].charAt(j);
                if(strs[i]  .contains(String.valueOf(c))&&
                        strs[i+1].contains(String.valueOf(c))){
                    ans= ans + c;
                    max++;
                }
            }
        }

        return ans;
    }

    public long countSubarrays(int[] nums, long k) {
        long max = 0;
        int[] arr = new int[nums.length];
        for(int i =0; i<nums.length; i++){
            if(nums[i] * 1 < k){
                max++;
            }
        }
        return max;
    }


    public static void main(String[] args) {
            int[] a =  new int[]{2, 7, 11, 15};
            int target = 9;
        twoSum(a,target);
    }
}