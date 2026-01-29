document.addEventListener("mouseup", () => {
    const selectedText = window.getSelection().toString().trim();
    if (selectedText) {
        document.getElementById("originalText").innerHTML =selectedText 
    }
});

chrome.action.onClicked.addListener(() => {
    chrome.windows.create({
        url: "popup.html",
        type: "popup",      // type popup = petite fenêtre
        width: 400,
        height: 600,
        left: 100,          // position sur l’écran
        top: 100
    });
});


document.addEventListener('mouseup', () => {
    const selectedText = window.getSelection().toString().trim();
    alert(selectedText);
    if (selectedText.length > 0) {
        // Envoie le texte au Side Panel ou au Background
        chrome.runtime.sendMessage({
            type: "TEXT_SELECTED",
            text: selectedText
        });
    }
});
