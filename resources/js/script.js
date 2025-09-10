async function loadIndex() {
  const res = await fetch("resources/data/index.json");
  const data = await res.json();

  // Header
  document.getElementById("course-title").textContent = data.title || "Tester Academy";

  // Recursos (derecha)
  const resourcesList = document.getElementById("resources-list");
  (data.resources || []).forEach(r => {
    const li = document.createElement("li");
    li.innerHTML = `<a href="${r.url}" target="_blank" rel="noopener">${r.label}</a>`;
    resourcesList.appendChild(li);
  });

  // Capítulos (izquierda)
  const container = document.getElementById("chapters-container");
  (data.chapters || []).forEach(ch => {
    const details = document.createElement("details");
    const summary = document.createElement("summary");
    summary.textContent = ch.title || "Capítulo";
    details.appendChild(summary);

    const ul = document.createElement("ul");

    if (ch.pdf) {
      ul.innerHTML += `<li><a href="${ch.pdf}" target="_blank" rel="noopener">📑 Presentación (PDF)</a></li>`;
    }
    if (Array.isArray(ch.quizzes)) {
      ch.quizzes.forEach((q, i) => {
        ul.innerHTML += `<li><a href="${q}" target="_blank" rel="noopener">📝 Quiz 0${i + 1}</a></li>`;
      });
    }
    if (Array.isArray(ch.videos)) {
      ch.videos.forEach((v, i) => {
        ul.innerHTML += `<li><a href="${v}" target="_blank" rel="noopener">🎬 Video 0${i + 1}</a></li>`;
      });
    }
    if (ch.code) {
      ul.innerHTML += `<li><a href="${ch.code}" target="_blank" rel="noopener">📂 Código (GitHub)</a></li>`;
    }
    if (ch.extras) {
      ul.innerHTML += `<li><a href="${ch.extras}" target="_blank" rel="noopener">📦 Materiales extra</a></li>`;
    }

    details.appendChild(ul);
    container.appendChild(details);
  });

  // Footer
  const ft = data.footer || {};
  const p = document.getElementById("footer-text");
  const year = new Date().getFullYear();
  p.innerHTML = `${ft.text || `© ${year} Tester Academy — Todos los derechos reservados`} | `
    + `<a href="${ft.privacyUrl || '#'}" target="_blank" rel="noopener">Aviso de privacidad</a> | `
    + `<a href="${ft.termsUrl || '#'}" target="_blank" rel="noopener">Términos y condiciones</a>`;

  const social = document.getElementById("social-links");
  (ft.social || []).forEach(s => {
    const a = document.createElement("a");
    a.href = s.url || "#";
    a.target = "_blank";
    a.rel = "noopener";
    a.innerHTML = `<img src="${s.icon}" alt="social">`;
    social.appendChild(a);
  });
}
loadIndex();
