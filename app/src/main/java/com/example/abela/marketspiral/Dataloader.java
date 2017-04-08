package com.example.abela.marketspiral;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Abela on 3/28/2017.
 */

public interface Dataloader {
    public void dataload(HashMap<Integer,List<Item>> itemsHashmap);
}
