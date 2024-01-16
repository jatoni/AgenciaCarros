const colapsarMenu = () => {
	const contenedorMenu = document.getElementById("contenedorMenu");
	const ocultar = document.getElementById("ocultar");
	const card = document.querySelector(".card");

	if (contenedorMenu.clientWidth > 0) {

		//Esto va a funcionar para hacer que el menu se cierre
		contenedorMenu.classList.add("cerrar");
		contenedorMenu.classList.remove("abrir");
		ocultar.classList.add("cerrar");
		ocultar.classList.remove("abrir");

		//Esto es para que se quite
		contenedorMenu.style.width = "0px";
		ocultar.style.width = "0px";

		card.classList.remove("opacar");
		card.classList.add("noOpacar");
		setTimeout(function() {
			card.style.display = "none"
		}, 1000);

	} else if (contenedorMenu.style.width <= "0px") {
		contenedorMenu.classList.remove("cerrar");
		contenedorMenu.classList.add("abrir");
		ocultar.classList.remove("cerrar");
		ocultar.classList.add("abrir");


		contenedorMenu.style.width = "17%";
		ocultar.style.width = "20%";

		card.classList.add("opacar");
		card.classList.remove("noOpacar");
		setTimeout(function() {
			setTimeout(card.style.display = "block", 1000);
		}, 500);
	}
}