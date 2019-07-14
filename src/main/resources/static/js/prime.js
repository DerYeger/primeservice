const endpoint = "http://yeger.eu:8080/prime/test";

function getResult() {
    let number = document.getElementById("input").value;

    let request = new XMLHttpRequest();
    request.overrideMimeType("text/plain");
    request.open("GET", endpoint + "?number=" + number, true);
    request.onreadystatechange = function() {
        if (request.readyState === 4) {
            if (request.status === 200) {
                showResult(number, request.responseText);
            } else {
                showError(request.responseText);
            }
        }
    };
    request.send();
}

function showResult(number, result) {
    alert(number + " is" + (result === "true" ? " " : " not ") + "prime");
}

function showError(responseText) {
    alert(responseText);
}