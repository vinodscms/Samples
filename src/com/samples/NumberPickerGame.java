package com.samples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberPickerGame {

    static List<Integer> p1 = new ArrayList<>();
    static List<Integer> p2 = new ArrayList<>();

    public static void main(String[] args) {
        Integer[] n = {0,0,0,-1,0};
        //Integer[] n = {1, 3, -4, -9, 13, -4, 3, 2, 9};
        //Integer[] n = {-345958805,1827984830,400936359,1699280007,-740291820,1032062473,413740342,-42805005,-1770926854,-314131245,637938393,-402305497,-1001543424,1711072594,-1174373946,116869601,661663653,-1525448309,-701179892,272805109,-1859888693,235393044,903117920,2024412488,718528749,1544336161,-1772029147,-555316852,1508460924,-2092618570,-1177352367,-498854521,551830139,-1497941790,881142905,-997000367,221250924,1176767978,-931301894,751529022,-2033513380,-835269032,1250054682,-1825122327,-849598331,348646017,861116228,-1988933414,-1827775054,-1417801293,1055531559,-1757708071,-1316584972,1136740936,-367426405,399332704,-1910837609,653295982,1607274040,-1467902969,1521180587,-1793645726,-596940373,-801826002,927752764,1609328601,249392836,-2115073045,-1960637139,-1266749337,225443170,834870104,1887343880,-312341679,1172959286,-804729970,807199355,1757295987,-1562147313,-825601645,-955076490,-1882736736,1382206324,-1840280252,449111976,-1126218587,-1818230261,-58187933,1066368516,2046509500,-474826140,597654579,-1176083823,22160525,289746545,-1774126465,-1094089624,14892980,-841726638,1514839594};
        //Integer n[] ={12,-45,32,-4,-5,43,44,-7,49,-6,-26,-23,-30,38,24,-8,3,24,37,-5,-13,-34,-67697676,33,-10,49,-22,23,48,-29,0,27,-7,18,1,-34,-25,-18,30,-9,21,42,41,-5,45,40,44,-43,43,-25,18,43,5,16,-36,29,-18,-38,31,41,28,12,-37,-22,20,41,-17,-16,-21,28,-27,20,38,15,31,43,-50,0,-19,-7,-50,-38,41,29,-26,-2,30,-4,3,39,-42,45,-7,-33,-48,8,-41,41,-44,43,-36};
        List<Integer> numbers = Arrays.asList(n);



        System.out.println(numbers);

        int[] points = {0,0};
        int player = 0;
        //points =
        findWinner(numbers,0,numbers.size()-1,points,player);
//        int sum1 = p1.stream().mapToInt(Integer::intValue).sum();
//        int sum2 = p2.stream().mapToInt(Integer::intValue).sum();

        System.out.println("Points:" + points[0] + " vs " + points[1]);
        //System.out.println("Points:" + sum1 + " vs " + sum2);

        if (points[0] == points[1]) {
            System.out.println("return Result.Draw");
        } else if (points[0] > points[1]) {
            System.out.println("return Result.Win");
        } else {
            System.out.println("return Result.Lose");
        }
    }

    static int[] findWinner(List<Integer> input,int head, int tail, int[] points,int player) {
        if(input.size() == 0) {
            System.out.println("Points:" + points[0] + "-" + points[1]);
        } else if (tail-head == 1) {
            points[player] += Math.max(input.get(head),input.get(tail));
            player ^= 1;
            points[player] += Math.min(input.get(head),input.get(tail));
            return points;
        } else {
            int headValue = input.get(head);
            int tailValue = input.get(tail);
            if (headValue >= tailValue) {
                head++;
                points[player]+=headValue;
            } else {
                tail--;
                points[player]+=tailValue;
            }
            player ^= 1;
            findWinner(input,head,tail,points,player);
        }
        return points;
    }

    /*static void findWinner(List<Integer> input, int head, int tail, int[] points, int player) {
        if(head==46){
            System.out.println("46");
        }

        if (tail - head == 1) {
            if(player==0)
                p1.add(Math.max(input.get(head), input.get(tail)));
            else
                p2.add(Math.max(input.get(head), input.get(tail)));

            player ^= 1;

            if(player==0)
                p1.add(Math.min(input.get(head), input.get(tail)));
            else
                p2.add(Math.min(input.get(head), input.get(tail)));

            return;
        } else {
            int headValue = input.get(head);
            int tailValue = input.get(tail);
            if (headValue >= tailValue) {
                head++;
                if(player==0)
                    p1.add(headValue);
                else
                    p2.add(headValue);
            } else {
                tail--;
                if(player==0)
                    p1.add(tailValue);
                else
                    p2.add(tailValue);
            }
            player ^= 1;
            findWinner(input, head, tail, points, player);
        }
        return;
    }*/
}
