package airport;
import java.util.*;

public class ControlCenter {
	PriorityQueue<Plane> planeQueue;
	Queue<Integer> runWayQueue;
	Map<Integer,RunWay> runWayMap;
	Map<String,Plane> parkingLot;
	public ControlCenter(int smallRunWayCount,int largeRunWayCount){
		this.planeQueue=new PriorityQueue<Plane>(new Comparator<Plane>(){
			public int compare(Plane p1,Plane p2){
				return p1.scheduledTime-p2.scheduledTime;
			}
		});
		this.runWayQueue=new LinkedList<Integer>();
		this.runWayMap=new HashMap<Integer,RunWay>();
		int i=1;
		while(i<=smallRunWayCount){
			RunWay toadd=new RunWay(i);
			this.runWayQueue.offer(toadd.id);
			this.runWayMap.put(toadd.id, toadd);
		}
		this.parkingLot=new HashMap<String,Plane>();
	}
	
	public void assignNextPlane(){
		if(this.planeQueue.isEmpty()){
			return;
		}
		Plane p=this.planeQueue.poll();
		Queue<Integer> runwayQueue=this.runWayQueue;
		if(runwayQueue.isEmpty()){
			DelayPlane(p,15);
			return;
		}
		RunWay rw=this.runWayMap.get(runwayQueue.poll());
		rw.addPlane(p);
		p.enterRunWay(rw);
		if(this.parkingLot.keySet().contains(p.id)){
			this.parkingLot.remove(p.id);
		}
	}
	public void DelayPlane(Plane p,int delay){
		p.onHold(delay);
		this.planeQueue.offer(p);
	}
	public void sendOffPlane(RunWay rw){
		rw.occupiedPlane.takeoff();
		rw.removePlane();
		this.runWayQueue.offer(rw.id);
	}
	public void receivePlane(RunWay rw){
		Plane p=rw.occupiedPlane;
		this.parkingLot.put(p.id,p);
		p.park();
		rw.removePlane();
		this.runWayQueue.offer(rw.id);
	}
}
