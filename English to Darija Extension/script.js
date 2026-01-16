document.addEventListener("DOMContentLoaded",()=>{

const startSpeech = document.getElementById("recordBtn");
const result = document.getElementById("originalText");

// Compatibilité navigateur
const SpeechRecognition = window.SpeechRecognition || window.webkitSpeechRecognition;
const recognition = new SpeechRecognition();

recognition.lang = "en-US"; // anglais (États-Unis)
recognition.continuous = false;
recognition.interimResults = false;

startSpeech.onclick = () => {
    recognition.start();
    recordBtn.classList.add('recording');
    recordBtn.textContent = '🎤 Enregistrement en cours...';
    originalText.style.color = '#667eea';
};

recognition.onresult = (event) => {
    const text = event.results[0][0].transcript;
    result.innerText = text;
    recordBtn.classList.remove('recording');
    recordBtn.innerHTML = '<span class="icon">🎙️</span>Démarrer l\'enregistrement';
    originalText.style.color = '#333';
};

recognition.onerror = (event) => {
    console.error("Erreur :", event.error);
};

transformBtn.addEventListener('click', function() {
    if (originalText.value.trim()) {
        transformedText.value = originalText.value.toUpperCase();
        transformedText.style.color = '#667eea';
    }
});        

})