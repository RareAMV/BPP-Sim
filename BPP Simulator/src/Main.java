import java.util.ArrayList;

/**
 * Created by Eldin on 4/9/2015 for Windesheim Magazijn Robot KBS
 * This class is where everything starts running
 */
public class Main {
    
    private static int binHeight = 400;
    private static int binWidth = 150;
    private static int binHspacing = 25;
    private static int binWspacing = 25;
    private static ArrayList<Bin> binArray = new ArrayList<Bin>();
    private static ArrayList<Packet> order = new ArrayList<Packet>();
    private static ArrayList<Drawer> drawers = new ArrayList<Drawer>();

    private static SimpelGretig test;


    public static void main(String[] args) {
        /**
         * This methode runs everything, creatin
         * g and showing the window, creating bins, creating packets and putting them into
         * the bins, and drawing the bins containing those packets on the main screen.
         */




        //create bins with: x, y, width, height, ContentHeight
        Bin bin1 = new Bin(10);
        Bin bin2 = new Bin(10);
        Bin bin3 = new Bin(10);
        Bin bin4 = new Bin(10);
        Bin bin5 = new Bin(10);
        Bin bin6 = new Bin(10);
//        Bin bin6 = new Bin(((binWspacing * 6) + binWidth * 5), binHspacing, binWidth, binHeight, 10);

        binArray.add(bin1);
        binArray.add(bin2);
        binArray.add(bin3);
        binArray.add(bin4);
        binArray.add(bin5);
        binArray.add(bin6);


        //create packets with: packetID , ContentHeight
          Packet packet1 = new Packet(0);

        for(Bin bin : binArray){
            bin.addPacket(packet1);
        }

        Drawer draw1 = new Drawer("Simpel gretig",bin1, bin2, binHeight, binWidth);
        Drawer draw2 = new Drawer("Gretig",bin3, bin4, binHeight, binWidth);
        Drawer draw3 = new Drawer("Volledige enumeratie Algoritme",bin5, bin6, binHeight, binWidth);
        drawers.add(draw1);
        drawers.add(draw2);
        drawers.add(draw3);
        int x = 0;
        while(true){
            if(x == 5){
                break;
            }
            bin3.addPacket(packet1);
            x++;
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
//        Drawer draw2 = new Drawer(bin3, bin4);

        //retrieve all the dimensions for the to be drawn bins and packages
        //create screen and drawer
        MainScreen screen = new MainScreen(drawers, binArray, order);
        screen.addToScreen(draw1);
        screen.addToScreen(draw2);
        screen.addToScreen(draw3);

        test = new SimpelGretig(bin1, bin2, screen, draw1, 1);

        test.setOrder(order);

        screen.addSimpelGretig(test);


        System.out.println("Bin capacity after adding packets: " + bin1.getBinCapacityLeft());

    }
}
