package base.task_4_4_1;

import java.util.*;

class PhoneContacts {
    private final Map<String, Collection<Contact>> mapGroupsContacts = new HashMap<>();
    private final Map<Integer, String> mapIndexesGroups = new HashMap<>();

    private final static Integer groupsFirstIndex = 1;
    private final static String indent = "    ";

    protected void addGroup(String group) {
        // Защита от создания дубликата группы
        if (mapGroupsContacts.containsKey(group)) {
            System.out.println("Такая группа уже записана.");
            return;
        }

        Collection<Contact> groupContacts = new HashSet<>();
        mapGroupsContacts.put(group, groupContacts);

        if (mapIndexesGroups.isEmpty()) {
            mapIndexesGroups.put(groupsFirstIndex, group);
        } else {
            Integer newIndex = groupsFirstIndex + mapIndexesGroups.size();
            mapIndexesGroups.put(newIndex, group);
        }
    }

    protected void printGroupsNames() {
        for (Map.Entry<Integer, String> entry : mapIndexesGroups.entrySet()) {
            System.out.println(entry.getKey() + ". " + entry.getValue());
        }
    }

    protected void printGroupsContent() {
        for (Map.Entry<Integer, String> entry : mapIndexesGroups.entrySet()) {
            String group = entry.getValue();
            System.out.println(entry.getKey() + ". " + group);
            for (Contact contact : mapGroupsContacts.get(group)) {
                System.out.println(indent + contact);
            }
        }
    }

    protected void addContactToGroup(Contact contact, Integer index) {
        if (mapIndexesGroups.containsKey(index)) {
            String groupName = mapIndexesGroups.get(index);
            mapGroupsContacts.get(groupName).add(contact);
        } else {
            System.out.println("Вы выбрали несуществующую группу.");
        }
    }
}
