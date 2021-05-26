var cancha;
var apiReservaCliente = (function () {
	function cargarPagina() {
		//var id = document.getElementById("contenido").text;
		const valores = window.location.search;
		const urlParams = new URLSearchParams(valores);
		var id = urlParams.get('id');
		var cancha = urlParams.get('sede');
		var usuario = urlParams.get('usuario');

		const options = {
			method: 'GET',
			url: "https://back-la-reserva.herokuapp.com/canchas?id=" + id
		};

		axios.request(options).then(function (response) {
			//console.log(response.data.sede);
			cancha = response.data;
			document.getElementById("nombreCancha").textContent = response.data.titulo;
			document.getElementById("precio").textContent = "Precio: $" + response.data.precio;


		}).catch(function (error) {
			console.error(error);
		});
	}

	function hacerReserva() {
		var inicio;
		var fin;
		const horarios = {
			"8:00-9:00": 1, "9:00-10:00": 2,
			"10:00-11:00": 3, "11:00-12:00": 4,
			"12:00-13:00": 5, "13:00-14:00": 6,
			"14:00-15:00": 7, "15:00-16:00": 8,
			"16:00-17:00": 9, "17:00-18:00": 10,
			"18:00-19:00": 11, "19:00-20:00": 12,
			"20:00-21:00": 13, "21:00-22:00": 14,
			"23:00-24:00": 15
		}
		for (const property in horarios) {
			var a = property;
			var b = horarios[property]
			if (a === "Hora") {
				alert("Porfavor ingrese una hora")
				break;

			}
			if (document.getElementById("hora").value == b) {
				var inicio = a;

			}
		}

		const valores = window.location.search;
		const urlParams = new URLSearchParams(valores);
		var cancha = urlParams.get('sede');
		var usuario = urlParams.get('usuario');
		var dia = document.getElementById("fecha").value;
		console.log(cancha, usuario, dia, inicio);
	
	
		if (dia === "") {
			alert("Debes seleccionar la fecha y hora de tu reserva.");
		}else {
			const options = {
				method: 'POST',
				url: "https://back-la-reserva.herokuapp.com/reservas/crear",
				data:
				{
					'cancha': cancha,
					'usuario': usuario,
					'dia': dia,
					'hora': inicio
				}

			};

			axios.request(options).then(function (response) {
				console.log(response.data);
				alert("La reserva ha sido realizada satisfactoriamente");
			}).catch(function (error) {
				alert("La cancha ya está reservada en este horario.");
			});

		}
	}

	return {
		cargarPagina: cargarPagina,
		hacerReserva: hacerReserva
	}
})();