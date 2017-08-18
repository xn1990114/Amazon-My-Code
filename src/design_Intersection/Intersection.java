package design_Intersection;

public class Intersection {
	//index 0-up,2-down, 1-left,3-right
	static final int defaultTimer=40;
	TrafficLight[] lights;
	int[] next;
	Sensor[] sensors;
	public Intersection(){
		this.lights=new TrafficLight[4];
		this.sensors=new Sensor[4];
		for(int i=0;i<4;i++){
			this.lights[i]=new TrafficLight();
			this.sensors[i]=new Sensor();
		}
		this.next=new int[4];
	}
	public void setSensor(int index,int status){
		for(int i=0;i<this.sensors.length;i++){
			if(i%2==index%2){
				sensors[i].status=Math.max(sensors[i].status, status);
			}
			else{
				sensors[i].status=Sensor.noTraffic;
			}
		}
	}
	
	public boolean checkSensor(){
		for(int i=0;i<this.sensors.length;i++){
			next[i]=this.sensors[i].status;
		}
		for(int i=0;i<this.next.length;i++){
			if(this.next[i]>0){
				return true;
			}
		}
		return false;
	}
	public void updateStatus() throws Exception{
		if(checkSensor()){
			boolean includeLeft=false;
			for(int i=0;i<next.length;i++){
				this.lights[i].status=next[i];
				next[i]=0;
				if(this.lights[i].status==2){
					includeLeft=true;
				}
			}
			for(int i=0;i<4;i++){
				System.out.print(this.lights[i].status+"\t");
			}
			if(includeLeft){
				Thread.sleep(3000);
				for(int i=0;i<this.lights.length;i++){
					TrafficLight curr=this.lights[i];
					if(curr.status==0){
						curr.setStatus(0, Intersection.defaultTimer);
					}
					else{
						curr.setStatus(1, Intersection.defaultTimer);
					}
				}
			}
		}
		else{
			for(int i=0;i<this.lights.length;i++){
				this.lights[i].setStatus(this.lights[i].status, this.lights[i].timer+5);
			}
		}
		if(checkMalfunction()){
			System.out.println("Error !");
		}
	}
	
	public boolean checkMalfunction(){
		if(lights[0].status+lights[2].status>2||lights[1].status+lights[3].status>2){
			for(int i=0;i<this.lights.length;i++){
				this.lights[i].setStatus(TrafficLight.Red, -1);
			}
			return true;
		}
		return false;
	}
}
