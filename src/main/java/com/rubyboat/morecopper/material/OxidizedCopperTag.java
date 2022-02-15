package com.rubyboat.morecopper.material;

import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.tag.Tag;

import java.util.ArrayList;
import java.util.List;

public class OxidizedCopperTag implements Tag {
    List<Item> list = new ArrayList<Item>() {
        {
            add(Items.OXIDIZED_COPPER);
            add(Items.OXIDIZED_CUT_COPPER);
        }
    };

    @Override
    public boolean contains(Object entry) {
        return list.contains(entry);
    }

    @Override
    public List values() {
        return list;
    }
}
