// https://leetcode.com/problems/4sum/
import java.util.*;
public class FourSum {
    public List<List<Integer>> twoSum(int[] nums, int si, int target){
      
        List<List<Integer>> ans = new ArrayList<>();
        int i=si;
        int j=nums.length-1;
        while(i<j){
            if(i!=si && nums[i]==nums[i-1]){
               i++;
              continue;
          }
          if(nums[i]+nums[j]==target){
              List<Integer> ll = new ArrayList<>();
              ll.add(nums[i]);
              ll.add(nums[j]);
              ans.add(ll);
              i++;
              j--;
          }
          else if(nums[i]+nums[j]<target){
              i++;
          }
          else{
              j--;
          }
        }
       return ans;
        
    }
    
    
    public List<List<Integer>> threeSum(int[] nums,int si, int target) {
      List<List<Integer>> ans = new ArrayList<>();
      int n=nums.length;
      for(int i=si;i<n-2;i++){
          
          if(i!=si && nums[i]==nums[i-1]){
              continue;
          }
          List<List<Integer>> res = twoSum(nums,i+1,target-nums[i]);
          for(List<Integer> ll : res){
              ll.add(nums[i]);
              ans.add(ll);
          }
      }
      
      return ans;
      
    }
        public List<List<Integer>> fourSum(int[] nums, int target) {
            Arrays.sort(nums);
            int n=nums.length;
            List<List<Integer>> ans = new ArrayList<>();
            for(int i=0;i<n-3;i++){
                if(i!=0 && nums[i]==nums[i-1])continue;
                List<List<Integer>> res= threeSum(nums,i+1,target-nums[i]);
                for(List<Integer> ll: res){
                    ll.add(nums[i]);
                    ans.add(ll);
                }
            }
            return ans;
        }
}
