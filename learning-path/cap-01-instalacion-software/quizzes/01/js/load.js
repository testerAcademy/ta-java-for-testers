// Render dinámico desde data.json (v2.1 con options {option, text})
(async function loadQuiz(){
  const path = document.querySelector('meta[name="quiz-data"]').content;
  const res = await fetch(path);
  const data = await res.json();

  // Header
  document.getElementById("quiz-title").textContent = data.title || "Quiz";

  const container = document.getElementById("quiz-container");
  container.innerHTML = "";

  // ===== RENDER DE SECCIONES =====
  (data.sections || []).forEach((section, secIndex) => {
    const secId = section.id || `sec-${secIndex+1}`;

    // ---------- OPCIÓN MÚLTIPLE ----------
    if (section.type === "options"){
      const panel = document.createElement("section");
      panel.className = "panel";
      panel.dataset.type = "options";
      panel.dataset.sec = secId;

      const h2 = document.createElement("h2");
      h2.textContent = section.title || "Sección";
      panel.appendChild(h2);

      if (section.instructions){
        const note = document.createElement("p");
        note.className = "note";
        note.textContent = section.instructions;
        panel.appendChild(note);
      }

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
          input.name = q.id;
          input.value = opt.option; // ahora el valor es la clave (ej. "a")
          label.appendChild(input);
          label.appendChild(document.createTextNode(" " + opt.text));
          qa.appendChild(label);
        });

        const fb = document.createElement("div");
        fb.id = "fb-" + q.id;
        fb.className = "qfb";
        qa.appendChild(fb);

        panel.appendChild(qa);
      });

      container.appendChild(panel);
    }

    // ---------- RELACIONAR ----------
    if (section.type === "matches"){
      const panel = document.createElement("section");
      panel.className = "panel";
      panel.dataset.type = "matches";
      panel.dataset.sec = secId;

      const h2 = document.createElement("h2");
      h2.textContent = section.title || "Sección";
      panel.appendChild(h2);

      if (section.instructions){
        const note = document.createElement("p");
        note.className = "note";
        note.textContent = section.instructions;
        panel.appendChild(note);
      }

      // Filas (rows)
      const rowsWrap = document.createElement("div");
      rowsWrap.className = "rows";
      rowsWrap.id = `${secId}-rows`;

      (section.pairs || []).forEach((pair, idx) => {
        const row = document.createElement("div");
        row.className = "row";
        row.dataset.ans = pair.answer; // ahora compara contra clave (ej. "a")

        const rq = document.createElement("div");
        rq.className = "row-question";
        rq.textContent = `${idx+1}. ${pair.text}`;
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

      // Banco de tarjetas
      const bankBlock = document.createElement("div");
      bankBlock.className = "bank-block";

      const bankTitle = document.createElement("div");
      bankTitle.className = "bank-title";
      bankTitle.textContent = "Tarjetas";
      bankBlock.appendChild(bankTitle);

      const bank = document.createElement("div");
      bank.className = "bank";
      bank.id = `${secId}-bank`;

      (section.options || []).forEach(opt => {
        const pill = document.createElement("div");
        pill.className = "pill";
        pill.dataset.opt = opt.option; // clave interna
        pill.textContent = opt.text;   // texto visible
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

      // Interacciones drag/click
      attachMatchesInteractions(panel);
    }
  });

  setNeutralScore();

})();

// ====== Interacciones matches ======
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

// ====== Utilidad compartida ======
function setNeutralScore(){
  const scoreEl = document.getElementById("scoreTop");
  const statusMsg = document.getElementById("statusMsg");
  scoreEl.textContent = 'Resultado: —';
  scoreEl.classList.remove('good','bad','pulse');
  statusMsg.textContent = '';
  statusMsg.classList.remove('ok','fail');
}
