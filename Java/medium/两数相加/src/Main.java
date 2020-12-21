/**
 *  输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 *  输出：7 -> 0 -> 8
 *
 * @author coderblue
 * @date 2020/12/21
 */
public class Main {

    /**
     * 最终存储的数据节点
     */
    private static ListNode root = new ListNode(0);
    /**
     * 需要先初始化一个预先指针 pre
     */
    private static ListNode curNode = root;
    /**
     * 判断是否需要进一位
     */
    private static int isAddOne = 0;

    public static void main(String[] args) {
        // (5 -> 6 -> 4)
        ListNode l3 = new ListNode(4, null);
        ListNode l2 = new ListNode(6, l3);
        ListNode l1 = new ListNode(5, l2);
        // (2 -> 4 -> 3)
        ListNode n3 = new ListNode(3, null);
        ListNode n2 = new ListNode(4, n3);
        ListNode n1 = new ListNode(2, n2);
        System.out.println(addTwoNumbers(l1, n1));

        // ListNode node1 = new ListNode(0, null);
        // ListNode node2 = new ListNode(0, null);
        // System.out.println(addTwoNumbers(node1, node2));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 != null || l2 != null || isAddOne != 0) {
            int l1Val = l1 != null ? l1.val : 0;
            int l2Val = l2 != null ? l2.val : 0;
            int sumVal = l1Val + l2Val + isAddOne;
            ListNode listNode = new ListNode(sumVal % 10);
            isAddOne = sumVal / 10;
            // 该指针的下一个节点指向真正的头结点head。
            curNode.next = listNode;
            curNode = curNode.next;
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
            addTwoNumbers(l1, l2);
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
