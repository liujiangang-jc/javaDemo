package cn.tedu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 点餐的主程序
 */
public class DishApp {

    //提前准备一点菜品,展示一些给用户,同时用户可以点餐
    //定义集合(表示小饭店拥有的菜品)
    static List<Dish> dishList = new ArrayList<>();

    static List<Dish> personDish = new ArrayList<>();

    public static void main(String[] args) {
        //先初始化餐单
        initDish();

        //创建扫描对象,获取控制台输出的内容
        Scanner s = new Scanner(System.in);
        while (true) {
            //给用户展主菜单
            showMenu();
            //获取内容
            int num = s.nextInt();
            //判断用户输入的数据
            switch (num) {
                case 1:
                    while (true) {
                        showDishMenu();
                        //获取用户输入的内容
                        int id = s.nextInt();
                        //判断
                        if (id == 0) {
                            break;
                        }
                        //从饭店的集合中获取到菜品的对象 1 2 3 4 5
                        //集合的索引:0 1 2 3 4
                        Dish dish = dishList.get(id - 1);
                        System.out.println("亲,您点了:" + dish.name + "菜");
                        //用户点一个,存储一个
                        personDish.add(dish);
                    }
                case 2:
                    showPersonDish();
                    break;
                case 3:
                    buy();
                    return;
            }
        }
    }

    /**
     * 展示饭店菜单
     */
    private static void showDishMenu() {
        System.out.println("--请您订餐--");
        //遍历集合 get
        for (int i = 0; i < dishList.size(); i++) {
            //从集合中使用i获取每一个菜品对象
            Dish dish = dishList.get(i);
            System.out.println(dish.id + "\t" + dish.price + "\t" + dish.name);
        }
        System.out.println("---按序号点菜,按0返回上一级---");
    }


    /**
     * 客户已点
     */
    private static void showPersonDish() {
        System.out.println("---您已点的菜---");
        //遍历已点的集合
        for (Dish dish : personDish) {
            System.out.println(dish.id + "\t" + dish.name + "\t" + dish.price);
        }

    }

    /**
     * 买单
     */
    private static void buy() {
        System.out.println("---请稍等,正在结算---");
        double total = 0f;
        for (Dish dish : personDish) {
            // 单价的累加
            total += dish.price;
        }
        System.out.println("亲,您本次共消费了:"+total+"元");
    }

    /**
     * 展示主菜单
     */
    public static void showMenu() {
        System.out.println("----主菜单----");
        System.out.println("菜单\t\t\t 1");
        System.out.println("已点餐品\t\t\t 2");
        System.out.println("买单\t\t\t 3");
        System.out.println("----根据编号请选择服务----");


    }

    /**
     * 初始化菜单
     */
    public static void initDish() {
        Dish dish = new Dish(1, "香辣肉丝", 29.0);
        dishList.add(dish);
        Dish dish1 = new Dish(2, "唐生肉", 100.0);
        dishList.add(dish1);

        dishList.add(new Dish(3, "麻婆豆腐", 21.0));
        dishList.add(new Dish(4, "地三鲜", 24.0));
        dishList.add(new Dish(5, "油焖大虾", 55.0));

    }
}
