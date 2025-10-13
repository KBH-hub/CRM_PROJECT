# CRM_PROJECT

## 📌 Git Branch & Commit Convention

### 🔹 Branch Naming
> 업무명(영문)을 기준으로 브랜치 생성

**예시**
```bash
PatientList
ReserveList
PatientAdd
```

---

### 🔹 Commit Type

| Type         | 설명                  |
| ------------ | ------------------- |
| **feat**     | 새로운 기능 추가           |
| **fix**      | 버그 수정               |
| **style**    | UI 관련 수정            |
| **refactor** | 코드 구조 개선 (기능 변화 없음) |
| **test**     | 테스트 코드 추가 또는 수정     |
| **docs**     | 문서, 이미지 변경          |
| **revert**   | 이전 커밋 되돌림           |
| **delete**   | 코드 또는 파일 삭제         |
| **wip**      | 작업 중 또는 실험적 변경사항    |

---

### 🔹 Commit Message 규칙

```
[타입]: [메시지]_[날짜]
```

**예시**

```
feat: 로그인 기능 추가_1013
fix: 예약 등록 오류 수정_1014
style: 환자 상세 페이지 UI 개선_1015
```
