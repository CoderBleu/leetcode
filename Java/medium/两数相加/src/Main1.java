/**
 *  输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 *  输出：7 -> 0 -> 8
 *
 * @author coderblue
 * @date 2020/12/21
 */
public class Main1 {

    public static void main(String[] args) {
        // (5 -> 6 -> 4)
        ListNode l3 = new ListNode(4, null);
        ListNode l2 = new ListNode(6, l3);
        ListNode l1 = new ListNode(5, l2);
        // (2 -> 4 -> 3)
        ListNode n3 = new ListNode(3, null);
        ListNode n2 = new ListNode(4, n3);
        ListNode n1 = new ListNode(2, n2);
        System.out.println(addTwoNumbers(n1, l1));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode cursor = root;

        // 如果先前有进一位就保存
        int isAddOne = 0;
        while(l1 != null || l2 != null || isAddOne != 0) {
            int l1Val = l1 != null ? l1.val : 0;
            int l2Val = l2 != null ? l2.val : 0;
            int sumVal = l1Val + l2Val + isAddOne;
            // 清零重新赋值
            isAddOne = sumVal / 10;

            ListNode sumNode = new ListNode(sumVal % 10);
            // 防止空指针异常,数据操作cursor，root数据也会变化。第一次来自同一个内存地址。
            cursor.next = sumNode;
            // 单独把cursor的值重置
            cursor = sumNode;

            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }

        return root.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

}
