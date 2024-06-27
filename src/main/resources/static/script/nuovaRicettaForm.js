document.addEventListener('DOMContentLoaded', function() {
    var fileInput = document.getElementById('fileInput');
    var fileLabel = fileInput.nextElementSibling;

    fileInput.addEventListener('change', function() {
        var fileNames = [];
        for (var i = 0; i < fileInput.files.length; i++) {
            fileNames.push(fileInput.files[i].name);
        }
        fileLabel.textContent = 'Foto caricate: ' + fileInput.files.length;
    });
});