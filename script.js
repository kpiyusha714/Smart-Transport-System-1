
setInterval(() => {
    const result = document.getElementById("result");
    if(result.innerHTML.trim() !== "") {
        const randomTime = Math.floor(Math.random() * 10) + 1;
        result.innerHTML = `<p>Bus arriving in ${randomTime} minutes...</p>`;
    }
}, 3000);
