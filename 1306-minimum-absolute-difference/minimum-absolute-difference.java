class Solution{
	public List<List<Integer>> minimumAbsDifference(int[]arr){
		java.util.Arrays.sort(arr);
		int min=Integer.MAX_VALUE;
		for(int i=1;i<arr.length;i++)
			min=Math.min(min,arr[i]-arr[i-1]);
		java.util.List<List<Integer>>res=new java.util.ArrayList<>();
		for(int i=1;i<arr.length;i++)
			if(arr[i]-arr[i-1]==min)
				res.add(java.util.Arrays.asList(arr[i-1],arr[i]));
		return res;
	}
}
