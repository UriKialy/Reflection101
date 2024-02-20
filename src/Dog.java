public class Dog {
    public  String name;
    public  int age;
    public   String owner;
    public Dog(String name,int age, String owner){
        this.name=name;
        this.age=age;
        this.owner=owner;
    }

    public void setName(java.lang.String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private void setOwner(java.lang.String owner) {
        this.owner = owner;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String getOwner() {
        return this.owner;
    }
}
