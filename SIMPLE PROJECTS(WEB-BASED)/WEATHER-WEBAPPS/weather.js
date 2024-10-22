const apiKey = "dd3b9ebfc13314d5fcd178667dbeba8c";
const apiUrl = "https://api.openweathermap.org/data/2.5/weather?units=metric&q=bangladesh";

async function checkWeather() {
    const response = await fetch(apiUrl + `$appid=${apiKey}`);
    var data = await response.json();

    console.log(data);
    document.querySelector(".city").innerHTML = data.name;
    document.
    
}

checkWeather();