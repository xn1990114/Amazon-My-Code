package design_callCenter;
import java.util.*;

public class CallCenter {
	public List<Queue<Employee>> employees;
	public Set<Call> calls;
	public CallCenter(){
		this.employees=new ArrayList<Queue<Employee>>();
		for(int i=0;i<3;i++){
			this.employees.add(new LinkedList<Employee>());
		}
	}
	public boolean ProcessCall(Call c){
		if(c==null){
			return false;
		}
		calls.add(c);
		Employee assignee=null;
		for(int i=c.requiredLevel;i<3;i++){
			if(!employees.get(i).isEmpty()){
				assignee=employees.get(i).poll();
			}
		}
		if(assignee==null){
			return false;
		}
		c.setRespondent(assignee);
		
		return true;
	}
	public void EndCall(Call c){
		if(c==null){
			return;
		}
		Employee asignee=c.respondent;
		this.employees.get(asignee.getLevel()).offer(asignee);
		calls.remove(c);
		c.setFinish();
	}
}
