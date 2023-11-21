package Recursion;

public class placeTiles {
    public static void main(String[] args) {
        // Let's find out how many ways we can place tiles on a 4x2 floor.
        System.out.println(placetiles(4, 3));
    }

    // This is a function to calculate the number of ways to place tiles on a floor.
    // It takes two parameters: n (the length of the floor) and m (the width of the tile).
    public static int placetiles(int lengthoffloor, int tilewidth) {
        // If the length of the floor is exactly the same as the width of the tile,
        // there are only 2 ways to place tiles (horizontally or vertically).
        if (lengthoffloor == tilewidth) {
            return 2;
        }
        
        // If the length of the floor is less than the width of the tile, 
        // we can only place tiles vertically.
        if (lengthoffloor < tilewidth) {
            return 1;
        }
        
        // Now, we have two choices for placing tiles:
        // 1. We can place a tile horizontally, reducing the available length by 1.
        // 2. We can place a tile vertically, which reduces the available length by tileWidth.
        
        // We recursively calculate the number of ways for both options and sum them up.
        int horizontalplacement = placetiles(lengthoffloor - 1, tilewidth);
        int verticalplacement = placetiles(lengthoffloor - tilewidth, tilewidth);
        
        // The answer is the sum of the ways we can place tiles using both options.
        int ans = horizontalplacement + verticalplacement;
        return ans;
    }
}
