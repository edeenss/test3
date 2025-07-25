const API_URL = 'http://127.0.0.1:8080/api/player';

// 선수 목록 불러오기
function loadList() {
  fetch(API_URL)
    .then((res) => res.json())
    .then((list) => {
      const playerList = document.getElementById('player-list');
      playerList.innerHTML = '';
      for (const vo of list) {
        playerList.innerHTML += `
          <button class="accordion" onclick="togglePanel(${vo.playerId})">${vo.name} (${vo.team})</button>
          <div class="panel" id="panel-${vo.playerId}" style="display:none;">
            <div>이름: <input id="name-${vo.playerId}" value="${vo.name}"></div>
            <div>팀: <input id="team-${vo.playerId}" value="${vo.team}"></div>
            <div>포지션: <input id="position-${vo.playerId}" value="${vo.position}"></div>
            <div>나이: <input id="age-${vo.playerId}" type="number" value="${vo.age}"></div>
            <button onclick="update(${vo.playerId})">수정</button>
            <button onclick="remove(${vo.playerId})">삭제</button>
            <button onclick="showPositionModal()">포지션 보기</button>
          </div>
        `;
      }
    });
}
loadList();

// 아코디언 패널 토글
window.togglePanel = function (playerId) {
  const panel = document.getElementById(`panel-${playerId}`);
  panel.style.display = panel.style.display === 'block' ? 'none' : 'block';
};

// 선수 등록
function insert() {
  const name = document.getElementById('name').value;
  const team = document.getElementById('team').value;
  const position = document.getElementById('position').value;
  const age = document.getElementById('age').value;
  fetch(API_URL, {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify({ name, team, position, age }),
  })
    .then((res) => res.text())
    .then(() => {
      loadList();
      document.getElementById('player-form').reset();
    });
}

// 선수 수정
function update(playerId) {
  const name = document.getElementById(`name-${playerId}`).value;
  const team = document.getElementById(`team-${playerId}`).value;
  const position = document.getElementById(`position-${playerId}`).value;
  const age = document.getElementById(`age-${playerId}`).value;
  fetch(API_URL, {
    method: 'PUT',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify({
      playerId,
      name,
      team,
      position,
      age
    }),
  })
    .then((res) => res.text())
    .then(() => {
      alert('수정되었습니다.');
      loadList();
    });
}

// 선수 삭제
function remove(playerId) {
  if (!confirm('정말 삭제하시겠습니까?')) return;
  fetch(`${API_URL}/${playerId}`, { method: 'DELETE' })
    .then((res) => res.text())
    .then(() => {
      alert('삭제되었습니다.');
      loadList();
    });
}

// 포지션 모달 표시 (전체 선수 현황)
window.showPositionModal = function() {
  fetch(API_URL)
    .then(res => res.json())
    .then(list => {
      // 각 포지션 영역 초기화
      document.getElementById('modal-gk').innerHTML = '';
      document.getElementById('modal-df').innerHTML = '';
      document.getElementById('modal-mf').innerHTML = '';
      document.getElementById('modal-fw').innerHTML = '';
      // 포지션별로 chip 쌓기
      list.forEach(vo => {
        const pos = vo.position ? vo.position.toUpperCase() : '';
        const chip = `<div class='player-chip'>${vo.name}</div>`;
        if (pos === 'GK') {
          document.getElementById('modal-gk').innerHTML += chip;
        } else if (pos === 'DF') {
          document.getElementById('modal-df').innerHTML += chip;
        } else if (pos === 'MF') {
          document.getElementById('modal-mf').innerHTML += chip;
        } else if (pos === 'FW') {
          document.getElementById('modal-fw').innerHTML += chip;
        } else {
          document.getElementById('modal-mf').innerHTML += `<div class='player-chip'>${vo.name} (${vo.position})</div>`;
        }
      });
      document.getElementById('position-modal').style.display = 'flex';
    });
};

// 포지션 모달 닫기
window.closePositionModal = function() {
  document.getElementById('position-modal').style.display = 'none';
};
