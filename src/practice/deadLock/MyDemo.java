package practice.deadLock;

public class MyDemo {
    public static final String obj1 = "obj1";
    public static final String obj2 = "obj2";

    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //int a = in.nextInt();
        //System.out.println(a);
        System.out.println("Hello World!");
        Thread threadA = new Thread (() -> {
            try {
                System.out.println("Lock1 running");
                while(true) {
                    synchronized(MyDemo.obj1) {
                        System.out.println("Lock1 lock obj1");
                        Thread.sleep(3000);//获取obj1后先等一会儿，让Lock2有足够的时间锁住obj2
                        synchronized(MyDemo.obj2) {
                            System.out.println("Lock1 lock obj2");
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        Thread threadB = new Thread (() -> {
            try {
                System.out.println("Lock2 running");
                while(true) {
                    synchronized(MyDemo.obj2){
                        System.out.println("Lock2 lock obj2");
                        Thread.sleep(3000);
                        synchronized(MyDemo.obj1) {
                            System.out.println("Lock2 lock obj1");
                        }
                    }
                }
            } catch(Exception e) {
                e.printStackTrace();
            }
        });

        threadA.start();
        threadB.start();

    }

    public static synchronized void A() {
        try{
            System.out.println("Lock2 running");
            while (true) {
                synchronized(MyDemo.obj2){
                    System.out.println("Lock2 lock obj2");
                    Thread.sleep(3000);
                    synchronized(MyDemo.obj1){
                        System.out.println("Lock2 lock obj1");
                    }
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public static synchronized void B() {
        try {
//            A();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
