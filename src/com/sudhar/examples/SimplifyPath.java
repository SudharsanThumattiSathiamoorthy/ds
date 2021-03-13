package com.sudhar.examples;

import java.util.ArrayList;
import java.util.List;

public class SimplifyPath {

    public String simplifyPath(String path) {
        if (path == null || path.length() == 0) {
            return path;
        }

        String[] a = path.split("/");
        List<String> paths = new ArrayList<>();

        for (int i = 0; i < a.length; i++) {
            String dir = a[i];

            if (dir.length() == 0 || ".".equals(dir)) {
                // ignore
            }

            else if ("..".equals(dir)) {
                if (paths.size() > 0) {
                    paths.remove(paths.size() - 1);
                }
            } else {
                paths.add(dir);
            }
        }

        if (paths.size() > 0) {
            StringBuilder result = new StringBuilder();

            for (String dir: paths) {
                result.append("/");
                result.append(dir);
            }
            return result.toString();
        }
        return  "/";
    }

    public static void main(String[] args) {

        SimplifyPath sp = new SimplifyPath();

        System.out.println(sp.simplifyPath("/a/./b/../../c/"));
        System.out.println(sp.simplifyPath("/a/../../b/../c//.//"));
        System.out.println(sp.simplifyPath("/home//foo/"));
    }

}
