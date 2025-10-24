# 미션_Review : java-racingcar-precourse
## 📑 목차
- [1. 주요 학습 내용](#1-주요-학습-내용)
- [2. 미션 후기](#2-미션-후기)
- [3. 양식](#3-양식)
  - [양식](#양식)


***

## 🧐 학습 회고 및 배운점

### 1. 주요 학습 내용
#### a. **객체지향 설계 원칙** 적용 (MVC)
이번 미션에서는 저번 미션의 코드리뷰를 통해 생각해 보게된 MVC패턴을 적용하는것이 목적이다.
이떄 객체지향 설계 원칙을 적용할것을 중요하게 생각했다.

#### b. **Stream API** 
stream API는 java의 기본 api로 리스트를 String으로 바꾸는 API이다. 
이번 미션에서 stream을 사용한 이유는 **객체 지향 및 책임 분리**을 위해서 이다.
반복문을 통한 코드를 대신하여 콘솔출력(System.out.println)의 횟수를 줄여 View의 책임을 더욱 명확히 하기 위해서 이다.
이를 통해 재사용성과 유연성을 확보하고 I/O작업의 횟수를 1회로 줄여 성능의 이점도 생각하였다.

stream은 데이터의 흐름, 파이프라인 이고 이 흐름을 따라 데이터를 처리(필터링, 변환)한다 
예시 코드를 보며 이해해 보자
```
// List<racingCar> cars -> racingCar는   private String name; private int position;을 가짐
List<String> winnerNames = cars.stream() // 1. 스트림 생성
        .map(racingCar::getName)       // 2. map (변환): 각 객체를 이름으로 매핑
        .collect(Collectors.toList()); // 3. collect (수집): 최종적으로 리스트로 수집
```
.stream : stream객체를 생성함(기술적으로는 객체가 맞는데 데이터흐름을 처리하는 도구 정도로 생각하면 됨 -> [stream의 특징](\#-스트림의-특징))
.map : mapping의 map(자료구조 Map아님!) racingCar객체 stream에서 getName메소드를 통해 name만을 추출 주로 람다식 형태로 사용되며 .map(현재 요소 타입, 변환함수가 반환할 새로운 타입)
.collect : 위의 stream을 다시 list로 collect하는 메소드 인자로 Collectors 객체의 .toList()를 호출하여 list로 만듬

\# 스트림의 특징
사용목적은 데이터를 필터링, 변환 하기 위한것임!
1. 데이터 저장소가 아님: 스트림 자체는 데이터를 저장하거나 보관하지 않습니다. 그저 원본 컬렉션에서 데이터를 가져와 파이프라인을 통해 처리하는 '흐름' 역할

2. 일회용: 스트림은 한 번 사용되면 닫히므로, 동일한 스트림을 두 번 이상 재사용할 수 없다. (데이터를 다시 처리하려면 원본 컬렉션에서 새 스트림을 다시 생성해야 함)

3. 함수적: 스트림은 함수형 프로그래밍 개념을 자바에 도입하여, 데이터를 '어떻게 처리할지'가 아니라 '무엇을 할지'를 선언적으로 명시함

4. Stream을 생성할 수 있는 주요 대상
   - Collection
   - 배열 (Array)
   - Map
   - Etc(Files, Randoms 등)

### 2. 미션 후기
... (후기 내용)
