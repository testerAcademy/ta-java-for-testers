async function loadQuiz() {
  try {
    const response = await fetch("data/data.json");
    const data = await response.json();
    const container = document.getElementById("quiz-container");

    data.questions.forEach((q, index) => {
      const div = document.createElement("div");
      div.className = "quiz-question";

      // Texto
      const p = document.createElement("p");
      p.textContent = (index + 1) + ". " + q.text;
      div.appendChild(p);

      // Imagen
      if (q.image) {
        const img = document.createElement("img");
        img.src = q.image;
        div.appendChild(img);
      }

      // Opciones
      q.options.forEach(opt => {
        const btn = document.createElement("button");
        btn.textContent = opt;
        btn.onclick = () => {
          if (opt === q.answer) {
            alert("✔ Correcto");
          } else {
            alert("✘ Incorrecto");
          }
        };
        div.appendChild(btn);
      });

      container.appendChild(div);
    });
  } catch (error) {
    console.error("Error cargando el quiz:", error);
  }
}

loadQuiz();
