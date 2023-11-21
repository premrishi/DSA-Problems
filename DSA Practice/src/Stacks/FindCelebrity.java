package Stacks;



import java.util.Stack;

/*
If i is a celebrity everybody knows i, and i does not know anybody
 */

public class FindCelebrity {
    public static void main(String[] args) {
        int[][] arr = {
                {0, 0, 1, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 0},
                {0, 0, 1, 0}
        };

        Stack<Integer> stack = new Stack<>();
        for (int i=0; i<arr.length; i++) {
            //push all the persons
            stack.push(i);
        }

        while (stack.size() >= 2) {
            int x1 = stack.pop();
            int x2 = stack.pop();

            if (arr[x1][x2] == 1) {
                // if x1 knows x2 => x1 is not a celebrity, 100%

                //x2 might be a celebrity, so push it onto my stack
                stack.push(x2);
            } else {
                // if x1 does not know x2 => x2 is not a celebrity, 100%

                //x1 might be a celebrity, push it onto my stack.
                stack.push(x1);
            }
        }


        /*
        {0, 0, 1, 0},
        {0, 0, 1, 0},
        {0, 0, 0, 0},
        {0, 0, 1, 0}
​
        02
        12
        22
        32
​
        20
        21
        22
        23
         */
        int flag = 0;
        int potentialAnswer = stack.pop();
        for (int i=0; i<arr.length; i++) {
            if (i != potentialAnswer) {
                if (arr[i][potentialAnswer] == 0 || arr[potentialAnswer][i] == 1) {
                    flag = 1;
                    break;
                }
            }
        }

        if (flag == 0) {
            System.out.println("Celebrity : " +potentialAnswer);
        } else {
            System.out.println("No celebrity");
        }

    }
}
