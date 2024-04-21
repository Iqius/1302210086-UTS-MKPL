package lib;

public class Child {
    private String childName;
    private String childIdNumber;

    public Child(String childName, String childIdNumber) {
        this.childName = childName;
        this.childIdNumber = childIdNumber;
    }

	public String getChildName() {
        return childName;
    }

    public void setChildName(String childName) {
        this.childName = childName;
    }

    public String getChildIdNumber() {
        return childIdNumber;
    }

    public void setChildIdNumber(String childIdNumber) {
        this.childIdNumber = childIdNumber;
    }
}
