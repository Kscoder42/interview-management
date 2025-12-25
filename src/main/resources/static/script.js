const API = "http://localhost:8080/api/candidates";

function loadCandidates() {
    fetch(API)
        .then(res => res.json())
        .then(data => {
            const table = document.getElementById("candidateTable");
            table.innerHTML = "";
            data.content.forEach(c => {
                table.innerHTML += `
                    <tr>
                        <td>${c.id}</td>
                        <td>${c.name}</td>
                        <td>${c.email}</td>
                        <td>${c.skill}</td>
                        <td>${c.status}</td>
                    </tr>
                `;
            });
        });
}

function addCandidate() {
    const candidate = {
        name: document.getElementById("name").value,
        email: document.getElementById("email").value,
        skill: document.getElementById("skill").value,
        status: document.getElementById("status").value
    };

    fetch(API, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(candidate)
    })
    .then(() => {
        loadCandidates();
        alert("Candidate Added");
    });
}

loadCandidates();
