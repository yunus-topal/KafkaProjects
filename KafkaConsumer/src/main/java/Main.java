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
        singleConsumer("deneme");
    }

    public static void singleConsumer(String groupId) throws InterruptedException {
        SampleConsumer sampleConsumer = new SampleConsumer("Consumer", groupId);
    }

    public static void singleConsumerGroup(String groupId) throws InterruptedException {
        SampleConsumer sampleConsumer1 = new SampleConsumer("Consumer1", groupId);

    }
}
