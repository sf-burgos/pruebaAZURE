var cancha;
var apiEditarPublicacionesCancha = (function () {
    function cargarPagina() {
		//var id = document.getElementById("contenido").text;
		const valores = window.location.search;
		const urlParams = new URLSearchParams(valores);
		var id = urlParams.get('id');
		const options={
				method: 'GET',
                url: "https://back-la-reserva.herokuapp.com/canchas?id="+ id
		};
		axios.request(options).then(function (response) {
                //console.log(response.data.sede);
				cancha = response.data;
				console.log(cancha.titulo);
                document.getElementById("titulo").textContent = response.data.sede;
				document.getElementById("nombreCancha").textContent = response.data.titulo;
				document.getElementById("precio").textContent = "Precio: $"+response.data.precio
				

				document.getElementById("title").value = response.data.titulo;
				document.getElementById("precioHora").value = response.data.precio;

            }).catch(function (error) {
                console.error(error);
            });
    }
	
	function hacerReserva() {
		//var id = document.getElementById("contenido").text;
		//console.log(id);
		console.log(document.getElementById("nuevo").value);
		var inicio;
		var fin;
		if(document.getElementById("nuevo").value == 1){
			inicio = "8:00";
			fin = "9:00";
		}else if(document.getElementById("nuevo").value == 2){
			inicio = "9:00";
			fin = "10:00";
		}else{
			inicio = "13:00";
			fin = "14:00";
		}

		var fecha = document.getElementById("fecha").value;
		var url = "https://proyecto-arsw.herokuapp.com/agenda/reserva";
		axios.post(url, {"cancha": cancha.id, "usuario": "sf.bug", "fecha":fecha, 
                "horainicio": inicio, "horafin": fin})
                    .then(res => {
                        alert("Se ha realizado la reserva.");
                    }
                    );
    }
	
	
	function actualizarCancha() {

		
		var url = "https://back-la-reserva.herokuapp.com/canchas/actualizar/"+cancha.id;
		axios.put(url, {
		  id: cancha.id,
		  titulo: document.getElementById("title").value,
		  foto: cancha.foto,
		  estado: cancha.estado,
		  sede: cancha.sede,
		  contacto: cancha.contacto,
		  calificacion: cancha.calificacion,
		  capacidad: cancha.capacidad,
		  precio: document.getElementById("precioHora").value
		  
		})
		.then((response) => {
		  alert("la cancha ha sido actualizada");
		  cargarPagina();
		}, (error) => {
		  console.log(error);
		});
		
    }
	
	function eliminarCancha() {
		//console.log(document.getElementById("description").value);
		
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
		hacerReserva : hacerReserva,
		actualizarCancha : actualizarCancha,
		eliminarCancha : eliminarCancha
    }
})();