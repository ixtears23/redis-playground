# Redis Playground
이 프로젝트는 Spring Boot를 기반으로 Redis와 AWS SQS를 사용하는 예제를 제공합니다.  
Redis는 고성능 키-값 저장소로, 데이터 캐싱 및 임시 데이터 저장에 사용됩니다.  
AWS SQS는 분산 메시지 큐 시스템으로, 서비스 간 비동기 메시지 전달에 활용됩니다.  

## 기술 스택
- Spring Boot: 3.2.3
- Redis: Spring Boot Starter Data Redis
- AWS SQS: Spring Cloud AWS Starter SQS
- MySQL: MySQL Connector J (Runtime)
- Lombok: 코드 간소화
- Testcontainers: LocalStack을 통한 AWS 서비스의 테스트 환경 제공

## 개발 환경 설정
프로젝트는 Java 21을 사용하며, Gradle을 통해 의존성 관리가 이루어집니다.

## 프로젝트 구성
- Redis 설정: Redis는 데이터 캐싱 및 임시 데이터 저장소로 사용됩니다.
- AWS SQS 통합: 메시지 큐 서비스로 SQS를 사용하여, 서비스 간 비동기 메시지 전달을 구현합니다.
- 테스트: Testcontainers를 사용한 LocalStack을 통해 SQS 서비스를 포함한 AWS 서비스의 통합 테스트를 지원합니다.

## 시작하기
프로젝트를 로컬에서 실행하기 전에 Redis 서버가 실행 중이어야 하며, 필요한 AWS 자격증명이 구성되어 있어야 합니다.  
Testcontainers를 사용한 테스트 실행 시에는 별도의 AWS 구성이 필요 없습니다.  
