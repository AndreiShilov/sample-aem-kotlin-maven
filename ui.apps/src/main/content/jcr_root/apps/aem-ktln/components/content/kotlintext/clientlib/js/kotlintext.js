import Vue from 'vue';

class KotlinText {
    static register() {
        Vue.component('kotlintext', {
            props: ['text'],
            template: '<button @click="addLetter">{{buttonText}}</button>',
            methods: {
                addLetter() {
                    this.buttonText = this.buttonText + 'a';
                }
            },
            data() {
                return {
                    buttonText: this.text
                }
            }
        });
    }
}

export default KotlinText


