package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
207. 课程表
你这个学期必须选修 numCourse 门课程，记为 0 到 numCourse-1 。
在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1]
给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？

示例 1:
输入: 2, [[1,0]]
输出: true
解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。

示例 2:
输入: 2, [[1,0],[0,1]]
输出: false
解释: 总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。

提示：
输入的先决条件是由 边缘列表 表示的图形，而不是 邻接矩阵 。详情请参见图的表示法。
你可以假定输入的先决条件中没有重复的边。
1 <= numCourses <= 10^5

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/course-schedule
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * 爺の芯僸芷訪問
 */
public class Solution0207 {
    boolean valid = true;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
        }
        // 0:未访问，1:正在访问，2:访问完成
        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses && valid; i++) {
            if (visited[i] == 0) {
                dfs(i, edges, visited);
            }
        }
        return valid;
    }

    private void dfs(int i, List<List<Integer>> edges, int[] visited) {
        visited[i] = 1;
        for (int v : edges.get(i)) {
            if (visited[v] == 0) {
                dfs(v, edges, visited);
                if (!valid) return;
            } else if (visited[v] == 1) {
                valid = false;
                return;
            }
        }
        visited[i] = 2;
    }

    public static void main(String[] args) {
        System.out.println(new Solution0207().canFinish(2, new int[][]{new int[]{1, 0}}));
        System.out.println(new Solution0207().canFinish(2, new int[][]{new int[]{1, 0}, new int[]{0, 1}}));
    }
}
