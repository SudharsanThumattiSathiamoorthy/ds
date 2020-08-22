package com.sudhar.examples;

import java.util.HashMap;
import java.util.Stack;

public class DesignExcelSumFormula {

    public class Excel {
        Formula[][] Formulas;
        class Formula {
            Formula(HashMap < String, Integer > c, int v) {
                val = v;
                cells = c;
            }
            HashMap< String, Integer > cells;
            int val;
        }
        Stack< int[] > stack = new Stack < > ();
        public Excel(int H, char W) {
            Formulas = new Formula[H][(W - 'A') + 1];
        }

        public int get(int r, char c) {
            if (Formulas[r - 1][c - 'A'] == null)
                return 0;
            return Formulas[r - 1][c - 'A'].val;
        }
        public void set(int r, char c, int v) {
            Formulas[r - 1][c - 'A'] = new Formula(new HashMap < String, Integer > (), v);
            topologicalSort(r - 1, c - 'A');
            execute_stack();
        }

        public int sum(int r, char c, String[] strs) {
            HashMap < String, Integer > cells = convert(strs);
            int summ = calculate_sum(r - 1, c - 'A', cells);
            set(r, c, summ);
            Formulas[r - 1][c - 'A'] = new Formula(cells, summ);
            return summ;
        }

        public void topologicalSort(int r, int c) {
            for (int i = 0; i < Formulas.length; i++)
                for (int j = 0; j < Formulas[0].length; j++)
                    if (Formulas[i][j] != null && Formulas[i][j].cells.containsKey("" + (char)('A' + c) + (r + 1))) {
                        topologicalSort(i, j);
                    }
            stack.push(new int[] {r,c});
        }

        public void execute_stack() {
            while (!stack.isEmpty()) {
                int[] top = stack.pop();
                if (Formulas[top[0]][top[1]].cells.size() > 0)
                    calculate_sum(top[0], top[1], Formulas[top[0]][top[1]].cells);
            }
        }

        public HashMap < String, Integer > convert(String[] strs) {
            HashMap < String, Integer > res = new HashMap < > ();
            for (String st: strs) {
                if (st.indexOf(":") < 0)
                    res.put(st, res.getOrDefault(st, 0) + 1);
                else {
                    String[] cells = st.split(":");
                    int si = Integer.parseInt(cells[0].substring(1)), ei = Integer.parseInt(cells[1].substring(1));
                    char sj = cells[0].charAt(0), ej = cells[1].charAt(0);
                    for (int i = si; i <= ei; i++) {
                        for (char j = sj; j <= ej; j++) {
                            res.put("" + j + i, res.getOrDefault("" + j + i, 0) + 1);
                        }
                    }
                }
            }
            return res;
        }

