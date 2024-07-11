
let contenedorPersonajes = document.getElementById("personajes")

fetch("https://rickandmortyapi.com/api/character")
    .then((response)=>response.json())
    .then((datos)=>{

        console.log(datos)
        console.log(datos.results)
        console.log(datos.results[0])

        datos.results.forEach((elementos) => {
            //console.log(elementos.name)

            const contenedorCreado = document.createElement('div')
            contenedorCreado.className = "card-trending";

            contenedorCreado.innerHTML = `
            <h3>${elementos.name}</h3>
            <img src="${elementos.image}">
            <h4>${elementos.species}</h4>
            <h4>${elementos.type}</h4>
            `;
            
            contenedorPersonajes.append(contenedorCreado)



        });


    })