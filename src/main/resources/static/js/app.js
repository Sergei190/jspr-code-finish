console.log('js executed');

const form = document.getElementById('form');
form.addEventListener('submit', (evt) => {
    evt.preventDefault();

    {
        const data = JSON.stringify({key: 'value'});
        const xhr = new XMLHttpRequest();
        xhr.open('POST', `http://localhost:9999/api`);
        xhr.setRequestHeader('Content-Type', 'application/json');
        xhr.send(data);
    }
});