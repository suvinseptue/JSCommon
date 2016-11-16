import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author suwen.yang
 * @date 2016/10/27
 */

public class TickTack {

   private List<Pointer> ticks = Lists.newArrayList();


    /**
     * remember the tick point of desc.
     * @param desc
     */
    public void tick(String desc){
        ticks.add(Pointer.newInstance(desc));
    }

    /**
     * tick and tack
     * @param desc
     */
    public void tickTack(String desc){
        tick(desc);
        tack();
    }

    public TickTack(){
        ticks = Lists.newArrayList();
        ticks.add(Pointer.newInstance("Tick Start!"));
    }

    /**
     * print every tick point
     */
    public void printAll(){
        for (int i = 2 ; i<ticks.size();i++){
            Pointer cur = ticks.get(i);
            System.out.println(cur.point+" takes : "+ (cur.time-ticks.get(i-2).time)/1000000+"ms.");
        }
    }

    /**
     * print the latest tick point
     */
    public void tack(){
        if(ticks.size()<2){
            return;
        }
        Pointer cur = ticks.get(ticks.size()-1);

        System.out.println(cur.point+" takes : "+(cur.time-ticks.get(ticks.size()-2).time)/1000000+"ms.");
    }

    /**
     * Each tick-tack point.
     */
    private static class Pointer{
        long time;
        String point;

        public static Pointer newInstance(String pointer){
            Pointer p = new Pointer();
            p.time = System.nanoTime();
            p.point = pointer;
            return p;
        }
    }
}
