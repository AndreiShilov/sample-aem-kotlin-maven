Vue.component('counter', {
    props: ['number', 'buttonText'],
    template: `<div>
                 <button @click="increment">{{buttonText}}</button>
                 <h3>{{counter}}</h3>
               </div>`,
    methods: {
        increment() {
            this.counter++;
        }
    },
    data() {
        return {
            counter: Number.parseInt(this.number)
        }
    }

});

[].forEach.call(document.getElementsByClassName('counter__content'), el => {
    new Vue({el: el})
})

