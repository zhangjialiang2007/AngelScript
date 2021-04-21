package angel.ast;
import java.util.List;

import angel.env.Enviroment;

public class WhileStmnt extends ASTList{
	public WhileStmnt(List<ASTree> tree){super(tree);}
	public ASTree condition(){return child(0);}
	public ASTree body(){return child(1);}
	public String toString(){
		return "(while " + condition() + " " + body() + ")";
	}
	public Object eval(Enviroment env) {
		Object result = 0;
		for(;;) {
			Object obj = condition().eval(env);
			if(obj instanceof Integer && ((Integer)obj).intValue() == 0) {
				return result;
			}else {
				result = body().eval(env);
			}
		}
	}
}