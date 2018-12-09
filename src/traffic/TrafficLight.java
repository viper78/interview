package traffic;

import java.util.*;



public class TrafficLight {

    enum Color {
        RED, YELLOW, GREEN
    }
    Long timeout;
    Color currentColor;

    public TrafficLight(Color color, long timeout) {

        currentColor = color;
        this.timeout = timeout;
    }

    public Color currentColor() {
        return currentColor;
    }

    public void changeColor(Color color) {
        this.currentColor = color;
    }

    public void setTimeout(Long timeout) {
        this.timeout = timeout;
    }

    public void countdown() {

        for (long i = timeout; i >=0; i--) {
            try {
                Thread.sleep(1);
                if (timeout > 0)
                    timeout--;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}


class TrafficController {


    List<TrafficLight> lights;

    public TrafficController() {
        lights = new ArrayList<>();
        lights.add(new TrafficLight(TrafficLight.Color.RED, 1000));
        lights.add(new TrafficLight(TrafficLight.Color.YELLOW, 1000));
        lights.add(new TrafficLight(TrafficLight.Color.GREEN, 1000));
    }

    public void registerLight(TrafficLight light) {
        lights.add(light);
    }

    public void removeLight(TrafficLight light) {
        lights.remove(light);
    }

    public void execute() {

        while (true) {

            Collections.sort(lights, (tl1, tl2) -> tl1.timeout.compareTo(tl2.timeout));

            for (TrafficLight light : lights) {
                light.countdown();
                switch (light.currentColor) {
                    case RED:
                        if (light.timeout == 0) {
                            System.out.println("Changing to GREEN...");
                            light.changeColor(TrafficLight.Color.GREEN);
                            light.setTimeout(1000L);
                            light.countdown();
                        }
                        break;
                    case GREEN:
                        if (light.timeout == 0) {
                            System.out.println("Changing to YELLOW...");
                            light.changeColor(TrafficLight.Color.YELLOW);
                            light.setTimeout(1000L);
                            light.countdown();
                        }
                        break;
                    case YELLOW:
                        if (light.timeout == 0) {
                            System.out.println("Changing to RED...");
                            light.changeColor(TrafficLight.Color.RED);
                            light.setTimeout(1000L);
                            light.countdown();
                        }
                        break;
                }
            }

        }

    }

    public static void main(String[] args) {

        TrafficController controller = new TrafficController();
        controller.execute();
    }

}
    //} extends JPanel implements Runnable{

//    int redDuration,	// Time (in seconds) for duration of red light
//            yellowDuration,	// Time (in seconds) for duration of yellow light
//            greenDuration;	// Time (in seconds) for duration of green light
//    PedestrianLight PL;	// Associated coordinated pedestrian light
//    Color onLight;	// To indicate which color light is on
//
//    int TLWidth = 0;	// Width of traffic light
//    int TLHeight;		// Height of traffic light
//    int xOrigin;		// Coordinates of upper left-hand corner of
//    int yOrigin;          // traffic light
//    int xLCoor;		// x coordinate of lights
//    int yLCoor; 		// y coor of red light
//    int LDiam;		// Diameter of each light
//    int interLSpace;	// Space between lights
//
//    /*************************************
//     * Constructors
//     *************************************/
//
//    TrafficLight( PedestrianLight PL )	// One-parameter constructor
//    {
//        this.PL = PL;
//        onLight = Color.green;
//        redDuration = 15000;		// Set red duration to 15 secs
//        yellowDuration = 5000;		// Set yellow duration to 5 seconds
//        greenDuration = 15000;		// Set green duration to 15 secs
//    }
//
//
//
//    TrafficLight( PedestrianLight PL,Color c ) // Two-parameter constructor
//    {
//        this.PL = PL;
//        setOnLight( c );	  // Verify color setting
//        redDuration = 15000;		// Set red duration to 15 secs
//        yellowDuration = 5000;		// Set yellow duration to 5 seconds
//        greenDuration = 15000;		// Set green duration to 15 secs
//    }
//
//
//    TrafficLight( PedestrianLight PL,int redDur,int yellowDur,int greenDur ){
//        this.PL = PL;
//        onLight = Color.green;
//        redDuration = 1000*redDur;	// Duration params given in secs
//        yellowDuration = 1000*yellowDur;	// Convert to milliseconds
//        greenDuration = 1000*greenDur;
//    }
//
//    /**************************************
//     * Setters and getters
//     **************************************/
//
//    public Color getOnLight()
//    {
//        return onLight;
//    }
//
//    public void setOnLight( Color c )
//    {
//        // Setters and constructors should insure that class variables
//        // are set to valid values.
//        if ( c == Color.red || c == Color.yellow || c == Color.green )
//        {
//            onLight = c;
//        }
//        else
//        {
//            System.out.println("TrafficLight.setOnLight:  cannot set " +
//                    "traffic light to color " + c +
//                    "\nSetting color to default green.");
//            onLight = Color.green;
//        }
//    }
//
//    public void setColor( Color c ){
//        setOnLight( c );
//        repaint();
//    }
//
//    /************************************************
//     * Paint
//     ************************************************/
//
//    public void paintComponent(Graphics g)
//    {
//        super.paintComponent( g );		// For background
//        System.out.println("Painting traffic light again");
//        if ( TLWidth == 0 ){
//            Dimension d = getSize();		// Get size of panel
//            System.out.println("d = " + d);
//            TLWidth = d.width/2;		// Set width of traffic light
//            TLHeight = 3*d.height/4;		// Set height of traffic light
//            xOrigin = (d.width - TLWidth)/2; // Center traffic light on panel
//            yOrigin = (d.height - TLHeight)/2;
//            LDiam = TLHeight/6;			// Diameter of each light
//            xLCoor = xOrigin + (TLWidth - LDiam)/2;	// x coordinate of lights
//            interLSpace = (TLHeight - 3*LDiam)/4;	// Space between lights
//            yLCoor = yOrigin + interLSpace; 		// y coor of red light
//        }
//
//        Color colorSave = g.getColor();	// Save current color
//
//        //Draw outline of traffic light
//        g.setColor( Color.lightGray );
//        g.fill3DRect(xOrigin,yOrigin,TLWidth,TLHeight,true);
//
//        Color Red, Yellow, Green;		// Colors to change light to
//        // Change the light
//        if ( onLight == Color.red ){
//            Red = turnOn( Color.red );
//            Yellow = turnOff( Color.yellow );
//            Green = turnOff( Color.green );
//        }
//        else if ( onLight == Color.yellow ){
//            Red = turnOff( Color.red );
//            Yellow = turnOn( Color.yellow );
//            Green = turnOff( Color.green );
//        }
//        else{
//            Red = turnOff( Color.red );
//            Yellow = turnOff( Color.yellow );
//            Green = turnOn( Color.green );
//        }
//
//        // Now color the lights.  onLight is bright others are darkened.
//
//        g.setColor( Red );
//        g.fillOval(xLCoor,yLCoor,LDiam,LDiam);
//
//        g.setColor( Yellow );
//        g.fillOval(xLCoor,yLCoor+LDiam+interLSpace,LDiam,LDiam);
//
//        g.setColor( Green );
//        g.fillOval(xLCoor,yLCoor+2*LDiam+2*interLSpace,LDiam,LDiam);
//
//        // Now draw black outline around each light
//        g.setColor(Color.black);
//        // Red light
//        g.drawOval(xLCoor,yLCoor,LDiam,LDiam);
//        // Yellow light
//        g.drawOval(xLCoor,yLCoor+LDiam+interLSpace,LDiam,LDiam);
//        // Green light
//        g.drawOval(xLCoor,yLCoor+2*LDiam+2*interLSpace,LDiam,LDiam);
//
//        g.setColor(colorSave);		// Restore original color
//    }
//
//    /************************************************
//     * Auxillary methods used by paintComponent
//     ************************************************/
//
//    Color turnOn( Color c )
//    { return c.brighter().brighter(); }
//
//    Color turnOff( Color c )
//    { return c.darker().darker(); }
//
//    /************************************************
//     * run method as required by Runnable interface
//     ************************************************/
//
//    public void run(){
//        System.out.println("Entering TrafficLight.run()");
//        long startTime;
//        PL.setMessage( "Don't Walk" );
//        while ( true )
//        {
//            setColor( Color.red );      // Change traffic light to red
//            try{
//                System.out.println( "TL.run() sleep for " + redDuration +
//                        "milliseconds." );
//                Thread.sleep( redDuration );
//            }
//            catch ( InterruptedException e ) {}
//
//            startTime = System.currentTimeMillis();
//            setColor( Color.green );    	// Change traffic light to green
//            PL.setMessage( "Walk" );       // Change ped light to "Walk"
//            try{ 				// Sleep for 2/3 green dur minus time
//                startTime += 2*greenDuration/3; // to change lights
//                Thread.sleep( Math.max( 0,startTime-System.currentTimeMillis() ) );
//            }
//            catch ( InterruptedException e ) {}
//
//            //PL.setMessage( "Don't Walk" ); // change ped light to "Don't Walk"
//            //PL.setFlashing( true );        // & start ped light flashing.
//            startTime = System.currentTimeMillis();
//            PL.setMessage( "Don't Walk",true ); //Atomize above two calls
//            try{
//                startTime += greenDuration/3; // Sleep 1/3 green duration
//                Thread.sleep( Math.max( 0,startTime-System.currentTimeMillis() ) );
//            }
//            catch ( InterruptedException e ) {}
//
//            startTime = System.currentTimeMillis();
//            PL.setFlashing( false );    // Chg ped light from flash to solid
//            setColor( Color.yellow );   // Change traffic light to yellow
//            try{
//                startTime += yellowDuration;
//                Thread.sleep( Math.max( 0,startTime-System.currentTimeMillis() ) );
//            }
//            catch ( InterruptedException e ) {}
//        }
//    }
//
//    /************************************************/
//
//    // Inform layout managers of minimum and preferred sizes of panel
//    // IMPORTANT: be sure to spell the names of these functions correctly
//    // or else they will not be over ridden and will have no effect.
//
//    public Dimension getMinimumSize()
//    {System.out.println("getMinimumSize() called");
//        return new Dimension(50,100);
//    }
//    /************************************************/
//    public Dimension getPreferredSize()
//    {System.out.println("getPreferredSize() called");
//        return new Dimension(150,300);
//    }
//}
