public class Dog {
    public  String name;
    public  int age;
    public   String owner;
    public Dog(String name,int age, String owner){
        this.name=name;
        this.age=age;
        this.owner=owner;
    }
    private  Dog (String name,int age){  //a default constructor without an owner will have default owner
        this.name=name;
        this.age=age;
        this.name="uri";
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

    private String getOwner() {
        return this.owner;
    }
    private  void sit(){
        System.out.println(this.name +" is sitting");
    }
}
