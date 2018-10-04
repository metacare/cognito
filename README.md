![logo](https://github.com/metacare/cognito/blob/master/.github/cognito-logo.png)

# Welcome to cognito

| | **Status** |
|---|:---:|
|**circle-ci**|[![CircleCI](https://circleci.com/gh/metacare/cognito/tree/master.svg?style=svg)](https://circleci.com/gh/metacare/cognito/tree/master)|


Cognito is a perosnal data anonymizer module to protect personal data from being disclosed. It works on top of metacare project to anonymize all the input data, so we do not store any personal data that can be later disclosed. At the time it works as a AWS lambda function that is trigered each time a report is updates to S3, then it anonymizes the data and stores the file in DynamoDB for later indexation.
