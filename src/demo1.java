public class demo1 {
    static void eat1(int n){
        for(int i=0; i<n; i++){;
            System.out.println("ㅹ待1分钟");
            System.out.println("ㅹ待1分钟");
            System.out.println("吃1cm 面包");
        }
    }
    static void eat2(int n){
        for (int i=0; i<n; i++){
            for (int j=0; j<i; j++){
                System.out.println("等待一分钟");
            }
            System.out.println("吃面包");
        }
    }
    public static void main(String[] args){
        int m=5;
        eat1(m);
        eat2(m);
    }

}
