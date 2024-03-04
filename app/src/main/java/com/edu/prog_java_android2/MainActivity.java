package com.edu.prog_java_android2;

import android.content.Intent;
import android.os.Bundle;

import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;


import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Дані для ExpandableListView
        List<Map<String, String>> groupData = createGroupData();
        List<List<Map<String, String>>> childData = createChildData();

        // Отримання адаптера для ExpandableListView
        SimpleExpandableListAdapter adapter = createExpandableListAdapter(groupData, childData);

        // Встановлення адаптера для ExpandableListView
        ExpandableListView expandableListView = findViewById(R.id.expandableListView);
        expandableListView.setAdapter(adapter);

        // Обробник події при виборі дочірнього елемента
        expandableListView.setOnChildClickListener((parent, v, groupPosition, childPosition, id) -> {
            if (childData.size() > groupPosition && childData.get(groupPosition).size() > childPosition) {
                String selectedChild = childData.get(groupPosition).get(childPosition).get("child");

                // Запуск відповідної активності
                Intent intent;
                switch (Objects.requireNonNull(selectedChild)) {
                    case "Enter Web Data":
                        intent = new Intent(MainActivity.this, WebActivity.class);
                        startActivity(intent);
                        break;
                    case "Enter Phone Data":
                        intent = new Intent(MainActivity.this, PhoneActivity.class);
                        startActivity(intent);
                        break;
                    case "Enter Map Data":
                        intent = new Intent(MainActivity.this, MapActivity.class);
                        startActivity(intent);
                        break;
                }
            }
            return true;
        });
    }

    // Метод для створення даних груп
    private List<Map<String, String>> createGroupData() {
        List<Map<String, String>> groupData = new ArrayList<>();

        // Додавання груп
        addGroup(groupData, "Web");
        addGroup(groupData, "Phone");
        addGroup(groupData, "Map");

        return groupData;
    }

    // Метод для додавання групи в список
    private void addGroup(List<Map<String, String>> groupData, String groupName) {
        Map<String, String> groupMap = new HashMap<>();
        groupMap.put("group", groupName);
        groupData.add(groupMap);
    }

    // Метод для створення даних дочірніх елементів
    private List<List<Map<String, String>>> createChildData() {
        List<List<Map<String, String>>> childData = new ArrayList<>();

        // Додавання дочірніх елементів (підгруп)
        addChildGroup(childData, "Enter Web Data");
        addChildGroup(childData, "Enter Phone Data");
        addChildGroup(childData, "Enter Map Data");

        return childData;
    }

    // Метод для додавання дочірньої групи в список
    private void addChildGroup(List<List<Map<String, String>>> childData, String childName) {
        List<Map<String, String>> childMapList = new ArrayList<>();
        Map<String, String> childMap = new HashMap<>();
        childMap.put("child", childName);
        childMapList.add(childMap);
        childData.add(childMapList);
    }

    // Метод для створення адаптера
    private SimpleExpandableListAdapter createExpandableListAdapter(List<Map<String, String>> groupData,
                                                                    List<List<Map<String, String>>> childData) {
        String[] groupFrom = new String[]{"group"};
        int[] groupTo = new int[]{R.id.group_text};
        String[] childFrom = new String[]{"child"};
        int[] childTo = new int[]{R.id.child_text};

        return new SimpleExpandableListAdapter(
                this,
                groupData,
                R.layout.group_row,
                groupFrom,
                groupTo,
                childData,
                R.layout.child_row,
                childFrom,
                childTo
        );
    }
}
