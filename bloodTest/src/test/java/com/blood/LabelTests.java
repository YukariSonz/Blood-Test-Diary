package com.blood;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.assertEquals;

import com.blood.pojo.Label;
import org.junit.Test;

public class LabelTests {

    @Test
    public void testGetID() {
        Label label = new Label(1, "tName", "tColor", "tDescription");
        assertEquals(label.getIdlabel(), 1);
    }

    @Test
    public void testSetID() {
        Label label = new Label(1, "tName", "tColor", "tDescription");
        label.setIdlabel(2);
        assertEquals(label.getIdlabel(), 2);
    }

    @Test
    public void testGetName() {
        Label label = new Label(1, "tName", "tColor", "tDescription");
        assertEquals(label.getName(), "tName");
    }

    @Test
    public void testSetName() {
        Label label = new Label(1, "tName", "tColor", "tDescription");
        label.setName("changedName");
        assertEquals(label.getName(), "changedName");
    }

    @Test
    public void testGetColor() {
        Label label = new Label(1, "tName", "tColor", "tDescription");
        assertEquals(label.getColor(), "tColor");
    }

    @Test
    public void testSetColor() {
        Label label = new Label(1, "tName", "tColor", "tDescription");
        label.setColor("changedColor");
        assertEquals(label.getColor(), "changedColor");
    }

    @Test
    public void testGetDescription() {
        Label label = new Label(1, "tName", "tColor", "tDescription");
        assertEquals(label.getDescription(), "tDescription");
    }

    @Test
    public void testSetDescription() {
        Label label = new Label(1, "tName", "tColor", "tDescription");
        label.setDescription("changedDescription");
        assertEquals(label.getDescription(), "changedDescription");
    }

    @Test
    public void testEmptyDetails() {
        Label label = new Label();
        assertEquals(label.getIdlabel(), 0);
        assertEquals(label.getName(), null);
        assertEquals(label.getColor(), null);
        assertEquals(label.getDescription(), null);
    }
}