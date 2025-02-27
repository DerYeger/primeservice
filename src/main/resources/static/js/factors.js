const endpoint = "http://yeger.eu/factors/";

function getResult() {
    let number = document.getElementById("input").value;

    let request = new XMLHttpRequest();
    request.overrideMimeType("application/json");
    request.open("GET", endpoint + "?number=" + number, true);
    request.onreadystatechange = function() {
        if (request.readyState === 4) {
            if (request.status === 200) {
                showFactors(number, JSON.parse(request.responseText));
            } else {
                showError(request.responseText);
            }
        }
    };
    request.send();
}

function showFactors(number, factors) {
    let string = "Factors: ";

    string += factors[0];

    for (let i = 1; i < factors.length; i++) {
        string += ", " + factors[i];
    }

    alert(string);
}

function showError(responseText) {
    alert(responseText);
}