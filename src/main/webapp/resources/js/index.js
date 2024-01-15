const colapsarMenu = () => {
	const contenedorMenu = document.getElementById("contenedorMenu");
	const card = document.querySelector(".card");
	if (contenedorMenu.clientWidth > 0) {
		contenedorMenu.classList.add("cerrar");
		contenedorMenu.classList.remove("abrir");
		contenedorMenu.style.width = "0px";
		card.classList.remove("opacar");
		card.classList.add("noOpacar");
		setTimeout(function() {
			card.style.display = "none"
		}, 1000);
	} else if (contenedorMenu.style.width <= "0px") {
		contenedorMenu.classList.remove("cerrar");
		contenedorMenu.classList.add("abrir");
		contenedorMenu.style.width = "300px";
		card.classList.add("opacar");
		card.classList.remove("noOpacar");
		setTimeout(function() {
			setTimeout(card.style.display = "block", 1000);
		}, 500);
	}
}