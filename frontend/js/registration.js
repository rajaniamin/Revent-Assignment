function registerStudent() {
    let sid = document.getElementById("id").value;
    let sname = document.getElementById("name").value;
    let ssubject = document.getElementById("subject").value; // Corrected the element ID
    let smarks = document.getElementById("marks").value;

    fetch("http://localhost:8080/addData", {
        method: "POST",
        headers: {
            "Content-Type": "application/json", // Corrected content-type header
        },
        body: JSON.stringify({
            "id": sid,
            "name": sname,
            "subject": ssubject,
            "marks": smarks,
        }),
    })
    .then(response => {
        if (response.ok) {
            return response.json();
        } else {
            throw new Error("Failed to register student");
        }
    })
    .then(data => {
        alert("Student successfully registered with Roll: " + data.roll);
    })
    .catch(error => {
        alert("Registration failed: " + error.message);
    });
}
