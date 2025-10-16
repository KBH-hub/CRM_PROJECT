<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Redirecting...</title>
<script>
  // 서버에서 전달받은 URL로 이동
  const redirectUrl = '<%= request.getAttribute("redirectUrl") %>';
  if (redirectUrl) {
    window.location.href = redirectUrl;
  } else {
    window.location.href = 'login.html';
  }
</script>
</head>
<body>
<p>로그인 중입니다...</p>
</body>
</html>
