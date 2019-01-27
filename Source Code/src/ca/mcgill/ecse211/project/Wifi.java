package ca.mcgill.ecse211.project;

import java.util.Map;

import ca.mcgill.ecse211.WiFiClient.WifiConnection;

/**
 * "Wifi" class is responsible for receiving the game parameters from the server and
 * transfering them to the "DesignProjectMain" class
 * 
 * @author Michael Smith, Tharsan Ponnampalam (1)
 * @version 1.1
 * @editHistory Maxime Cardinal - Modification of the class to pass the received 
 * 									data to the main class (DesignProjectMain) (07/11/2018) (1.1)
 */
public class Wifi {

  // ** Set these as appropriate for your team and current situation **
  private static final String SERVER_IP = "192.168.2.2";
  private static final int TEAM_NUMBER = 17;
  public static boolean dataReceived = false;

  // Enable/disable printing of debug info from the WiFi class
  private static final boolean ENABLE_DEBUG_WIFI_PRINT = false;

  @SuppressWarnings("rawtypes")
  public static void main(String[] args) {

    System.out.println("Running..");

    // Initialize WifiConnection class
    WifiConnection conn = new WifiConnection(SERVER_IP, TEAM_NUMBER, ENABLE_DEBUG_WIFI_PRINT);

    // Connect to server and get the data, catching any errors that might occur
    try {
      /*
       * getData() will connect to the server and wait until the user/TA presses the "Start" button
       * in the GUI on their laptop with the data filled in. Once it's waiting, you can kill it by
       * pressing the upper left hand corner button (back/escape) on the EV3. getData() will throw
       * exceptions if it can't connect to the server (e.g. wrong IP address, server not running on
       * laptop, not connected to WiFi router, etc.). It will also throw an exception if it connects
       * but receives corrupted data or a message from the server saying something went wrong. For
       * example, if TEAM_NUMBER is set to 1 above but the server expects teams 17 and 5, this robot
       * will receive a message saying an invalid team number was specified and getData() will throw
       * an exception letting you know.
       */
      Map data = conn.getData();
      dataReceived = true;
      
      int redTeam = ((Long) data.get("RedTeam")).intValue();
      int greenTeam = ((Long) data.get("GreenTeam")).intValue();
      
      //The team number correspond to the red team
      if(redTeam == TEAM_NUMBER) {
    	  
    	  //Starting corner 
    	  DesignProjectMain.StartingCorner = ((Long) data.get("RedCorner")).intValue();
    	  
    	  //Lower left corner of the red team zone
          DesignProjectMain.CO_LL_x = ((Long) data.get("Red_LL_x")).intValue();
          DesignProjectMain.CO_LL_y = ((Long) data.get("Red_LL_y")).intValue();
          //Upper right corner of the red team zone
          DesignProjectMain.CO_UR_x = ((Long) data.get("Red_UR_x")).intValue();
          DesignProjectMain.CO_UR_y = ((Long) data.get("Red_UR_y")).intValue();
          
          //Lower left corner of the island
          DesignProjectMain.Island_LL_x = ((Long) data.get("Island_LL_x")).intValue();
          DesignProjectMain.Island_LL_y = ((Long) data.get("Island_LL_y")).intValue();
          //Upper right corner of the island
          DesignProjectMain.Island_UR_x = ((Long) data.get("Island_UR_x")).intValue();
          DesignProjectMain.Island_UR_y = ((Long) data.get("Island_UR_y")).intValue();
          
          //Lower left corner of the red team tunnel
          DesignProjectMain.TN_LL_x = ((Long) data.get("TNR_LL_x")).intValue();
          DesignProjectMain.TN_LL_y = ((Long) data.get("TNR_LL_y")).intValue();
          //Upper right corner of the red team tunnel
          DesignProjectMain.TN_UR_x = ((Long) data.get("TNR_UR_x")).intValue();
          DesignProjectMain.TN_UR_y = ((Long) data.get("TNR_UR_y")).intValue();
          
          //Ring set
          DesignProjectMain.T_x = ((Long) data.get("TR_x")).intValue();
          DesignProjectMain.T_y = ((Long) data.get("TR_y")).intValue();
          
      }
      //The team number correspond to the green team
      else if(greenTeam == TEAM_NUMBER) {
    	  
    	  //Starting corner 
    	  DesignProjectMain.StartingCorner = ((Long) data.get("GreenCorner")).intValue();
    	  
    	  //Lower left corner of the green team zone
          DesignProjectMain.CO_LL_x = ((Long) data.get("Green_LL_x")).intValue();
          DesignProjectMain.CO_LL_y = ((Long) data.get("Green_LL_y")).intValue();
          //Upper right corner of the green team zone
          DesignProjectMain.CO_UR_x = ((Long) data.get("Green_UR_x")).intValue();
          DesignProjectMain.CO_UR_y = ((Long) data.get("Green_UR_y")).intValue();
          
          //Lower left corner of the island
          DesignProjectMain.Island_LL_x = ((Long) data.get("Island_LL_x")).intValue();
          DesignProjectMain.Island_LL_y = ((Long) data.get("Island_LL_y")).intValue();
          //Upper right corner of the island
          DesignProjectMain.Island_UR_x = ((Long) data.get("Island_UR_x")).intValue();
          DesignProjectMain.Island_UR_y = ((Long) data.get("Island_UR_y")).intValue();
          
          //Lower left corner of the green team tunnel
          DesignProjectMain.TN_LL_x = ((Long) data.get("TNG_LL_x")).intValue();
          DesignProjectMain.TN_LL_y = ((Long) data.get("TNG_LL_y")).intValue();
          //Upper right corner of the green team tunnel
          DesignProjectMain.TN_UR_x = ((Long) data.get("TNG_UR_x")).intValue();
          DesignProjectMain.TN_UR_y = ((Long) data.get("TNG_UR_y")).intValue();
          
          //Ring set
          DesignProjectMain.T_x = ((Long) data.get("TG_x")).intValue();
          DesignProjectMain.T_y = ((Long) data.get("TG_y")).intValue();
    	  
      }
      
    } catch (Exception e) {
      System.err.println("Error: " + e.getMessage());
    }
  }
}