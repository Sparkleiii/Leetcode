import java.util.LinkedList;
import java.util.Queue;

public class maxDist {
    /**
     *你现在手里有一份大小为 N x N 的『地图』（网格） grid，
     * 上面的每个『区域』（单元格）都用 0 和 1 标记好了。
     * 其中 0 代表海洋，1 代表陆地，
     * 你知道距离陆地区域最远的海洋区域是是哪一个吗？
     * 请返回该海洋区域到 离它最近的陆地区域的距离。
     *
     * 我们这里说的距离是『曼哈顿距离』（ Manhattan Distance）：(x0, y0) 和 (x1, y1) 这两个区域之间的距离是 |x0 - x1| + |y0 - y1| 。
     *
     * 如果我们的地图上只有陆地或者海洋，请返回 -1。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/as-far-from-land-as-possible
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    /**
     * 使用广度优先遍历
     * 反向思考这个问题
     * 从每个陆地出发
     * 同时进行遍历。
     * 找到最近的海洋并将它标记，标记为第几个遍历到的海洋
     * 若遍历到边界值或！=0（表示不是陆地或离其他的陆地更近）
     * 曼哈顿距离 =
     */
    // 图的广度优先搜索
    // 0：海洋
    // 1：陆地
    public static int maxDistance(int[][] grid) {
        // 表四个方向
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        //BFS 使用队列实现
        Queue<Cordinate> queue = new LinkedList<>();
        int n = grid.length;
        // 首先将所有的陆地都入队
        for(int i=0;i<n;i++){
            for(int j = 0; j<n; j++){
                if(grid[i][j]==1){
                    queue.offer(new Cordinate(i,j));
                }
            }
        }
        // 从各个陆地开始，一圈一圈地遍历海洋
        // 最后遍历到的海洋就是离陆地最远的海洋
        boolean hasOcean = false;
        Cordinate point = null;
        while(!queue.isEmpty()){
            point = queue.poll();
            int x = point.getX();
            int y = point.getY();
            //取出队列的元素，将其四周的海洋入队
            for(int i=0; i<4; i++){
                int newX = x+dx[i];
                int newY = y+dy[i];
                // 如果下一个是边界或不是0（表示已经被访问过了），跳过
                if(newX<0 || newX >=n || newY<0 || newY>=n || grid[newX][newY]!=0){
                    continue;
                }
                //如果下一个是海洋，修改数组值为出发点的值+1
                grid[newX][newY] = grid[x][y] + 1;
                hasOcean = true;
                queue.offer(new Cordinate(newX, newY));
            }
        }

        // 没有陆地或者没有海洋返回-1
        if(point==null || !hasOcean){
            return -1;
        }

        return grid[point.getX()][point.getY()] - 1;
    }


    public static void main(String[] args) {

    }

    public static class Cordinate{
        private int x;
        private int y;

        public Cordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

    }
}
