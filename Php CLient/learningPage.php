<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>To Darija</title>
    <link rel="icon" type="image/png" href="icon128.png">
    <link rel="stylesheet" href="learningPage.css">
</head>
<body>
    <div class="container">
        <h1>To Darija</h1>

        <div class="language-selection" style="display: flex; justify-content: space-between; margin-bottom: 20px;">
            <div class="select-group" style="flex: 1; margin-right: 10px;">
                <label for="sourceLang">From :</label>
                <select id="sourceLang" style="width: 100%; padding: 8px; border-radius: 5px;">
                    <option value="en">English</option>
                    <option value="fr">French</option>
                    <option value="es">Spanish</option>
                </select>
            </div>

        </div>

        <div class="textarea-group">
            <label class="textarea-label">Original Text</label>
            <textarea id="originalText" placeholder="Le texte original apparaîtra ici..."></textarea>
        </div>

        <div class="textarea-group">
            <label class="textarea-label">Transformed Text</label>
            <textarea id="transformedText" placeholder="Le texte transformé apparaîtra ici..."></textarea>
        </div>

        <div class="buttons-container">
            <button class="btn-primary" id="recordBtn">
                <span class="icon">🎙️</span>
                Start recording 
            </button>

            <button class="btn-secondary" id="transformBtn">
                <span class="icon">✨</span>
                Transform to Darija
            </button>

            <button class="btn-primary" id="login">
                <span class="icon">👤</span>
                Login
            </button>
        </div>
    </div>

    <script src="learningPage.js"></script>
</body>
</html>
