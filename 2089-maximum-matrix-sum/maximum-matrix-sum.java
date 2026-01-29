class Solution{
	public long maxMatrixSum(int[][]matrix){
		long sum=0;
		int negCount=0;
		int minVal=Integer.MAX_VALUE;
		for(int[]row:matrix){
			for(int val:row){
				if(val<0)negCount++;
				int abs=Math.abs(val);
				sum+=abs;
				minVal=Math.min(minVal,abs);
			}
		}
		return negCount%2==0?sum:sum-2L*minVal;
	}
}
