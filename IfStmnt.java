package angel.ast;
import java.util.List;

import angel.env.Enviroment;

public class IfStmnt extends ASTList{
	public IfStmnt(List<ASTree> tree){super(tree);}
	public ASTree condition(){return child(0);}
	public ASTree thenBlock(){return child(1);}
	public ASTree elseBlock(){
		return numChildren() > 2 ? child(2) : null;
	}
	public String toString(){
		return "(if " + condition() + " " + thenBlock() + " else " + elseBlock() + ")";
	}
	public Object eval(Enviroment env) {
		Object obj = condition().eval(env);
		if(obj instanceof Integer && ((Integer)obj).intValue() != 0) {
			return thenBlock().eval(env);
		}else {
			ASTree eb = elseBlock();
			if(eb == null) {
				return 0;
			}else {
				return eb.eval(env);
			}
		}
	}
}