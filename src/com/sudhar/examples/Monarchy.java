package com.sudhar.examples;

import java.util.*;

// Link: https://leetcode.com/discuss/interview-question/302164/google-phone-screen-monarchy

interface MonarchyInterface {
    void birth(String child, String parent);
    void death(String name); // if a person dies, they are removed from monarchy but their children are still considered monarchs
    List<String> getOrderOfSuccession();
}

public class Monarchy implements MonarchyInterface {

    private static final String KING = "king";
    private Map<String, List<String>> map = new HashMap<>();
    private Set<String> dead = new HashSet<>();

    public Monarchy(String king) {
        map.put(king, new ArrayList<>());
    }

    public static void main(String[] args) {
        Monarchy m = new Monarchy("king");
        m.birth("andy", "king");
        m.birth("bob", "king");
        m.birth("cath", "king");
        m.birth("matt", "andy");
        m.birth("alex", "bob");
        m.birth("asha", "bob");

        m.death("andy");

        System.out.println(m.getOrderOfSuccession());
    }

    @Override
    public void birth(String child, String parent) {
        List<String> children = map.get(parent);

        if (children == null) {
            children = new ArrayList<>();
        }

        children.add(child);
    }

    @Override
    public void death(String name) {
        dead.add(name);
    }

    @Override
    public List<String> getOrderOfSuccession() {
        List<String> result = new ArrayList<>();
        dfs(KING, result);

        return result;
    }

    private void dfs(String name, List<String> result) {
        if (!dead.contains(name)) {
            result.add(name);
        }

        if (map.get(name) == null || map.get(name).size() == 0) {
            return;
        }

        for (String child: map.get(name)) {
            dfs(child, result);
        }
    }
}
