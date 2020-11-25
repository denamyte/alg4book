package org.denamyte.other;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ProxetCodingInterviewTree {
    static class Node {

        public Node l;

        public Node r;

        public int v;

        public Node(final int v) {
            this.v = v;
            this.l = null;
            this.r = null;
        }

        public String toString() {
            return "Node{" +
                    "left=" + (l == null ? "null" : l.v) +
                    ", right=" + (r == null ? "null" : r.v) +
                    ", value=" + v +
                    '}';
        }
    }

    static class binaryTree {

        public Node Root;

        public void add_node(int value) {
            Root = addRecursive(Root, value);
        }

        private Node addRecursive(Node current, int value) {
            if (current == null) {
                return new Node(value);
            }
            if (value < current.v) {
                current.l = addRecursive(current.l, value);
            } else if (value > current.v) {
                current.r = addRecursive(current.r, value);
            }
            return current;
        }

        private void visit(int value) {
            System.out.print(" " + value);
        }

        public void visitAll(Node node) {
            if (node == null) {
                return;
            }
            visitAll(node.l);
            visit(node.v);
            visitAll(node.r);
        }

        public void visitHorz(List<Node> nodes) {
            List<Node> lowNodes = new ArrayList<>();
            for (Node node : nodes) {
                if (node.l != null) {
                    lowNodes.add(node.l);
                }
                if (node.r != null) {
                    lowNodes.add(node.r);
                }
                visit(node.v);
            }
            if (lowNodes.size() != 0) {
                visitHorz(lowNodes);
            }
        }

        public void visitHorzNoRecursion() {
            List<Node> nodes = Collections.singletonList(Root);
            while (nodes.size() > 0) {
                List<Node> lowNodes = new LinkedList<>();
                for (Node node : nodes) {
                    if (node.l != null) {
                        lowNodes.add(node.l);
                    }
                    if (node.r != null) {
                        lowNodes.add(node.r);
                    }
                    visit(node.v);
                }
                nodes = lowNodes;
            }
        }
    }

    public static void main(String[] args) {

        //         5
        //       /   \
        //      /     \
        //     3       6
        //    /\        \
        //   /  \        \
        //  1    4        9
        //   \           /
        //    2         7

        binaryTree bt = new binaryTree();
        bt.add_node(5);
        bt.add_node(6);
        bt.add_node(3);
        bt.add_node(1);
        bt.add_node(2);
        bt.add_node(4);
        bt.add_node(9);
        bt.add_node(7);

        // bt.visitAll(bt.Root);
        LinkedList<Node> nodes = new LinkedList();
        nodes.add(bt.Root);
        bt.visitHorz(nodes);
        System.out.println();

        bt.visitHorzNoRecursion();
    }
}
