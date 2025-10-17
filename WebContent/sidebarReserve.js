async function loadSidebarReserve() {
  try {
    const resp = await fetch('controller?cmd=countDailyAllReserve&t=' + Date.now(), {
      cache: 'no-store',
      credentials: 'include'
    });

    if (!resp.ok) throw new Error('서버 응답 오류');

    const data = await resp.json();

    // 서버 응답 구조: { result: [ { RESERVE_COUNT: 12 } ] }
    const count = data.result?.[0]?.RESERVE_COUNT ?? 0;

    document.getElementById('allReserve').textContent = count;
  } catch (err) {
    console.error('사이드바 정보 불러오기 실패:', err);
  }
}