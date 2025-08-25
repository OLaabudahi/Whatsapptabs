package com.example.whatsapptabs;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Room;

import java.util.List;

public class ItemViewModel extends AndroidViewModel {
    private final MutableLiveData<List<Item>> chatsLiveData = new MutableLiveData<>();
    private final MutableLiveData<Integer> countLiveData = new MutableLiveData<>();
    private final AppDatabase db;

    public ItemViewModel(@NonNull Application application) {
        super(application);
        db = Room.databaseBuilder(application, AppDatabase.class, "app_db")
                .allowMainThreadQueries().build();
        refreshData();
    }

    public LiveData<List<Item>> getChats() {
        return chatsLiveData;
    }

    public LiveData<Integer> getCount() {
        return countLiveData;
    }

    public void insertItem(String content) {
        Item item = new Item();
        item.category = "CHATS";
        item.content = content;
        db.itemDao().insert(item);
        refreshData();
    }

    private void refreshData() {
        List<Item> chats = db.itemDao().getItemsByCategory("CHATS");
        chatsLiveData.setValue(chats);
        countLiveData.setValue(chats.size());
    }
}