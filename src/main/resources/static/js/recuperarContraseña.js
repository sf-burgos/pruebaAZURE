var username;
var apiRecuperarContraseña = (function () {
	
	
		
    function recuperarContraseña() {
		
        var password = document.getElementById("contraseña").value;
        var confirm = document.getElementById("confirmarContraseña").value;
        if (password === "" || confirm === "") {
            alert("Todos los campos son requeridos.");
        } else {
			if (password != confirm){
				alert("Las contraseñas deben coincidir");
				
			}else{
				const options = {
                method: 'PUT',
                url: "https://back-la-reserva.herokuapp.com/usuarios/actualizar?password="+generateHash(password).toString()+"&username="+username
				};
				axios.request(options).then(function (response) {
					alert("Contraseña cambiada satisfactoriamente")
					window.location.href = "/login.html";
				}).catch(function (error) {
                console.error(error);
				});
			}
			//window.location.href = "login.html";
			
            

        }
    }
	
	function cargarPagina() {
		const valores = window.location.search;
		const urlParams = new URLSearchParams(valores);
		username = urlParams.get('username');
		console.log(username);
    }

	function generateHash(password) {
		var plainText = password;
		var hashText = CryptoJS.SHA256(plainText);
		return hashText;
		}
		
		
    return {
        recuperarContraseña: recuperarContraseña,
		cargarPagina: cargarPagina
    }
})();