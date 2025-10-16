async function loadSidebarInfo() {
  try {
    const resp = await fetch('controller?cmd=sidebarAction&t=' + Date.now(), {
      cache: 'no-store',
      credentials: 'include'
    });

    if (!resp.ok) throw new Error('서버 응답 오류');

    const data = await resp.json();

    document.getElementById('sidebar-name').textContent = data.EMPLOYEE_NAME;
    document.getElementById('sidebar-position').textContent = data.POSITION;
    document.getElementById('sidebar-last-login').textContent = data.LOGIN_DATE;
    document.getElementById('sidebar-current-ip').textContent = data.LOGIN_IP;
  } catch (err) {
    console.error('사이드바 정보 불러오기 실패:', err);
  }
  
}