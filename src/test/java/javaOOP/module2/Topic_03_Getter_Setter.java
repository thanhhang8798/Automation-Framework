package javaOOP.module2;

public class Topic_03_Getter_Setter {
    private String personName;
    private int personAge;
    private int personPhone;
    private float PersonBankAccountAmount;

    public int getPersonAge() {
        return personAge;
    }

    public void setPersonAge(int personAge) throws IllegalAccessException {
        if (personAge > 15 && personAge < 60) {
            throw new IllegalAccessException("Tuổi nhập vào không hợp lệ");
        } else {
            this.personAge = personAge;
        }
    }

    public int getPersonPhone() throws IllegalAccessException {
        if (!String.valueOf(personPhone).startsWith("0")) {
            throw new IllegalAccessException("Số điện thoại bắt đầu bằng: 09 - 03 - 012");
        } else if (personPhone < 10 || personPhone > 11) {
            throw new IllegalAccessException("Số điện thoại phải từ 10-11 số.");
        } else {
            return personPhone;
        }
    }

    public void setPersonPhone(int personPhone) {
        this.personPhone = personPhone;
    }

    public float getPersonBankAccountAmount() {
        return PersonBankAccountAmount;
    }

    public void setPersonBankAccountAmount(float personBankAccountAmount) {
        PersonBankAccountAmount = personBankAccountAmount;
    }

    // Setter
    public void setPersonName(String personName) throws IllegalAccessException {
        // validate
        if (personName == null || personName.isEmpty() || personName.isBlank()) {
            throw new IllegalAccessException("Tên nhập vào không hợp lệ");
        } else {
            this.personName = personName;
        }
    }

    // Getter
    public String getPersonName() {
        return this.personName;
    }
}
