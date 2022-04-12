package com.gildedrose;

public class AgedBrie implements ItemUpdate{
    public Item getItem() {
        return item;
    }

    private final Item item;

    public AgedBrie(Item item) {
        this.item = item;
    }

    @Override
    public void updateItem() {

    }

    @Override
    public void updateQuality() {
        incrementQuality(item);
    }

    @Override
    public void updateSellin() {
        decreaseSellin(item);
    }

    @Override
    public void updateExpired() {


    }
}
