package Main;

public class Calculator {
	
	public static double getLocationCost(int q, int c, boolean f) {
		int index = 0;
		int screenCost = 0;
		int[][] quantity = {{12,36},
							{37,72},
							{73,108},
							{109,288},
							{289,576},
							{577,1008},
							{1009,2900}};
		
		double[][] data = {{1.70,2.00,2.30,2.60,2.90,3.25},
						   {1.35,1.65,1.90,2.10,2.35,2.60},
						   {1.25,1.50,1.70,1.85,2.00,2.25},
						   {1.10,1.25,1.40,1.50,1.65,1.80},
						   {0.90,1.05,1.15,1.25,1.35,1.45},
						   {0.80,0.85,1.00,0.95,1.00,1.05},
						   {0.65,0.68,0.73,0.75,0.85,0.95}};
		
		for(int i = 0; i < quantity.length; i++) {
			if(q >= quantity[i][0] && q <= quantity[i][1]) {
				index = i;
				break;
			}
		}
		
		if(c == 0)
			return 0;
		else {
			if(f)
				return data[index][c-1]+(c*0.15);
			return data[index][c-1];
		}
		
	}
}
