package com.example.binarysearchtree.model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class BinarySearchTree<T extends Comparable<T>> {
    private TreeNode<T> root;

    public void insert(T data) {
        root = insertRec(root, data);
    }

    private TreeNode<T> insertRec(TreeNode<T> node, T data) {
        if (node == null) {
            return new TreeNode<>(data);
        }

        if (data.compareTo(node.getData()) < 0) {
            node.setLeft(insertRec(node.getLeft(), data));
        } else if (data.compareTo(node.getData()) > 0) {
            node.setRight(insertRec(node.getRight(), data));
        }

        return node;
    }

    public boolean contains(T data) {
        return containsRec(root, data);
    }

    private boolean containsRec(TreeNode<T> node, T data) {
        if (node == null) {
            return false;
        }

        int comparison = data.compareTo(node.getData());
        if (comparison == 0) {
            return true;
        }
        return comparison < 0 
            ? containsRec(node.getLeft(), data) 
            : containsRec(node.getRight(), data);
    }

    public List<T> inOrderTraversal() {
        List<T> result = new ArrayList<>();
        inOrderRec(root, result);
        return result;
    }

    private void inOrderRec(TreeNode<T> node, List<T> result) {
        if (node != null) {
            inOrderRec(node.getLeft(), result);
            result.add(node.getData());
            inOrderRec(node.getRight(), result);
        }
    }

}