function registerStudent() {
    let sid = document.getElementById("id").value;
    let sname = document.getElementById("name").value;
    let ssubject = document.getElementById("subject").value; 
    let smarks = document.getElementById("marks").value;

    fetch("http://localhost:8080/updatedata", {
        method: "PUT",
        headers: {
            "Content-Type": "application/json", 
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
            throw new Error("Failed to update the detailst");
        }
    })
    .then(data => {
        alert("Student data "+ data.roll+ " is updated succesfully : " );
    })
    .catch(error => {
        alert("Updataion  failed: " + error.message);
    });
}
