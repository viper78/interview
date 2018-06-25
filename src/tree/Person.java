package tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

// For the above class, you basically have to implement 2 methods. // public List getOldestSisters() // public List getGreatestAncestors()
public class Person {
    Person father;
    Person mother;
    Gender gender;
    Integer age;
    List children;
    int level = 0;
    public enum Gender { Male, Female; }
    Person(Person dad, Person mom, Gender gender, int age, int level) {
        this.father = dad;
        this.mother = mom;
        this.gender = gender;
        this.age = age;
        this.level = level;
    }
    public void setChildren(List children) {
        this.children = children;
    }
    public void addChild(Person child) {
        this.children.add(child);
    }
    public List getOldestSisters () {
        // given the current person (self), determine parents
        // then get children of those parents
        // Determine gender of each child
        // Where they are female, get ages
        // return females with age &gt; mine
        // Note: must check on both sides father/mother as there may be a mixed marriage
        // Combine list of children - Exclude YOU as you cannot be your own sister.
        // Use a set to eliminate duplicates.
        HashSet<Person> allChildren = new HashSet();
        // Can't add null to a hashSet so screen for it.
        if ((father != null) && (father.children != null)){
            allChildren.addAll(father.children);
        }
        if ((mother != null) && (mother.children != null)) {
            allChildren.addAll(mother.children);
        } // If you are not in this list, there is an issue!
        if (allChildren.contains(this)) {
            allChildren.remove(this);
            // System.out.println("Removing self from list.");
        } else {
            System.out.println("Error: You are not a child of your parents! Adopted?");
        }
        // Filter down to only women and get any older than me:
        int myAge = this.age;
        List oldestSisters = new ArrayList();
        for (Person child : allChildren) {
            if (child.gender == Gender.Female) {
                if (child.age > myAge) {
                    oldestSisters.add(child);
                }
            }
        }
        return oldestSisters;
    }

    public List getGreatestAncestors() {
        // If this is the root of the tree, return empty array because there is no ancestor for the tree
        if (this.father == null && this.mother == null) {
            return new ArrayList();
        }
        List<Person> fList = new ArrayList();
        List<Person> mList = new ArrayList();
        if (this.father != null) {
            fList = this.father.getGreatestAncestors();
        }
        if (this.mother != null) {
            mList = this.mother.getGreatestAncestors();
        }
        List results = new ArrayList();
        for (Person p : fList) {
            if (results.contains(p)){
                continue;
            }
            results.add(p);
        }
        for (Person p : mList) {
            if (results.contains(p)){
                continue;
            }
            results.add(p);
        }
        return results;
    }

    public List getGreatestAncestors2() {
        if ((this.father == null) || (this.mother == null)) {
            return null;
            // You must have two parents to have ancestors
        }
        // Find root parents
        List myParents = getParents(this);
        return getElders(myParents);
    }
    private List getElders(List<Person> parents) {
        List elders = new ArrayList();
        List myParents = new ArrayList();
        boolean newElders = false;
        for (Person parent : parents) {
            myParents = getParents(parent);
            if (myParents.isEmpty()) {
                elders.add(parent);
            } else {
                elders.addAll(myParents);
                newElders = true;
            }
        }
        if (newElders == true) {
            return getElders(elders);
        }
        return elders;
    }
    private List getParents(Person person) {
        List parents = new ArrayList();
        if (person.father != null)
            parents.add(person.father);
        if (person.mother != null)
            parents.add(person.mother);
        return parents;
    }
}
