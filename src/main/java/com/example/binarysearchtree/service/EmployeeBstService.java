package com.example.binarysearchtree.service;

import com.example.binarysearchtree.model.BinarySearchTree;
import com.example.binarysearchtree.model.Employee;
import com.example.binarysearchtree.model.TreeNode;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class EmployeeBstService {
    private BinarySearchTree<Employee> employeeTree;

    @PostConstruct
    public void init() {
        this.employeeTree = new BinarySearchTree<>();
        // Initialize with sample data
        this.employeeTree.insert(new Employee(50, "John Doe", "CEO"));
        this.employeeTree.insert(new Employee(30, "Jane Smith", "CTO"));
        this.employeeTree.insert(new Employee(70, "Mike Johnson", "CFO"));
        this.employeeTree.insert(new Employee(20, "Alice Williams", "VP Engineering"));
        this.employeeTree.insert(new Employee(40, "Bob Brown", "VP Marketing"));
    }

    /**
     * Adds a new employee to the BST
     * @param employee The employee to add
     */
    public void addEmployee(Employee employee) {
        if (employee == null) {
            throw new IllegalArgumentException("Employee cannot be null");
        }
        employeeTree.insert(employee);
    }

    /**
     * Checks if an employee with the given ID exists
     * @param id The employee ID to search for
     * @return true if employee exists, false otherwise
     */
    public boolean employeeExists(Integer id) {
        if (id == null) {
            return false;
        }
        Employee searchEmployee = new Employee(id, "", "");
        return employeeTree.contains(searchEmployee);
    }

    /**
     * Returns all employees sorted by ID (in-order traversal)
     * @return List of employees in ascending order by ID
     */
    public List<Employee> getAllEmployeesSorted() {
        return employeeTree.inOrderTraversal();
    }

    /**
     * Returns a string representation of the employee hierarchy tree
     * @return Formatted tree structure
     */
    public String getTreeStructure() {
        return printTree(employeeTree.getRoot(), 0);
    }

    // Helper method for tree visualization
    private String printTree(TreeNode<Employee> node, int level) {
        if (node == null) {
            return "";
        }
        String indent = "  ".repeat(level);
        return printTree(node.getRight(), level + 1) +
                indent + node.getData().getId() + " (" + node.getData().getName() + ")\n" +
                printTree(node.getLeft(), level + 1);
    }

}