// ===============================
// WorkNest App - Global JS Scripts
// ===============================

// Show confirmation before deleting
function confirmDelete(message) {
    return confirm(message || "Are you sure you want to delete this?");
}

// Automatically hide Bootstrap alerts after 3 seconds
document.addEventListener("DOMContentLoaded", function () {
    let alerts = document.querySelectorAll(".alert");
    alerts.forEach(function (alert) {
        setTimeout(() => {
            alert.style.display = "none";
        }, 3000);
    });
});

// Example: toggle task status dynamically
function updateTaskStatus(taskId, status) {
    console.log("Updating Task:", taskId, "to status:", status);
    // TODO: Call backend API via AJAX
    alert("Task " + taskId + " updated to " + status);
}
