import Vue from 'vue';

const slider = {
    name: 'slider',
    component: {
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
    }
}

export default slider