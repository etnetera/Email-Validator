[![Build Status](https://travis-ci.org/etnetera/Email-Validator.svg?branch=master)](https://travis-ci.org/etnetera/Email-Validator)
[ ![Download](https://api.bintray.com/packages/tpavel-etn/Email-Validator/Email-Validator/images/download.svg) ](https://bintray.com/tpavel-etn/Email-Validator/Email-Validator/_latestVersion) 
[![codecov](https://codecov.io/gh/etnetera/Email-Validator/branch/master/graph/badge.svg)](https://codecov.io/gh/etnetera/Email-Validator)
[![License](https://img.shields.io/badge/License-BSD%203--Clause-blue.svg)](https://opensource.org/licenses/BSD-3-Clause)
# Email-Validator
Library for advanced email validation

```xml
<repositories>
    <repository>
        <id>jcenter</id>
        <url>https://jcenter.bintray.com/</url>
    </repository>
</repositories>

<dependencies>
    <dependency>
        <groupId>cz.etn</groupId>
        <artifactId>email-validator</artifactId>
        <version>1.1.2</version>
    </dependency>
<dependencies>
```

Example:
```java
var email = new Email("example@email.com");
// valid according to RFC 5322
System.out.println(email.isValid());
System.out.println(email.getError());
// TYPO for typos and DISPOSABLE for temporary emails
System.out.println(email.getWarnings());
// suggested corrections for typos - gnail.com -> gmail.com
System.out.println(email.getSuggestion());
```
