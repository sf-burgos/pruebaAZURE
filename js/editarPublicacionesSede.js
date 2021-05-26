	var propietario;
	var ids;
	var apiEditarPublicacionesSede = (function () {
    function cargarPagina() {
		const valores = window.location.search;
		const urlParams = new URLSearchParams(valores);
		propietario = urlParams.get('id');
		ids = urlParams.get('ids');
		if(ids!=null){
			const options = {
                method: 'GET',
                url: "https://back-la-reserva.herokuapp.com/sedes?id="+ids
            };
            axios.request(options).then(function (response) {
                console.log(response);
                document.getElementById("title").value = response.data.nombre;
				document.getElementById("description").value =  response.data.descripcion;
				document.getElementById("direccion").value = response.data.direccion;
                
            }).catch(function (error) {
                alert("La sede no existe");
            });
		}
    }
	
	function vistaPrevia() {
		$("label[for='Name']").text(document.getElementById("title").value);
        document.getElementById("descripcion").value = document.getElementById("description").value;
		document.getElementById("address").value = document.getElementById("direccion").value;
    }
	
	function crearSede() {
		var nombre = document.getElementById("title").value;
		var descripcion = document.getElementById("description").value;
		var direccion = document.getElementById("direccion").value;
		var url = "https://back-la-reserva.herokuapp.com/sedes/crear";
		axios.post(url, {
                    "nombre": nombre, "encargado": propietario,
					"direccion": direccion, "descripcion": descripcion,
					
                })
                    .then(res => {
                        alert("Sede creada satisfactoriamente.");
                        //window.location.href = "/login.html";
                    }
                    );
    }
	
	function eliminarSede() {
		//console.log(document.getElementById("description").value);
		if(ids != null){
			var url = "https://back-la-reserva.herokuapp.com/sedes/eliminar?id="+ids
			axios.delete(url)
			.then((response) => {
			  alert("La sede se ha eliminado satisfactoriamente");
			  window.location.href="https://cherry-surprise-79251.herokuapp.com/landingPropietarios.html?id="+propietario;
			}, (error) => {
			  console.log(error);
			});
		}else{
			alert("Se ha eliminado la sede");
			window.location.href="https://cherry-surprise-79251.herokuapp.com/landingPropietarios.html?id="+propietario;
		}
		var url = "https://back-la-reserva.herokuapp.com/canchas/eliminar/"+cancha.id;
		axios.delete(url)
		.then((response) => {
		  alert("La cancha se ha eliminado satisfactoriamente");
		  window.location.href="https://cherry-surprise-79251.herokuapp.com/landingPropietarios.html";
		}, (error) => {
		  console.log(error);
		});
		
    }
    return {
        cargarPagina: cargarPagina,
		crearSede : crearSede,
		eliminarSede : eliminarSede,
		vistaPrevia : vistaPrevia
    }
})();