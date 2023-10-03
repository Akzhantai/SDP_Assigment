import java.util.Random;

public class RandomGenerator {
    private final static Random random = new Random();
    private final static RandomGenerator instance = new RandomGenerator();
    private RandomGenerator(){}

    public static RandomGenerator getInstance() {
        return instance;
    }
    public int nextInt(int bound){
        return random.nextInt(bound);
    }
}

