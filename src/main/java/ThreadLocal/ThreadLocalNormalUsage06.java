package ThreadLocal;

import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
避免传递参数的麻烦
 */
public class ThreadLocalNormalUsage06 {

    public static void main(String[] args) {
        new Service().process();
    }






}
class Service{
    public void process(){
        User user = new User("超哥");
        UserContextHolder.holder.set(user);
        new Service2().process();
    }
}

class Service2{
    public void process(){
        User user = UserContextHolder.holder.get();
        System.out.println("serivce2"+user);
        new Service3().process();

    }
}

class Service3{
    public void process(){
        User user = UserContextHolder.holder.get();
        System.out.println("serivce3"+user);

    }
}
class UserContextHolder{
    public static ThreadLocal<User> holder=new ThreadLocal<>();
}

class User{
    String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}