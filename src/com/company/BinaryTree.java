package com.company;

// Java program to print all the Node1 to leaf path

/* A binary tree Node1 has data, pointer to left child
   and a pointer to right child */
class Node1
{
    int data;
    Node1 left, right;

    Node1(int item)
    {
        data = item;
        left = right = null;
    }
}

class BinaryTree
{
    Node1 root;

    /*Given a binary tree, print out all of its root-to-leaf
      paths, one per line. Uses a recursive helper to do
      the work.*/
    void printPaths(Node1 Node1)
    {
        int path[] = new int[1000];
        printPathsRecur(Node1, path, 0);
    }

    /* Recursive helper function -- given a Node1, and an array
       containing the path from the root Node1 up to but not
       including this Node1, print out all the root-leaf paths.*/
    void printPathsRecur(Node1 Node1, int path[], int pathLen)
    {
        if (Node1 == null)
            return;

        /* append this Node1 to the path array */
        path[pathLen] = Node1.data;
        pathLen++;

        /* it's a leaf, so print the path that led to here  */
        if (Node1.left == null && Node1.right == null)
            printArray(path, pathLen);
        else
        {
            /* otherwise try both subtrees */
            printPathsRecur(Node1.left, path, pathLen);
            printPathsRecur(Node1.right, path, pathLen);
        }
    }

    /* Utility function that prints out an array on a line. */
    void printArray(int ints[], int len)
    {
        int i;
        for (i = 0; i < len; i++)
        {
            System.out.print(ints[i] + " ");
        }
        System.out.println("");
    }

    // driver program to test above functions
    public static void main(String args[])
    {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node1(10);
        tree.root.left = new Node1(8);
        tree.root.right = new Node1(2);
        tree.root.left.left = new Node1(3);
        tree.root.left.right = new Node1(5);
        tree.root.right.left = new Node1(2);

        /* Let us test the built tree by printing Insorder traversal */
        tree.printPaths(tree.root);
    }
}