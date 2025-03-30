package com.jt.test;

/**
 * @author com.jt
 * @date 2024/8/8 21:38
 */
public  class fdsdf {

    //单例模式的懒汉实现5--线程安全
//通过设置同步代码块，使用DCL双检查锁机制
//使用双检查锁机制成功的解决了单例模式的懒汉实现的线程不安全问题和效率问题
//DCL 也是大多数多线程结合单例模式使用的解决方案
    static class SingletonLazy5 {

        private static volatile SingletonLazy5 singletonLazy;

        private SingletonLazy5() {

        }

        public static SingletonLazy5 getInstance() {
            try {
                if (null == singletonLazy) {
                    // 模拟在创建对象之前做一些准备工作
//                    Thread.sleep(1000);
                    synchronized (SingletonLazy5.class) {
                        if(null == singletonLazy) {
                            singletonLazy = new SingletonLazy5();
                        }
                    }
                }
            } catch (Exception e) {
                // TODO: handle exception
            }
            return singletonLazy;
        }
    }

    //饿汉模式
    static class SingletonHungary {
        private static SingletonHungary singletonHungary = new SingletonHungary();
        //将构造器设置为private禁止通过new进行实例化
        private SingletonHungary() {

        }
        public static SingletonHungary getInstance() {
            return singletonHungary;
        }
    }

    public static void main(String[] args) {

    }

    static class ehan{
        private static ehan ehan =new ehan();
        private ehan(){}

        public static ehan getInstance(){
            return ehan;
        }
    }

    static class lhan{
        private static volatile lhan lhan;
        private lhan(){}

        public static lhan getInstance(){
            if(lhan==null){
                synchronized (lhan.class){
                    if(lhan==null){
                        return new lhan();
                    }
                }
            }
            return lhan;
        }
    }

}
