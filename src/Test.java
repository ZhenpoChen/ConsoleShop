import java.io.File;
import java.io.InputStream;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException {
        boolean bool = true;
        while (bool) {


            System.out.println("请输入用户名：");

            Scanner sc = new Scanner(System.in);
            String username = sc.next();//阻塞方法
            System.out.println("你输入的用户名：" + username);

            System.out.println("请输入密码：");
            String password = sc.next();
            System.out.println("你输入的密码是：" + password);

            /*File file=new File("D:\\LanQiao\\idealIU2019\\IdeaProjects\\ConsoleShop\\src\\UserInfo.xlsx");*/ //转成一个可变的自由的读取路径方式
            InputStream in = Class.forName("Test").getResourceAsStream("/UserInfo.xlsx");

            ReadExcel readExcel = new ReadExcel();//创建对象
            User[] users = readExcel.readExcel(in);
            for (int i = 0; i < users.length; i++) {
                if (username.equals(users[i].getUsername()) && password.equals(users[i].getPassword())) {
                    System.out.println("登入成功");
                    bool=false;
                    break;
                } else {
                    System.out.println("登录失败");
                }
            }
        }
    }
}