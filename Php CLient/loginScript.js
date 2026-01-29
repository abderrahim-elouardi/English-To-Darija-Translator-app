document.addEventListener('DOMContentLoaded', ()=>{
    userNameInput = document.getElementById("login-username")
    passwordInput = document.getElementById("login-password")
    loginButton = document.querySelector(".submit-btn")

    loginButton.addEventListener('click', ()=>{
        const username = userNameInput.value
        const password = passwordInput.value

        if(!username || !password){
            alert("Please enter both username and password.")
            return
        }else{
            localStorage.setItem('username', username)
            localStorage.setItem('password', password)
            alert("Credentials saved!")
            window.location.href = "learningPage.php"; 
        }
        
    })
})
