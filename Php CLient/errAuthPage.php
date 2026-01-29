<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Authentication Required - To Darija</title>
    <link rel="stylesheet" href="errAuthPage.css">
</head>
<body>
    <div class="error-container">
        <span class="error-icon">🔐</span>
        
        <div class="error-code">401</div>
        
        <h1 class="error-title">Authentication Required</h1>
        
        <p class="error-description">
            You need to be authenticated to access this page. Please log in to your account to continue learning Darija.
        </p>

        <div class="error-content">
            <p><strong>Why do I see this message?</strong></p>
            <p>This page is only available to authenticated users. Your session may have expired or you haven't logged in yet.</p>
            <p style="margin-top: 12px;"><strong>What should I do?</strong></p>
            <p>Click the "Login" button below to access your account and continue your learning journey with To Darija.</p>
        </div>

        <div class="buttons-container">
            <a id="loginBtn" class="btn-primary">
                <span class="icon">👤</span>
                Login
            </a>
            <a id="goBack" class="btn-secondary">
                <span class="icon">←</span>
                Go Back
            </a>
        </div>

        <div class="security-badge">
            <span>🛡️</span>
            <span>Your data is secure with us</span>
        </div>
    </div>
    <script src="errAuthPage.js"></script>
</body>
</html>
