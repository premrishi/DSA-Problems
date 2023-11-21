package Stacks;
import java.util.Stack;

/*
Change path to caNONICAL PATH
 */
public class simplifyPath {
    public static void main(String[] args) {

        //String path = "/../";
        String path = "/a/./b/../../c/";

        String ansSimplifyPath = simpliifyPath(path);
        System.out.println(ansSimplifyPath);
    }

    public static String simpliifyPath(String path) {
        Stack<String> stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        String[] p =path.split("/");

        for(int i=0;i<p.length;i++){
            if(!stack.isEmpty()  && p[i].equals("..")) stack.pop();
            else if(!p[i].equals("") && !p[i].equals(".") && !p[i].equals(".."))
                stack.push(p[i]);
        }


        if(stack.isEmpty()) return "/";
        while(!stack.isEmpty()){
            result.insert(0,stack.pop()).insert(0,"/");
        }

        return result.toString();
    }
}