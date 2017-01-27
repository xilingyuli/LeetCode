/**
 * Created by xilingyuli on 2017/1/27.
 */
public class P4MediaOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length==0)
        {
            if(nums2.length%2==0)
                return (nums2[nums2.length/2-1]+nums2[nums2.length/2])/2.0;
            else
                return nums2[nums2.length/2];
        }
        if(nums2.length==0)
        {
            if(nums1.length%2==0)
                return (nums1[nums1.length/2-1]+nums1[nums1.length/2])/2.0;
            else
                return nums1[nums1.length/2];
        }
        int b1=0, b2=0, e1=nums1.length, e2=nums2.length;
        int total = nums1.length+nums2.length;
        boolean flag = false;
        while (true){
            flag = !flag;
            int key,m1,m2;
            if(flag)
            {
                m1 = (b1+e1)/2;
                if(m1>=nums1.length)
                    continue;
                key = nums1[m1];
                m2 = find(nums2,key,b2,e2);
            }
            else
            {
                m2 = (b2+e2)/2;
                if(m2>=nums2.length)
                    continue;
                key = nums2[m2];
                m1 = find(nums1,key,b1,e1);
            }
            if(m1+m2+1==(total+1)/2||(b1==e1&&b2==e2))
            {
                if(total%2==0)
                {
                    int temp=key;
                    if(flag)
                        m1++;
                    else
                        m2++;
                    if(m1<nums1.length&&m2<nums2.length)
                        temp = nums1[m1]<nums2[m2]?nums1[m1]:nums2[m2];
                    else if(m1<nums1.length)
                        temp = nums1[m1];
                    else if(m2<nums2.length)
                        temp = nums2[m2];
                    return (temp+key)/2.0;
                }
                else
                    return key;
            }
            else if(m1+m2+1<(total+1)/2)
            {
                if(flag)
                    b1 = m1+1;
                else
                    b2 = m2+1;
            }
            else if(m1+m2+1>(total+1)/2)
            {
                if(flag)
                    e1 = m1;
                else
                    e2 = m2;
            }
        }
    }
    public int find(int[] array, int num, int begin, int end)
    {
        if(begin==end)
        {
            if(begin<array.length)
                return array[begin] > num ? begin : begin + 1;
            else
                return array.length;
        }
        int mid = (begin+end)/2;
        if(array[mid]>num)
            return find(array,num,begin,mid);
        else
            return find(array,num,mid+1,end);
    }
}
