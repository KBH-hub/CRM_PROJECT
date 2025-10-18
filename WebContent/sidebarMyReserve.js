async function loadSidebarMyReserve() {
	try {
        const resp = await fetch('controller?cmd=countDailyMyReserve&t=' + Date.now(), {
          cache: 'no-store',
          credentials: 'include'
        });

        if (!resp.ok) throw new Error('서버 응답 오류');

        const data = await resp.json();
        console.log('서버 응답:', data);

        const count = (data[0] && data[0].reserveCount) || 0;
        document.getElementById('myReserve').textContent = count;

      } catch (err) {
        console.error('사이드바 정보 불러오기 실패:', err);
  }
}
