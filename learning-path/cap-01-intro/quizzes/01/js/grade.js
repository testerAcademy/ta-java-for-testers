const PASS_THRESHOLD = 60;

document.getElementById("gradeTop").addEventListener("click", gradeQuiz);
document.getElementById("resetTop").addEventListener("click", resetQuiz);

async function gradeQuiz(){
  const res = await fetch("data/data.json");
  const data = await res.json();

  let score = 0;
  let total = 0;

  const scoreEl = document.getElementById("scoreTop");
  const statusMsg = document.getElementById("statusMsg");

  // Secciones
  (data.sections || []).forEach(section => {
    if (section.type === "options"){
      // Cada pregunta suma 1
      (section.questions || []).forEach(q => {
        total++;
        const qid = q.id;
        const sel = document.querySelector(`input[name="${qid}"]:checked`);
        const fb = document.getElementById(`fb-${qid}`);
        if (sel && sel.value === q.answer){
          score++; if (fb){ fb.textContent = "✔ Correcto"; fb.className = "qfb ok"; }
        } else {
          if (fb){ fb.textContent = "✘ Incorrecto"; fb.className = "qfb badText"; }
        }
      });
    }

    if (section.type === "matches"){
      // Cada par (fila) suma 1
      const panel = document.querySelector(`section.panel[data-sec="${section.id}"][data-type="matches"]`);
      if (!panel) return;

      const rows = Array.from(panel.querySelectorAll(".row"));
      rows.forEach((row, idx) => {
        total++;
        const expected = (section.pairs || [])[idx]?.answer;
        const drop = row.querySelector(".drop");
        const fb = row.querySelector(".rowfb");

        if (drop && drop.firstChild && drop.firstChild.textContent === expected){
          score++; if (fb){ fb.textContent = "✔ Correcto"; fb.className = "rowfb ok"; }
        } else {
          if (fb){ fb.textContent = "✘ Revisa"; fb.className = "rowfb bad"; }
        }
      });
    }
  });

  const percent = Math.round((score / total) * 100);
  scoreEl.textContent = `Resultado: ${score}/${total} (${percent}%)`;
  scoreEl.classList.remove('good','bad','pulse');
  statusMsg.classList.remove('ok','fail');

  if (percent >= PASS_THRESHOLD) {
    scoreEl.classList.add('good');
    statusMsg.textContent = '✅ Aprobado';
    statusMsg.classList.add('ok');
  } else {
    scoreEl.classList.add('bad');
    statusMsg.textContent = '❌ No Aprobado';
    statusMsg.classList.add('fail');
  }

  requestAnimationFrame(()=>scoreEl.classList.add('pulse'));
  setTimeout(()=>scoreEl.classList.remove('pulse'), 180);
}

function resetQuiz(){
  // Radios
  document.querySelectorAll("input[type=radio]").forEach(r => r.checked = false);
  document.querySelectorAll(".qfb").forEach(fb => fb.textContent = "");

  // Regresar tarjetas de todas las secciones "matches"
  document.querySelectorAll('section.panel[data-type="matches"]').forEach(panel=>{
    const bank = panel.querySelector(".bank");
    panel.querySelectorAll(".drop .pill").forEach(pill => bank.appendChild(pill));
    panel.querySelectorAll(".drop").forEach(d => d.innerHTML = "");
    panel.querySelectorAll(".rowfb").forEach(fb => fb.textContent = "");
    panel.querySelectorAll(".pill.selected").forEach(p=> p.classList.remove('selected'));
  });

  setNeutralScore();
  document.scrollingElement.scrollTo({ top: 0, behavior: 'smooth' });
}
