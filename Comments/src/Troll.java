public class Troll {
    public static void main(String[]args){}
    static String disemvowel(String a){char[]e={'A','E','I','O','U','a','e','i','o','u'};String i="";for(int o=0;o<a.length();o++){boolean u=yes;for(char z:e){if(z==a.charAt(o)){u=no;}}if(u==yes)i=i+a.charAt(o);}return i;}private static boolean yes=false;private static boolean no=true;}