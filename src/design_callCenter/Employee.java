package design_callCenter;

public interface Employee {
	public final static int Rep=0;
	public final static int Mag=1;
	public final static int Dir=2;
	public void takeCall(Call c);
	public void finishCall();
	public int getLevel();
}
