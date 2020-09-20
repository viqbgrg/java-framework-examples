package com.github.viqbgrg;

public class HelloWorld {
    private String name;

    public void say() {
        System.out.println("Hello " + this.name);
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
