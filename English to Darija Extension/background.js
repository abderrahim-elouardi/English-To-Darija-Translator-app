chrome.runtime.onInstalled.addListener(() => {
    console.log("Extension installée !");
});

// Permet d'ouvrir le Side Panel au clic sur l'icône de l'extension
chrome.sidePanel
  .setPanelBehavior({ openPanelOnActionClick: true })
  .catch((error) => console.error(error));