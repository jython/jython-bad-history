// Autogenerated AST node
package org.python.antlr.ast;
import org.python.antlr.PythonTree;
import org.antlr.runtime.CommonToken;
import org.antlr.runtime.Token;
import java.io.DataOutputStream;
import java.io.IOException;

public class Lambda extends exprType {
    public argumentsType args;
    public exprType body;

    private final static String[] fields = new String[] {"args", "body"};
    public String[] get_fields() { return fields; }

    public Lambda(argumentsType args, exprType body) {
        this.args = args;
        this.body = body;
        addChild(body);
    }

    public Lambda(Token token, argumentsType args, exprType body) {
        super(token);
        this.args = args;
        this.body = body;
        addChild(body);
    }

    public Lambda(int ttype, Token token, argumentsType args, exprType body) {
        super(ttype, token);
        this.args = args;
        this.body = body;
        addChild(body);
    }

    public Lambda(PythonTree tree, argumentsType args, exprType body) {
        super(tree);
        this.args = args;
        this.body = body;
        addChild(body);
    }

    public String toString() {
        return "Lambda";
    }

    public String toStringTree() {
        StringBuffer sb = new StringBuffer("Lambda(");
        sb.append("args=");
        sb.append(dumpThis(args));
        sb.append(",");
        sb.append("body=");
        sb.append(dumpThis(body));
        sb.append(",");
        sb.append(")");
        return sb.toString();
    }

    public <R> R accept(VisitorIF<R> visitor) throws Exception {
        return visitor.visitLambda(this);
    }

    public void traverse(VisitorIF visitor) throws Exception {
        if (args != null)
            args.accept(visitor);
        if (body != null)
            body.accept(visitor);
    }

    public int getLineno() {
        return getLine();
    }

    public int getCol_offset() {
        return getCharPositionInLine();
    }

}
