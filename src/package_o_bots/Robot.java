package package_o_bots;

public interface Robot {
	
	 enum RobotType {
		 UNIPEDAL,
		 BIPEDAL,
		 QUADRUPEDAL,
		 ARACHNID,
		 RADIAL,
		 AERONAUTICAL
	}
	 
	public String getBotName();
	
	public RobotType getBotType();
}
