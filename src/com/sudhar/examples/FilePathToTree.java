package com.sudhar.examples;

import java.util.ArrayList;
import java.util.List;

class FileNode {
    String val;
    ArrayList<FileNode> children;

    public FileNode(String val) {
        this.val = val;
        this.children = new ArrayList<>();
    }
}

public class FilePathToTree {

    public static void main(String[] args) {
        ArrayList<String> input = new ArrayList<String>();
        input.add("/app/components/header");
        input.add("/app/services");
        input.add("/app/tests/components/header");
        input.add("/images/image.png");
        input.add("/tsconfig.json");
        input.add("/index.html");
        printFileStructure(input);
    }

    public static void printFileStructure(ArrayList<String> input) {
        FileNode root = new FileNode("root");

        for (String curr: input) {
            String[] currArr = curr.split("/");

            FileNode parent = saveChild(root, currArr[0]);
            for (int i = 1; i < currArr.length; i++) {
                FileNode child = saveChild(parent, currArr[i]);
                parent = child;
            }
        }

        print(root, "");
    }

    private static FileNode saveChild(FileNode parent, String childVal) {
        boolean found = false;
        List<FileNode> children = parent.children;
        for (FileNode n: children) {
            if (n.val.equals(childVal)) {
                found = true;
                return n;
            }
        }

        if (!found) {
            FileNode child = new FileNode(childVal);
            children.add(child);
            return child;
        }

        return null;
    }

    private static void print(FileNode n, String spaces) {
        System.out.println(spaces + n.val);
        List<FileNode> children = n.children;
        for (FileNode child: children) {
            print(child, spaces + "-");
        }
    }

}
