package nhn_coding_test;

import java.util.Arrays;

class Shape<T> {
    String name;

    public Shape(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

interface Shape2D {
    double getArea();

    void draw();
}

interface Shape3D {
    double getVolume();

    void build();
}

class Circle extends Shape implements Shape2D {
    int r;

    public Circle(int r) {
        super("Cirlce");
        this.r = r;
    }

    @Override
    public double getArea() {
        return Math.PI * Math.pow(r, 2);
    }

    @Override
    public void draw() {
    }
}

class Rectangle extends Shape implements Shape2D {
    int w, h;

    public Rectangle(int w, int h) {
        super("Rectangle");
        this.w = w;
        this.h = h;
    }

    @Override
    public double getArea() {
        return w * h;
    }

    @Override
    public void draw() {
    }
}

class Ball extends Shape implements Shape3D {
    int r;

    public Ball(int r) {
        super("Ball");
        this.r = r;
    }

    @Override
    public double getVolume() {
        return 4 / 3 * Math.PI * Math.pow(r, 3);
    }

    @Override
    public void build() {
    }
}

class Box extends Shape implements Shape3D {
    int w, h, d;

    public Box(int w, int h, int d) {
        super("Box");
        this.w = w;
        this.h = h;
        this.d = d;
    }

    @Override
    public double getVolume() {
        return w * h * d;
    }

    @Override
    public void build() {
    }

}

public class World {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[4];
        // 6-1 Circle을 구현하라.(5)
        Circle circle = new Circle(3);
        System.out.println(circle + "의 넓이는 " + circle.getArea() + " 입니다.");
        // 6-2 Box을 구현하라.(5)
        Box box = new Box(7, 8, 9);
        System.out.println(box + "의 부피는 " + box.getVolume() + " 입니다.");
        shapes[0] = circle;
        shapes[1] = new Rectangle(4, 5);
        shapes[2] = new Ball(6);
        shapes[3] = box;
        // 6-3 도형 종류를 출력하라(10)
        System.out.println("Shapes : " + Arrays.toString(shapes));
        //6-4 2차원 도형만 출력하라(20)
        System.out.print("2차원 도형은 ");
        for (Shape k : shapes) {
            if(k instanceof Circle || k instanceof Rectangle){
                System.out.print(k + " ");
            }
        }
        System.out.print("이며, 넓이는 ");
        for (Shape k : shapes) {
            if(k instanceof Circle){System.out.print(((Circle)k).getArea() + " ");}
            else if(k instanceof Rectangle){System.out.print(((Rectangle)k).getArea() + " ");}
        }
        System.out.println("입니다.");

        // 6-5 3차원 도형만 출력하라(30)
        // 주석 처리된 부분에만 코드를 추가한다.
        // Java Stream을 이용해 구현한다.
        System.out.print("3차원 도형은 ");
        Object[] shape3ds = Arrays.stream(shapes).filter(shape -> (shape instanceof Ball) || (shape instanceof Box))
        .toArray();
        System.out.print(Arrays.toString(shape3ds) + " 이며, 부피는 [");
        for(Object shape : shape3ds){
            if(shape instanceof Ball)
            {System.out.print(((Ball)shape).getVolume());}
            else if(shape instanceof Box)
            {System.out.print(((Box)shape).getVolume());}
            System.out.print(" ");
        }
        System.out.print("] 입니다.");
    }

}
