package com.gildedrose;

public class CommonItem implements ItemUpdate{
    public Item getItem() {
        return item;
    }

    private final Item item;

    public CommonItem(Item item) {
        this.item = item;
    }



    @Override
    public void updateItem() {

    }

    @Override
    public void updateQuality() {
        decreaseQuality(item);

    }

    @Override
    public void updateSellin() {
        decreaseSellin(item);

    }

    @Override
    public void updateExpired() {

    }
}
