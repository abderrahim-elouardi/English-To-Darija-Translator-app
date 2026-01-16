chrome.runtime.onInstalled.addListener(() => {
    console.log("Extension installée !");
});



// chrome.action.onClicked.addListener(() => {
//   chrome.windows.create({
//     url: "index.html",  // page que tu veux ouvrir
//     type: "popup",
//     width: 800,         // largeur souhaitée
//     height: 600         // hauteur souhaitée
//   });
// });
