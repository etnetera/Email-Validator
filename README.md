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

## Publication to Artifactory
`./gradlew -P publish.ivy.target=$PUBLICATION_TARGET -P publish.ivy.base-url=$ARTIFACTORY_URL -P publish.ivy.credentials.user=$ARTIFACTORY_USER -P publish.ivy.credentials.password=$ARTIFACTORY_PASSWORD publish`