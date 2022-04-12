package com.gildedrose;

public class Legendary implements ItemUpdate{
    public Item getItem() {
        return item;
    }

    private final Item item;

    public Legendary(Item item) {
        this.item = item;
    }


    @Override
    public void updateItem() {

    }

    @Override
    public void updateQuality() {

    }

    @Override
    public void updateSellin() {

    }

    @Override
    public void updateExpired() {

    }
}
