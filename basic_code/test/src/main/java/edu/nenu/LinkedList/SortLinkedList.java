package edu.nenu.LinkedList;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: chenshanquan
 * @CreateTime: 2025-09-27
 * @Description: 对一组链表进行修改，让他们的值升序
 */

public class SortLinkedList {

    public static void main(String[] args) {
        SortLinkedList sortLinkedList = new SortLinkedList();
        sortLinkedList.new ListNode();
    }

    public class ListNode {
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
    }

    /**
     * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表
     * @param head 原始链表
     * @return edu.nenu.LinkedList.SortLinkedList.ListNode
     * @author chenshanquan
     * @date 2025/9/28 11:25
     **/
    public ListNode sortList(ListNode head) {
        if (head == null) return null;

        List<ListNode> list = new ArrayList<>();
        for (ListNode temp = head; temp != null; temp = temp.next) {
            list.add(temp);
        }
        list.sort((a, b) -> a.val - b.val);

        ListNode dummy = new ListNode(0), tail = dummy;
        for (ListNode node : list) {
            node.next = null;   // 关键：断开旧指向
            tail.next = node;
            tail = node;
        }
        return dummy.next;
    }
}
