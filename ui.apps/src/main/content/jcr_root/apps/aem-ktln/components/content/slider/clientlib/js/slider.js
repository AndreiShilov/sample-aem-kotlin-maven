import Vue from 'vue';
import { Slider, SliderItem } from 'vue-easy-slider'

class CustomSlider {
    static register() {
        Vue.component('custom-slider', {
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
            },
            components:{
                Slider,
                SliderItem
            }
        });
    }
}

export default CustomSlider