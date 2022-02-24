import java.nio.charset.Charset;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        char[] str = new char[10];
        for(int i = 0; i<10; i++){
            str[i] = (char) random.nextInt(50,100);
        }
        System.out.println(str);
        String id = String.valueOf(str);
        singleConsumer("consumers");
    }

    public static void singleConsumer(String groupId) throws InterruptedException {
        SampleConsumer sampleConsumer = new SampleConsumer("Consumer", groupId);
    }

    public static void singleConsumerGroup(String groupId) throws InterruptedException {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                SampleConsumer sampleConsumer1 = new SampleConsumer("Consumer1", groupId);
            }
        };

        Thread t2 = new Thread() {
            @Override
            public void run() {
                SampleConsumer sampleConsumer2 = new SampleConsumer("Consumer2", groupId);
            }
        };


        Thread t3 = new Thread() {
            @Override
            public void run() {
                SampleConsumer sampleConsumer3 = new SampleConsumer("Consumer3", groupId);
            }
        };


        t1.start();
        t2.start();
        t3.start();

    }
}
