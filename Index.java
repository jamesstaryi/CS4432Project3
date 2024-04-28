import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Hashtable;

public class Index {

    public void count(){
        long startTime = System.nanoTime();
        int count = 0;
        for(int i = 1; i <= 99; i ++){
            String fileName = "A" + i + ".txt";
            String[] array = new String[100];
            try (FileInputStream fileInputStream = new FileInputStream("Project3Dataset-A/" + fileName);
                InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
                    String text = bufferedReader.readLine();
                    for(int j = 0; j < 100; j++){
                        int index = j*40;
                        String randomV = text.substring(index+33, index+37);
                        array[j] = randomV;
                    }
                    for(int b = 1; b <= 99; b ++){
                        String fileNameB = "B" + b + ".txt";
                        try (FileInputStream fileInputStreamB = new FileInputStream("Project3Dataset-B/" + fileNameB);
                            InputStreamReader inputStreamReaderB = new InputStreamReader(fileInputStreamB);
                            BufferedReader bufferedReaderB = new BufferedReader(inputStreamReaderB)) {
                                String textB = bufferedReaderB.readLine();
                                for(int j = 0; j < 100; j++){
                                    int index = j*40;
                                    String randomV = textB.substring(index+33, index+37);
                                    for (String num : array) {
                                        if(Integer.parseInt(num) > Integer.parseInt(randomV)){
                                            count++;
                                        }
                                    }
                                }
                            }
                        }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(count);
        long stopTime = System.nanoTime();
        System.out.println("Time Taken: " + ((stopTime - startTime)/1000000) + " ms");
    }

    public void hashJoin(){
        long startTime = System.nanoTime();
        Hashtable<Integer, String> hash = new Hashtable<>();
        for(int i = 1; i <= 99; i ++){
            String fileName = "A" + i + ".txt";
            try (FileInputStream fileInputStream = new FileInputStream("Project3Dataset-A/" + fileName);
                InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
                    String text = bufferedReader.readLine();
                    for(int j = 0; j < 100; j++){
                        int index = j*40;
                        String randomV = text.substring(index+33, index+37);
                        String column = text.substring(index, index+40);
                        int value = Integer.parseInt(randomV) % 50;
                        if(hash.containsKey(value)){
                            hash.put(value, hash.get(value) + column);
                        }
                        else{
                            hash.put(value, column);
                        }
                    }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        for(int b = 1; b <= 99; b ++){
            String fileNameB = "B" + b + ".txt";
            try (FileInputStream fileInputStreamB = new FileInputStream("Project3Dataset-B/" + fileNameB);
                InputStreamReader inputStreamReaderB = new InputStreamReader(fileInputStreamB);
                BufferedReader bufferedReaderB = new BufferedReader(inputStreamReaderB)) {
                    String textB = bufferedReaderB.readLine();
                    for(int j = 0; j < 100; j++){
                        int index = j*40;
                        String randomV = textB.substring(index+33, index+37);
                        String columnB = textB.substring(index+12, index+31);
                        int value = Integer.parseInt(randomV) % 50;
                        if(hash.containsKey(value)){
                            int location = hash.get(value).indexOf(randomV);
                            if(location != -1){
                                int nearestFactor = (location / 40) * 40;
                                String columnA = hash.get(value).substring(nearestFactor+12, nearestFactor+31);
                                System.out.println(columnA + ", " + columnB);
                            }
                        }
                    }
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            long stopTime = System.nanoTime();
            System.out.println("Time Taken: " + ((stopTime - startTime)/1000000) + " ms");
    }
}