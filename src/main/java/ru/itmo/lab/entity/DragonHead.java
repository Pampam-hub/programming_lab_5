package ru.itmo.lab.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

@XStreamAlias("dragonHead")
public class DragonHead {

    private double eyesCount;

    public double getEyesCount() {
        return eyesCount;
    }

    public void setEyesCount(double eyesCount) {
        this.eyesCount = eyesCount;
    }

    @Override
    public String toString() {
        return "DragonHead{" +
                "eyesCount=" + eyesCount +
                '}';
    }
}
