
//adding data
// Function to add a new row to the table
function addRowToTable(student) {
    const tableBody = document.getElementById('studentTableBody');
  
    const newRow = document.createElement('tr');
    newRow.innerHTML = `
      <th><span class="custom-checkbox">
        <input type="checkbox" id="checkbox4" name="option[]" value="1">
        <label for="checkbox4"></label>
      </th>
      <th>${student.id}</th>
      <th>${student.name}</th>
      <th>${student.subject}</th>
      <th>(${student.marks})</th>
      <th>
        <a href="#editEmployeeModal" class="edit" data-toggle="modal">
          <i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i>
        </a>
        <a href="#deleteEmployeeModal" class="delete" data-toggle="modal">
          <i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i>
        </a>
      </th>
    `;
  
    tableBody.appendChild(newRow);
  }
  

  // Get a reference to the "Add" button
  const addStudentButton = document.getElementById('addStudentButton');

  // Add a click event listener to the "Add" button
  addStudentButton.addEventListener('click', function () {
    // Get the values from the input fields
    const rollNumber = document.getElementById('rollNumber').value;
    const name = document.getElementById('name').value;
    const subject = document.getElementById('subject').value;
    const marks = document.getElementById('marks').value;

    // Create an object to hold the data
    const studentData = {
      rollNumber,
      name,
      subject,
      marks,
    };

    // Display the data in the console
    console.log('Student Data:', studentData);

    // Send the data to your API
    fetch('http://localhost:8080/addData', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(studentData),
    })
      .then(response => response.json())
      .then(data => {
        console.log('Data sent to the API:', data);

        // Add the new row to the table
        addRowToTable(data);
      })
      .catch(error => {
        console.error('Error sending data to the API:', error);
      });
  });

//editing data
//--------------------------------------------------------------------------------------------

// Get a reference to the "Save" button in the edit modal
const saveEditButton = document.getElementById('saveEditButton');

// Add a click event listener to the "Save" button in the edit modal
saveEditButton.addEventListener('click', function () {
  // Get the values from the input fields
  const rollNumber = document.getElementById('rollNumber').value;
  const name = document.getElementById('name').value;
  const subject = document.getElementById('subject').value;
  const marks = document.getElementById('marks').value;

  // Create an object to hold the data
  const studentData = {
    rollNumber,
    name,
    subject,
    marks,
  };

  // Display the data in the console
  console.log('Student Data:', studentData);

  // Send the data to your API
  fetch('http://localhost:8080/updatedata', {
    method: 'PUT',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify(studentData),
  })
    .then(response => response.json())
    .then(data => {
      console.log('Data sent to the API:', data);

      // Update the existing row in the table
      updateStudentRow(data);
    })
    .catch(error => {
      console.error('Error sending data to the API:', error);
    });
});

// Function to update an existing row in the table
function updateStudentRow(student) {
  // Find the existing row in the table and update its content
  const existingRow = document.querySelector(`[value="${student.id}"]`).closest('tr');
  existingRow.querySelector('td:nth-child(2)').textContent = student.name;
  existingRow.querySelector('td:nth-child(3)').textContent = student.subject;
  existingRow.querySelector('td:nth-child(4)').textContent = student.marks;
}

//delete data
//----------------------------------------------------------------------------------

// Add a click event listener to the "Delete" button in the modal
document.querySelector('#deleteEmployeeModal .btn-success').addEventListener('click', function () {
    const studentIdToDelete = document.getElementById('deleteid').value; // Get the ID from the input field
  
    // Check if the ID is valid (you can add more validation here)
    if (studentIdToDelete === '' || isNaN(studentIdToDelete)) {
      alert('Please enter a valid student ID for confirmation.');
      return;
    }
  
    // Send a DELETE request to your API
    fetch(`http://localhost:8080/deleteData/${studentIdToDelete}`, {
      method: 'DELETE',
    })
      .then(response => {
        if (response.status === 200) {
          // Data deleted successfully
          console.log('Data deleted successfully.');
          
          // Remove the row from the table (you can implement this function)
          removeStudentRow(studentIdToDelete);
          
          // Close the delete modal using Bootstrap's modal('hide')
          $('#deleteEmployeeModal').modal('hide');
        } else {
          // Handle error or display an error message
          console.error('Error deleting data:', response.status);
        }
      })
      .catch(error => {
        console.error('Error deleting data:', error);
      });
  });
  

  // Function to remove a row from the table
function removeStudentRow(studentId) {
    const rowToRemove = document.querySelector(`tr[data-id="${studentId}"]`);
    if (rowToRemove) {
      rowToRemove.remove();
    }
  }
  