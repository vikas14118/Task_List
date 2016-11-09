package com.hello_world.vikas.task_list;

/**
 * Created by vikas on 11/9/2016.
 */
public class Item {
    private String title;
    private String details;

    public Item(String title, String details) {
        this.title = title;
        this.details = details;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
