class Solution{
	public int minimumPairRemoval(int[]nums){
		int ops=0;
		java.util.ArrayList<Integer>a=new java.util.ArrayList<>();
		for(int v:nums)a.add(v);
		while(!isSorted(a)&&a.size()>1){
			int minSum=Integer.MAX_VALUE,idx=0;
			for(int i=0;i<a.size()-1;i++){
				int s=a.get(i)+a.get(i+1);
				if(s<minSum){
					minSum=s;
					idx=i;
				}
			}
			a.set(idx,a.get(idx)+a.get(idx+1));
			a.remove(idx+1);
			ops++;
		}
		return ops;
	}
	private boolean isSorted(java.util.List<Integer>a){
		for(int i=1;i<a.size();i++){
			if(a.get(i)<a.get(i-1))return false;
		}
		return true;
	}
}
