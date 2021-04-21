package angel.ast;
import java.util.List;

import angel.base.AngelException;
import angel.env.Enviroment;

public class NegativeExpr extends ASTList{
	public NegativeExpr(List<ASTree> tree){super(tree);}
	public ASTree operand(){return child(0);}
	public String toString(){return "-" + operand();}
	public Object eval(Enviroment env) {
		Object obj = operand().eval(env);
		if(obj instanceof Integer) {
			return new Integer(-((Integer)obj).intValue());
		}else {
			throw new AngelException("bad type for -", this);
		}		
	}
}