You need to install SUMO: https://eclipse.dev/sumo/

You need to install Maven: https://maven.apache.org/

You need to install VSCODE: https://code.visualstudio.com/download)https://code.visualstudio.com/download

After that, use Maven commands using Terminal to install the dependencies found in the Pom.xml file (there are other ways to do this on the internet)

Example of command using Terminal:
mvn install:install-file -Dfile="YOURPATH\vscode-workspace\sim\lib\libsumo-1.18.0.jar" -DgroupId="libsumo-1.18.0" -DartifactId="libsumo-1.18.0" -Dversion="libsumo-1.18.0" -Dpackaging="jar" -DgeneratePom=true

This command will enable what you can found in the Pom.xml file:

![image](https://github.com/21lab-technology/sim/assets/94874350/5f4e1f33-5a2b-4a5f-aacc-5ebf0c3b3df6)

At YOURPATH\vscode-workspace\sim\src\main\java\sim\traci4j you will find support for TraCI - Interact with the Simulation in the source code. TraCI4J - A Java Package implementing the TraCI Protocol.

![image](https://github.com/21lab-technology/sim/assets/94874350/9861cc7a-41ae-44b1-8b5f-fbc02865d611)

*****To use it, make the necessary changes in the source code, starting with the correct way to connect with SUMO*****

This is very important, it allows the actuation (Actuating on Vehicles): https://cst.fee.unicamp.br/sites/default/files/sumo/sumo-roadmap.pdf

Please read the documentation: Another complex class in TraCI4J (even though not so complex as the TrafficLight class) is the Vehicle class. It is important to know that in SUMO, each Vehicle is an object with its own attributes and behavior. Because there are many vehicles which in principle might behave equally, it is possible to define Vehicle Types, generalizing some properties which will remain the same for all the vehicles of the same type. ****From the point of view of a Vehicle Type, it is possible to redefine most of the vehicle type parameters, like acceleration and deceleration, length, maximum speed and minimum gap to other vehicles. Specifically to each Vehicle, it is possible to define and redefine the vehicle color, the change lane model, the route intended by the vehicle, the speed and the final target. It is possible still to grab information about the vehicle CO2 emission, the CO emission, the actual edge where the vehicle is, the actual lane, the position within the lane, the fuel consumption, the Hc emission, the noise emission, the NOx emission, the PMx emission, the overall position (not the relative position within the lane) and the vehicle’s id and type.****
Again, just like in the case of Traffic Lights, ****to actuate in a vehicle will demand some responsibility. As it is possible to change vehicle’s routes, there is always a chance that the reprogrammed route is unfeasible. In this case, this will make the vehicle to be “teleported” out from the simulation before the final route is reached. 
If you change the speed, SUMO will assume that you are controlling the vehicle and will maintain the speed until you command another change in speed or give back to SUMO the control (by setting a speed of -1). This can potentially cause accidents and indeed SUMO is prepared to handle situations like accidents and crashes that might congestion the affected lane and create delays in traffic, just like in a real case.****
