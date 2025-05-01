package utils;

import com.github.javafaker.Faker;

public class TestDataGenerator {
    private final Faker faker;

    public TestDataGenerator() {
        this.faker = new Faker();
    }

    public String generateEmail() {
        return faker.internet().emailAddress();
    }

    public String generatePassword() {
        return faker.internet().password(8, 16, true, true, true);
    }

    public String generateFirstName() {
        return faker.name().firstName();
    }

    public String generateLastName() {
        return faker.name().lastName();
    }
}
