package design_callCenter;

public class Call {
	public int source;
	public int requiredLevel;
	public Employee respondent;
	public boolean finished;
	public Call(int source){
		this.source=source;
		this.finished=false;
	}
	public void setRespondent(Employee e){
		this.respondent=e;
	}
	public void setFinish(){
		this.finished=true;
	}
}
