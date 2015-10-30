package com.kent.tech;

/**
 * Created by kenthu on 15/10/29.
 */
public class ClassLoaderResourceTest {
    public static void main(String[] args) {

        //获取与ClassLoaderResourceTest同目录下资源。
        //输出结果：jar:file:/D:/ClassLoaderResourceTest.jar!/com/cyc/classloader/test/a.txt
        System.out.println(ClassLoaderResourceTest.class.getResource("a.txt"));
        //获取与ClassLoaderResourceTest同目录下资源。
        //输出结果：jar:file:/D:/ClassLoaderResourceTest.jar!/com/cyc/classloader/test/conf/b.txt
        System.out.println(ClassLoaderResourceTest.class.getResource("conf/b.txt"));
        //获取与ClassLoaderResourceTest父目录下资源，使用相对路径无法获取，不支持../
        //输出结果：null
        System.out.println(ClassLoaderResourceTest.class.getResource("../g.txt"));
        //与ClassLoaderResourceTest类不处于同目录，路径不对
        //输出结果：null
        System.out.println(ClassLoaderResourceTest.class.getResource("c.txt"));
        //使用绝对路径，从根目录下获取
        //输出结果：jar:file:/D:/ClassLoaderResourceTest.jar!/c.txt
        System.out.println(ClassLoaderResourceTest.class.getResource("/a.txt"));
        //使用绝对路径，获取根目录下的子目录文件，该目录是属于test，不属于jar包
        //输出结果：file:/D:/test/one/e.txt
        System.out.println(ClassLoaderResourceTest.class.getResource("/one/e.txt"));
        //使用相对路径，获取jar包中的文件，该文件处于classpath的根目录下
        //输出结果：jar:file:/D:/ClassLoaderResourceTest.jar!/c.txt
        System.out.println(ClassLoaderResourceTest.class.getClassLoader().getResource("c.txt"));
        //使用相对路径，获取test目录中的文件，该文件处于classpath的根目录下
        //输出结果：file:/D:/test/d.txt
        System.out.println(ClassLoaderResourceTest.class.getClassLoader().getResource("a.txt"));
        //使用绝对路径，但是ClassLoader中的方法不支持绝对路径。
        //输出结果：null
        System.out.println(ClassLoaderResourceTest.class.getClassLoader().getResource("/"));
        System.out.println(ClassLoaderResourceTest.class.getClassLoader().getResource(""));
        System.out.println(ClassLoaderResourceTest.class.getClassLoader().getResource("."));
        System.out.println(ClassLoaderResourceTest.class.getClassLoader().getResource("test/b.txt"));
        System.out.println(ClassLoaderResourceTest.class.getClassLoader().getResource("./test/b.txt"));
        System.out.println(ClassLoaderResourceTest.class.getClassLoader().getResource("b.txt"));
    }
}
