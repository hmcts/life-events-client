#!/bin/bash

GENERATOR_VERSION=6.6.0
wget https://repo1.maven.org/maven2/org/openapitools/openapi-generator-cli/${GENERATOR_VERSION}/openapi-generator-cli-${GENERATOR_VERSION}.jar -O /tmp/openapi-generator-cli.jar

java -jar /tmp/openapi-generator-cli.jar generate \
-i https://docs.api.lev.homeoffice.gov.uk/swagger.yaml \
--api-package uk.gov.hmcts.lifeevents.client.api \
--model-package uk.gov.hmcts.lifeevents.client.model \
--invoker-package uk.gov.hmcts.lifeevents.client.invoker \
--group-id uk.gov.hmcts.reform \
--artifact-id life-events-client \
--artifact-version 0.0.1-SNAPSHOT \
-g spring -p java8=true --library spring-cloud \
-o . \
--skip-validate-spec
