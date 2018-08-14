package com.company;
import java.io.*;
public class DecoderSettlementFeed {
    public static void main(String args[]) {
        try {
            File feedFile = new File("C:\\Users\\vprasan\\Desktop\\some info\\Tempoe\\SettlementFeed_784020180803191703.txt");
            FileInputStream fis = new FileInputStream(feedFile);
            Reader rd = new InputStreamReader(fis,"IBM037");
            int data = rd.read();
            while(data != -1){
                char dataChar = (char) data;
                if (dataChar == 'd') System.out.println(dataChar);
                else System.out.print(dataChar);
                data = rd.read();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
