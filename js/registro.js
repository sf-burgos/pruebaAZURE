/* global axios */
var apiclient = (function () {
    var url = "https://back-la-reserva.herokuapp.com/usuarios/registrar";
    function registrarCliente() {
        var nombre = document.getElementById("nombre").value;
        var apellidos = document.getElementById("apellido").value;
        var username = document.getElementById("username").value;
        var celular = document.getElementById("celular").value;
        var email = document.getElementById("correo").value;
        var documento = document.getElementById("ndoc").value;
        var password = document.getElementById("contraseña").value;
        var pwdconfirmacion = document.getElementById("confcont").value;

        if (nombre === "" || apellidos === "" || username === "" || celular === "" || email === "" || documento === "" || password === "" || pwdconfirmacion === "") {
            alert("Todos los campos son requeridos.");
        } else {
            if (password !== pwdconfirmacion) {
                alert("Las contaseñas con coinciden.");
            } else {
                axios.post(url, {
                    "nombre": nombre, "apellidos": apellidos, "username": username,
                    "contrasena": generateHash(password).toString(), "celular": celular, "email": email, "rol": "cliente",
                    "documento": documento
                })
                    .then(res => {
                        alert("Usuario registrado satisfactoriamente.");
                        window.location.href = "/login.html";
                    }
                    );
            }
        }
    }


    function registrarPropietario() {
        var nombre = document.getElementById("nom").value;
        var apellidos = document.getElementById("ap").value;
        var username = document.getElementById("usrname").value;
        var celular = document.getElementById("cel").value;
        var email = document.getElementById("cor").value;
        var documento = document.getElementById("doc").value;
        var password = document.getElementById("pw").value;
        var pwdconfirmacion = document.getElementById("confpw").value;
		
        if (nombre === "" || apellidos === "" || username === "" || celular === "" || email === "" || documento === "" || password === "" || pwdconfirmacion === "") {
            alert("Todos los campos son requeridos.");
        } else {
            if (password !== pwdconfirmacion) {
                alert("Las contaseñas con coinciden.");
            } else {
                axios.post(url, {
                    "nombre": nombre, "apellidos": apellidos, "username": username,
                    "contrasena": generateHash(password).toString(), "celular": celular, "email": email, "rol": "propietario",
                    "documento": documento
                })
                    .then(res => {
                        alert("Usuario registrado satisfactoriamente.");
                        window.location.href = "/login.html";
                    }
                    );
            }
        }
    }

    function generateHash(password) {
        var plainText = password;
        var hashText = CryptoJS.SHA256(plainText);
        return hashText;
    }
    return {
        registrarCliente: registrarCliente, registrarPropietario:registrarPropietario
    };
}

)();
