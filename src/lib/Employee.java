package lib;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class Employee {

    private String employeeId;
    private String firstName;
    private String lastName;
    private String idNumber;
    private String address;

    private LocalDate dateJoined;

    private boolean isForeigner;

    private int monthlySalary;
    private int otherMonthlyIncome;
    private int annualDeductible;

    private Spouse spouse;
    private List<Child> children;

    private Gender gender;

    public Employee(String employeeId, String firstName, String lastName, String idNumber, String address, LocalDate dateJoined, boolean isForeigner, Gender gender) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.idNumber = idNumber;
        this.address = address;
        this.dateJoined = dateJoined;
        this.isForeigner = isForeigner;
        this.gender = gender;

        children = new LinkedList<>();
    }

    public void setMonthlySalary(int grade) {
        switch (grade) {
            case 1:
                monthlySalary = isForeigner ? (int) (3000000 * 1.5) : 3000000;
                break;
            case 2:
                monthlySalary = isForeigner ? (int) (5000000 * 1.5) : 5000000;
                break;
            case 3:
                monthlySalary = isForeigner ? (int) (7000000 * 1.5) : 7000000;
                break;
            default:
                break;
        }
    }

    public void setAnnualDeductible(int deductible) {
        this.annualDeductible = deductible;
    }

    public void setAdditionalIncome(int income) {
        this.otherMonthlyIncome = income;
    }

    public void setSpouse(String spouseName, String spouseIdNumber) {
        this.spouse = new Spouse(spouseName, spouseIdNumber);
    }

    public void addChild(String childName, String childIdNumber) {
        children.add(new Child(childName, childIdNumber));
    }

    public int getAnnualIncomeTax() {
        int monthWorkingInYear = calculateMonthsWorkedInYear();
        boolean isSingle = isSingle();
        int numberOfChildren = numberOfChildren();

        return TaxFunction.calculateTax(monthlySalary, otherMonthlyIncome, monthWorkingInYear, annualDeductible, isSingle, numberOfChildren);
    }

    private int calculateMonthsWorkedInYear() {
        LocalDate currentDate = LocalDate.now();
        return (currentDate.getYear() == dateJoined.getYear()) ? currentDate.getMonthValue() - dateJoined.getMonthValue() + 1 : 12;
    }

    private boolean isSingle() {
        return spouse == null;
    }

    private int numberOfChildren() {
        return children.size();
    }

    // Enum untuk jenis kelamin
    public enum Gender {
        MALE,
        FEMALE
    }
}

