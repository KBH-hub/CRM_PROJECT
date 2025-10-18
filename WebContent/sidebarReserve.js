async function loadSidebarReserve() {
		try {
		    const resp = await fetch('controller?cmd=countDailyAllReserve&t=' + Date.now(), {
		      cache: 'no-store',
		      credentials: 'include'
		    });

		    if (!resp.ok) throw new Error('서버 응답 오류');

		    const data = await resp.json();
		    console.log('전체 예약 응답:', data);

		    const count = (data[0] && data[0].reserveCount) || 0;
		    document.getElementById('allReserve').textContent = count;
		  } catch (err) {
		    console.error('전체 예약 불러오기 실패:', err);
		  }
}