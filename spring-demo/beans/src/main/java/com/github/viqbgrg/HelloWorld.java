package com.github.viqbgrg;

public class HelloWorld {
    private String name;

    public HelloWorld() {
    }

    public HelloWorld(String name) {
        this.name = name;
    }

    public static HelloWorld createInstance() {
        return new HelloWorld();
    }

    public HelloWorld createNoStaticInstance() {
        return new HelloWorld();
    }

    public String say() {
        return "Hello " + this.name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    static class InnerClass {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
