
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class AngryBird implements Runnable{

    private Display display;
    public Thread thread;
    private boolean running=false;
    private BufferStrategy bs;
    private Graphics g;
    private int birdX,birdY;
    private int width=1200,height=600;
    int maxvv=17,maxhv=17;
    private double vv=maxvv,hv=maxhv;
    boolean firstTime=true;
    double gravity=-0.5;
    double delay=0;
    double startTime;
    public void init(){
        birdX=30;
        birdY=height-30;
        display=new Display();
        startTime=System.nanoTime();
    }

    public void update(){
        if(birdY + 30 == height && birdX + 30 == width)
            running=false;
        else{
            //System.out.println(birdX);
            if(delay==0) {
                vv += gravity;
                birdX += hv;
                if (birdX + 30 == width) {
                    hv=0;
                }
                birdY += vv * -1;
                if (birdY + 30 == height) {
                    delay = 20;
                    vv = maxvv;
                }
            }
            else
                delay--;
            if(birdX>1170)
                birdX=1170;
            if(birdY>570)
                birdY=570;
        }
    }
    public void render(){
        Toolkit.getDefaultToolkit().sync();
        bs=display.canvas.getBufferStrategy();
        if(bs==null) {
            display.canvas.createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        g.clearRect(0,0,width,height);
        // Start drawing
        g.setColor(Color.green);
        g.fillRect(0,0,width,height);
        g.setColor(Color.red);
        g.fillOval(birdX,birdY,30,30);
        g.setColor(Color.black);
        g.drawRect(width-30,height-30,30,30);

        //End drawing
        bs.show();
        g.dispose();
    }

    @Override
    public void run() {
        init();
        int fps=60;
        double timePerTick=1000000000/fps;
        double delta=0;
        long now;
        long lastTime=System.nanoTime();

        while (running){
            now=System.nanoTime();
            delta+=(now-lastTime)/timePerTick;
            lastTime=now;
            if(delta >= 1){
                update();
                render();
                delta--;
            }
        }
        System.out.println("Time elapsed: "+(System.nanoTime()-startTime)/1000000000.0+" Seconds");
        stop();
    }

    public synchronized void start(){
        if(running)
            return;
        running=true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop() {
        if(!running)
            return;
        running=false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
