class Solution{
	public int[] minBitwiseArray(List<Integer> nums){
		int n=nums.size();
		int[] ans=new int[n];
		for(int i=0;i<n;i++){
			int v=nums.get(i),x=-1;
			for(int a=0;a<v;a++){
				if((a|(a+1))==v){
					x=a;
					break;
				}
			}
			ans[i]=x;
		}
		return ans;
	}
}
