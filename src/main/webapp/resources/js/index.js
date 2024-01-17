const handleMenu = (contenedor, ocultarVariable) => {
	const card = document.querySelector(".card");
	const contenedorMenu = document.getElementById("contenedorMenu");
	const ocultar = document.getElementById("ocultar");
	if (contenedorMenu.clientWidth > 0) {

		//Sirve para cerrar el contenedorMenu
		contenedorMenu.classList.add("cerrar");
		contenedorMenu.classList.remove("abrir");

		//Sirve para hacer el efecto de desvanecer
		card.classList.remove("opacar");
		card.classList.add("noOpacar");

		ocultar.classList.add("cerrar");
		ocultar.classList.remove("abrir");

		//		contenedorMenu.style.width = "0px";
		//		ocultar.style.width = "0px";

		setTimeout(function() {
			card.style.display = "none";
			contenedorMenu.style.display = "none";
			ocultar.style.display = "none";
		}, 1000);

	} else if (contenedorMenu.style.width <= "0px") {

		//Siver para abrir el contenedorMenu
		contenedorMenu.classList.remove("cerrar");
		contenedorMenu.classList.add("abrir");

		//Sirve para hacer el efecto de aparecer
		card.classList.add("opacar");
		card.classList.remove("noOpacar");

		ocultar.classList.remove("cerrar");
		ocultar.classList.add("abrir");

		//		contenedorMenu.style.width = contenedor;
		//		ocultar.style.width = ocultarVariable;

		setTimeout(function() {
			card.style.display = "block";
			contenedorMenu.style.display = "block";
			ocultar.style.display = "block";
		}, 1000);

	}
}

const colapsarMenu = () => {
	const pantalla = screen.width;
	console.log(pantalla);
	if (pantalla > 1200) {
		console.log("mayor a 1200");
		handleMenu("17%", "20%");
	} else if (pantalla > 800 && pantalla <= 1200) {
		console.log("mayor a 800 y menor a 1200");
		handleMenu("30%", "0%");
	} else if (pantalla > 570 && pantalla <= 800) {
		console.log("mayor a 570 y menor 800");
		handleMenu("40%", "0%");
	} else if (pantalla > 0 && pantalla <= 570) {
		console.log("mayor a 0 y menor a 570");
		handleMenu("50%", "0%");
	}
}