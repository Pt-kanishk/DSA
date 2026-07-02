class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int rows = grid.size();
        int cols = grid.get(0).size();

        int[][] minCost = new int[rows][cols];
        for (int[] row : minCost) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);

        minCost[0][0] = grid.get(0).get(0);
        pq.offer(new int[]{0, 0, minCost[0][0]});

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!pq.isEmpty()) {
            int[] current = pq.poll();

            int row = current[0];
            int col = current[1];
            int cost = current[2];

            if (cost > minCost[row][col]) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int newRow = row + dr[i];
                int newCol = col + dc[i];

                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols) {
                    int newCost = cost + grid.get(newRow).get(newCol);

                    if (newCost < minCost[newRow][newCol]) {
                        minCost[newRow][newCol] = newCost;
                        pq.offer(new int[]{newRow, newCol, newCost});
                    }
                }
            }
        }

        return minCost[rows - 1][cols - 1] < health;
    }
}