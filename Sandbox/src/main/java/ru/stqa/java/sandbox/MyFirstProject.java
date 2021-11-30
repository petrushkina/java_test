package ru.stqa.java.sandbox;

public class MyFirstProject {

 public static void main(String[] args) {
  Point p = new Point ();

  p.x1 = 2.7;
  p.y1 = 5.7;
  p.x2 = 8.3;
  p.y2 = 6.1;

  System.out.println("Расстояние между двумя точками " + "= " + p.distance());
 }
}

