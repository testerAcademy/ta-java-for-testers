// Render dinámico desde data.json
(async function loadQuiz(){
  const res = await fetch("data/data.json");
  const data = await res.json();

  // Header
  const titleEl = document.getElementById("quiz-title");
  titleEl.textContent = data.title || "Quiz";

  // Contenedor principal
  const container = document.getElementById("quiz-container");
  container.innerHTML = "";

  // Utilidad: crea una sección .panel
  function createPanel({id, title, instructions, type}){
    const panel = document.createElement("section");
    panel.className = "panel";
    panel.dataset.type = type;
    panel.dataset.sec = id;

    const h2 = document.createElement("h2");
    h2.textContent = title || "Sección";
    panel.appendChild(h2);

    if (instructions){
      const note = document.createElement("p");
      note.className = "note";
      note.textContent = instructions;
      panel.appendChild(note);
    }
    return panel;
  }

  // ====== RENDER SECCIONES ======
  (data.sections || []).forEach((section, secIndex) => {
    const secId = section.id || `sec-${secIndex+1}`;

    if (section.type === "options"){
      const panel = createPanel({ id: secId, title: section.title, instructions: section.instructions, type: "options" });

      (section.questions || []).forEach((q, qIndex) => {
        const qa = document.createElement("div");
        qa.className = "qa";
        qa.dataset.q = q.id || `q${secIndex+1}_${qIndex+1}`;

        const p = document.createElement("p");
        p.innerHTML = `<strong>${qIndex+1}.</strong> ${q.text || ""}`;
        qa.appendChild(p);

        if (q.image){
          const img = document.createElement("img");
          img.src = q.image;
          img.alt = "Imagen de la pregunta";
          img.style.maxWidth = "100%";
          img.style.margin = "10px 0";
          qa.appendChild(img);
        }

        (q.options || []).forEach(opt => {
          const label = document.createElement("label");
          const input = document.createElement("input");
          input.type = "radio";
          input.name = q.id || `q${secIndex+1}_${qIndex+1}`;
          input.value = opt;
          label.appendChild(input);
          label.appendChild(document.createTextNode(" " + opt));
          qa.appendChild(label);
        });

        const fb = document.createElement("div");
        fb.id = "fb-" + (q.id || `q${secIndex+1}_${qIndex+1}`);
        fb.className = "qfb";
        qa.appendChild(fb);

        panel.appendChild(qa);
      });

      container.appendChild(panel);
    }

    if (section.type === "matches"){
      const panel = createPanel({ id: secId, title: section.title, instructions: section.instructions, type: "matches" });

      // Filas (rows) con su respuesta esperada en data-ans
      const rowsWrap = document.createElement("div");
      rowsWrap.className = "rows";
      rowsWrap.id = `${secId}-rows`;

      (section.pairs || []).forEach((pair, idx) => {
        const row = document.createElement("div");
        row.className = "row";
        row.dataset.ans = pair.answer;

        const rq = document.createElement("div");
        rq.className = "row-question";
        rq.textContent = `${idx+1}. ${pair.text || ""}`;
        row.appendChild(rq);

        const drop = document.createElement("div");
        drop.className = "drop";
        row.appendChild(drop);

        const rfb = document.createElement("div");
        rfb.className = "rowfb";
        row.appendChild(rfb);

        rowsWrap.appendChild(row);
      });

      panel.appendChild(rowsWrap);

      // Banco de tarjetas (opciones)
      const bankBlock = document.createElement("div");
      bankBlock.className = "bank-block";

      const bankTitle = document.createElement("div");
      bankTitle.className = "bank-title";
      bankTitle.textContent = "Tarjetas";
      bankBlock.appendChild(bankTitle);

      const bank = document.createElement("div");
      bank.className = "bank";
      bank.id = `${secId}-bank`;

      // Crear conjunto único de respuestas
      const answers = Array.from(new Set((section.pairs || []).map(p => p.answer)));
      // (Opcional) mezclar
      // answers.sort(() => Math.random() - 0.5);

      answers.forEach(txt => {
        const pill = document.createElement("div");
        pill.className = "pill";
        pill.textContent = txt;
        bank.appendChild(pill);
      });

      bankBlock.appendChild(bank);
      panel.appendChild(bankBlock);

      const bar = document.createElement("div");
      bar.className = "bar";
      const backBtn = document.createElement("button");
      backBtn.className = "secondary";
      backBtn.id = `${secId}-returnBtn`;
      backBtn.textContent = "Regresar tarjetas";
      bar.appendChild(backBtn);
      panel.appendChild(bar);

      container.appendChild(panel);

      // Interacciones (modo click/tap-to-place) por sección
      attachMatchesInteractions(panel);
    }
  });

  // Estado inicial del score
  setNeutralScore();

})();

// ========== Interacciones para "matches" por sección ==========
function attachMatchesInteractions(panel){
  const bank = panel.querySelector(".bank");
  const drops = Array.from(panel.querySelectorAll(".drop"));
  const returnBtn = panel.querySelector("button[id$='-returnBtn']");
  let selected = null;

  function selectPill(pill){
    if (selected === pill){ pill.classList.remove('selected'); selected=null; return; }
    if (selected) selected.classList.remove('selected');
    selected = pill; pill.classList.add('selected');
    pill.scrollIntoView({behavior:'smooth', block:'center'});
  }

  bank.addEventListener('click', e=>{
    const pill = e.target.closest('.pill');
    if (!pill) return;
    selectPill(pill);
  });

  drops.forEach(d=>{
    d.addEventListener('click', ()=>{
      if (!selected) return;
      const prev = d.querySelector('.pill');
      if (prev) bank.appendChild(prev);
      d.innerHTML = ''; d.appendChild(selected);
      selected.classList.remove('selected'); selected=null;
      d.scrollIntoView({behavior:'smooth', block:'center'});
    });
  });

  returnBtn.addEventListener("click",()=>{
    panel.querySelectorAll(".pill").forEach(p=> bank.appendChild(p));
    drops.forEach(d=> d.innerHTML="");
    panel.querySelectorAll(".rowfb").forEach(fb=> fb.textContent="");
    panel.querySelectorAll(".pill.selected").forEach(p=> p.classList.remove('selected'));
    setNeutralScore();
  });
}

// ====== Utilidades de score (compartidas con grade.js) ======
function setNeutralScore(){
  const scoreEl = document.getElementById("scoreTop");
  const statusMsg = document.getElementById("statusMsg");
  scoreEl.textContent = 'Resultado: —';
  scoreEl.classList.remove('good','bad','pulse');
  statusMsg.textContent = '';
  statusMsg.classList.remove('ok','fail');
}
