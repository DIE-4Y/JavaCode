package com.nenu.extend_;

import jdk.nashorn.internal.ir.CallNode;

public class Test {
    public static void main(String[] args) {
        NotePad notepad = new NotePad("inter", 16, 512, "black");
        notepad.getInform();
        System.out.println("=======================");
        Pc pc = new Pc("AMD", 27, 2048, "Alien");
        pc.showInform();
    }

}
