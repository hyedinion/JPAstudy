# JPAstudy
jpa study 화이팅

## 1. pom.xml
- maven을 쓰기위한 xml파일
- 여기에 dependencies(사용할 library) 추가해주면 됨

## 2. persistence.xml
- jpa를 쓰기위한 xml파일
- 꼭 폴더이름을 지켜야됨. (resources/META-INF/persistence.xml)
- jpa이름 설정 및 어떤 jpa와 database를 쓸건지 선택

=> 이 두개는 Spring boot에서 jpa사용하면 spring이 알아서 해줌

## JAVA

### JPA 구동방식
persistence 클래스에서 시작<BR>
META-INF/persistence.xml에서 설정정보 조회<BR>
EntityManagerFactory 라는 클래스를 만듦<BR>
필요할 때마다 EntityManager를 찍어내서 돌리면 됨<BR>

## 정리
https://gold-citron-b93.notion.site/ORM-JPA-5c8c29f8345a49fea3d491628bf0ef5a