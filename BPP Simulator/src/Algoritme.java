import java.util.ArrayList;

/**
 * Created by Eldin on 4/13/2015.
 */
public interface Algoritme {
     void setOrder(ArrayList<Packet> order);

     void startAlgo();

     void stopAlgo();

     void replaceBin(Bin bin);
}
