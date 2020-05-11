class Insertion_Sort
{
    protected int[] arr;
    
    protected void ins_sort()
    {
        int n = arr.length;
        for(int i=1;i<n;i++)
        {
            int pos = i;int temp = arr[i];
            for(int j=i-1;j>=0;j--)
            {
                if(arr[j]>temp) {arr[j+1] = arr[j];pos = j;}
            }
            arr[pos] = temp;
        }
    }
    
}