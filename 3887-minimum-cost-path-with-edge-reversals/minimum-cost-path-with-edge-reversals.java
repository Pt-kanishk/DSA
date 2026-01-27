class Solution{
	public int minCost(int n,int[][]edges){
		java.util.List<int[]>[]g=new java.util.ArrayList[n];
		for(int i=0;i<n;i++)g[i]=new java.util.ArrayList<>();
		for(int[]e:edges){
			g[e[0]].add(new int[]{e[1],e[2],0});
			g[e[1]].add(new int[]{e[0],e[2],1});
		}
		long[]dist=new long[n];
		java.util.Arrays.fill(dist,Long.MAX_VALUE);
		dist[0]=0;
		java.util.PriorityQueue<long[]>pq=new java.util.PriorityQueue<>((a,b)->Long.compare(a[0],b[0]));
		pq.add(new long[]{0,0});
		while(!pq.isEmpty()){
			long[]cur=pq.poll();
			long d=cur[0];int u=(int)cur[1];
			if(d>dist[u])continue;
			for(int[]e:g[u]){
				int v=e[0],w=e[1],rev=e[2];
				long nd=d+(rev==0?w:2L*w);
				if(nd<dist[v]){
					dist[v]=nd;
					pq.add(new long[]{nd,v});
				}
			}
		}
		return dist[n-1]==Long.MAX_VALUE?-1:(int)dist[n-1];
	}
}
