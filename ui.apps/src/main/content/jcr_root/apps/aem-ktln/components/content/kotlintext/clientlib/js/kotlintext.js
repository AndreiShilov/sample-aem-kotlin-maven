import Vue from 'vue';
import TestComponent from './test.ts'

class KotlinText {
    static register() {
        Vue.component('kotlintext', {
            props: ['text'],
            template: '<button @click="addLetter">{{buttonText}}</button>',
            methods: {
                addLetter() {
                    this.buttonText = this.buttonText + TestComponent.toLowerCase(this.buttonText);
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


