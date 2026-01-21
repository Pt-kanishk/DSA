class Solution{
	public int[] minBitwiseArray(java.util.List<Integer> nums){
		int m=nums.size();
		int[] ans=new int[m];
		for(int i=0;i<m;i++){
			int v=nums.get(i);
			if((v&1)==0){ ans[i]=-1; continue; } 
			int t=0;
			int tmp=v;
			while((tmp&1)==1){ t++; tmp>>=1; }
			int H = v >> t;
			int lowMask = (t==1)?0:((1 << (t-1)) - 1);
			long x = ((long)H << t) | lowMask;
			ans[i] = (int)x;
		}
		return ans;
	}
}
