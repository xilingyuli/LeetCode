/**
 * Created by xilingyuli on 2017/1/29.
 */
public class P11ContainerWithMostWater {
    public int maxArea(int[] height) {
        int low = 0, high = height.length-1;
        int max = calArea(height,low,high);
        int key;
        while (low<high)
        {
            key = Math.min(height[low],height[high]);
            while (low<high && height[low]<height[high])
            {
                low++;
                if(height[low]>key) {
                    key = height[low];
                    int temp = calArea(height, low, high);
                    if (temp > max)
                        max = temp;
                }
            }
            key = Math.min(height[low],height[high]);
            while (low<high && height[low]>height[high])
            {
                high--;
                if(height[high]>key) {
                    key = height[high];
                    int temp = calArea(height, low, high);
                    if (temp > max)
                        max = temp;
                }
            }
            if(low<high && height[low]==height[high]){
                int tl = low, th = high;
                while (tl<th)
                {
                    tl++;
                    th--;
                    if(height[tl]>height[low] && height[th]>height[low])
                    {
                        if(height[tl]<height[th])
                            low = tl;
                        else
                            high = th;
                        break;
                    }
                    else if(height[tl]>height[low])
                    {
                        low = tl;
                        break;
                    }
                    else if(height[th]>height[low])
                    {
                        high = th;
                        break;
                    }
                }
                int temp = calArea(height,low,high);
                if(temp>max)
                    max = temp;
                if(tl>=th)
                    break;
            }
        }
        return max;
    }
    public int calArea(int[] height, int low, int high)
    {
        return Math.min(height[low],height[high])*(high-low);
    }
    public static void main(String[] args)
    {
        int[] arr = new int[15000];
        for(int i=0;i<15000;i++)
            arr[i] = 15000-i;
        System.out.print(new P11ContainerWithMostWater().maxArea(arr));
    }
}
