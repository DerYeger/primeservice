const maxValue = 40000000;
const minValue = 0;

function validateInput(arguments) {
    const event = arguments[0];
    const node = event.target;

    if (event.data === "-") {
        node.value = node.value.replace("-", "");
    } else if (node.value > maxValue) {
        node.value = maxValue;
    } else if (node.value < minValue) {
        node.value = minValue;
    }
}