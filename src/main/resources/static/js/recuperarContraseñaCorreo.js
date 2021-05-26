var apiRecuperarContraseña = (function () {
    function recuperarContraseña() {
        var usuario = document.getElementById("usuario").value;
        if (usuario === "") {
            alert("Debe llenar el campo solicitado.");
        } else {
			//window.location.href = "recuperarContraseña.html";
			const options={
				method: 'GET',
                url: "https://back-la-reserva.herokuapp.com/usuarios/send-email/"+usuario
			};
			
            axios.request(options).then(function (response) {
                console.log(response);
                if (response.data === null) {
					alert("El usuario no se encuentra registrado.");
                }else{
					alert("Se ha enviado un correo para cambiar la contraseña");
				}
            }).catch(function (error) {
                console.error(error);
            });

        }
    }
    return {
        recuperarContraseña: recuperarContraseña
    }
})();