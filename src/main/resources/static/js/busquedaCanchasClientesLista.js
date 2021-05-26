var apiLandingPropietarios = (function () {
    var canchas = [];
    function busquedaCanchasClientesLista() {
        const options = {
            method: 'GET',
            url: "https://back-la-reserva.herokuapp.com/sedes/listar"
        };
        axios.request(options).then(function (response) {
            response.data.map(function (record) {
                //callback
                retornarCachasDeSede(record.id,record.nombre, mostrarCanchas);
            });
        }).catch(function (error) {
            console.error(error);
        });

    }
    function retornarCachasDeSede(id, nombre, callback) {
        const options = {
            method: 'GET',
            url: 'https://back-la-reserva.herokuapp.com/canchas/sede?id=' + id
        };
        axios.request(options).then(function (response) {
            response.data.map(function (record) {
                canchas.push(record);
            });
            callback(id,nombre);
        }).catch(function (error) {
            console.error(error);
        });
    }

    function mostrarCanchas(id, nombre) {
        const valores = window.location.search;
		const urlParams = new URLSearchParams(valores);
		var id = urlParams.get('id');
        var canchasSedes = "";

        canchas.map((cancha) => {
            canchasSedes = canchasSedes.concat(`<li><a class='dropdown-item' href='reservaCliente.html?id=${cancha.id}&usuario=${id}&sede=${cancha.id}'>${cancha.titulo}</a></li>`);
        });
        $("#sedes").append(
            "<button type='button' href='vistaSedeCliente.html' class='btn btn-danger b1 d-block'>" + nombre + "</button>" +
            "<button type='button' class='btn btn-danger dropdown-toggle dropdown-toggle-split'" +
            "data-bs-toggle='dropdown' aria-expanded='false'>" +
            "<span class='visually-hidden'>Toggle Dropdown</span>" +
            "</button>" +
            "<ul class='dropdown-menu'>" +
            canchasSedes +
            "<li>" +
            " <hr class='dropdown-divider'>" +
            "</li>" +
            "</ul>"
        );

        canchas = [];
    }

    return {
        busquedaCanchasClientesLista: busquedaCanchasClientesLista
    };

})();
