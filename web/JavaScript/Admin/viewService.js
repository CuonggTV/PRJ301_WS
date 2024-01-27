function showEditForm(serviceId) {
    // Hide all edit forms
    document.querySelectorAll('.edit-form').forEach(form => form.style.display = 'none');

    // Show the selected edit form
    const editForm = document.getElementById(`editForm${serviceId}`);
    editForm.style.display = 'flex';
}

function closeEditForm(serviceId) {
    // Hide the edit form when the "Close" button is clicked
    const editForm = document.getElementById(`editForm${serviceId}`);
    editForm.style.display = 'none';
}

function saveChanges(serviceId) {
    // Implement logic to save changes, e.g., update the table data
    alert(`Changes for Service ${serviceId} saved!`);

    // Hide the edit form after saving changes
    const editForm = document.getElementById(`editForm${serviceId}`);
    editForm.style.display = 'none';
}