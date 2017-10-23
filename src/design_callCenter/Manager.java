package design_callCenter;

public class Manager implements Employee{
	public int level;
	public int ID;
	public Call currCall;
	public CallCenter location;
	public Manager(int ID){
		this.ID=ID;
		this.level=Employee.Rep;
	}
	@Override
	public void takeCall(Call c) {
		if(c==null){
			return;
		}
		this.currCall=c;
	}
	@Override
	public void finishCall() {
		this.currCall=null;
		this.location.employees.get(this.level).offer(this);
	}
	@Override
	public int getLevel() {
		return this.level;
	}
}
