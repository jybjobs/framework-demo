package com.sma.demo.problem;

import me.champeau.jdoctor.Problem;
import me.champeau.jdoctor.Solution;

import java.util.List;
import java.util.function.Consumer;

/**
 * @TODO 后续改为通过MDC打印日志
 */
public class SmaTextRenderer {
    private static final boolean isNeedPrefix=false;
    private static final String DEFAULT_PREFIX = "";
    public static <ID extends Enum<ID>, SEVERITY extends Enum<SEVERITY>, CONTEXT> String render(Problem<ID, SEVERITY, CONTEXT> problem) {
        return render("A problem happened", problem);
    }

    public static <ID extends Enum<ID>, SEVERITY extends Enum<SEVERITY>, CONTEXT> String render(String header, Problem<ID, SEVERITY, CONTEXT> problem) {
        StringBuilder sb = new StringBuilder();
        TreeNode treeNode = new TreeNode(sb, 0);
        treeNode.node(header + ": ")
              //  .append("["+problem.getId().name()+"] ")
                .append(problem.getWhat());
        CONTEXT where = problem.getWhere();
        treeNode.newLine();
        treeNode.node(getMessage("Where? : " ,where.toString()));
        problem.getWhy().ifPresent(reason -> {
            treeNode.newLine();
            treeNode.node(getMessage( "Why? : " , reason ));
        });
        problem.getLongDescription().ifPresent(desc -> {
            treeNode.newLine();
            treeNode.node(getMessage("Details: " , desc));
        });
        List<Solution> possibleSolutions = problem.getPossibleSolutions();
        if (possibleSolutions.size() == 1) {
            treeNode.newLine();
            treeNode.node(getMessage("Possible solution: " , possibleSolutions.get(0).getShortDescription()));
        } else if (possibleSolutions.size() > 0) {
            treeNode.newLine();
            treeNode.children("Possible solutions:", n ->
                    possibleSolutions.stream()
                            .map(Solution::getShortDescription)
                            .map(d -> "- " + d)
                            .forEachOrdered(n::node));
        }
        problem.getDocumentationLink().ifPresent(url -> {
            treeNode.newLine();
            treeNode.node("You can learn more about this problem at " + url);
        });
        return sb.toString();
    }

    private static String getMessage(String prefix,String desc){
        return isNeedPrefix ? (prefix + desc) : (DEFAULT_PREFIX + desc);
    }

    private static class TreeNode {
        private final static String INDENT = "    ";
        private final StringBuilder builder;
        private final int level;
        boolean addNewLine = false;

        private TreeNode(StringBuilder builder, int level) {
            this.builder = builder;
            this.level = level;
        }

        public TreeNode children(String text, Consumer<? super TreeNode> consumer) {
            node(text);
            TreeNode childNode = new TreeNode(builder, level + 1);
           // childNode.addNewLine = true;
            consumer.accept(childNode);
            return this;
        }

        public TreeNode newLine() {
//            builder.append("\n");
            builder.append(" --- ");
            return this;
        }

        public TreeNode append(String text) {
            builder.append(text);
            return this;
        }

        public TreeNode node(String text) {
            if (addNewLine) {
                builder.append("\n");
            }
            for (int i = 0; i < level; i++) {
                builder.append(INDENT);
            }
            builder.append(text);
          //  addNewLine = true;
            return this;
        }
    }
}