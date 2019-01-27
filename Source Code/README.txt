Author: Maxime Cardinal
Date: November 29, 2018
version: 1
Edit: None

Classes Explanation: 
	
	Package: ca.mcgill.ecse211.project =>
 
		DesignProjectMain:
		
			DesignProjectMain is the main class of the project. It is 				responsible for initiating the other classes,
			initiating the odometer thread, calling relevant methods and 				initiating all the motors, sensors and
			important parameters.

		Wifi:
		
			This class is responsible for receiving the parameters from 				the server and sending them to the 
			main class.

	Package: navigation =>

		Localization:
	
			This class contains the methods to get the initial board 				light reference, execute the light sensor localization and 				execute the ultrasonic sensor localization. 

		TravelToInitialPosition:

			This class contains the methods to travel the robot from the 				tree to its initial position.

		TravelToTree:
	
			This class contains the methods to travel the robot from its 				starting grid intersection to its tree. 

	Package: odometer =>

		Odometer:

			This class runs as a thread. It is responsible for keeping 				track of the robot's position. 

		OdometerData:

			This class contains the methods to access the data concerning 			the position of the robot.
		
		OdometerException:

			This class is an odometer exception object.

	Package: ringHandling =>

		RingRetrieval:

			This class contains the methods to retrieve a ring, identify 				the color of a ring and unload a ring.