        public int calculate_sum(int r, int c, HashMap < String, Integer > cells) {
            int sum = 0;
            for (String s: cells.keySet()) {
                int x = Integer.parseInt(s.substring(1)) - 1, y = s.charAt(0) - 'A';
                sum += (Formulas[x][y] != null ? Formulas[x][y].val : 0) * cells.get(s);
            }
            Formulas[r][c] = new Formula(cells, sum);
            return sum;
        }
    }

//    Before discussing the required design, we'll discuss some prerequisites to help ease the understanding of the solution.
//
//    Firstly, we can note that once a formula is applied to any cell in excel, let's say C1 = C2 + C3C1=C2+C3, if any change is made to C2C2 or C3C3, the result to be put into C1C1 needs to be evaluated again based on the new values of C2C2 and C3C3. Further, suppose some other cell, say D2D2 is also dependent on C1C1 due to some prior formula applied to D2D2. Then, when any change is made to, say, C2C2, we re-evaluate C1C1's value. Furhter, since D2D2 is dependent on C1C1, we need to re-evaluate D2D2's value as well.
//
//    Thus, whenever, we make any change to any cell, xx, we need to determine the cells which are dependent on xx, and update these cells, and further determine the cells which are dependent on the changed cells and so on. We can assume that no cycles are present in the formulas, i.e. Any cell's value won't directly or indirectly be dependent on its own value.
//
//    But, while doing these set of evaluations of the cells to determine their updated values, we need to update the cells in such an order that the cell on which some other cell is dependent is always evaluated prior to the cell which is dependent on the former cell.
//
//    In order to do so, we can view the dependence between the cells in the form of a dependency graph, which can be a Directed Graph. Since, no cycles are allowed between the formulas, the graph reduces to a Directed Acyclic Graph. Now, to solve the problem of evaluating the cells in the required order, we can make use of a very well known method specifically used for such problems in Directed Acyclic Graphs, known as the Topological Sorting.
//
//    Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices such that for every directed edge uvuv, vertex uu comes before vv in the ordering. For example, a topological sorting of the following graph is 5 4 2 3 1 0.
//
//    There can be more than one topological sorting for a graph. For example, another topological sorting of the following graph is 4 5 2 3 1 0. The first vertex in topological sorting is always a vertex with in-degree as 0 (a vertex with no in-coming edges).

//    We can make use of the same concept while evaluating the cell values to determine the order in which they need to be evaluated.
//
//            Now, let's discuss how we implement the various required functions. We make use of a simple structure(Class), FormulaFormula, which contains two elements. First, the value of the cell which it represents, valval, and a HashMap, cellscells. It is a list of cells on which the current cell's value is dependent. This cellscells hashmap stores the data in the form (cellName, count)(cellName,count). cellNamecellName has the format ColRowColRow. countcount refers to the number of times the current cell directly or indirectly comes in the current cell's formulas. e.g. C1 = C2 + C3 + C2C1=C2+C3+C2. In this case, the frequency of C3C3 is 1 and that of C2C2 is 2.
//
//    Excel(int H, char W) : We simply need to initialize an array of FormulaFormula with HH rows and the required number of columns corresponding to WW.
//
//            set(int row, char column, int val) : For setting the value of the cell corresponding to the given rowrow and columncolumn, we can simply change the value , valval, in the FormulasFormulas array at the indices corresponding to the current cell. Further, if any new formula is applied to a particular cell, we need to remove the previously applied formulas on the same cell. This is because two formulas can't be used to determine the value of a cell simultaneously. Now, setting a cell to a particular value can also be seen as a formula e.g. C1 = 2C1=2. Thus, we remove all the cellscells in the FormulasFormulas for the current cell. Further, when the current cell's value is changed, all the other cells which are dependent on it also need to be evaluated in the correct order. Thus, we make use of Topological Sorting starting with the current cell. We make use of a function topologicalSort(r, c) for this purpose.
//
//            topologicalSort(r, c): In every call to this function, we traverse over all the cells in the FormulasFormulas array and further apply topological sorting to all the        cells which are dependent on the current cell(row=r, column=c). To find these cells, we can check the cellscells in the FormulasFormulas associated with each cell        and check if the current cell lies in it. After applying Topological sorting to all these dependent cells, we put the current cell onto a stackstack.
//
//    After doing the topological sorting, the cells on the stackstack lie in the order in which their values should be evaluated given the current dependency chain        based on the formulas applied. Thus, we pick up these cells one by one, and evaluate their values. To do the evaluation, we make use of        calculate_sum(r, c, cells). In this function, we traverse over all the cellscells in the FormulasFormulas of the current cell(row=r, column=c), and keep on adding        their values. When this summing has been done, we update the current cell's value, valval, to the sum just obtained. We keep on doing so till all the cells in        the stackstack have been evaluated.
//
//    get(int row, char column) : We can simply obtain the value(valval) associated with the current cell's FormulasFormulas. If the cell has never been initialized previously, we can return a 0 value.
//
//    sum(int row, char column, List of Strings : numbers) : To implement this function, firstly, we need to expand the given numbersnumbers to obtain all the cells which need to be added in the current formula. We obtain them, by making use of a convert function, which extracts all these cells by doing appropriate expansions based on : values. We put all these cells in the cellscells associated with the current cell's FormulasFormulas. We also need to set the current cell's value to a new value based on the current formula added. For this, we make use of calculate_sum function as discussed above. We also need to do the topological sorting and evaluate all the cells dependent on the current cell. This is done in the same manner as in the set function discussed above. We also need to return the value to which the current cell has been set.


}
