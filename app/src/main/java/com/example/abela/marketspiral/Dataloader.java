package com.example.abela.marketspiral;

import com.example.abela.marketspiral.Core.Item;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Abela on 3/28/2017.
 */

public interface Dataloader {
    public void dataload(HashMap<Integer,List<Item>> itemsHashmap);
}
