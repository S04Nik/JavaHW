package com.company.HW01.array;

public class Array implements Imath, Isort {
    public int[] nums;
    public Array(){
        nums=new int[]{1,2,3,4,5,9,12,55,36,78,0};
    }
    @Override
    public int Max() {
        int tmp=nums[0];
        for(int i:nums){
            if(tmp<i) tmp=i;
        }
        System.out.println("MAX: "+tmp);
        return tmp;
    }

    @Override
    public float Avg() {
        int tmp=0;
        for(int i:nums){
            tmp+=i;
        }
        tmp/=nums.length;
        System.out.println("AVG: "+tmp);
        return tmp;
    }

    @Override
    public int Min() {
        int tmp=nums[0];
        for(int i=0;i<nums.length;i++){
            if(tmp>nums[i])
                tmp=nums[i];
        }
        System.out.println("MIN: "+tmp);
        return tmp;
    }

    @Override
    public void SortAsc() {

//        tmp=Arrays.copyOf(nums,nums.length);
        for (int i=nums.length;i>0;i--)
        {
            for (int j=0;j<i-1;j++)
            {
                if(nums[j]>nums[j+1]){
                    int tmp=nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=tmp;
                }
            }
        }
        for (int i:nums) {
            System.out.println(i);
        }
    }

    @Override
    public void SortDesc() {
        for (int i=nums.length;i>0;i--)
        {
            for (int j=0;j<i-1;j++)
            {
                if(nums[j]<nums[j+1]){
                    int tmp=nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=tmp;
                }
            }
        }
        for (int i:nums) {
            System.out.println(i);
        }
    }



}
