package angel.ast;
import java.util.List;

import angel.base.AngelException;
import angel.env.Enviroment;

public class BinaryExpr extends ASTList{
	public BinaryExpr(List<ASTree> list){super(list);}
    public ASTree left(){return child(0);}
	public String operator(){
		return ((ASTLeaf)child(1)).token.getText();
	}
	public ASTree right(){return child(2);}
	
	public Object eval(Enviroment env) {
		String op = operator();
		if("=".equals(op)) {
			Object right = right().eval(env);
			return computeAssign(env,right);
		}else{
			Object left = left().eval(env);
			Object right = right().eval(env);
			return computeOp(left,op,right);
		}		
	}
	protected Object computeAssign(Enviroment env, Object rvalue) {
		ASTree lvalue = left();
		if(lvalue instanceof Name) {
			env.put(((Name)lvalue).name(), rvalue);
			return rvalue;
		}else {
			throw new AngelException("bad assignment", this);
		}
	}
	protected Object computeOp(Object left, String op, Object right) {
		if(left instanceof Integer && right instanceof Integer) {
			return computeNumber((Integer)left,op,(Integer)right);
		}else{
			if(op.equals("+")) {
				return String.valueOf(left) + String.valueOf(right);
			}else if(op.equals("==")) {
				if(left == null) {
					return right == null ? 1 : 0;
				}else {
					return left.equals(right) ? 1 : 0;
				}
			}else {
				throw new AngelException("bad type",this);
			}
		}
	}
	protected Object computeNumber(Integer left, String op, Integer right) {
		int lvalue = left.intValue();
		int rvalue = right.intValue();
		if(op.equals("+")) {
			return lvalue + rvalue;
		}else if(op.equals("-")) {
			return lvalue - rvalue;
		}else if(op.equals("*")) {
			return lvalue * rvalue;
		}else if(op.equals("/")) {
			return lvalue / rvalue;
		}else if(op.equals("%")) {
			return lvalue % rvalue;
		}else if(op.equals("==")) {
			return lvalue == rvalue ? 1 : 0;
		}else if(op.equals("!=")) {
			return lvalue != rvalue ? 1 : 0;
		}else if(op.equals(">")) {
			return lvalue > rvalue ? 1 : 0;
		}else if(op.equals("<")) {
			return lvalue < rvalue ? 1 : 0;
		}else{
			throw new AngelException("bad operator", this);
		}
		
	}
}