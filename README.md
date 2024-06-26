# 🖥 알고리즘 스터디

## 🤖 스터디 멤버

<table>
  <tr>
    <td align="center">
      <a href="https://github.com/samgakjisam">
        <img src="https://avatars.githubusercontent.com/samgakjisam" width="130px;" alt="">
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/calendar2">
        <img src="https://avatars.githubusercontent.com/calendar2" width="130px;" alt="">
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/moeun12">
        <img src="https://avatars.githubusercontent.com/moeun12" width="130px;" alt="moeun_profile">
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/badacura">
        <img src="https://avatars.githubusercontent.com/badacura" width="130px;" alt="kiyong_profile">
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/syhuni">
        <img src="https://avatars.githubusercontent.com/syhuni" width="130px;" alt="syhuni_profile">
      </a>
    </td>
  </tr>
  <tr>
    <td align="center">
      <a href="https://github.com/samgakjisam">
        <b>samgakjisam</b>
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/calendar2">
        <b>calendar2</b>
      </a>
    </td>
     <td align="center">
      <a href="https://github.com/moeun12">
        <b>moeun12</b>
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/badacura">
        <b>badacura</b>
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/syhuni">
        <b>syhuni</b>
      </a>
    </td>
  </tr>
  <tr> 
    <td align="center">
      <img src="https://img.shields.io/badge/Python-3776AB?style=for-the-badge&logo=python&logoColor=white"><br/>
      <img src="https://img.shields.io/badge/C++-007396?style=for-the-badge&logo=c++&logoColor=white">
    </td>
    <td align="center">
      <img src="https://img.shields.io/badge/Java-007396?style=for-the-badge&logo=java&logoColor=white"><br/>
      <img src="https://img.shields.io/badge/Python-3776AB?style=for-the-badge&logo=python&logoColor=white">
    </td>
    <td align="center">
      <img src="https://img.shields.io/badge/C++-007396?style=for-the-badge&logo=c++&logoColor=white"><br/>
      <img src="https://img.shields.io/badge/Java-007396?style=for-the-badge&logo=java&logoColor=white">
    </td>
    <td align="center">
      <img src="https://img.shields.io/badge/Java-007396?style=for-the-badge&logo=java&logoColor=white"><br/>
      <img src="https://img.shields.io/badge/Python-3776AB?style=for-the-badge&logo=python&logoColor=white">
    </td>
    <td align="center">
      <img src="https://img.shields.io/badge/Python-3776AB?style=for-the-badge&logo=python&logoColor=white">
    </td>
  </tr>
</table>

<br/>

## 📌 스터디 규칙

- 당일에 알고리즘 문제 1개를 선정하여 푼다.
- (선택) 프로그래머스에서 SQL 문제 1개를 선정하여 푼다.
- 플랫폼은 프로그래머스와 백준으로 지정한다. (백준: BOJ / 프로그래머스: PGS)
- 타인의 풀이가 이해되지 않거나 더 좋은 방법이 생각나면 해당 코드에 comment를 남긴다.
- 긴 설명이 필요한 부분은 대면으로 질문한다.
- 최대 1시간 반이 되어도 못풀겠는 문제나 왜 틀렸는지 모르겠는 문제는 틀린 코드와 모르는 부분을 주석으로 남겨 올린다.
- 다른 사람들은 해당 코드를 디버깅하여 comment로 개선 방안을 남긴다.
- 오답 코드를 개선 방안을 적용해 수정하여 다시 올린다.

<br/>

## 🔍 참여 방법
1. master branch에 올리기
> 알고리즘 풀이 후 master 브랜치 `플랫폼_문제번호` 폴더 내부에 `푼 사람. 사용 언어`로 파일을 만든다.

2. fork한 후 PR 보내기
>  1) 이 저장소를 fork 한다.
>  2) 생성된 저장소에 플랫폼_문제번호로 폴더를 생성한다.
>  3) 알고리즘 풀이 후 원본 저장소에 PR를 보낸다.

<br/>

## 📁 Repository 폴더 구조

```
{플랫폼_문제번호}/{푼 사람}.{사용 언어}
```

- 💡 예시: `BOJ_1043/sirlyun.java`

<br/>

## ⚠️ commit 컨벤션

```
기본 제출 시에는 {플랫폼_문제 번호}: {사용 언어}
이외에는 {태그}: {플랫폼_문제 번호} {커밋 메시지}
```

- 플랫폼에 따라 없는 내용은 생략 가능
- 💡 예시: `✨error: BOJ_1043 오답 코드`

### 플랫폼

| 플랫폼       | 태그 |
| :----------- | :--- |
| 백준         | BOJ  |
| 프로그래머스 | PGS  |
| 소프티어     | STR  |

### 이모지 및 태그

- 이모지는 선택에 따라 활용한다.

| 이모지 | 태그     | 설명                                    |
| :----- | :------- | :-------------------------------------- |
| ✨     | error    | 풀이 방식이나 왜 틀렸는지 모르겠는 문제 |
| ♻️     | refactor | 다시 푼 코드                            |
| ✏️     | comment  | 주석 추가(코드 변경 X) 혹은 오타 수정   |
| 📝     | docs     | README와 같은 문서 수정                 |
| 🚚     | rename   | 파일, 폴더명 수정 혹은 이동             |

<br/>

## ⚠️ PR 규칙

```
[날짜] {플랫폼} {문제 번호 또는 제목} - {기타 내용}
```

- 💡 예시: `[230809] PGS 다트 게임 - 1문제`

---

<br/>
