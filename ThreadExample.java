class DownloadImage{
    void downloadImage(String name, int size){
        for (int i = 0; i < size; i++) {
            System.out.println("downloading image cat"+name);
        }
    }
}

class mythread extends Thread{
    DownloadImage dref;
    mythread(DownloadImage dref){
        this.dref=dref;
    }
    @Override
    public void run(){
        dref.downloadImage("dog" , 10);
    }
}

class yourthread extends Thread{
    DownloadImage dref;
    yourthread(DownloadImage dref){
        this.dref=dref;
    }
    @Override
    public void run(){
        dref.downloadImage("dog" , 10);
    }
}


public class ThreadExample extends Thread{
    @Override
    public void run(){
        for (int i = 0; i < 100; i++) {
            System.out.println("dowmload image cat" + i + "");            
        }
    }
    public static void main(String[] args) {
        System.out.println("application started");
        for (int i = 0; i < 100; i++) {
            System.out.println("download image dog" + i + ".jpg");
        }
        DownloadImage dref = new DownloadImage();
        mythread t1 = new mythread(dref);
        yourthread t2 = new yourthread(dref);
        t1.start();
        t2.start();
        System.out.println("application stopped");
    }
}
