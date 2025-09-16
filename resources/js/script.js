fetch("resources/data/index.json")
  .then(r => r.json())
  .then(data => {
    // Título
    const titleEl = document.getElementById("courseTitle");
    if (data.title) titleEl.textContent = data.title;

    // Recursos
    const resourcesList = document.getElementById("resourcesList");
    (data.resources || []).forEach(r => {
      const li = document.createElement("li");
      const iconHtml = r.icon ? `<i class="${r.icon}"></i>` : "";
      li.innerHTML = `${iconHtml}<a href="${r.url || '#'}" target="_blank">${r.label || ''}</a>`;
      resourcesList.appendChild(li);
    });

    // Capítulos
    const chaptersContainer = document.getElementById("chaptersContainer");
    (data.chapters || []).forEach(ch => {
      const details = document.createElement("details");
      const summary = document.createElement("summary");
      summary.textContent = ch.title || "Capítulo";
      details.appendChild(summary);

      const ul = document.createElement("ul");

      if (ch.pdf) {
        ul.innerHTML += `<li><i class="fa-solid fa-file-pdf"></i><a href="${ch.pdf}" target="_blank">PDF</a></li>`;
      }

      if (Array.isArray(ch.videos) && ch.videos.length) {
        ch.videos.forEach((v, i) => {
          ul.innerHTML += `<li><i class="fa-brands fa-youtube"></i><a href="${v}" target="_blank">Video ${i + 1}</a></li>`;
        });
      }

      if (ch.code) {
        ul.innerHTML += `<li><i class="fa-solid fa-code"></i><a href="${ch.code}" target="_blank">Código</a></li>`;
      }

      if (Array.isArray(ch.quizzes) && ch.quizzes.length) {
        ch.quizzes.forEach((q, i) => {
          ul.innerHTML += `<li><i class="fa-solid fa-list-check"></i><a href="${q}" target="_blank">Quiz ${i + 1}</a></li>`;
        });
      }

      if (ch.extras) {
        ul.innerHTML += `<li><i class="fa-solid fa-box-archive"></i><a href="${ch.extras}" target="_blank">Materiales extra</a></li>`;
      }

      if (ul.children.length) details.appendChild(ul);
      chaptersContainer.appendChild(details);
    });

    // Footer
    document.getElementById("footerText").textContent = data.footer?.text || "";
    const privacy = document.getElementById("privacyLink");
    const terms = document.getElementById("termsLink");
    if (data.footer?.privacyUrl) privacy.href = data.footer.privacyUrl;
    if (data.footer?.termsUrl)   terms.href = data.footer.termsUrl;

    const social = document.getElementById("socialLinks");
    (data.footer?.social || []).forEach(s => {
      const a = document.createElement("a");
      a.href = s.url || "#";
      a.target = "_blank";
      a.innerHTML = `<i class="${s.icon || ''}"></i>`;
      social.appendChild(a);
    });
  })
  .catch(err => console.error("Error cargando index.json:", err));
