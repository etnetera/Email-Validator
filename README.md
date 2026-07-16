[![Build Status](https://travis-ci.org/etnetera/Email-Validator.svg?branch=master)](https://travis-ci.org/etnetera/Email-Validator)
[![License](https://img.shields.io/badge/License-BSD%203--Clause-blue.svg)](https://opensource.org/licenses/BSD-3-Clause)
# Email-Validator
Library for advanced email validation

Example:
```java
EmailValidator validator = new EmailValidatorBuilder().build();
ValidationResult result = validator.validate("example@email.com");

// valid according to RFC 5322
System.out.println(result.isValid());

// all validation messages
System.out.println(result.messages);

// error messages
System.out.println(result.email.getError());

// TYPO for typos and DISPOSABLE for temporary emails
System.out.println(result.email.getWarnings());

// suggested corrections for typos - gnail.com -> gmail.com
System.out.println(result.email.getSuggestion());
```

## Use

Coordinates: `cz.etn:email-validator:<version>`.

### Gradle

```kotlin
repositories {
    maven { url = uri("https://etnetera.github.io/Email-Validator/") }
    mavenCentral()
}

dependencies {
    implementation("cz.etn:email-validator:1.4.0")
}
```

### Maven

```xml
<repositories>
    <repository>
        <id>email-validator-github-pages</id>
        <url>https://etnetera.github.io/Email-Validator/</url>
    </repository>
</repositories>

<dependency>
    <groupId>cz.etn</groupId>
    <artifactId>email-validator</artifactId>
    <version>1.4.0</version>
</dependency>
```
