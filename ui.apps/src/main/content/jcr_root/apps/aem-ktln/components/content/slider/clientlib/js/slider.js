import Vue from 'vue';

class Slider {
    static register() {
        Vue.component('slider', {
            props: ['array'],
            methods: {
                nextSlide() {
                    this.index = (this.index + 1) % this.slides.length;

                }
            },
            data() {
                return {
                    index: 0,
                    slides: JSON.parse(this.array)
                }
            },
            computed:{
                image(){
                    return this.slides[this.index]
                }
            }
        });
    }
}

export default Slider