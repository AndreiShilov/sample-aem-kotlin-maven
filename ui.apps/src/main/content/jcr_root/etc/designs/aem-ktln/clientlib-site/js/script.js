import Vue from 'vue'
import components from './components.js'

function startApp() {

    components.forEach(component => {
        component.register()
    });

    const elements = document.querySelectorAll('[data-component]');
    ([]).forEach.call(elements, (el) => {

        el.dataset.initialized = 'true';

        new Vue({el: el});
    });

}

document.addEventListener("DOMContentLoaded", startApp);

