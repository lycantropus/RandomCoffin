import java.util.ArrayList;
import java.util.Collections;


public class HundredPrisioners {

	
	
	public static void main (String[] args)
	{
		
		
		class Prisioner{
			
			private int prisionerNumber;
			
			Prisioner(int myNumber)
			{
				prisionerNumber = myNumber;
			}

			public int getPrisionerNumber() {
				return prisionerNumber;
			}
		}
		
		int numberOfGames = 1;
		
		int nPrisioners = 100;
		
		int nBoxes = nPrisioners;
		
		ArrayList<Integer> boxes = new ArrayList<Integer>(nBoxes);
		ArrayList<Prisioner> prisioners = new ArrayList<Prisioner>(nPrisioners);
		
		
		for(int i = 0; i< nBoxes; i++)
		{
			boxes.add(i);
			prisioners.add(new Prisioner(i));
		}
		
		
		
		int safePrisioners;
		
		
		if (args.length > 0) {
		    try {
		        numberOfGames = Integer.parseInt(args[0]);
		    } catch (NumberFormatException e) {
		        System.err.println("number of games " + args[0] + " must be an integer.");
		        System.exit(1);
		    }
		}
		
		
		int numberOfSafeRounds = 0;
		
		
		//serie of game loops
		for(int j = 0; j<numberOfGames; j++)
		{
			safePrisioners=0;
			Collections.shuffle(boxes);
		
			//game loop
			for (Prisioner prisioner : prisioners) {
				
				ArrayList<Integer> roomBoxes = boxes;
				
				int tries=0;
				
				Boolean found = false;
				
				int targetBox = prisioner.getPrisionerNumber();
					
				//prisioner loop
				while(tries <= nBoxes/2 && found != true)
				{
					if(roomBoxes.get(targetBox) == prisioner.getPrisionerNumber())
					{
						found=true;
						if(numberOfGames==1)
						{
						System.out.println("Found my Number! i'm number " + prisioner.prisionerNumber);
						}
						safePrisioners++;
					}
					else
					{
						targetBox=roomBoxes.get(targetBox);
					}
					tries++;
					
				}
				
			}
			
			if(numberOfGames==1)
			{
			System.out.println(safePrisioners + " prisioners found his number!");
			}
			
			if(safePrisioners == nPrisioners)
			{
				numberOfSafeRounds++;
			}
		}
		
		System.out.println("Combined success rate: " + (float) numberOfSafeRounds/numberOfGames);
	}
	
	
}
