function validarAltura() {
    const auxAltura = document.getElementById("altura")
    const auxErro = document.getElementById("erro")
    auxErro.textContent = ""

    const valor = (auxAltura.value || "").trim().replace(",", ".")
    const altura = Number(valor)

    if(!Number.isFinite(altura)) {
        auxErro.textContent = "Digite um NÚMERO válido"
        auxAltura.focus()

        return false
    }

    if(altura < 0.65 || altura > 2.51) {
         auxErro.textContent = "Digite um NÚMERO entre 0,65m e 2,51m"
        auxAltura.focus()

        return false
    }

    return true
}