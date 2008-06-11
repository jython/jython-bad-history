package org.python.antlr;

import org.antlr.runtime.tree.BaseTree;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.CommonToken;
import org.antlr.runtime.Token;

import java.io.DataOutputStream;
import java.io.IOException;

import org.python.antlr.ast.VisitorIF;

public class PythonTree extends CommonTree implements AST {

    public boolean from_future_checked = false;

    public PythonTree(int ttype, Token t) {
        super();
        CommonToken c = new CommonToken(ttype, t.getText());
		c.setLine(t.getLine());
		c.setTokenIndex(t.getTokenIndex());
		c.setCharPositionInLine(t.getCharPositionInLine());
		c.setChannel(t.getChannel());
        c.setStartIndex(((CommonToken)t).getStartIndex());
        c.setStopIndex(((CommonToken)t).getStopIndex());
        token = c;
    }

    public PythonTree(Token token) {
        super(token);
    }

    public PythonTree(PythonTree node) {
        super(node);
    }

    public String toString() {
        if (isNil()) {
            return "None";
        }
        return token.getText() + "(" + this.getLine() + "," + this.getCharPositionInLine() + ")";
    }

    public String toStringTree() {
        if (children == null || children.size() == 0) {
            // System.out.println("Where are my children? -- asks " + token.getText());
            return this.toString();
        }
        StringBuffer buf = new StringBuffer();
        if (!isNil()) {
            buf.append("(");
            buf.append(this.toString());
            buf.append(' ');
        }
        for (int i = 0; children != null && i < children.size(); i++) {
            BaseTree t = (BaseTree)children.get(i);
            if (i > 0) {
                buf.append(' ');
            }
            buf.append(t.toStringTree());
        }
        if (!isNil()) {
            buf.append(")");
        }
        return buf.toString();
    }

    public <R> R accept(VisitorIF<R> visitor) throws Exception {
        throw new RuntimeException("Unexpected node: " + this);
    }
    
    public void traverse(VisitorIF visitor) throws Exception {
        throw new RuntimeException("Cannot traverse node: " + this);
    }
}
