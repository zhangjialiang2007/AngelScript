package angel.ast;
import java.util.List;

import angel.base.AngelException;
import angel.env.Enviroment;

import java.util.Iterator;

public class ASTList extends ASTree{
	protected List<ASTree> children;
	public ASTList(List<ASTree> list){children = list;}
	public ASTree child(int i){return children.get(i);}
	public int numChildren(){return children.size();}
	public Iterator<ASTree> children(){return children.iterator();}
	public String toString(){
		StringBuilder builder = new StringBuilder();
		builder.append('(');
		String sep = "";
		for(ASTree t: children){
			builder.append(sep);
			sep = " ";
			builder.append(t.toString());
		}
		return builder.append(')').toString();
	}
	public String location(){
		for(ASTree t: children){
			String s = t.location();
			if(s != null){
				return s;
			}
		}		
		return null;
	}
	
	public Object eval(Enviroment env) {
		throw new AngelException("can not eval " + toString(), this);
	}
}