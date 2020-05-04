package com.wallapp.fragments;

public class Thumbnail {
    private Point a;
    private Point b;
    private Point c;

    public Thumbnail(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Point getA() {
        return a;
    }

    public Point getB() {
        return b;
    }

    public Point getC() {
        return c;
    }
}
