package leetcode.editor.cn;

public class P1741FindTotalTimeSpentByEachEmployee {
    public static void main(String[] args) {
        // TO TEST
        String sql = """
                SELECT event_day AS day, emp_id, SUM(out_time - in_time) AS total_time
                FROM Employees
                GROUP BY day, emp_id;
                """;
    }
    //Java：查找每个员工花费的总时间
    //There is no code of Java type for this problem
}