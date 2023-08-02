# Getting Started
This is demonstration for aws sns,ses, sqs integration with Spring boot. This demo is based on this [localstack tutorials](https://docs.localstack.cloud/tutorials/java-notification-app/)

### Run the docker compose to start localstack on docker.
>$ docker-compose -f "src/main/resources/docker-compose.yml" up -d

### awslocal wraps the aws cli commands
>$ awslocal cloudformation deploy --template-file src/main/resources/email-infra.yml --stack-name email-infra

### Set environment variable. Default values are 'test'.
> AWS_ACCESS_KEY_ID=test;AWS_SECRET_ACCESS_KEY=test

#### run spring boot to start the application.

#### Problems and solutions
> Caused by: software.amazon.awssdk.core.exception.SdkClientException: Unable to load credentials from system settings. Access key must be specified either via environment variable (AWS_ACCESS_KEY_ID) or system property (aws.accessKeyId).

> please check the environment variables. This error is missing environment variables.

>  QueueDoesNotExistException: The specified queue does not exist for this wsdl version. (Service: Sqs, Status Code: 400, Request ID: e0d348d4-22e4-4782-8c09-5dbfafe15388)

> This error queue is missing in the region. You can check default region by running aws configure list. And the region should be same with AwsConfiguration.DEFAULT_REGION static field. 

### verify email
>$ awslocal ses verify-email-identity --email-address no-reply@localstack.cloud

### Send push message into topic
>$ awslocal sns publish --topic arn:aws:sns:ap-southeast-1:000000000000:email-notifications --message '{\"subject\":\"he
llo\", \"address\": \"alice@example.com\", \"body\": \"hello world\"}'`

### Reference Documentation
For further reference, please consider the following sections:

* [Official documentation](https://docs.localstack.cloud/overview/)
* [Tutorials](https://docs.localstack.cloud/tutorials/)
