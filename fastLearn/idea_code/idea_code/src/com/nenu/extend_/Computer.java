package com.nenu.extend_;

public class Computer {
    private String cpu;
    private int rom;
    private int disk;

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        cpu = cpu;
    }

    public int getRom() {
        return rom;
    }

    public void setRom(int rom) {
        this.rom = rom;
    }

    public int getDisk() {
        return disk;
    }

    public void setDisk(int disk) {
        this.disk = disk;
    }

    public Computer(String cpu, int rom, int disk) {
        this.cpu = cpu;
        this.rom = rom;
        this.disk = disk;
    }

    public Computer() {
    }

    public String getDetails(){
        return "cpu:" + this.cpu + ",rom:" +this.rom + ",dis:" + disk;
    }
}
