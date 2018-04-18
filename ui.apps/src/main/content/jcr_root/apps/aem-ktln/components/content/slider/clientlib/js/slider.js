import Vue from 'vue';

function slider() {
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
        computed: {
            image() {
                return this.slides[this.index]
            }
        }
    });
}

export default slider